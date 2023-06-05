package com.example.excel.common;

import com.example.excel.dto.BankExcel;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParseException;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class BankFactory {
    static Logger log = LoggerFactory.getLogger(BankFactory.class);
    static final String bankFile = "config/json/bank.json";

    static ArrayList<BankExcel> bankExcels;

    public BankFactory() throws JsonParseException, JsonMappingException, IOException {
        bankExcels = addDefaultBankExcel();
    }

    public static ArrayList<BankExcel> addDefaultBankExcel() throws JsonParseException, JsonMappingException, IOException {
        log.info("adding default bank excel");

        // get file
        String json = getStreamFromResource();

        // add hashmap
        ArrayList<BankExcel> bankExcelMap = mapInputStreamMenus(json);

        // check with log
        log.info("bank excel config map: " + bankExcelMap.toString());

        return bankExcelMap;
    }

    private static String getStreamFromResource() throws IOException {
        ClassLoader classLoader = BankFactory.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(BankFactory.bankFile);

        if (inputStream == null) {
            throw new IllegalArgumentException("bank file \"" + BankFactory.bankFile + "\" not found.");
        } else {
            byte[] byteData = FileCopyUtils.copyToByteArray(inputStream);
            return new String(byteData, StandardCharsets.UTF_8);
        }
    }

    private static ArrayList<BankExcel> mapInputStreamMenus(String json) throws JsonParseException, JsonMappingException, IOException {
        //파일 읽기
        Gson gson = new Gson();
        ArrayList<BankExcel> bankExcelMap = gson.fromJson(json, new TypeToken<List<BankExcel>>() {
        }.getType());

        return bankExcelMap;
    }

    public static ArrayList<BankExcel> getBankExcels() {
        return bankExcels;
    }

    public static void setBankExcels(ArrayList<BankExcel> bankExcels) {
        BankFactory.bankExcels = bankExcels;
    }
}
