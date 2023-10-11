package com.ayuconpon.coupon.service.case2;

import com.ayuconpon.coupon.domain.CouponRepository;
import com.ayuconpon.coupon.domain.entity.Coupon;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveCouponServiceCase2 {

    private final CouponRepository couponRepository;

    @Transactional
    public void success(Coupon coupon) {
        couponRepository.save(coupon);
    }

    @Transactional
    public void fail(Coupon coupon) {
        throw new RuntimeException("RuntimeException inside");
    }

}
