package com.ayuconpon.coupon.service.case1;

import com.ayuconpon.coupon.domain.CouponRepository;
import com.ayuconpon.coupon.domain.entity.Coupon;
import com.ayuconpon.coupon.service.case2.CouponsServiceCase2;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveCouponServiceCase1 {

    private final CouponRepository couponRepository;
    private static final Logger log = LoggerFactory.getLogger(CouponsServiceCase1.class);

    public void success(Coupon coupon) {
        couponRepository.save(coupon);
    }

    @Transactional
    public void fail(Coupon coupon) {
        try {
            couponRepository.save(coupon);
            throw new RuntimeException("RuntimeException inside");
        } catch (Exception e) {
            log.warn("SaveCouponServiceCase1 caught exception at inner. ex {}", e.getMessage());
        }
    }

}
