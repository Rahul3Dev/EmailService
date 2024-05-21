//package com.nobroker.service;
//
//import com.nobroker.entity.User;
//import com.nobroker.repository.UserRepository;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.IOException;
//import java.util.List;
//
//public class ExcelExportService {
//    @Autowired
//    private UserRepository userRepository;
//
//    public void exportUserToExcel(){
//
//        List<User> userList = userRepository.findAll();
//
//        try (Workbook workbook = new XSSFWorkbook()){
//            Sheet sheet = workbook.cloneSheet(Integer.parseInt("Users"));
//
//            // Create header row
//
//            Row headerRow = Sheet.cre
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
