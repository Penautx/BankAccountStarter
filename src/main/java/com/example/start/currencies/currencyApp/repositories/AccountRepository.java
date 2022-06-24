package com.example.start.currencies.currencyApp.repositories;
import com.example.start.currencies.currencyApp.entities.AccountProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
public interface AccountRepository extends JpaRepository<AccountProfile, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE AccountProfile SET balance = :newAmount WHERE accountprofileid=:accountId")
    void updateAccountBalance(@Param("accountId") long id, @Param("newAmount") BigDecimal amount);
}
