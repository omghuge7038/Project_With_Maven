package com.tut;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import  org.hibernate.annotations.Cache;

import javax.persistence.*;

@Entity
@Cacheable
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY)


@Table(name = "Student")
public class Student {

    @Id
    private int id;

    private String name;
    private String city;

    @Embedded
    private Certificate certi;

    public Student() {
    }

    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    // getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {   // ❗ FIXED (no parameter)
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // 🔥 THIS METHOD FIXES setCerti ERROR
    public Certificate getCerti() {
        return certi;
    }

    public void setCerti(Certificate certi) {
        this.certi = certi;
    }

    @Override
    public String toString() {
        return id + " : " + name + " : " + city;
    }
}
