package com.example.start.currencies.currencyApp.entities;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString
@Table(name="accountprofile")
public class AccountProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountprofileid")
    private Long id;

    @Column(name = "accountprofilenumber")
    private String accountProfileNumber;
    private BigDecimal balance;
    private String currency;

    @OneToOne(mappedBy = "accountProfile", cascade = CascadeType.ALL)
    private ApplicationUser applicationUser;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountProfile")
    private List<Payment> payments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountProfile")
    private List<AccountBalanceChange> accountBalanceChanges;

    @Version
    @Column(name = "optlock", nullable = false)
    private long version = 0L;










}
