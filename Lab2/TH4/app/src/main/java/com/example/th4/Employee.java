package com.example.th4;

public class Employee {
    private String id;
    private String name;
    private boolean isManager;
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }
    @Override
    public String toString()
    {
        return this.id +" - "+ this.name;
    }
}
