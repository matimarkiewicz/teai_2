package pl.markiewicz.teai_2.shopProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shop-plus")
public class ShopPlusProperties {

    private double tax;

    public double getTax() {
        return tax;
    }

    public ShopPlusProperties setTax(double tax) {
        this.tax = tax;
        return this;
    }
}
