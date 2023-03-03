package com.example.JobPortal.service.impl;

import com.example.JobPortal.model.Account;
import com.example.JobPortal.model.dto.AccountDto;
import com.example.JobPortal.model.dto.LogInDto;
import com.example.JobPortal.repository.AccountRepository;
import com.example.JobPortal.service.AccountService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

//    @Override
//    public Optional<Account> getOneAccount(String username) {
//        return accountRepository.findById(username);
//    }

    @Override
    public Optional<Account> getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Account saveAccount(AccountDto accountDto, MultipartFile picture) throws IOException {
        Account account = new Account();

        if (picture != null) {
            account.setPicture(picture.getBytes());
        }
        mapDtoToEntity(account, accountDto);
        return accountRepository.save(account);
    }

    @Override
    public Account editAccount(AccountDto accountDto, String username,MultipartFile picture) throws IOException {
        Optional<Account> optionalAccount = accountRepository.findByUsername(username);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            if (picture != null) {
                account.setPicture(picture.getBytes());
            }
            mapDtoToEntity(account, accountDto);

            return accountRepository.save(account);
        }
        return null;
    }

    @Override
    public void deleteAccount(String username) {
        accountRepository.deleteById(username);
    }

    //TODO
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // param for function: String username,String mail
        //TODO
//        Account account = accountRepository.findByUsername(username)
//                .orElseGet(() -> accountRepository.findByEmail(mail)
//                        .orElseThrow(() -> new UsernameNotFoundException("User Name is not Found")));
        return null;
    }

    private void mapDtoToEntity(Account account, AccountDto accountDto) {
        account.setName(accountDto.getName());
        account.setPassword(accountDto.getPassword());
        account.setUsername(accountDto.getUsername());
        account.setSurname(accountDto.getSurname());
        account.setMail(accountDto.getMail());
        account.setPhoneNumber(accountDto.getPhoneNumber());
        account.setAboutAccount(accountDto.getAboutAccount());
        account.setCompanyName(accountDto.getCompanyName());
        account.setSince(accountDto.getSince());
    }

}
