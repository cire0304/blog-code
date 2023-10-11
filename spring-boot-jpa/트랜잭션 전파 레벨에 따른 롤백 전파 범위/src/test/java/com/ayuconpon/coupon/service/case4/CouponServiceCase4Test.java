package com.ayuconpon.coupon.service.case4;


import com.ayuconpon.coupon.domain.CouponRepository;
import com.ayuconpon.coupon.domain.entity.Coupon;
import com.ayuconpon.coupon.service.case3.CouponsServiceCase3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class CouponServiceCase4Test {

    @Autowired
    private CouponsServiceCase4 couponsServiceCase4;
    @Autowired
    private CouponRepository couponRepository;

    @BeforeEach
    public void beforeEach() {
        couponRepository.deleteAllInBatch();
    }

    @Test
    public void case4 () {
        //given
        // 쿠폰 3개 생성
        List<Coupon> coupons = List.of(new Coupon(), new Coupon(), new Coupon());

        //when
        couponsServiceCase4.case4(coupons);

        //then
        assertThat(couponRepository.findAll()).hasSize(2);
     }

}
