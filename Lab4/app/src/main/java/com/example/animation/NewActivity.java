package com.example.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.animation.Animation;
import android.os.Bundle;
import android.widget.Toast;
import android.view.animation.AnimationUtils;

public class NewActivity extends MainActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity);

        Button button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khởi chạy MainActivity
                Intent intent = new Intent(NewActivity.this, MainActivity.class);
                startActivity(intent);

                // Đóng Newactivity
                finish();
            }
        });
    }
}

