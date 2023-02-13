package com.uniovi.notaineitor.entities;

public class Professor {
    private Long id;

    private String dni;
    private String name;
    private String surName;
    private String category;
    public Professor() {
    }

    public Professor(Long id, String dni, String name,String surName,String category) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.surName = surName;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
