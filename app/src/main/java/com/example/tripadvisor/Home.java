package com.example.tripadvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    Button Hotel2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button Hotel2 = findViewById(R.id.hotels);
        Hotel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Clicked");
                Toast.makeText(Home.this, "Button Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Home.this,Hotel.class);
                startActivity(intent);
            }
        });
    }
}