package pages;

import static com.codeborne.selenide.Selenide.page;

public class BasePage {

    protected HeaderElements header;

    public BasePage() {
        this.header = page(HeaderElements.class);
    }

    public HeaderElements getHeader() {
        return header;
    }
}