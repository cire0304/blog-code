package com.ayuconpon.coupon.service.case3;


import com.ayuconpon.coupon.domain.CouponRepository;
import com.ayuconpon.coupon.domain.entity.Coupon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class CouponServiceCase3Test {

    @Autowired
    private CouponsServiceCase3 couponsServiceCase3;
    @Autowired
    private CouponRepository couponRepository;

    @BeforeEach
    public void beforeEach() {
        couponRepository.deleteAllInBatch();
    }

    @Test
    public void case3 () {
        //given
        // 쿠폰 3개 생성
        List<Coupon> coupons = List.of(new Coupon(), new Coupon(), new Coupon());

        //when
        couponsServiceCase3.case3(coupons);

        //then
        assertThat(couponRepository.findAll()).hasSize(2);
     }

}
