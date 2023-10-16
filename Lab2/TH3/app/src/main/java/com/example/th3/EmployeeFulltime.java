package com.example.th3;

public class EmployeeFulltime extends Employee{

    @Override
    public double TinhLuong() {
        return 500;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() +" -->FullTime="+TinhLuong();
    }
}
