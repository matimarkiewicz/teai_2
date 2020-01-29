package pl.markiewicz.teai_2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ShopProduct {

    private String nameProduct;
    private double priceProduct;

    public ShopProduct(String nameProduct, double priceProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return new BigDecimal(String.valueOf(priceProduct)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    @Override
    public String toString() {
        return nameProduct + " " + priceProduct + "zł.";
    }
}
