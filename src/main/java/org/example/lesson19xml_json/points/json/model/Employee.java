package org.example.lesson19xml_json.points.json.model;

import java.util.List;

public class Employee {
    private int id;
    private String name;
    private boolean isPermanent;
    private Address address;
    private List<Integer> phoneNumbers;
    private String role;
    private List<String> cities;

    public Employee(int id, String name, boolean isPermanent, Address address, List<Integer> phoneNumbers, String role, List<String> cities) {
        this.id = id;
        this.name = name;
        this.isPermanent = isPermanent;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.role = role;
        this.cities = cities;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsPermanent() {
        return isPermanent;
    }

    public void setIsPermanent(boolean permanent) {
        isPermanent = permanent;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Integer> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Integer> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isPermanent=" + isPermanent +
                ", address=" + address +
                ", phoneNumbers=" + phoneNumbers +
                ", role='" + role + '\'' +
                ", cities=" + cities +
                '}';
    }
}
