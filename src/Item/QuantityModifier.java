/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

/**
 *
 * @author muhammad
 */
public enum QuantityModifier {
    piece("pcs"),berat("g"),volume("l"),luas("m");
    private String mod;

    private QuantityModifier(String mod) {
        this.mod = mod;
    }

    public String getMod() {
        return mod;
    }

    @Override
    public String toString() {
        return getMod();
    }
    
}

