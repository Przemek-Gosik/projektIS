package com.integracja.projektis;

import com.integracja.projektis.model.Row;
import com.integracja.projektis.service.RowService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProjektIsApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProjektIsApplication.class, args);
    }

    /*
    public static void main (String[] args){
        RowService rowService = new RowService();
        List<Row> rows= rowService.deserializeFromXML("data/CENY_WODKA_CZYSTA_40.xml");
        for(Row row:rows){
            System.out.println(row.getNazwa());
        }

    }
    */



}
