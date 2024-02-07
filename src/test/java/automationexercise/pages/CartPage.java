package automationexercise.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    public SelenideElement productsDescriptionInCart = $("[class='cart_description']");
    public SelenideElement buttonSignupOrLogin = $("[href='/login']");
    public SelenideElement titleShoppingCart = $("[class='breadcrumbs']");
    public SelenideElement buttonProceedToCheckout = $("[class='btn btn-default check_out']");
    public SelenideElement popupButtonRegisterOrLogin = $("[class='modal-content'] [href='/login']");

}
