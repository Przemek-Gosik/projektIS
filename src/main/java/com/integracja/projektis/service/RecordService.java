package com.integracja.projektis.service;

import com.integracja.projektis.entity.Record;
import com.integracja.projektis.entity.Type;

import java.util.List;
import java.util.Map;

public interface RecordService {
    public List<Record> findAll();
    public List<Record> findTypeRecords(Type type);
    public Map<Integer,Double> findAllbyType(Type type);
    public Map<Integer,Double> findType(Type type,String region);
    public void deleteAll();
    public void save(Record record);
    public void loadDB();


}
