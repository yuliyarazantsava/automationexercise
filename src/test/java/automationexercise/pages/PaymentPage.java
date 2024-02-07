package automationexercise.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {
    public SelenideElement inputNameOnCard = $("[data-qa='name-on-card']");
    public SelenideElement inputCardNumber = $("[data-qa='card-number']");
    public SelenideElement inputCVC = $("[data-qa='cvc']");
    public SelenideElement inputExpiryMonth = $("[data-qa='expiry-month']");
    public SelenideElement inputExpiryYear = $("[data-qa='expiry-year']");
    public SelenideElement buttonPayAndConfirmOrder = $("[data-qa='pay-button']");

}
