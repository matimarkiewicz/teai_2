package pl.markiewicz.teai_2.shopProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shop-pro")
public class ShopProProperties {

    private double discount;

    public double getDiscount() {
        return discount;
    }

    public ShopProProperties setDiscount(double discount) {
        this.discount = discount;
        return this;
    }
}
