package com.integracja.projektis.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name="record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="typ")
    private Type type;
    @Column(name="wojewodztwo")
    private String wojewodztwo;

    @ElementCollection
    @CollectionTable(name="wartosci",
    joinColumns = {@JoinColumn(name="wartosc_id",referencedColumnName = "id")})
    @MapKeyColumn(name="rok")
    @Column(name="wartosci")
    private Map<Integer,Double> values;
    public Record() {
    }

    public Record(Type type, String wojewodztwo, Map<Integer, Double> values) {
        this.type = type;
        this.wojewodztwo = wojewodztwo;
        this.values = values;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getWojewodztwo() {
        return wojewodztwo;
    }

    public void setWojewodztwo(String wojewodztwo) {
        this.wojewodztwo = wojewodztwo;
    }

    public Map<Integer, Double> getValues() {
        return values;
    }

    public void setValues(Map<Integer, Double> values) {
        this.values = values;
    }
}
