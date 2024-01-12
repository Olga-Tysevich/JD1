package org.example.lesson18reflection.models;

import java.util.Objects;

public class Man {
    private String name;
    private String surname;
    private int age;

    public Man(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    private Man(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    protected void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Man man = (Man) o;
        return age == man.age &&
                Objects.equals(name, man.name) &&
                Objects.equals(surname, man.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Man{");
        sb.append("name='").append(name);
        sb.append(", surname='").append(surname);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
