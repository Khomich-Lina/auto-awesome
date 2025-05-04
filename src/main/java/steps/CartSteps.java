package steps;

import pages.ProductPage;
import pages.CartPage;

import static com.codeborne.selenide.Selenide.back;

public class CartSteps {

    private final ProductPage productPage;
    private final CartPage cartPage;

    public CartSteps(ProductPage productPage, CartPage cartPage) {
        this.productPage = productPage;
        this.cartPage = cartPage;
    }

    public void addProductToCart(String category, int productId, String shippingOption) {
        productPage.selectCategory(category);
        productPage.selectProductById(productId);
        productPage.selectShippingOption(shippingOption);
        productPage.addToCart();
    }

    public void navigateBackToShop() {
        back();
    }

    public void openCart() {
        productPage.getHeader().clickCart();
    }

    public Double getCartTotalPrice() {
        return cartPage.getTotalPrice();
    }

    public Double calculateCartPrice() {
        return cartPage.calculateProductPurchasedPrice();
    }
}