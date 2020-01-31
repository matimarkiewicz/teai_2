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

        shopProductList.add(new ShopProduct("Buraki", randomPrice()));
        shopProductList.add(new ShopProduct("Marchew", randomPrice()));
        shopProductList.add(new ShopProduct("Pietruszka", randomPrice()));
        shopProductList.add(new ShopProduct("Por", randomPrice()));
        shopProductList.add(new ShopProduct("Seler", randomPrice()));
        shopProductList.add(new ShopProduct("Kabaczek", randomPrice()));
        shopProductList.add(new ShopProduct("Rzodkiew", randomPrice()));
        shopProductList.add(new ShopProduct("Oregano", randomPrice()));
        shopProductList.add(new ShopProduct("Pomidor", randomPrice()));
    }

    public List<ShopProduct> getShopProducts() {
        return shopProductList;
    }
}
