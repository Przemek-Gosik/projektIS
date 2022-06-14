package com.integracja.projektis.model;

import java.util.List;

public class OutputData {
    String nazwa;
    List<Region> wojewodztwa;

    public OutputData() {
    }

    public OutputData(String nazwa, List<Region> wojewodztwa) {
        this.nazwa = nazwa;
        this.wojewodztwa = wojewodztwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<Region> getWojewodztwa() {
        return wojewodztwa;
    }

    public void setWojewodztwo(Region wojewodztwo) {
        this.wojewodztwa = wojewodztwa;
    }
}
