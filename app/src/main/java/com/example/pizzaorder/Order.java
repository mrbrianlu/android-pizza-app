package com.example.pizzaorder;

public class Order {

    private int id;
    private String name;
    private String phone;
    private double price;

    public Order (int newId, String newName, String newPhone, double newPrice) {
        setId(newId);
        setName(newName);
        setPhone(newPhone);
        setPrice(newPrice);
    }

    public void setId (int newId) {
        id = newId;
    }

    public void setName (String newName) {
        name = newName;
    }

    public void setPhone (String newPhone) {
        phone = newPhone;
    }

    public void setPrice (double newPrice) {
        if (newPrice >= 0.0)
            price = newPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public double getPrice() {
        return price;
    }

    public String toString( ) {
        return id + "; " + name + "; " + phone + "; "+ price;
    }
}
