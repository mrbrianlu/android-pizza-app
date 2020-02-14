package com.example.pizzaorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class ConfirmActivity extends AppCompatActivity {

    private DatabaseManager dbManager;
    private double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_confirm);

        Intent nextIntent = getIntent();
        String priceString = nextIntent.getStringExtra("Price");
        price = Double.parseDouble(priceString);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        priceString = currencyFormat.format(price);
        TextView priceTxv = findViewById(R.id.price_txv);
        priceTxv.setText("Total: "+ priceString);

    }

    public void insert(View v) {

        EditText nameEdt = findViewById(R.id.name_edt);
        EditText phoneEdt = findViewById(R.id.phone_edt);

        String name = nameEdt.getText().toString();
        String phone = phoneEdt.getText().toString();

        if (name.isEmpty()) {
            nameEdt.setError("Please enter a name.");
            nameEdt.requestFocus();
        } else if (phone.isEmpty()) {
            phoneEdt.setError("Please enter a phone number.");
            phoneEdt.requestFocus();
        } else {
            Order order = new Order(0, name, phone, price);
            dbManager.insert(order);
            Toast.makeText(this, "Order Completed", Toast.LENGTH_LONG).show();
            Intent goBackMain = new Intent(this, MainActivity.class);
            startActivity(goBackMain);
        }
    }
}
