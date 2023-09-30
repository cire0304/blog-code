package com.ayuconpon.coupon.service;

import com.ayuconpon.coupon.domain.entity.Coupon;
import com.ayuconpon.coupon.domain.entity.UserCoupon;
import com.ayuconpon.coupon.domain.CouponRepository;
import com.ayuconpon.coupon.domain.UserCouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class IssueCouponService {

    private final CouponRepository couponRepository;
    private final UserCouponRepository userCouponRepository;

    @Transactional
    public synchronized void issue(Long couponId) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(RuntimeException::new);

        coupon.decrease();
        UserCoupon issuedCoupon = new UserCoupon(coupon);
        userCouponRepository.saveAndFlush(issuedCoupon);
    }

}
