package com.ayuconpon.coupon.service.case4;

import com.ayuconpon.coupon.domain.entity.Coupon;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponsServiceCase4 {

    public final SaveCouponServiceCase4 saveCouponServiceCase4;
    private static final Logger log = LoggerFactory.getLogger(SaveCouponServiceCase4.class);

    @Transactional
    public void case4(List<Coupon> coupons) {
        try {
            saveCouponServiceCase4.success(coupons.get(0));
            saveCouponServiceCase4.fail(coupons.get(1));
            saveCouponServiceCase4.success(coupons.get(2));
        } catch (Exception e) {
            log.warn("CouponsServiceCase4 caught exception at outer. ex {}", e.getMessage());
        }
    }

}
