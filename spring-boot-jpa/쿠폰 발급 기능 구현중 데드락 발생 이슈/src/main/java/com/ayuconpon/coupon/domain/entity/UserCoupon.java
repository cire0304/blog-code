package com.ayuconpon.coupon.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_coupon")
public class UserCoupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userCouponId;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    public UserCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

}
