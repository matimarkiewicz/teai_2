package pl.markiewicz.teai_2.shopController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.markiewicz.teai_2.shopType.Shop;

@RestController
public class ShopController {

    private Shop shop;

    @Autowired
    public ShopController(Shop shop) {
        this.shop = shop;
    }

    @GetMapping
    public String get() {
        return shop.getShopInfo();
    }
}
