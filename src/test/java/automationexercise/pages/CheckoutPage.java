package automationexercise.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

    public SelenideElement addressItemBox = $("[class='address item box']");
    public SelenideElement productDetails = $("[href='/product_details/3']");
    public SelenideElement textAreaForComment = $("[class='form-control']");
    public SelenideElement buttonPlaceOrder = $("[class='btn btn-default check_out']");

}
