package com.integracja.projektis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.integracja.projektis.entity.Record;
import com.integracja.projektis.entity.Type;
import com.integracja.projektis.service.OutputService;
import com.integracja.projektis.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pobierz")
public class DownloadController {
    private RecordService recordService;
    private OutputService outputService;
    @Autowired
    public DownloadController(RecordService recordService, OutputService outputService) {
        this.recordService = recordService;
        this.outputService = outputService;
    }

    @GetMapping("/json/{type}")
    public ResponseEntity<byte[]> downloadJsonFile(@PathVariable String type) throws JsonProcessingException {
        String filename;
        Type type1=getTypeFromString(type);
        List<Record> records = recordService.findTypeRecords(type1);
        String recordsToJson = outputService.setOutPutJsonFile(records);
        filename=outputService.getFileName(type1);
        byte[] dataJsonBytes = recordsToJson.getBytes();
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename="+filename+".json")
                .contentType(MediaType.APPLICATION_JSON)
                .contentLength(dataJsonBytes.length)
                .body(dataJsonBytes);
    }
    @GetMapping("/xml/{type}")
    public ResponseEntity<byte[]>downloadXmlFile(@PathVariable String type) throws JsonProcessingException {
        String filename;
        Type type1 = getTypeFromString(type);
        List<Record> records = recordService.findTypeRecords(type1);
        String recordsToXml = outputService.setOutPutXmlFile(records);
        filename=outputService.getFileName(type1);
        byte[] dataXmlBytes = recordsToXml.getBytes();
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename="+filename+".xml")
                .contentType(MediaType.APPLICATION_XML)
                .contentLength(dataXmlBytes.length)
                .body(dataXmlBytes);



    }
    private Type getTypeFromString(String type){
        Type type1;
        switch (type) {
            case "wino" -> type1 = Type.WINO;
            case "wodka" -> type1 = Type.WODKA;
            case "wypadki" -> type1 = Type.WYPADKI;
            default -> throw new RuntimeException("Nie ma takiego typu!");
        }
        return type1;
    }


}
