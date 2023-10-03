package com.ayuconpon.coupon.facade;

import com.ayuconpon.coupon.service.OptimisticLockIssueCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OptimisticLockCouponFacade {

    private final OptimisticLockIssueCouponService optimisticLockIssueCouponService;

    public void issue(Long couponId) throws InterruptedException {
        while (true) {
            try {
                optimisticLockIssueCouponService.issue(couponId);

                break;
            }  catch (Exception e) {
                Thread.sleep(10);
            }
        }
    }


}
