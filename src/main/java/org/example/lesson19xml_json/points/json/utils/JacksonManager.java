package org.example.lesson19xml_json.points.json.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.lesson19xml_json.points.json.model.Employee;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JacksonManager {
    public void printEmployeeFromJson(String filePath) {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(filePath));
            ObjectMapper mapper = new ObjectMapper();
            Employee employee = mapper.readValue(jsonData, Employee.class);
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            StringWriter stringEmployee = new StringWriter();
            mapper.writeValue(stringEmployee, employee);
            System.out.println("Jackson employee:\n" + stringEmployee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
