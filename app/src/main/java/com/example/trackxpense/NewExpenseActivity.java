package com.example.trackxpense;

import static java.lang.Float.parseFloat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewExpenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_expense);
    }

    public void newExpense(View view) throws ParseException {

        Switch s = (Switch) findViewById(R.id.recurringSwitch);
        Boolean recurring;
        if (s != null) {
            recurring = true;
        } else {
            recurring = false;
        }
        EditText value = (EditText) findViewById(R.id.expenseFloat);
        EditText date = (EditText) findViewById(R.id.expenseDate);
        EditText category = (EditText) findViewById(R.id.expenseCategory);
        String expenseValue = value.getText().toString();
        String expenseDate = date.getText().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date d = dateFormat.parse(expenseDate);
        String expenseCategory = category.getText().toString();
        Expense e = new Expense(parseFloat(expenseValue), d, recurring,expenseCategory);
    }
}