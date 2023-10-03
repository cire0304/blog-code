package com.ayuconpon.coupon.service;

import com.ayuconpon.coupon.domain.CouponRepository;
import com.ayuconpon.coupon.domain.UserCouponRepository;
import com.ayuconpon.coupon.domain.entity.Coupon;
import com.ayuconpon.coupon.facade.NamedLockCouponFacade;
import com.ayuconpon.coupon.facade.OptimisticLockCouponFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class IssueCouponServiceTest {

    @Autowired
    private SynchronizedIssueCouponService synchronizedIssueCouponService;
    @Autowired
    private OptimisticLockCouponFacade optimisticLockCouponFacade;
    @Autowired
    private PessimisticLockIssueCouponService pessimisticLockIssueCouponService;
    @Autowired
    private NamedLockCouponFacade namedLockCouponFacade;
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private UserCouponRepository userCouponRepository;

    @DisplayName("동시성 테스트")
    @Test
    public void synchronizedTest () throws InterruptedException {
        //given
        Long couponId = 1L;
        int leftQuantity = 100000;
        int numberOfThreads = 32;
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch latch = new CountDownLatch(leftQuantity);

        long start = System.currentTimeMillis();

        //when
        for (int i = 1; i <= leftQuantity; i++) {
            service.execute(() -> {
                synchronizedIssueCouponService.issue(couponId);
                latch.countDown();
            });
        }
        latch.await();

        long end = System.currentTimeMillis();
        System.out.println(end - start); // 1000 => 5909 // 100000 => 109286

        assertThat(userCouponRepository.count()).isEqualTo(leftQuantity);

        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(RuntimeException::new);
        assertThat(coupon.getQuantity()).isEqualTo(0);

    }

    @DisplayName("동시성 테스트")
    @Test
    public void pessimisticLockTest () throws InterruptedException {
        //given
        Long couponId = 1L;
        int leftQuantity = 1000;
        int numberOfThreads = 32;
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch latch = new CountDownLatch(leftQuantity);

        long start = System.currentTimeMillis();
        //when
        for (int i = 1; i <= leftQuantity; i++) {
            Thread.sleep(10);
            service.execute(() -> {
                pessimisticLockIssueCouponService.issue(couponId);
                latch.countDown();
            });
        }
        latch.await();

        long end = System.currentTimeMillis();
        System.out.println(end - start); // 1000 => 5809 // 100_000 => 59861

        // then
        assertThat(userCouponRepository.count()).isEqualTo(leftQuantity);

        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(RuntimeException::new);
        assertThat(coupon.getQuantity()).isEqualTo(0);
    }

    @DisplayName("동시성 테스트")
    @Test
    public void optimisticLockTest () throws InterruptedException {
        //given
        Long couponId = 1L;
        int leftQuantity = 2;

        int numberOfThreads = 32;
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch latch = new CountDownLatch(leftQuantity);

        long start = System.currentTimeMillis();
        //when
        for (int i = 1; i <= leftQuantity; i++) {
            service.submit(() -> {
                try {
                    optimisticLockCouponFacade.issue(couponId);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();

        long end = System.currentTimeMillis();
        System.out.println(end - start); // 1000 => 9316  // 100_000 => 123885

        assertThat(userCouponRepository.count()).isEqualTo(leftQuantity);

        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(RuntimeException::new);
        assertThat(coupon.getQuantity()).isEqualTo(0);
    }

    @DisplayName("동시성 테스트")
    @Test
    public void namedLockTest () throws InterruptedException {
        //given
        Long couponId = 1L;
        int leftQuantity = 2;

        int numberOfThreads = 32;
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch latch = new CountDownLatch(leftQuantity);

        long start = System.currentTimeMillis();
        //when
        for (int i = 1; i <= leftQuantity; i++) {
            service.submit(() -> {
                try {
                    namedLockCouponFacade.issue(couponId);
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();

        long end = System.currentTimeMillis();
        System.out.println(end - start); // 1000 => 6097 // 100000 => 88780

        assertThat(userCouponRepository.count()).isEqualTo(leftQuantity);

        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(RuntimeException::new);
        assertThat(coupon.getQuantity()).isEqualTo(0);
    }

}
