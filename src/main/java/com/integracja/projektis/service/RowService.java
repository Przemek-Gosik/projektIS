package com.integracja.projektis.service;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.integracja.projektis.model.Root;
import com.integracja.projektis.model.Row;

import java.io.*;
import java.util.List;

public class RowService {

    public RowService() {
    }

    public List<Row> deserializeFromXML(String fileName) {
        Root root=new Root();

       try {
           ClassLoader classLoader = getClass().getClassLoader();
           InputStream inputStream = classLoader.getResourceAsStream(fileName);
           if(inputStream == null){
               System.out.println("e");
           }
           JacksonXmlModule module = new JacksonXmlModule();
           module.setDefaultUseWrapper(false);
           XmlMapper mapper = new XmlMapper(module);
           String readValues = inputStreamToString(inputStream);
            root = mapper.readValue(readValues,Root.class);


       }catch (IOException e ){
            e.printStackTrace();
       }
        return root.getRow();
    }

    private  String inputStreamToString(InputStream inputStream) throws IOException{
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    public List<Row> doubleFormat(List<Row> rows) {
        for (Row row : rows) {
            row.set_2014(row.get_2014().replace(",", "."));
            row.set_2015(row.get_2015().replace(",", "."));
            row.set_2016(row.get_2016().replace(",", "."));
            row.set_2017(row.get_2017().replace(",", "."));
            row.set_2018(row.get_2018().replace(",", "."));
            row.set_2019(row.get_2019().replace(",", "."));
            row.set_2020(row.get_2020().replace(",", "."));


        }
        return rows;
    }

}
