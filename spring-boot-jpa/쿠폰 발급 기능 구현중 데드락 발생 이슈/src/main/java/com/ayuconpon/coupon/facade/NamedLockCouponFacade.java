package com.ayuconpon.coupon.facade;

import com.ayuconpon.coupon.domain.LockRepository;
import com.ayuconpon.coupon.service.IssueCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class NamedLockCouponFacade {

    private final LockRepository lockRepository;

    private final IssueCouponService issueCouponService;

    @Transactional
    public void issue(Long couponId) {
        try {
            lockRepository.getLock(couponId.toString());
            issueCouponService.issue(couponId);
        }finally {
            lockRepository.releaseLock(couponId.toString());
        }
    }

}
