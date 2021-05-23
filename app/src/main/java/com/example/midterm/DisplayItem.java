package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayItem extends AppCompatActivity {
    TextView tvDisplayName, tvDisplayItem, tvDisplayPrior, tvDatePickDisplay, textviewDateDisplay, tvTimeDsiplay;
    ImageView ivRepeatDis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item);
        Intent intent = getIntent();
        init();
        textviewDateDisplay.setText(intent.getStringExtra("keyarraydate"));
        tvTimeDsiplay.setText(intent.getStringExtra("keyarraytime"));
        tvDisplayName.setText(intent.getStringExtra("keyarrayname"));
        tvDisplayPrior.setText(intent.getStringExtra("keyarraypriority"));
        tvDisplayItem.setText(intent.getStringExtra("keyarrayitems"));
        String repeat = intent.getStringExtra("keyrepeat");

        if(repeat=="true")
        {
            ivRepeatDis.setImageResource(R.drawable.repeatblue);
        }
        else
        {
            ivRepeatDis.setImageResource(R.drawable.repeatblack);
        }


    }

    private void init() {
        tvDisplayName = findViewById(R.id.tvDisplayName);
        tvDisplayItem = findViewById(R.id.tvDisplayItem);
        tvDisplayPrior = findViewById(R.id.tvDisplayPrior);
        textviewDateDisplay = findViewById(R.id.textviewDateDisplay);
        tvTimeDsiplay = findViewById(R.id.tvTimeDsiplay);
        ivRepeatDis = findViewById(R.id.ivRepeatDis);

    }
}