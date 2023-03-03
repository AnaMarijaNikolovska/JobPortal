package com.example.JobPortal.service;

import com.example.JobPortal.model.Account;
import com.example.JobPortal.model.dto.AccountDto;
import com.example.JobPortal.model.dto.LogInDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AccountService extends UserDetailsService {
    List<Account> getAllAccounts();

    //TODO maybe "getOneAccount" is same as "getAccountByUsername"
//    Optional<Account> getOneAccount(String username);

    Optional<Account> getAccountByUsername(String username);

    Account saveAccount(AccountDto accountDto, MultipartFile picture) throws IOException;

    Account editAccount(AccountDto accountDto,String username,MultipartFile picture) throws IOException;

    void deleteAccount(String username);
}
