package com.example.mobile.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tblStudent")
/*
create table tblStudent(
id int primary key auto_increment,
    email varchar(200),
    password int
    );
    * */
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String password;

    public User() {}
    public User(String email, String password){

        this.email = email;
        this.password = password;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password=" + password +
                '}';
    }
}
