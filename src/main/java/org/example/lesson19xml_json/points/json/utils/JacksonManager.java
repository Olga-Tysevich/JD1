package org.example.lesson19xml_json.points.json.utils;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.reflect.TypeToken;
import org.example.lesson19xml_json.points.json.model.Employee;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

    public List<Employee> getEmployeeList(String filePath) {
        List<Employee> result = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(new File(filePath),  new TypeReference<List<Employee>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
