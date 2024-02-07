package automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StartPage {
    public SelenideElement sliderLoginPage = $("[id='slider-carousel']");
    public SelenideElement buttonLogin = $("[href='/login']");
    public SelenideElement buttonProducts = $("[href='/products']");
    public SelenideElement buttonCart = $("[class='shop-menu pull-right'] [href='/view_cart']");
    public SelenideElement buttonViewCart = $("[id='cartModal'] [href='/view_cart']");
    public SelenideElement buttonAddToCartDress = $("[data-product-id='3']");

    public void addItemToCartByName(String itemName){
        $(byText(itemName)).shouldHave(Condition.visible).parent().$("a.add-to-cart").scrollTo().click();
    }
}
