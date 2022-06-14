package com.integracja.projektis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Row> row;

    public Root() {
    }

    public List<Row> getRow() {
        return row;
    }

    public void setRow(List<Row> rows) {
        this.row = rows;
    }
}
