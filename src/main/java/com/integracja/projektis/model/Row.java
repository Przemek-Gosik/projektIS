package com.integracja.projektis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Row {
    private String _2014;
    private String _2015;
    private String _2016;
    private String _2017;
    private String _2018;
    private String _2019;
    private String _2020;

    @JsonProperty("Nazwa")
    private String Nazwa;

    public Row() {
    }

    public String get_2014() {
        return _2014;
    }

    public void set_2014(String _2014) {
        this._2014 = _2014;
    }

    public String get_2015() {
        return _2015;
    }

    public void set_2015(String _2015) {
        this._2015 = _2015;
    }

    public String get_2016() {
        return _2016;
    }

    public void set_2016(String _2016) {
        this._2016 = _2016;
    }

    public String get_2017() {
        return _2017;
    }

    public void set_2017(String _2017) {
        this._2017 = _2017;
    }

    public String get_2018() {
        return _2018;
    }

    public void set_2018(String _2018) {
        this._2018 = _2018;
    }

    public String get_2019() {
        return _2019;
    }

    public void set_2019(String _2019) {
        this._2019 = _2019;
    }

    public String get_2020() {
        return _2020;
    }

    public void set_2020(String _2020) {
        this._2020 = _2020;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }
}
