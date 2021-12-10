package com.example.trackxpense;

import java.util.Date;

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
}
