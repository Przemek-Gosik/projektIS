package com.integracja.projektis.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.integracja.projektis.entity.Record;
import com.integracja.projektis.entity.Type;
import com.integracja.projektis.model.OutputData;
import com.integracja.projektis.model.Region;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class OutputService {
    private final String nazwaWino = "Ceny win z podziałem na województwa";
    private final String nazwaWodka = "Ceny wódki z podziałem na województwa";
    private final String nazwaWypadki = "Ilość wypadków spowodowanych przez nietrzeźwych kierowców";
    private final String fnameWino = "Ceny_wino";
    private final String fnameWodka ="Ceny_wodka_40";
    private final String fnameWypadki="Ilosc_wypadkow";
    private Region returnRegion(Record record){
        return new Region(record.getWojewodztwo(),record.getValues());
    }
    public String getFileName(Type type){
        String returnString="";
        switch (type){
            case WYPADKI :
                returnString=fnameWypadki;
                break;
            case WODKA:
                returnString=fnameWodka;
                break;
            case WINO:
                returnString=fnameWino;
                break;

        }
        return  returnString;
    }
    private OutputData getOutputObject(List<Record> recordList){
        List<Region> regions = new ArrayList<>();
        for(Record record:recordList){
            Region region = returnRegion(record);
            regions.add(region);
        }
        Type pom = recordList.get(0).getType();
        String name="";
        switch (pom){
            case WINO :
                name=nazwaWino;
                break;
            case WODKA:
                name=nazwaWodka;
                break;
            case WYPADKI:
                name=nazwaWypadki;
                break;
        }
        return new OutputData(name,regions);
    }
    public String setOutPutJsonFile(List<Record> list) throws JsonProcessingException {
        OutputData data = getOutputObject(list);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(data);
        return json;

    }
    public String setOutPutXmlFile(List<Record> list) throws JsonProcessingException {
        OutputData data = getOutputObject(list);
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(data);
        return xml;
    }
}
