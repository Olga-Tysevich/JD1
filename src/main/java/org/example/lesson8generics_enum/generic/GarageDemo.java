package org.example.lesson8generics_enum.generic;

import java.util.Scanner;

/*Создать классы Car и Motorcycle, которые наследуются от Vehicle.
* Создать поле name в Vehicle и проинициализировать его через конструктор.
* Создать generic класс Garage, который может хранить только объекты типа
* наследуемого от Vehicle. Создать два объекта класса Garage(все поля ввести с клавиатуры)
* и вывести на экран имя хранимого транспортного средства*/
public class GarageDemo {
    public static void main(String[] args) {
       Garage<Motorcycle> garage1 = new Garage<>();
       garage1.addVehicle(new Motorcycle(getVehicleName()));
       Garage<Car> garage2 = new Garage<>();
       garage2.addVehicle(new Car(getVehicleName()));

       garage1.printVehicleName();
       garage2.printVehicleName();
    }

    //Или я не правильно поняла задание или не поняла зачем эта часть нужна =)
    public static String getVehicleName() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input vehicle name:");
            String name = scanner.nextLine();
            if (!name.isBlank()) {
                return name;
            } else {
                System.out.println("Invalid name");
            }
        }
    }
}
