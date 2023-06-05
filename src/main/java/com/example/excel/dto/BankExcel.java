package com.example.excel.dto;

public class BankExcel {

    // 은행명
    private String name;


    // 시트
    private String sheet;

    // 필드 좌표
    private String field1;
    private String field2;

    public BankExcel() {
    }

    public BankExcel(String name, String sheet, String field1, String field2) {
        this.name = name;
        this.sheet = sheet;
        this.field1 = field1;
        this.field2 = field2;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSheet() {
        return sheet;
    }

    public void setSheet(String sheet) {
        this.sheet = sheet;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "BankExcel{" +
                "name='" + name + '\'' +
                ", sheet='" + sheet + '\'' +
                ", field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                '}';
    }
}
