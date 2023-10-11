package com.ayuconpon.coupon.service.case2;


import com.ayuconpon.coupon.domain.CouponRepository;
import com.ayuconpon.coupon.domain.entity.Coupon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class CouponServiceCase2Test {

    @Autowired
    private CouponsServiceCase2 couponsServiceCase2;
    @Autowired
    private CouponRepository couponRepository;

    @BeforeEach
    public void beforeEach() {
        couponRepository.deleteAllInBatch();
    }

    @Test
    public void case2 () {
        //given
        // 쿠폰 3개 생성
        List<Coupon> coupons = List.of(new Coupon(), new Coupon(), new Coupon());

        //when
        couponsServiceCase2.case2(coupons);

        //then
        assertThat(couponRepository.findAll()).hasSize(0);
     }

}
