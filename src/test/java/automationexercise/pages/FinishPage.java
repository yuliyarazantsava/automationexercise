package automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class FinishPage {
    public SelenideElement titleAccountDeleted = $("[data-qa='account-deleted']");
    public SelenideElement buttonContinue = $("[data-qa='continue-button']");

}
