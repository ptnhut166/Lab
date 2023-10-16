package com.example.th3;

public abstract class Employee {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double TinhLuong();
    @Override
    public String toString() {
        return this.id+" - "+this.name;
    }
}
