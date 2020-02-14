package com.example.pizzaorder;

public class Pizza {

    double sizePrice;
    double pepperoni;
    double sausage;
    double chicken;
    double bacon;
    double mushroom;
    double greenpepper;
    double olive;
    double pineapple;
    double total;

    public Pizza () {

    }

    public double getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(double sizePrice) {
        this.sizePrice = sizePrice;
    }

    public double getPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(double pepperoni) {
        this.pepperoni = pepperoni;
    }

    public double getSausage() {
        return sausage;
    }

    public void setSausage(double sausage) {
        this.sausage = sausage;
    }

    public double getChicken() {
        return chicken;
    }

    public void setChicken(double chicken) {
        this.chicken = chicken;
    }

    public double getBacon() {
        return bacon;
    }

    public void setBacon(double bacon) {
        this.bacon = bacon;
    }

    public double getMushroom() {
        return mushroom;
    }

    public void setMushroom(double mushroom) {
        this.mushroom = mushroom;
    }

    public double getGreenpepper() {
        return greenpepper;
    }

    public void setGreenpepper(double greenpepper) {
        this.greenpepper = greenpepper;
    }

    public double getOlive() {
        return olive;
    }

    public void setOlive(double olive) {
        this.olive = olive;
    }

    public double getPineapple() {
        return pineapple;
    }

    public void setPineapple(double pineapple) {
        this.pineapple = pineapple;
    }

    public double calculateTotal() {
        total = sizePrice + pepperoni + sausage + chicken + bacon + mushroom + greenpepper + olive + pineapple;
        return total;
    }
}
