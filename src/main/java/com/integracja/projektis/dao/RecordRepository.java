package com.integracja.projektis.dao;

import com.integracja.projektis.entity.Record;
import com.integracja.projektis.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record,Integer> {
    List<Record> findByType(Type type);
    List<Record> findByTypeAndWojewodztwo(Type type,String region);
}
