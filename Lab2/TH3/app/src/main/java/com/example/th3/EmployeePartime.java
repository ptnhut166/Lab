package com.example.th3;

public class EmployeePartime extends Employee{
    @Override
    public double TinhLuong() {
        // TODO Auto-generated method stub
        return 150;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() +" -->PartTime="+TinhLuong();
    }
}
