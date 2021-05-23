package com.example.midterm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.Calendar;

import static android.widget.Toast.LENGTH_SHORT;
import static com.example.midterm.AddItem.ENTERITEMACTIVITY;
import static com.example.midterm.ListItemsData.items;

public class MainActivity extends AppCompatActivity implements Adapter.ItemSelected {
    TextView tvDateDisplay, tvEmpty,tvTaskHeadline;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter myAdaptor;
    final int ADDITEMACTIVITY=2;
    String arraypriority,arraydate,arraytime,arrayname,arrayitems;
    boolean repeat;
    ImageView ivList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        init();
        tvTaskHeadline.setText("Add some tasks for your ease");
        Calendar calender = Calendar.getInstance();
        String current = DateFormat.getDateInstance().format(calender.getTime());
        tvDateDisplay.setText(current);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, com.example.midterm.AddItem.class);
                startActivityForResult(intent,ADDITEMACTIVITY);

                tvTaskHeadline.setText("You have these tasks to perform");



            }
        });


    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ADDITEMACTIVITY)
        {

            if(resultCode==RESULT_CANCELED)
            {
                Toast.makeText(MainActivity.this, "Item could not be added in main", LENGTH_SHORT).show();
            }
            else if(resultCode==RESULT_OK)
            {
                 arraypriority  = data.getStringExtra("keyarraypriority");
                arraydate = data.getStringExtra("keyarraydate");
                 arraytime = data.getStringExtra("keyarraytime");
                 arrayname = data.getStringExtra("keyarrayname");
                 repeat = data.getBooleanExtra("keyrepeat",false);
                 arrayitems = data.getStringExtra("keyarrayitem");
                items.add(new ListItems(arraypriority, arraydate, arraytime,repeat, arrayname,arrayitems));
                myAdaptor = new Adapter(this,ListItemsData.items);
                recyclerView.setAdapter(myAdaptor);
                myAdaptor.notifyDataSetChanged();
                ivList.setVisibility(View.GONE);
                tvEmpty.setVisibility(View.GONE);









            }
        }

    }
    public void init()
    {
        tvDateDisplay = findViewById(R.id.tvDateDisplay);
        fab = findViewById(R.id.fab);
        tvEmpty = findViewById(R.id.tvEmpty);
        ivList = findViewById(R.id.ivList);
        tvTaskHeadline = findViewById(R.id.tvTaskHeadline);



    }
    public void onItemClicked(int index)
    {
        Intent intent = new Intent(MainActivity.this, DisplayItem.class);
        intent.putExtra("keyarrayname",ListItemsData.items.get(index).getName());
        intent.putExtra("keyarraydate",ListItemsData.items.get(index).getDate());
        intent.putExtra("keyarraytime",ListItemsData.items.get(index).getTime());
        intent.putExtra("keyarrayitems",ListItemsData.items.get(index).getItems());
        intent.putExtra("keyarraypriority",ListItemsData.items.get(index).getPriority());
        intent.putExtra("keyrepeat",ListItemsData.items.get(index).isRepeat());
        startActivity(intent);


    }


}