package automationexercise.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {
    public SelenideElement titleAllProducts = $("[class='title text-center']");
    public SelenideElement searchInput = $("[id='search_product']");
    public SelenideElement buttonSearch = $("[id='submit_search']");
}
