package com.batch;

// @NamedQueries({
//     @NamedQuery(name = "Person.findAll", query = "SELECT c FROM Person c"),
//     @NamedQuery(name = "Person.findByName", query = "SELECT c FROM Person c WHERE c.name = :name"),
//     @NamedQuery(name = "Person.findByHiredate", query = "SELECT c FROM Person c WHERE c.hiredate = :hiredate") })
public class Person{

    private int id;
    private String name;
    private String hiredate;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String hiredate) {
        this.name = name;
        this.hiredate = hiredate;
    }

    public Person(int id, String name, String hiredate) {
        this.id = id;
        this.name = name;
        this.hiredate = hiredate;
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

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

}
