package automationexercise.pages;

import automationexercise.TestData;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement titleSignup = $("[class='signup-form']");
    public SelenideElement titleLogin = $("[class='login-form']");
    public SelenideElement signupName = $("[data-qa='signup-name']");
    public SelenideElement signupEmail = $("[data-qa='signup-email']");
    public SelenideElement buttonSignup = $("[data-qa='signup-button']");
    public SelenideElement loginEmail = $("[data-qa='login-email']");
    public SelenideElement loginPassword = $("[data-qa='login-password']");
    public SelenideElement buttonLogin = $("[data-qa='login-button']");

}
