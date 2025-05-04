package assertions;

import com.codeborne.selenide.WebDriverRunner;
import org.assertj.core.api.SoftAssertions;

public class CartAssertions {

    private final SoftAssertions softAssertions = new SoftAssertions();

    public void assertCartItemCount(int expectedCount, String actualCount) {
        softAssertions.assertThat(actualCount)
                .as("The cart item count does not match the expected value.")
                .isEqualTo(String.valueOf(expectedCount));
    }

    public void assertAlertMessage(String expectedMessage, String actualMessage) {
        softAssertions.assertThat(actualMessage)
                .as("The alert message does not match the expected value.")
                .isEqualTo(expectedMessage);
    }

    public void assertCalculatedPrice(Double expectedPrice, Double actualPrice) {
        softAssertions.assertThat(actualPrice)
                .as("The calculated price does not match the expected value.")
                .isEqualTo(expectedPrice);
    }

    public void assertRedirectedToCartPage(String expectedUrl) {
        softAssertions.assertThat(WebDriverRunner.url())
                .as("The redirection URL does not match the expected cart page URL.")
                .isEqualTo(expectedUrl);
    }

    public void assertAll() {
        softAssertions.assertAll();
    }
}