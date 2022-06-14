package com.integracja.projektis.controller;

import com.integracja.projektis.entity.Record;
import com.integracja.projektis.entity.Type;
import com.integracja.projektis.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping ("/api")
public class RecordRestController {
    private RecordService recordService;

    @Autowired
    public RecordRestController(RecordService recordService) {
        this.recordService = recordService;
    }
    @GetMapping("/dane")
    public List<Record> findAll(){
        return recordService.findAll();
    }

    @GetMapping("/dane/{type}")
    public Map<Integer,Double>findAllByType(@PathVariable String type){

        return recordService.findAllbyType(typeOfData(type));
    }

    @GetMapping("/dane/{type}/{region}")
    public Map<Integer,Double> findAllByTypeAndWojewodztwo(@PathVariable String type, @PathVariable String region){
        Map<Integer,Double>results = recordService.findType(typeOfData(type),region);
        if(results.isEmpty()){
            throw new RuntimeException("Did not find any results matching data"+type+"/"+region);
        }
        return results;
    }
    @DeleteMapping("/dane/usun")
    public String deleteAllData(){
        recordService.deleteAll();
        return "All dataBase is now empty";
    }
  //  @GetMapping("/pobierz")
    //public ResponseEntity<byte[]>

    private Type typeOfData(String type){
        return switch (type) {
            case "wino" -> Type.WINO;
            case "wodka" -> Type.WODKA;
            case "wypadki" -> Type.WYPADKI;
            default -> throw new RuntimeException("Did not find any matching data" + type);
        };
    }

}
