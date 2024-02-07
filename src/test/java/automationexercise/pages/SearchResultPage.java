package automationexercise.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    public SelenideElement titleSearchedProducts = $("[class='title text-center']");
    public SelenideElement searchedProductName = $("[class='productinfo text-center']");
    public SelenideElement buttonAddToCart = $("[class='btn btn-default add-to-cart']");
    public SelenideElement buttonViewCart = $("#cartModal [href='/view_cart']");

}
