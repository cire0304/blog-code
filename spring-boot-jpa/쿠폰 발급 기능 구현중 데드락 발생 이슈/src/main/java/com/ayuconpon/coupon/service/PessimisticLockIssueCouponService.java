package com.ayuconpon.coupon.service;

import com.ayuconpon.coupon.domain.CouponRepository;
import com.ayuconpon.coupon.domain.UserCouponRepository;
import com.ayuconpon.coupon.domain.entity.Coupon;
import com.ayuconpon.coupon.domain.entity.UserCoupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PessimisticLockIssueCouponService {

    private final CouponRepository couponRepository;
    private final UserCouponRepository userCouponRepository;

    @Transactional
    public void issue(Long couponId) {
        Coupon coupon = couponRepository.findByIdWithPessimisticLock(couponId);

        coupon.decrease();
        UserCoupon issuedCoupon = new UserCoupon(coupon);
        userCouponRepository.save(issuedCoupon);
    }

}
