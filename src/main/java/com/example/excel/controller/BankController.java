package com.example.excel.controller;


import com.example.excel.common.BankFactory;
import com.example.excel.enums.Bank;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController {

    @GetMapping("/bank-config")
    public String getConfig() {
        return BankFactory.getBankExcels().toString();
    }

    @GetMapping("/banks")
    public String getBanks() {
        Map<String, String> map = new HashMap<>();
        for (Bank bank : Bank.values()) {
            map.put(bank.name(), bank.getDescription());
        }
        return map.toString();
    }
}
