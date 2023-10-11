package com.ayuconpon.coupon.service.case3;

import com.ayuconpon.coupon.domain.CouponRepository;
import com.ayuconpon.coupon.domain.entity.Coupon;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SaveCouponServiceCase3 {

    private final CouponRepository couponRepository;
    private static final Logger log = LoggerFactory.getLogger(SaveCouponServiceCase3.class);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void success(Coupon coupon) {
        couponRepository.save(coupon);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void fail(Coupon coupon) {
        try {
            throw new RuntimeException("RuntimeException inside");
        } catch (Exception e) {
            log.warn("SaveCouponServiceCase3 caught exception at inner. ex {}", e.getMessage());
        }
    }

}
