package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class SecondActivity extends AppCompatActivity {
TextView overviewTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        overviewTV=findViewById(R.id.overviewTV);
        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            overviewTV.setText(extras.getString("overview"));
        }
    }
}
