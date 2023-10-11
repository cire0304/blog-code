package com.ayuconpon.coupon.service.case3;

import com.ayuconpon.coupon.domain.entity.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponsServiceCase3 {

    public final SaveCouponServiceCase3 saveCouponServiceCase3;

    @Transactional
    public void case3(List<Coupon> coupons) {
        saveCouponServiceCase3.success(coupons.get(0));
        saveCouponServiceCase3.fail(coupons.get(1));
        saveCouponServiceCase3.success(coupons.get(2));
    }

}
