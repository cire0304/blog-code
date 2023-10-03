package com.ayuconpon.coupon.service;

import com.ayuconpon.coupon.domain.CouponRepository;
import com.ayuconpon.coupon.domain.UserCouponRepository;
import com.ayuconpon.coupon.domain.entity.Coupon;
import com.ayuconpon.coupon.domain.entity.UserCoupon;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SynchronizedIssueCouponService {

    private final CouponRepository couponRepository;
    private final UserCouponRepository userCouponRepository;

    public synchronized void issue(Long couponId) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(RuntimeException::new);

        coupon.decrease();
        couponRepository.saveAndFlush(coupon);

        UserCoupon issuedCoupon = new UserCoupon(coupon);
        userCouponRepository.saveAndFlush(issuedCoupon);
    }

}
