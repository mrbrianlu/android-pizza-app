package com.example.pizzaorder;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {

    // define database name, version, table name, column names in the following as constants
    private static final String DATABASE_NAME = "pizzaDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_ORDER = "orderlist";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PHONE = "phone";
    private static final String PRICE = "price";

    // constructor
    public DatabaseManager( Context context ) {
        // create database with database name and version
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    // initialization
    // we can create table(s) in onCreate method
    public void onCreate( SQLiteDatabase db ) {
        // build sql create statement
        String sqlCreate = "create table " + TABLE_ORDER + "( " + ID;
        sqlCreate += " integer primary key autoincrement, " + NAME;
        sqlCreate += " text, " + PHONE + " text, " + PRICE + " real )" ;

        // run sql command without any return results
        // db is given in the parameter list
        db.execSQL( sqlCreate );
    }

    public void onUpgrade( SQLiteDatabase db,
                           int oldVersion, int newVersion ) {
        // Drop old table if it exists
        db.execSQL( "drop table if exists " + TABLE_ORDER );
        // Re-create tables
        onCreate( db );
    }

    // below, these are NOT an override method
    // insert any candy record
    public void insert( Order order ) {
        // we use getWritableDatabase to open a database so that we can delete/search/update it
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlInsert = "insert into " + TABLE_ORDER;
        sqlInsert += " values( null, '" + order.getName( );
        sqlInsert += "', '" + order.getPhone() + "', '" + order.getPrice( ) + "' )";

        // execute SQL statement without return
        db.execSQL( sqlInsert );

        // close the database connection
        db.close( );
    }

    public ArrayList<Order> selectAll( ) {
        String sqlQuery = "select * from " + TABLE_ORDER;

        SQLiteDatabase db = this.getWritableDatabase( );
        Cursor cursor = db.rawQuery( sqlQuery, null );

        ArrayList<Order> orders = new ArrayList<Order>( );
        // use loops to read all the records from Cursor object
        // we call cursor.moveToNext() to determine if we reach the end of ResultSet
        while( cursor.moveToNext( ) ) {
            Order currentOrder
                    = new Order( Integer.parseInt( cursor.getString( 0 ) ),
                    cursor.getString( 1 ), cursor.getString( 2 ),cursor.getDouble( 3 ) );
            orders.add(currentOrder);
        }
        db.close( );
        return orders;
    }
}
