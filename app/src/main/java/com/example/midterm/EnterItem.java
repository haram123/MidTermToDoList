package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

import static android.widget.Toast.LENGTH_SHORT;

public class EnterItem extends AppCompatActivity {
    EditText etItem;
    Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_item);
        etItem = findViewById(R.id.etItem);
        btnSubmit = findViewById(R.id.btnSubmit);
        Calendar calender = Calendar.getInstance();
        String current = DateFormat.getDateInstance().format(calender.getTime());



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etItem.getText().toString().isEmpty())
                {
                    Toast.makeText(EnterItem.this, "Enter item ", LENGTH_SHORT).show();
                }
                else
                {

                    String itemName = etItem.getText().toString();
                    Intent i = new Intent();
                    i.putExtra("itemNamekey",itemName);
                    setResult(RESULT_OK,i);
                    finish();

                }
            }
        });

    }
}