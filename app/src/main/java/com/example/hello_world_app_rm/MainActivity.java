package com.example.hello_world_app_rm;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        TextView textView1 = findViewById(R.id.textView1);


        button2.setText("Change color");
        button2.setOnClickListener(View -> {
            textView1.setTextColor(Color.parseColor("#FF0000"));
        });
        button1.setText("Change text");
        button1.setOnClickListener(v -> {
            textView1.setText("Hello World!");
        });
        button3.setText("Change the text's background color");
        button3.setOnClickListener(v -> {
            textView1.setBackgroundColor(Color.parseColor("#FFFF00"));
        });
        textView1.setGravity(Gravity.CENTER);
        button1.setGravity(Gravity.CENTER);
        button2.setGravity(Gravity.CENTER);
        button3.setGravity(Gravity.CENTER);
    }
}