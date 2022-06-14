package com.integracja.projektis.config;

public class ConfigurationForImport {
    String source_folder;
    String wodka_file_name;
    String wino_file_name;
    String wypadki_file_name;

    public ConfigurationForImport() {
    }

    public String getSource_folder() {
        return source_folder;
    }

    public void setSource_folder(String source_folder) {
        this.source_folder = source_folder;
    }

    public String getWodka_file_name() {
        return wodka_file_name;
    }

    public void setWodka_file_name(String wodka_file_name) {
        this.wodka_file_name = wodka_file_name;
    }

    public String getWino_file_name() {
        return wino_file_name;
    }

    public void setWino_file_name(String wino_file_name) {
        this.wino_file_name = wino_file_name;
    }

    public String getWypadki_file_name() {
        return wypadki_file_name;
    }

    public void setWypadki_file_name(String wypadki_file_name) {
        this.wypadki_file_name = wypadki_file_name;
    }
}
