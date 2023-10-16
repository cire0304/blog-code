package com.ayuconpon.coupon.service;

import com.ayuconpon.coupon.domain.entity.Coupon;
import com.ayuconpon.coupon.domain.entity.UserCoupon;
import com.ayuconpon.coupon.domain.CouponRepository;
import com.ayuconpon.coupon.domain.UserCouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CouponService {

    private final UserCouponRepository userCouponRepository;

    @Transactional
    public void case1() {
        List<UserCoupon> userCoupons = userCouponRepository.findAll();

        userCoupons.forEach(userCoupon -> userCoupon.getCoupon()
                                                    .getCouponId());
    }

    @Transactional
    public void case2() {
        List<UserCoupon> userCoupons = userCouponRepository.findAll();

        userCoupons.forEach(userCoupon -> userCoupon.getCoupon()
                                                    .getQuantity());
    }

}
