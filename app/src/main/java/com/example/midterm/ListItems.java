package com.example.midterm;

public class ListItems {
    String priority;
    String date;
    String time;
    boolean repeat;
    String name;
    String items;

    public ListItems() {
    }

    public ListItems(String priority, String date, String time, boolean repeat, String name, String items) {
        this.priority = priority;
        this.date = date;
        this.time = time;
        this.repeat = repeat;
        this.name = name;
        this.items = items;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ListItems{" +
                "priority='" + priority + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", repeat=" + repeat +
                '}';
    }
}
