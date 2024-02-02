package automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AccountCreatedPage {
    public SelenideElement titleAccountCreated = $("[data-qa='account-created']");
    public SelenideElement buttonContinue = $("[data-qa='continue-button']");

}
