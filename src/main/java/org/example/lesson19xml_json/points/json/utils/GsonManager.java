package org.example.lesson19xml_json.points.json.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.lesson19xml_json.points.json.model.Employee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GsonManager {
    private Gson gson;

    public GsonManager() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public void writeEmployeeToJson(String filePath, Employee employee) {
        try (PrintWriter writer = new PrintWriter(filePath)){
            writer.println(convertToJson(employee));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String convertToJson(Employee employee) {
        return gson.toJson(employee);
    }

    public Employee readEmployee(String filePath) {
        String employeeString = readEmployeeAsString(filePath);
        return gson.fromJson(employeeString, Employee.class);
    }

    public String readEmployeeAsString(String filePath) {
        String result = null;
        try {
            result = Files.readString(Paths.get(filePath));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}