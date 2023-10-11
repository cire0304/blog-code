package com.ayuconpon.coupon.service.case5;

import com.ayuconpon.coupon.domain.CouponRepository;
import com.ayuconpon.coupon.domain.entity.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class SaveCouponServiceCase5 {

    private final CouponRepository couponRepository;

    @Transactional
    public void success(Coupon coupon) {
        couponRepository.save(coupon);
    }

    @Transactional
    public void fail(Coupon coupon) throws IOException {
        throw new IOException("IOException inside");
    }

}
