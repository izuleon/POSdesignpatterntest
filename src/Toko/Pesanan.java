/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Toko;

import Item.Item;
import Item.Items;
import java.util.ArrayList;

/**
 *
 * @author muhammad
 */
public class Pesanan {
    ArrayList<Order> pesanan = new ArrayList<Order>();
    Items gudang = Items.getInstance();
    public Pesanan getTotal(){
        return this;
    }
    public Pesanan removeOrder(Item item){
        return this;
    }
    public Pesanan addOrder(Item item){
        return this;
    }
    public void commitOrder(){
        
    }
    public void print(){
        
    }
    
}
