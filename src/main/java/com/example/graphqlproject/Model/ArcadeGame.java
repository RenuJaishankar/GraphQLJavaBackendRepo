package com.example.graphqlproject.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="arcade_games")
public class ArcadeGame {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    // I need to use a type of Long (wrapper class) for my ID

    public Long getId() {
        return id;
    }

    private String name;
    private int amountOfPlayers;

    public ArcadeGame(String name, int amountOfPlayers) {
        this.name = name;
        this.amountOfPlayers = amountOfPlayers;
    }

    public ArcadeGame(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfPlayers() {
        return amountOfPlayers;
    }

    public void setAmountOfPlayers(int amountOfPlayers) {
        this.amountOfPlayers = amountOfPlayers;
    }



    @Override
    public String toString() {
        return "ArcadeGame{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amountOfPlayers=" + amountOfPlayers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArcadeGame that = (ArcadeGame) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(amountOfPlayers, that.amountOfPlayers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amountOfPlayers);
    }


}
