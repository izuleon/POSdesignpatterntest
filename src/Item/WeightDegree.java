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
public enum WeightDegree {
    juta(1000000),ribu(1000),ratus(100),satu(1);
    private int modifier;
    private WeightDegree(int modifier) {
        this.modifier = modifier;
    }

    public int getModifier() {
        return modifier;
    }

    @Override
    public String toString() {
        switch(modifier){
            case 1000000:{
                return "K";
            }
            case 1000:{
                return "";
            }
            case 100: {
                return "c";
            }
        }
        return "m";
    }
    
}
