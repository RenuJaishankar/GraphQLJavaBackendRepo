package com.example.graphqlproject.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="animals")
public class Animal {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private int amountOfLegs;
    private String name;

    public Animal(int amountOfLegs, String name) {
        this.amountOfLegs = amountOfLegs;
        this.name = name;
    }

    public Animal(){};

    public Long getId() {
        return id;
    }


    public int getAmountOfLegs() {
        return amountOfLegs;
    }

    public void setAmountOfLegs(int amountOfLegs) {
        this.amountOfLegs = amountOfLegs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id='" + id + '\'' +
                ", amountOfLegs=" + amountOfLegs +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return amountOfLegs == animal.amountOfLegs &&
                Objects.equals(id, animal.id) &&
                Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amountOfLegs, name);
    }
}
