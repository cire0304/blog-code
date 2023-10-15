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

    private final CouponRepository couponRepository;
    private final UserCouponRepository userCouponRepository;

    @Transactional
    public void case1() {
        List<UserCoupon> userCoupons = userCouponRepository.findAll();

        userCoupons.forEach(userCoupon -> userCoupon.getCoupon()
                                                    .getCouponId());

//        Coupon coupon = userCoupons.get(0).getCoupon();
//        Long couponId = coupon.getCouponId();
////        Long b = userCoupons.get(0).getCoupon().getQuantity();
////        Long c = userCoupons.get(1).getCoupon().getQuantity();
////        Long d = userCoupons.get(2).getCoupon().getQuantity();

    }

    @Transactional
    public void case2() {
        List<UserCoupon> userCoupons = userCouponRepository.findAll();

        userCoupons.forEach(userCoupon -> userCoupon.getCoupon()
                                                    .getQuantity());
    }

}
