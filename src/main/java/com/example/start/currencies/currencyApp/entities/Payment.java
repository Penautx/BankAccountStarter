package com.example.start.currencies.currencyApp.entities;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name="payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentid")
    private long id;
    private BigDecimal amount;
    private String currency;
    @Column(name = "createdatetime")
    private Date createDatetime;
    @Column(name = "accountprofilenumber")
    private String accountProfileNumber;
    @ManyToOne
    @JoinColumn(name="accountprofileid")
    private AccountProfile accountProfile;

    public void setDatetime(){
        this.createDatetime = new Date();
    }
}
