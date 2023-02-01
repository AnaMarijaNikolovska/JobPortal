package com.example.JobPortal.repository;

import com.example.JobPortal.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
    @Transactional
    Optional<Account> getByUsernameAndPassword(String username, String password);
}
