/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

/**
 *
 * @author muhammad
 */
public class Items {
    private static Items item_instance = null;
    public ArrayList<Item> collectible;
    private Items(){
        collectible = new ArrayList<Item>();
    }
    public static Items getInstance() 
    { 
        if (item_instance == null) 
            item_instance = new Items(); 
  
        return item_instance; 
    }

    public ArrayList<Item> getCollectible() {
        return collectible;
    }

    private Item get(int index) {
        return collectible.get(index);
    }

    private Item set(int index, Item element) {
        return collectible.set(index, element);
    }

    public Item get(String o) {
        int index = -1;
        Item barang = new Item(o);
        if (collectible.contains(barang)) {
            index = collectible.indexOf(barang);
        } else {
            System.out.println("Bahan baku tidak ada di list bahan baku");;
        }
        return get(index);
    }

    public Item set(String lama, Object baru) {
        int index = -1;
        Item barangLama = new Item(lama);
        if (collectible.contains(barangLama)) {
            index = collectible.indexOf(barangLama);
        } else {
            System.out.println("Bahan baku tidak ada di list bahan baku");;
        }
        return set(index, (Item) baru);
    }

    public void setCollectible(ArrayList<Item> collectible) {
        this.collectible = collectible;
    }

    public int size() {
        return collectible.size();
    }

    public boolean isEmpty() {
        return collectible.isEmpty();
    }

    public boolean contains(Object o) {
        return collectible.contains(o);
    }

    public boolean add(Item e) {
        return collectible.add(e);
    }

    public boolean remove(Object o) {
        return collectible.remove(o);
    }

    public void clear() {
        collectible.clear();
    }

    public boolean removeAll(Collection<?> c) {
        return collectible.removeAll(c);
    }

    public void forEach(Consumer<? super Item> action) {
        collectible.forEach(action);
    }
    
}
