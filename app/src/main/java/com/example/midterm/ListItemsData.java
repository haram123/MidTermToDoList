package com.example.midterm;
import android.app.Application;

import com.example.midterm.ListItems;

import java.util.ArrayList;

public class ListItemsData extends Application {
    public static ArrayList<ListItems> items;
    public void onCreate() {
        super.onCreate();
        items = new ArrayList<>();
        items.add(new ListItems("HIGH", "10-12-2020", "12:23", false, "Shopping", "abc"));


    }

}
