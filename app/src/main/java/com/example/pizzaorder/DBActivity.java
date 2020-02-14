package com.example.pizzaorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DBActivity extends AppCompatActivity {

    private DatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager( this );
        updateView( );
    }

    public void updateView( ) {
        ArrayList<Order> orders = dbManager.selectAll( );
        RelativeLayout layout = new RelativeLayout( this );
        ScrollView scrollView = new ScrollView( this );
        RadioGroup group = new RadioGroup( this );
        for ( Order order : orders ) {
            RadioButton rb = new RadioButton( this );
            rb.setId( order.getId( ) );
            rb.setText( order.toString( ) );
            group.addView( rb );
        }
        scrollView.addView(group);
        layout.addView(scrollView);
        setContentView(layout);
    }
}
