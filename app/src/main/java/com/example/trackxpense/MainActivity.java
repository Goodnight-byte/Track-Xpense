package com.example.trackxpense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Expense> expenseList = new ArrayList<>();

    ArrayAdapter<Expense> itemsAdapter;
    Float total = Float.valueOf(0);
    TextView totalCost;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        itemsAdapter =
                new ArrayAdapter<Expense>(getContext(), android.R.layout.simple_list_item_1, expenseList);
        final ListView listview = (ListView) findViewById(R.id.listOfExpenses);
        listview.setAdapter(itemsAdapter);
        totalCost = findViewById(R.id.totalExpenses);
        this.updateTotal();


        final ImageButton button = findViewById(R.id.addNewExpenses);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(MainActivity.this.getContext(), NewExpenseActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    
    }

    private void updateTotal() {
        for (Expense e: expenseList) {
            total += e.value;

        }
        totalCost.setText(total.toString());

    }

    private Context getContext() {
        return this;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == RESULT_OK){
            String je = data.getStringExtra("expense");
            Expense e = new Gson().fromJson(je, Expense.class);
            e.listAdd(expenseList);
            itemsAdapter.notifyDataSetChanged();
            this.updateTotal();

        }


}


}