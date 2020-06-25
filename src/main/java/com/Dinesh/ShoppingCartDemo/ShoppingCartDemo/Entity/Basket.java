package com.Dinesh.ShoppingCartDemo.ShoppingCartDemo.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Basket {

//    private List<Items> items;

    private HashMap<Items,Integer> basket;

    public Basket() {
//        this.items=new ArrayList<Items>();
        this.basket=new HashMap<>();
    }

    public HashMap<Items, Integer> getBasket() {
        return basket;
    }

    //    public boolean add_item(Items item){
//        int pos=search_item(item.getName());
//        if(pos>=0){
//            Items item1=this.items.get(pos);
//
//        }
//    }
//
//    public int  search_item(String item){
//
//        for (Items exist:this.items) {
//            if(exist.getName().toLowerCase().equals(item.toLowerCase())){
//                return 0;
//            }
//
//            return -1;
//
//        }
//
//
//    }
//
//    public List<Items> getItems() {
//        return items;
//    }
}
