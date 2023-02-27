package com.example.JobPortal.repository;

import com.example.JobPortal.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
    @Query("SELECT account " +
            "FROM Account account" +
            "WHERE account.deletedOn IS NULL " +
            "   AND (account.username = :username OR account.email = :username)" +
            "   AND account.password = :password ")
    Optional<Account> getByUsername(String username);
    Optional<Account> findByUsername(String username);

    Optional<Account> findByEmail(String mail);
}
