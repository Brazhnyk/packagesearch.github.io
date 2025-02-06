package com.peakwork.trainee.artem.packagesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ResponseBody
public class MyFirstProjectApplication<CSVReader, CsvToBean> {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstProjectApplication.class, args);
    }

}