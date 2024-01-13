package org.example.lesson19xml_json.points.json;

import org.example.lesson19xml_json.points.json.model.Address;
import org.example.lesson19xml_json.points.json.model.Employee;
import org.example.lesson19xml_json.points.json.utils.JacksonManager;
import org.example.lesson19xml_json.points.json.utils.GsonManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String FILE_PATH = "src\\main\\java\\org\\example\\lesson19xml_json\\points\\json\\Employee.json";

    public static void main(String[] args) {
        /*Напишите программу, которая будет разбирать json файл и выводить его в текстовом виде*/
        Employee employee = new Employee(123, "Tester", true,
                new Address("Sryganova", "Minsk", 220000), new ArrayList<>(List.of(123456, 987654)),
                "Manager", new ArrayList<>(List.of("Minsk", "Grodno")));

        GsonManager manager = new GsonManager();
        manager.writeEmployeeToJson(FILE_PATH, employee);
        System.out.println(manager.readEmployee(FILE_PATH) + "\n");
        System.out.println("Gson employee:\n" + manager.readEmployeeAsString(FILE_PATH));

        JacksonManager jacksonManager = new JacksonManager();
        jacksonManager.printEmployeeFromJson(FILE_PATH);

    }
}
