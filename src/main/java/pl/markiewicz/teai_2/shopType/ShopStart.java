package pl.markiewicz.teai_2.shopType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.markiewicz.teai_2.ShopBag;
import pl.markiewicz.teai_2.ShopProduct;
import pl.markiewicz.teai_2.ShopProductService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@Profile("ShopStart")
@Component
public class ShopStart implements Shop {

    private ShopBag shopBag;
    private ShopProductService shopProductService;

    @Autowired
    public ShopStart(ShopBag shopBag, ShopProductService shopProductService) {
        this.shopBag = shopBag;
        this.shopProductService = shopProductService;
    }

    @PostConstruct
    private void init(){
        addRandomProductsToShopBag(5);
    }

    private void addRandomProductsToShopBag(int number) {
        List<ShopProduct> products = shopProductService.getShopProducts();

        Random randomProducts = new Random();
        for (int i = 0; i < number; i++) {
            shopBag.addToShopBag(products.get(randomProducts.nextInt(9)));
        }
    }

    @Override
    public String getShopInfo() {
        return "Products in bag: " + shopBag.getProducts() + " Cost (netto): " + shopBag.getCost() + "zł.";
    }

    public double getCostInfo() {
        return shopBag.getCost();
    }
}
