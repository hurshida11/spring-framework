package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "merchants")
@Data
@NoArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private BigDecimal transaction;
    private BigDecimal commission;
    private Integer payoutDelayCount;

    public Merchant(String name, String code, BigDecimal transaction, BigDecimal commission, Integer payoutDelayCount) {
        this.name = name;
        this.code = code;
        this.transaction = transaction;
        this.commission = commission;
        this.payoutDelayCount = payoutDelayCount;
    }

    @OneToMany (mappedBy = "merchant")//one merchant obj to collections of payments ,ownership belongs to many side(payment)
    private List<Payment> paymentList;
}
