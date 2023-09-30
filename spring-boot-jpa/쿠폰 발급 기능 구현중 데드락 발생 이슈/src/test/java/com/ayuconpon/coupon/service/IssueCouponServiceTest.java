package com.ayuconpon.coupon.service;

import com.ayuconpon.coupon.domain.CouponRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class IssueCouponServiceTest {

    @Autowired
    private IssueCouponService issueCouponService;
    @Autowired
    private CouponRepository couponRepository;

    @DisplayName("동시성 테스트")
    @Test
    public void 재고가_1인_쿠폰에_동시에_2개의_쿠폰_발급_요청 () throws InterruptedException {
        //given
        Long couponId = 1L;

        int numberOfThreads = 2;
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        //when
        for (int i = 1; i <= numberOfThreads; i++) {
            service.execute(() -> {
                issueCouponService.issue(couponId);
                latch.countDown();
            });
        }

        latch.await();
    }

}
