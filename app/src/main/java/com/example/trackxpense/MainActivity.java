package com.example.trackxpense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        final ImageButton button = findViewById(R.id.addNewExpenses);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(MainActivity.this.getContext(), NewExpenseActivity.class);
                startActivity(intent);
            }
        });
        ArrayList[] expenseList = new ArrayList[]{};
    }
    private Context getContext() {
        return this;
    }

}