package pl.markiewicz.teai_2;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopBag {

    private List<ShopProduct> products;

    public ShopBag() {
        products = new ArrayList<>();
    }

    public void addToShopBag(ShopProduct shopProduct) {
        products.add(shopProduct);
    }

    public List<ShopProduct> getProducts(){
        return this.products;
    }

    public double getCost() {
        return new BigDecimal(String.valueOf(products.stream().mapToDouble(ShopProduct::getPriceProduct).sum())).
                setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
