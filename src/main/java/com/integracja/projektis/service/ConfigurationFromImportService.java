package com.integracja.projektis.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.integracja.projektis.config.ConfigurationForImport;
import org.apache.catalina.mapper.Mapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ConfigurationFromImportService {
    private final String filePath="src/main/resources/basic_config.yaml";

    public ConfigurationFromImportService() {
    }
    public ArrayList<String> setFileNames() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        ConfigurationForImport forImport = mapper.readValue(new File(filePath),ConfigurationForImport.class);
        ArrayList<String> listaNazw = new ArrayList<String>();
        listaNazw.add(forImport.getSource_folder()+"/"+forImport.getWino_file_name());
        listaNazw.add(forImport.getSource_folder()+"/"+forImport.getWodka_file_name());
        listaNazw.add(forImport.getSource_folder()+"/"+forImport.getWypadki_file_name());
        return listaNazw;
    }
}
