package com.Dinesh.ShoppingCartDemo.ShoppingCartDemo.Entity;

public class Customer {

    private String name;

    private String contact;

    private Double bill_amount=0.0;

    //Every customer hase individaul basket for shopping
    private Basket basket;

    public Customer() {
        this.basket=new Basket();
    }

    public Customer(String name, String contact, Basket basket) {
        this.name = name;
        this.contact = contact;
//        this.bill_amount = bill_amount;
        this.basket = basket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Double getBill_amount() {
        return bill_amount;
    }

    public void setBill_amount(Double bill_amount) {
        this.bill_amount = bill_amount;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
