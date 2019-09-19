package com.ics.demo.models;

public class MockLecturers {
    private Long id;
    private String name;

    public MockLecturers() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MockLecturers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
