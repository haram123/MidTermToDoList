package com.example.midterm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddItem extends AppCompatActivity {
    ImageView ivAdd, ivClock, ivRepeatDisplay;
    TextView tvItem,tvDatePickDisplay, tvTime, tvItemName;
    static final int ENTERITEMACTIVITY=1 ;
    DatePickerDialog datePickerDialog;
    ImageView ivDatePicker;
    int timeMinute, hour;
    String arraypriority,arraydate,arraytime,arrayname,arrayitems;
    boolean repeat;
    RadioButton rbHigh, rbLow, rbMedium;
    EditText etName;

    RadioGroup rgroup;
    Button btnAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        init();
        initDatePicker();

        tvItemName.setVisibility(View.GONE);


        Calendar calender = Calendar.getInstance();
        String current = DateFormat.getDateInstance().format(calender.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm aa");
        String time = simpleDateFormat.format(calender.getTime());
        tvDatePickDisplay.setText(current);
        tvTime.setText(time);



        ivDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        ivClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        AddItem.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                hour = hourOfDay;
                                timeMinute = minute;

                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,hour,timeMinute);
                                tvTime.setText(android.text.format.DateFormat.format("hh:mm aa", calendar.getTime()));

                            }
                        }, 12, 0, false
                );

                timePickerDialog.updateTime(hour, timeMinute);
                timePickerDialog.show();
                arraytime = tvTime.getText().toString();
            }
        });
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddItem.this, EnterItem.class);
                startActivityForResult(i, ENTERITEMACTIVITY);
                tvItemName.setVisibility(View.VISIBLE);




            }
        });
        ivRepeatDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivRepeatDisplay.setImageResource(R.drawable.repeatblue);

                repeat=true;

            }
        });
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayname = etName.getText().toString();

                if(rbHigh.isChecked())
                {
                    arraypriority="HIGH";
                }
                else if(rbMedium.isChecked())
                {
                    arraypriority="MEDIUM";
                }
                else if (rbLow.isChecked())
                {
                    arraypriority="LOW";
                }


                Intent intent = new Intent();
                intent.putExtra("keyarrayname",arrayname);
                intent.putExtra("keyarrayitem", arrayitems);
                intent.putExtra("keyarraytime",arraytime);
                intent.putExtra("keyarraydate",arraydate);
                intent.putExtra("keyarraypriority",arraypriority);
                intent.putExtra("keyrepeat",repeat);
                setResult(RESULT_OK,intent);
                finish();




            }
        });


    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener datasetListner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month+1;
                String date = makeDateString(year, month, day);
                tvDatePickDisplay.setText(date);

            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog = new DatePickerDialog(this, style,datasetListner, year,month,day);
        arraydate = tvDatePickDisplay.getText().toString();


    }

    private String makeDateString(int year, int month, int day) {
        return day+  "-"+ month + "-"+ year;
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

          if(requestCode==ENTERITEMACTIVITY)
        {
            if(resultCode==RESULT_OK)
            {
                arrayitems = data.getStringExtra("itemNamekey");
                tvItemName.setText(arrayitems);
            }
        }
    }

    private void init() {
        ivAdd = findViewById(R.id.ivAdd);
        tvDatePickDisplay = findViewById(R.id.textviewDateDisplay);
        ivDatePicker = findViewById(R.id.ivDatePicker);
        ivClock = findViewById(R.id.ivClock);
        tvTime = findViewById(R.id.tvTimeDsiplay);
        tvItemName = findViewById(R.id.tvDisplayItem);
        ivRepeatDisplay = findViewById(R.id.ivRepeatDisplay);
        rbHigh = findViewById(R.id.rbHigh);
        rbLow = findViewById(R.id.rbLow);
        rbMedium = findViewById(R.id.rbMedium);
        rgroup = findViewById(R.id.rgroup);
        btnAddItem = findViewById(R.id.btnAddItem);
        etName = findViewById(R.id.etName);


    }

//    public void OpenDatePicker(View view) {
//        datePickerDialog.show();
//    }
}