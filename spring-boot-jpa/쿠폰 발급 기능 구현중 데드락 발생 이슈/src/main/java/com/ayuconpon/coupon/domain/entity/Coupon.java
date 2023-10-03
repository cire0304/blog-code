package com.ayuconpon.coupon.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponId;

    @Column(name = "quantity")
    private Long quantity;

//    @Version
//    private Long version;

    public void decrease() {
        if (quantity <= 0) throw new IllegalStateException("쿠폰의 재고가 없습니다.");
        quantity--;
    }

}
