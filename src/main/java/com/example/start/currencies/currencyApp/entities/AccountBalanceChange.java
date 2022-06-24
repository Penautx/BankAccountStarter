package com.example.start.currencies.currencyApp.entities;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="accountbalancechange")
public class AccountBalanceChange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountbalancechangeid")
    private long id;
    private BigDecimal amount;
    @Column(name = "isdeposit")
    private boolean isDeposit;
    @Column(name = "createdatetime")
    private Date createDatetime;

    @ManyToOne
    @JoinColumn(name="accountprofileid")
    private AccountProfile accountProfile;
    public void setDateTime(){

        this.createDatetime = new Date();
    }

}
