package com.example.trackxpense;

import java.util.Date;
import java.util.List;

public class Expense {
    Float value;
    Date date;
    Boolean recurring;
    String category;

    public Expense(Float value, Date date, Boolean recurring, String category) {
        this.value = value;
        this.date = date;
        this.recurring = recurring;
        this.category = category;
    }

    public Expense getExpense() {
        return this;
    }

    public void listAdd (List l) {
        l.add(this);
    }

    public String toString() {
        return this.value.toString() + " " + this.date.toString();
    }
}
