package com.ayuconpon.coupon.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponId;

    @Column(name = "quantity")
    private Long quantity;

    public Long getCouponId() {
        return couponId;
    }

    public Long getQuantity() {
        return quantity;
    }
}
