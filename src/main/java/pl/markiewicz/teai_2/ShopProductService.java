package pl.markiewicz.teai_2;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ShopProductService {

    private double minPriceValue = 50;
    private double maxPriceValue = 300;

    private List<ShopProduct> shopProductList;

   @PostConstruct
    public void init() {
       shopProductList = new ArrayList<>();
       createShopShelfProducts();
    }

    private double randomPrice() {
        double randomPrice = new Random().nextDouble();
        double result = minPriceValue + (randomPrice * (maxPriceValue - minPriceValue));

        return new BigDecimal(String.valueOf(result)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    private void createShopShelfProducts() {

        ShopProduct product1 = new ShopProduct("Buraki", randomPrice());
        ShopProduct product2 = new ShopProduct("Marchew", randomPrice());
        ShopProduct product3 = new ShopProduct("Pietruszka", randomPrice());
        ShopProduct product4 = new ShopProduct("Por", randomPrice());
        ShopProduct product5 = new ShopProduct("Seler", randomPrice());
        ShopProduct product6 = new ShopProduct("Kabaczek", randomPrice());
        ShopProduct product7 = new ShopProduct("Rzodkiew", randomPrice());
        ShopProduct product8 = new ShopProduct("Oregano", randomPrice());
        ShopProduct product9 = new ShopProduct("Pomidor", randomPrice());

        shopProductList.add(product1);
        shopProductList.add(product2);
        shopProductList.add(product3);
        shopProductList.add(product4);
        shopProductList.add(product5);
        shopProductList.add(product6);
        shopProductList.add(product7);
        shopProductList.add(product8);
        shopProductList.add(product9);
    }

    public List<ShopProduct> getShopProducts() {
        return shopProductList;
    }
}
