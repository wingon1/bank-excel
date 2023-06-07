package com.example.excel.service;

import com.example.excel.common.BankFactory;
import com.example.excel.dto.BankExcel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Objects;

@org.springframework.stereotype.Service
public class TestService {

    static final String testExcel = "data/test.xlsx";

    public String getTest() {
        return "test";
    }

    public void readTestExcelFile(String bankName) throws Exception {
        ClassLoader classLoader = TestService.class.getClassLoader();
        BankExcel bankConfig = getBankExcel(bankName);

        try {
            FileInputStream file = new FileInputStream(Objects.requireNonNull(classLoader.getResource(testExcel)).getFile());
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // 시트 이름 OR 시트 번호
            //Sheet sheet = workbook.getSheet(bankConfig.getSheet());
            Sheet sheet = workbook.getSheetAt(Integer.parseInt(bankConfig.getSheet()));

            // field1 거래 날짜
            CellReference dateRef = new CellReference(bankConfig.getField1());
            // field2 거래 금액
            CellReference amountRef = new CellReference(bankConfig.getField2());

            // 거래 내역 관련 필드일 경우 같은 row 수 로 예상
            int i = dateRef.getRow();

            while (true) {
                try {
                    Row r = sheet.getRow(i);
                    if (r != null) {
                        Cell c = r.getCell(dateRef.getCol(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        Cell c2 = r.getCell(amountRef.getCol(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        System.out.printf("%10s", c.getNumericCellValue());
                        System.out.printf("%10s", c2.getNumericCellValue());
                        System.out.println();
                    } else {
                        break;
                    }
                    i++;
                } catch (Exception e) {
                    break;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    BankExcel getBankExcel(String bankName) throws Exception {
        for (BankExcel bankExcel : BankFactory.getBankExcels()) {
            if (bankExcel.getName().equals(bankName)) {
                return bankExcel;
            }
        }
        // TODO : throw exception
        throw new Exception("bank name \"" + bankName + "\" not found.");
    }
}
