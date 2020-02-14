package com.example.pizzaorder;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class OrderActivity extends AppCompatActivity {

    Pizza pizza = new Pizza();
    private double price;
    private ImageView pepperoniImg, sausageImg, chickenImg, baconImg, mushroomImg, grnpepperImg, oliveImg, pineappleImg,
            pepperoniIcon, sausageIcon, chickenIcon, baconIcon, mushroomIcon, grnpepperIcon, oliveIcon, pineappleIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }
    public void onRdoClicked(View v) {

        boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId()) {
            case R.id.small_rdo:
                if(checked) {
                    pizza.setSizePrice(7);
                    updatePrice();
                }
                break;
            case R.id.medium_rdo:
                if(checked) {
                    pizza.setSizePrice(10);
                    updatePrice();
                }
                break;
            case R.id.large_rdo:
                if(checked) {
                    pizza.setSizePrice(13);
                    updatePrice();
                }
                break;
        }
    }

    public void onChkClicked(View v) {

        boolean checked = ((CheckBox) v).isChecked();
        switch (v.getId()) {
            case R.id.pepperoni_chk:
                pepperoniImg = findViewById(R.id.pepperoniImg);
                pepperoniIcon = findViewById(R.id.pepperoniIcon);
                if(checked) {
                    pizza.setPepperoni(2);
                    updatePrice();
                    pepperoniImg.setVisibility(View.VISIBLE);
                    pepperoniIcon.setForeground(getDrawable(R.drawable.check));
                } else {
                    pizza.setPepperoni(0);
                    updatePrice();
                    pepperoniImg.setVisibility(View.INVISIBLE);
                    pepperoniIcon.setForeground(null);
                }
                break;
            case R.id.sausage_chk:
                sausageImg = findViewById(R.id.sausageImg);
                sausageIcon = findViewById(R.id.sausageIcon);
                if(checked) {
                    pizza.setSausage(2);
                    updatePrice();
                    sausageImg.setVisibility(View.VISIBLE);
                    sausageIcon.setForeground(getDrawable(R.drawable.check));
                } else {
                    pizza.setSausage(0);
                    updatePrice();
                    sausageImg.setVisibility(View.INVISIBLE);
                    sausageIcon.setForeground(null);
                }
                break;
            case R.id.chicken_chk:
                chickenImg = findViewById(R.id.chickenImg);
                chickenIcon = findViewById(R.id.chickenIcon);
                if(checked) {
                    pizza.setChicken(2);
                    updatePrice();
                    chickenImg.setVisibility(View.VISIBLE);
                    chickenIcon.setForeground(getDrawable(R.drawable.check));
                } else {
                    pizza.setChicken(0);
                    updatePrice();
                    chickenImg.setVisibility(View.INVISIBLE);
                    chickenIcon.setForeground(null);
                }
                break;
            case R.id.bacon_chk:
                baconImg = findViewById(R.id.baconImg);
                baconIcon = findViewById(R.id.baconIcon);
                if(checked) {
                    pizza.setBacon(2);
                    updatePrice();
                    baconImg.setVisibility(View.VISIBLE);
                    baconIcon.setForeground(getDrawable(R.drawable.check));
                } else {
                    pizza.setBacon(0);
                    updatePrice();
                    baconImg.setVisibility(View.INVISIBLE);
                    baconIcon.setForeground(null);
                }
                break;

            case R.id.mushroom_chk:
                mushroomImg = findViewById(R.id.mushroomImg);
                mushroomIcon = findViewById(R.id.mushroomIcon);
                if(checked) {
                    pizza.setMushroom(2);
                    updatePrice();
                    mushroomImg.setVisibility(View.VISIBLE);
                    mushroomIcon.setForeground(getDrawable(R.drawable.check));
                } else {
                    pizza.setMushroom(0);
                    updatePrice();
                    mushroomImg.setVisibility(View.INVISIBLE);
                    mushroomIcon.setForeground(null);
                }
                break;
            case R.id.greenpepper_chk:
                grnpepperImg = findViewById(R.id.grnpepperImg);
                grnpepperIcon = findViewById(R.id.grnpepperIcon);
                if(checked) {
                    pizza.setGreenpepper(2);
                    updatePrice();
                    grnpepperImg.setVisibility(View.VISIBLE);
                    grnpepperIcon.setForeground(getDrawable(R.drawable.check));
                } else {
                    pizza.setGreenpepper(0);
                    updatePrice();
                    grnpepperImg.setVisibility(View.INVISIBLE);
                    grnpepperIcon.setForeground(null);
                }
                break;
            case R.id.olive_chk:
                oliveImg = findViewById(R.id.oliveImg);
                oliveIcon = findViewById(R.id.oliveIcon);
                if(checked) {
                    pizza.setOlive(2);
                    updatePrice();
                    oliveImg.setVisibility(View.VISIBLE);
                    oliveIcon.setForeground(getDrawable(R.drawable.check));
                } else {
                    pizza.setOlive(0);
                    updatePrice();
                    oliveImg.setVisibility(View.INVISIBLE);
                    oliveIcon.setForeground(null);
                }
                break;
            case R.id.pineapple_chk:
                pineappleImg = findViewById(R.id.pineappleImg);
                pineappleIcon = findViewById(R.id.pineappleIcon);
                if(checked) {
                    pizza.setPineapple(2);
                    updatePrice();
                    pineappleImg.setVisibility(View.VISIBLE);
                    pineappleIcon.setForeground(getDrawable(R.drawable.check));
                } else {
                    pizza.setPineapple(0);
                    updatePrice();
                    pineappleImg.setVisibility(View.INVISIBLE);
                    pineappleIcon.setForeground(null);
                }
                break;
        }
    }

    public void updatePrice () {

        price = pizza.calculateTotal();
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String priceString = currencyFormat.format(price);
        TextView priceTxv = findViewById(R.id.initTotal_txv);
        priceTxv.setText("Total: " + priceString);
    }

    public void next (View v) {

        if (pizza.getSizePrice() < 7) {
            Toast.makeText(this, "Please select a size.", Toast.LENGTH_LONG).show();
        } else if ((pizza.calculateTotal() - pizza.getSizePrice()) == 0) {
            Toast.makeText(this, "Please select at least one topping.", Toast.LENGTH_LONG).show();
        } else {
            Intent nextIntent = new Intent(this, ConfirmActivity.class);
            String priceString = Double.toString(price);
            nextIntent.putExtra("Price", priceString);
            startActivity(nextIntent);
        }
    }
}
