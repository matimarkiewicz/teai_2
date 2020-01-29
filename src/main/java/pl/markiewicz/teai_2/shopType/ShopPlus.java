package pl.markiewicz.teai_2.shopType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.markiewicz.teai_2.ShopBag;
import pl.markiewicz.teai_2.ShopProductService;
import pl.markiewicz.teai_2.shopProperties.ShopPlusProperties;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@Profile("ShopPlus")
public class ShopPlus extends ShopStart {

    private ShopPlusProperties shopPlusProperties;

    @Autowired
    public ShopPlus(ShopBag shopBag, ShopProductService shopProductService, ShopPlusProperties shopPlusProperties) {
        super(shopBag, shopProductService);
        this.shopPlusProperties = shopPlusProperties;
    }

    public double getValueWithTax() {
        double valueWithTax = getCostInfo();

        return new BigDecimal(String.valueOf(valueWithTax * (shopPlusProperties.getTax() / 100) + valueWithTax)).
                setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String getShopInfo() {
        return super.getShopInfo() + System.lineSeparator() + " Cost with TaxVAT: " + getValueWithTax() + "zł.";
    }
}
