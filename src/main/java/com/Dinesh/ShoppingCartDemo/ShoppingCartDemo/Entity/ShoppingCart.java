package com.Dinesh.ShoppingCartDemo.ShoppingCartDemo.Entity;

import java.util.*;

public class ShoppingCart {

    private String shop_name;

    private List<Items> items;

    private List<Customer> customers;

    private HashMap<Date,Customer> invoice;

    public ShoppingCart(String shop_name) {
        this.shop_name = shop_name;
        this.customers=new ArrayList<>();
        this.items=new ArrayList<>();
        this.invoice=new HashMap<>();
    }


    public boolean add_item(Items item){

        int pos=check_item(item.getName());
        if(pos<0){
            this.items.add(item);
            return true;
        }else {
            System.out.println("Item => "+item.getName()+" already exist");
        }
        return false;
    }

    public int check_item(String item){
        int i=0;
        for (Items item1:this.items
             ) {
            if(item1.getName().trim().toLowerCase().equals(item.trim().toLowerCase())){
                return i;
            }
            i++;
        }
        return -1;

    }

    public boolean add_customer(Customer customer){

        int pos=check_cust(customer.getName());
        if(pos<0){
            this.customers.add(customer);
            return true;
        }else {
            System.out.println("Customer "+customer.getName()+" already exists");
        }

        return false;

    }

    public int check_cust(String customer){

        int i=0;
        for (Customer cust:this.customers
             ) {
            if(cust.getName().toLowerCase().equals(customer.toLowerCase())){
                return i;
            }
            i++;
        }
        return -1;

    }

    public boolean add_prod_basket(String customer,String item,int quantity){

        int checkcust=check_cust(customer);
        int itemcheck=check_item(item);
        if(checkcust>=0 && itemcheck>=0){
            Customer cust=this.customers.get(checkcust);
            Items item_add=this.items.get(itemcheck);
            HashMap<Items,Integer> basket=cust.getBasket().getBasket();
            if(basket.containsKey(item_add)){
                basket.put(item_add,quantity+basket.get(item_add));
                item_add.reduce_stock(quantity);
            }else {
                basket.put(item_add,quantity);
                item_add.reduce_stock(quantity);
            }
            return true;
        }else {
            return false;
        }



    }

    public boolean remove_prod_basket(String customer,String item){

        int checkcust=check_cust(customer);
        int itemcheck=check_item(item);
        if(checkcust>=0 && itemcheck>=0){
            Customer cust=this.customers.get(checkcust);
            Items item_add=this.items.get(itemcheck);
            HashMap<Items,Integer> basket=cust.getBasket().getBasket();
            if(basket.containsKey(item_add)){
                basket.remove(item_add);
            }
            return true;
        }else {
            return false;
        }


    }

    public void print_bill(String customer){

        int pos=check_cust(customer);
        Double price=0.0;
        if(pos>=0){
            Customer find=this.customers.get(pos);

            System.out.println("*************Billing*************");
            System.out.println("Customer Name : "+find.getName()+"\t, Customer contact : "+find.getContact());
            for(Map.Entry<Items,Integer> e:find.getBasket().getBasket().entrySet()){

                System.out.println("Item => "+e.getKey().getName()+" , Price => "+e.getKey().getPrice()+" , Quantity => "+e.getValue()+", Amount => "+e.getKey().getPrice()*e.getValue());
                price+=e.getKey().getPrice()*e.getValue();
            }
            if(price!=0){
                find.setBill_amount(price);
                System.out.println("Total amount to pay : "+find.getBill_amount());
                invoice.put(new Date(),find);
            }

        }else {
            System.out.println("customer doesn't exist");
        }

    }

    public void print_invoice(){
        System.out.println("============================> Invoice <=================================");
        for(Map.Entry<Date,Customer> e:this.invoice.entrySet()){
            System.out.println("Date : "+e.getKey()+", Customer Name : "+e.getValue().getName()+", Contact : "+e.getValue().getContact());
            for (Map.Entry<Items,Integer> a:e.getValue().getBasket().getBasket().entrySet()){
                System.out.println("Item => "+a.getKey().getName()+" , Price => "+a.getKey().getPrice()+" , Quantity => "+a.getValue()+", Amount => "+a.getKey().getPrice()*a.getValue());
            }
            System.out.println();
        }

    }


    public String getShop_name() {
        return shop_name;
    }

    public List<Items> getItems() {
        return items;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public HashMap<Date, Customer> getInvoice() {
        return invoice;
    }
}
