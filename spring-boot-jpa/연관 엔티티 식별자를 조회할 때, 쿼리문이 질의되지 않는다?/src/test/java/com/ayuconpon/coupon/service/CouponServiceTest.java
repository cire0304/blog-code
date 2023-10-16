package com.ayuconpon.coupon.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CouponServiceTest {

    @Autowired
    private CouponService couponService;

    @Test
    public void case1 () {
        couponService.case1();
     }

    @Test
    public void case2 () {
        couponService.case2();
    }


}
