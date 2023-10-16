package com.example.th2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editxt = findViewById(R.id.editxt);
        Button btn = findViewById(R.id.btn);
        TextView tvPerson = findViewById(R.id.tv_person);
        ListView lvPerson = findViewById(R.id.lv_person);

        ArrayList personList = new ArrayList<String>();
        personList.add("Tèo");
        personList.add("Tý");
        personList.add("Bin");

        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, personList);
        lvPerson.setAdapter(adapter);
        lvPerson.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {

                        tvPerson.setText("position:"+position+";value="+ personList.get(position));
                    }

                });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String person = editxt.getText().toString();
                personList.add(person);
                adapter.notifyDataSetChanged();
            }
        });
        lvPerson.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
            adapter.remove(adapter.getItem(position));
            adapter.notifyDataSetChanged();
            return true;
        }
        });
    }
}