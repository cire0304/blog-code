package com.ayuconpon.coupon.service.case2;

import com.ayuconpon.coupon.domain.entity.Coupon;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponsServiceCase2 {

    public final SaveCouponServiceCase2 saveCouponServiceCase2;

    private static final Logger log = LoggerFactory.getLogger(CouponsServiceCase2.class);

    @Transactional
    public void case2(List<Coupon> coupons) {
        try {
            saveCouponServiceCase2.success(coupons.get(0));
            saveCouponServiceCase2.fail(coupons.get(1));
            saveCouponServiceCase2.success(coupons.get(2));
        } catch (Exception e) {
            log.warn("CouponsServiceCase2 caught exception at outer. ex {}", e.getMessage());
        }
    }

}
