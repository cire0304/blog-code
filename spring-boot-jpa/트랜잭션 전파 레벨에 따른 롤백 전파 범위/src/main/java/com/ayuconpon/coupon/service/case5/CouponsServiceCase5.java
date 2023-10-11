package com.ayuconpon.coupon.service.case5;

import com.ayuconpon.coupon.domain.entity.Coupon;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponsServiceCase5 {

    public final SaveCouponServiceCase5 saveCouponServiceCase5;

    private static final Logger log = LoggerFactory.getLogger(CouponsServiceCase5.class);

    @Transactional
    public void case5(List<Coupon> coupons) {
        try {
            saveCouponServiceCase5.success(coupons.get(0));
            saveCouponServiceCase5.fail(coupons.get(1));
            saveCouponServiceCase5.success(coupons.get(2));
        } catch (Exception e) {
            log.warn("CouponsServiceCase2 caught exception at outer. ex {}", e.getMessage());
        }
    }

}
