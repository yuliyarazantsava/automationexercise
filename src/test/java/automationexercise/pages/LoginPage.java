package automationexercise.pages;

import automationexercise.TestData;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement titleSignup = $("[class='signup-form']");
    public SelenideElement signupName = $("[data-qa='signup-name']");
    public SelenideElement signupEmail = $("[data-qa='signup-email']");
    public SelenideElement buttonSignup = $("[data-qa='signup-button']");

}
