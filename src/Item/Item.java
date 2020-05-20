/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author muhammad
 */
public class Item {

    private String name;
    private Quantity Stock;
    private ArrayList<Item> ingredients = new ArrayList<Item>();
    private int Harga;
    private Quantity need;
    private ArrayList<String> category;

    public Item(String name, Quantity total, ArrayList<Item> ingredients) {
        this.name = name;
        this.Stock = total;
        this.ingredients = ingredients;
    }

    public Item(String name, Quantity total) {
        this.name = name;
        this.Stock = total;
    }

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Quantity getStock() {
        if (ingredients.isEmpty()) {
            return Stock;
        }
        Double sisaan = Double.MAX_VALUE;
        for (Item ingredient : ingredients) {
            sisaan = Double.min(sisaan, (ingredient.Stock.getPureWeight() % need.getPureWeight()));
        }
        Quantity left = new Quantity(sisaan);
        return left;
    }

    public void setStock(Quantity Stock) {
        if (ingredients.isEmpty()) {
            this.Stock = Stock;
        } else {
            System.out.println("Maaf anda tidak bisa men-set jumlah barang yang memiliki bahan baku");
        }
    }

    public void addStock(Quantity Stock) {
        this.Stock.add(Stock);
    }

    public ArrayList<Item> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Item> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }

    public int size() {
        return ingredients.size();
    }

    public boolean contains(Object o) {
        return ingredients.contains(o);
    }
    
    private Item getIngredients(int index) {
        return ingredients.get(index);
    }

    private Item set(int index, Item element) {
        return ingredients.set(index, element);
    }

    public Item getIngredients(String o) {
        int index = -1;
        Item barang = new Item(o);
        if (ingredients.contains(barang)) {
            index = ingredients.indexOf(barang);
        } else {
            System.out.println("Bahan baku tidak ada di list bahan baku");;
        }
        return getIngredients(index);
    }

    public Item set(String lama, Object baru) {
        int index = -1;
        Item barangLama = new Item(lama);
        if (ingredients.contains(barangLama)) {
            index = ingredients.indexOf(barangLama);
        } else {
            System.out.println("Bahan baku tidak ada di list bahan baku");;
        }
        return set(index, (Item) baru);
    }

    public boolean addIngredients(Item e) {
        return ingredients.add(e);
    }

    public boolean removeIngredients(Object o) {
        return ingredients.remove(o);
    }

    public boolean removeAllIngredients(Collection<?> c) {
        return ingredients.removeAll(c);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!this.name.equalsIgnoreCase(other.name)) {
            return false;
        }
        Iterator a = this.ingredients.iterator();
        Iterator b = other.ingredients.iterator();
        while (a.hasNext()) {
            if (!b.hasNext()) {
                return false;
            }
            return a.next().equals(b.next());
        }
        if (b.hasNext()) {
            return false;
        }
        return true;
    }

    public void print() {
        if (ingredients.isEmpty()) {
            System.out.printf("\nProduk: %s\nHarga: Rp.%d\nStock: %s\n", name, Harga, Stock);
        } else {
            System.out.printf("\nProduk: %s\nHarga: Rp.%d\nStock: %d\nBahan Baku\n", name, Harga, getStock());
            for (Item ingredient : ingredients) {
                System.out.println(ingredient + "Butuh: " + need);
            }
        }
    }
}
