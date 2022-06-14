package com.integracja.projektis.service;

import com.integracja.projektis.dao.RecordRepository;
import com.integracja.projektis.entity.Record;
import com.integracja.projektis.entity.Type;
import com.integracja.projektis.model.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


@Service
public class RecordServiceImpl implements RecordService{

    private RecordRepository recordRepository;

    @Autowired
    public RecordServiceImpl(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }


    @Override
    public List<Record> findAll() {
        List<Record> result=recordRepository.findAll();
        if(result.isEmpty()){
            loadDB();
            result = recordRepository.findAll();
        }
        result.forEach(record -> record.setValues(getSortedValues(record.getValues())));
        return result;
    }

    @Override
    public List<Record> findTypeRecords(Type type) {
        List<Record> records = recordRepository.findByType(type);
        records.forEach(r-> r.setValues(getSortedValues(r.getValues())));
        return records;
    }

    @Override
    public Map<Integer,Double> findAllbyType(Type type) {

        List<Record> records=recordRepository.findByType(type);
        Map<Integer,Double> values= new HashMap<>();

        values.put(2014,0.0);
        values.put(2015,0.0);
        values.put(2016,0.0);
        values.put(2017,0.0);
        values.put(2018,0.0);
        values.put(2019,0.0);
        values.put(2020,0.0);


                for(Record record : records) {
                    for(int i = 2014;i<2021;i++){
                        values.put(i,values.get(i)+record.getValues().get(i));
                    }

                }
                if(type!=Type.WYPADKI) {
                    for (int i = 2014; i < 2021; i++) {
                        values.put(i, values.get(i) / (16));
                        values.put(i,roundValues(values.get(i)));
                    }
                }


        return getSortedValues(values);

    }

    @Override
    public Map<Integer,Double> findType(Type type, String region) {
        List<Record> record=recordRepository.findByTypeAndWojewodztwo(type,region);

        return getSortedValues(record.get(0).getValues());
    }


    @Override
    public void deleteAll() {
        recordRepository.deleteAll();

    }
    @Override
    public void save(Record record){
        recordRepository.save(record);
    }

    @Override
    public void loadDB() {
        RowService rowService = new RowService();
        List<Record> data=new ArrayList<>();
        ConfigurationFromImportService importService = new ConfigurationFromImportService();
        try {
            ArrayList<String> fileNameList = importService.setFileNames();
            List<Row> wina = rowService.deserializeFromXML(fileNameList.get(0));
            wina = rowService.doubleFormat(wina);
            List<Row> wodki = rowService.deserializeFromXML(fileNameList.get(1));
            wodki=rowService.doubleFormat(wodki);
            List <Row> wypadki  =rowService.deserializeFromXML(fileNameList.get(2));

            setToRecord(data,wina,Type.WINO);
            setToRecord(data,wodki,Type.WODKA);
            setToRecord(data,wypadki,Type.WYPADKI);

        }catch (IOException io){
            io.printStackTrace();
        }
        recordRepository.saveAll(data);
    }
    private void setToRecord(List<Record> data,List<Row> importedData,Type type){
        for(Row impD : importedData){
            Map<Integer,Double> results=new HashMap<>();
            results.put(2014,Double.parseDouble(impD.get_2014()));
            results.put(2015,Double.parseDouble(impD.get_2015()));
            results.put(2016,Double.parseDouble(impD.get_2016()));
            results.put(2017,Double.parseDouble(impD.get_2017()));
            results.put(2018,Double.parseDouble(impD.get_2018()));
            results.put(2019,Double.parseDouble(impD.get_2019()));
            results.put(2020,Double.parseDouble(impD.get_2020()));

            Record pom = new Record(type,impD.getNazwa(),getSortedValues(results));
            data.add(pom);
        }
    }
    private Map<Integer,Double> getSortedValues(Map<Integer,Double> values){
        return new TreeMap<>(values);
    }
    private Double roundValues(Double number){
        BigDecimal numDec = new BigDecimal(number).setScale(2, RoundingMode.HALF_UP);
        return numDec.doubleValue();
    }
}
