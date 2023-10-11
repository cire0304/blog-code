package com.ayuconpon.coupon.service.case1;


import com.ayuconpon.coupon.domain.CouponRepository;
import com.ayuconpon.coupon.domain.entity.Coupon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class CouponServiceCase1Test {

    @Autowired
    private CouponsServiceCase1 couponsServiceCase1;
    @Autowired
    private CouponRepository couponRepository;

    @BeforeEach
    public void beforeEach() {
        couponRepository.deleteAllInBatch();
    }

    @DisplayName("기본 롤백 전파")
    @Test
    public void case1 () {
        //given
        // 쿠폰 3개 생성
        List<Coupon> coupons = List.of(new Coupon(), new Coupon(), new Coupon());

        //when
        couponsServiceCase1.case1(coupons);

        //then
        assertThat(couponRepository.findAll()).hasSize(2);
     }



}
