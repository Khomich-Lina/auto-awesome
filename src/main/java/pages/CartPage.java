package pages;

import java.util.List;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class CartPage extends BasePage {

    @FindBy(xpath = ".//div[contains(@class, 'product-purchased')]")
    private List<SelenideElement> purchasedProducts;

    @FindBy(xpath = ".//*[contains(@class, 'total')]/dd")
    private SelenideElement totalPrice;

    public CartPage() {
        page(this);
    }

    public Double calculateProductPurchasedPrice() {
        Double totalPrice = 0.0;
        purchasedProducts.get(0).shouldBe(visible);
        for (SelenideElement product : purchasedProducts) {
            String price = product.$x(".//*[contains(@class,'price')]/strong").getText();
            totalPrice = totalPrice + Double
                    .parseDouble(price.replace("$", ""));
        }
        return totalPrice;
    }

    public Double getTotalPrice() {
        return Double.parseDouble(totalPrice.getText().replace("$", ""));
    }

}
