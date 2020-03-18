package com.example.graphqlproject.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="fruits")
public class Fruit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String state;
    private String color;

       public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public Long getId() {
        return id;
    }

    public Fruit(String name, String state, String color) {
        this.name = name;
        this.state = state;
        this.color = color;
    }
    public Fruit() {
    }
    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(id, fruit.id) &&
                Objects.equals(name, fruit.name) &&
                Objects.equals(state, fruit.state) &&
                Objects.equals(color, fruit.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, state, color);
    }

}
