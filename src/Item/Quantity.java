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
public class Quantity {

    static Double min(Quantity Stock, Quantity OtherStock) {
        if (!Stock.modifier.equals(OtherStock.modifier)) {
            System.out.println("Kuantitas barang tidak dalam ukuran yang sama");
            return -1.0;
        }
        if (!Stock.degree.equals(OtherStock.degree)) {
            return Double.min(Stock.getWeight() * Stock.degree.getModifier(), OtherStock.getWeight() * OtherStock.degree.getModifier());
        }
        return Double.min(Stock.getWeight(), OtherStock.getWeight());
    }

    private Double weight;
    private QuantityModifier modifier;
    private WeightDegree degree;

    public int hashCode() {
        return weight.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }
        final Quantity other = (Quantity) obj;
        if (!this.modifier.equals(other.modifier)) {
            return false;
        }
        if (!this.degree.equals(other.degree)) {
            return false;
        }
        return weight.equals(obj);
    }

    public Quantity add(Quantity other) {
        if (!this.modifier.equals(other.modifier)) {
            System.out.println("Kuantitas barang tidak dalam ukuran yang sama");
            return this;
        }
        this.setWeight(getPureWeight() + other.getPureWeight());
        return this;
    }

    public Quantity() {
        this.weight = -1.0;
        this.modifier = QuantityModifier.piece;
        this.degree = WeightDegree.satu;
    }

    public Quantity(Double weight) {
        this.modifier = QuantityModifier.piece;
        setWeight(weight);
    }

    public Quantity(Double weight, QuantityModifier modifier, WeightDegree degree) {
        this.weight = weight;
        this.modifier = modifier;
        this.degree = degree;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        if (weight > 1000000) {
            this.weight = weight / 1000000;
            this.degree = WeightDegree.juta;
            return;
        }
        if (weight > 1000) {
            this.weight = weight / 1000;
            this.degree = WeightDegree.ribu;
            return;
        }
        if (weight > 100 && this.modifier.equals(QuantityModifier.luas)) {
            this.weight = weight / 100;
            this.degree = WeightDegree.ratus;
            return;
        }
        this.weight = weight;
        this.degree = WeightDegree.satu;
    }

    @Override
    public String toString() {
        return "Kuantitas{" + weight + degree + modifier + '}';
    }

    public QuantityModifier getModifier() {
        return modifier;
    }

    public void setModifier(QuantityModifier modifier) {
        this.modifier = modifier;
    }

    public WeightDegree getDegree() {
        return degree;
    }

    public void setDegree(WeightDegree degree) {
        this.degree = degree;
    }

    Double getPureWeight() {
        return getWeight() * getDegree().getModifier();
    }

}
