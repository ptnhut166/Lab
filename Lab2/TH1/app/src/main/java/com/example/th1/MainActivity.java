package com.example.th1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import java.util.ArrayList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Khoi tao ListView
        TextView textView=findViewById(R.id.tv_person);
        ListView lvPerson = findViewById(R.id.lv_person);
        final String arr[] = {"Teo", "Ty", "Bin", "Bo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, arr);
        lvPerson.setAdapter(adapter);
        lvPerson.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    
                    public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {

                        textView.setText("position:"+position+";value="+arr[position]);
                        arr[position];
                        Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_LONG).show();
                    }
                });

    }
}
