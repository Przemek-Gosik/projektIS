package com.integracja.projektis.model;

import java.util.Map;

public class Region {
    String nazwa_wojewodztwa;
    Map<Integer,Double> wartosci;

    public Region() {
    }

    public Region(String nazwa_wojewodztwa, Map<Integer, Double> wartosci) {
        this.nazwa_wojewodztwa = nazwa_wojewodztwa;
        this.wartosci = wartosci;
    }

    public String getNazwa_wojewodztwa() {
        return nazwa_wojewodztwa;
    }

    public void setNazwa_wojewodztwa(String nazwa_wojewodztwa) {
        this.nazwa_wojewodztwa = nazwa_wojewodztwa;
    }

    public Map<Integer, Double> getWartosci() {
        return wartosci;
    }

    public void setWartosci(Map<Integer, Double> wartosci) {
        this.wartosci = wartosci;
    }
}
