package com.ayuconpon.coupon.service.case1;

import com.ayuconpon.coupon.domain.entity.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponsServiceCase1 {

    public final SaveCouponServiceCase1 saveCouponServiceCase1;

    @Transactional
    public void case1(List<Coupon> coupons) {
        saveCouponServiceCase1.success(coupons.get(0));
        saveCouponServiceCase1.fail(coupons.get(1));
        saveCouponServiceCase1.success(coupons.get(2));
    }

}
