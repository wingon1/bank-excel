package com.example.excel.enums;

public enum Bank {
    KB("국민은행", "001"),
    IBK("기업은행", "003"),
    ;

    private final String description;
    private final String code;
    Bank(String description, String code){
        this.description = description;
        this.code = code;
    }

    public String getDescription(){
        return this.description;
    }

    String getCode(){
        return this.code;
    }
}
