package com.example.th3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    EditText edt_ma,edt_ten;
    Button btn_nhap;
    RadioButton rad_ct,rad_tv;
    ListView lv_nv;
    RadioGroup rad_gr;
    ListView lvNhanvien;
    ArrayList<Employee>arrEmployee=new ArrayList<Employee>();
    ArrayAdapter<Employee>adapter=null;
    //Khai báo 1 employee object
    Employee employee=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_ma = findViewById(R.id.ma_nv);
        edt_ten = findViewById(R.id.ten_nv);
        rad_ct =findViewById(R.id.rad_ct);
        rad_tv =findViewById(R.id.rad_tv);
        rad_gr =findViewById(R.id.rad_gr);
        btn_nhap = findViewById(R.id.btn);
        lv_nv =findViewById(R.id.lv_nv);


        adapter=new ArrayAdapter<Employee>(this,
                android.R.layout.simple_list_item_1,
                arrEmployee);
        //đưa adapter vào ListView
        lv_nv.setAdapter(adapter);

        btn_nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewEmployee();
            }
        });

    }


    public void addNewEmployee() {
        //Lấy ra đúng id của Radio Button được checked
        int radId = rad_gr.getCheckedRadioButtonId();
        String id = edt_ma.getText().toString();
        String name = edt_ten.getText().toString();
        if (radId == R.id.rad_ct) {
            //tạo instance là FullTime
            employee = new EmployeeFulltime();
        } else {
            //Tạo instance là Partime
            employee = new EmployeePartime();
        }
        //FullTime hay Partime thì cũng là Employee nên có các hàm này là hiển nhiên
        employee.setId(id);
        employee.setName(name);
        //Đưa employee vào ArrayList
        arrEmployee.add(employee);
        //Cập nhập giao diện
        adapter.notifyDataSetChanged();
        edt_ma.getText().clear();
        edt_ten.getText().clear();
    }
}

