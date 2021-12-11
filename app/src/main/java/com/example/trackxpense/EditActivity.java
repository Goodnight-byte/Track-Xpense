package com.example.trackxpense;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_expense);
        Intent intent = getIntent();
        String expense = intent.getStringExtra("expense");
        Expense e = new Gson().fromJson(expense, Expense.class);

        EditText value = findViewById(R.id.editExpenseFloat);
        EditText date = findViewById(R.id.editExpenseDate);
        EditText category = findViewById(R.id.editExpenseCategory);

        value.setText(String.valueOf(e.value));
        date.setText(String.valueOf(e.date));
        category.setText(e.category);

    }

}