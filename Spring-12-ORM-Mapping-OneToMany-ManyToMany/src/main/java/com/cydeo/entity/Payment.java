package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    @Column(columnDefinition = "Date")
    private LocalDate createdDate;
    private Status paymentStatus;

    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "payment_detail_id")
    private PaymentDetail paymentDetail;

    @ManyToOne
    private Merchant merchant;


    public Payment( LocalDate createdDate,BigDecimal amount, Status paymentStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;

    }

    @ManyToOne
    private Customer customer;


}
