package com.example.mobile.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tblStudent")
/*
create table tblStudent(
id int primary key auto_increment,
    name varchar(200),
    year int
    );
    * */
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer year;

    public Student() {}
    public Student( String name, Integer year){

        this.name = name;
        this.year = year;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
