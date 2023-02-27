package com.example.JobPortal.controller;

import com.example.JobPortal.model.Account;
import com.example.JobPortal.model.dto.AccountDto;
import com.example.JobPortal.service.AccountService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    List<Account> listAllAccounts(){
        return accountService.getAllAccounts();
    }

    //TODO implement more functions

    @PostMapping
    Account createAccount(@RequestBody AccountDto accountDto, @RequestPart MultipartFile picture) throws IOException {
        return accountService.saveAccount(accountDto,picture);
    }

    @PutMapping("/{username}")
    Account editAccount(@RequestBody AccountDto accountDto, @PathVariable String username, @RequestPart MultipartFile picture) throws IOException {
        return accountService.editAccount(accountDto, username, picture);
    }

    @DeleteMapping("/{username}")
    void deleteAccount(@PathVariable String username){
        accountService.deleteAccount(username);
    }
}
