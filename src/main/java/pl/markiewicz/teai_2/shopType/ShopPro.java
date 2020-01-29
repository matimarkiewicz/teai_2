package pl.markiewicz.teai_2.shopType;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.markiewicz.teai_2.ShopBag;
import pl.markiewicz.teai_2.ShopProductService;
import pl.markiewicz.teai_2.shopProperties.ShopPlusProperties;
import pl.markiewicz.teai_2.shopProperties.ShopProProperties;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@Profile("ShopPro")
public class ShopPro extends ShopPlus {

    private ShopProProperties shopProProperties;

    public ShopPro(ShopBag shopBag, ShopProductService shopProductService, ShopPlusProperties shopPlusProperties,
                   ShopProProperties shopProProperties) {
        super(shopBag, shopProductService, shopPlusProperties);
        this.shopProProperties = shopProProperties;
    }

    public double getCostWithDiscount() {
        double valueWithTax = getValueWithTax();
        double discount = shopProProperties.getDiscount();

        return new BigDecimal(String.valueOf(valueWithTax - (discount / 100) * valueWithTax)).
                setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String getShopInfo() {
        return super.getShopInfo() + " Cost after discount: " + getCostWithDiscount() + "zł.";
    }
}
