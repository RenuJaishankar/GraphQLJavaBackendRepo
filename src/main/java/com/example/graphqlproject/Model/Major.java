package com.example.graphqlproject.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="majors")
public class Major {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String major;
    private int noOfKids;

    public Major(String major, int noOfKids) {
        this.major = major;
        this.noOfKids = noOfKids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Major major = (Major) o;
        return noOfKids == major.noOfKids &&
                Objects.equals(id, major.id) &&
                Objects.equals(this.major, major.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, major, noOfKids);
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", major='" + major + '\'' +
                ", noOfKids=" + noOfKids +
                '}';
    }

    public Major() {
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setNoOfKids(int noOfKids) {
        this.noOfKids = noOfKids;
    }

    public Long getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    public int getNoOfKids() {
        return noOfKids;
    }
}