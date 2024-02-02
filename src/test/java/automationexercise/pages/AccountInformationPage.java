package automationexercise.pages;

import automationexercise.TestData;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AccountInformationPage {
    public SelenideElement titleAccountInformationPage =  $("[class='title text-center']");
    public SelenideElement buttonGender =  $("[id='id_gender1']");
    public SelenideElement signupName =   $("[data-qa='name']");
    public SelenideElement userPassword =   $("[data-qa='password']");
    public SelenideElement dayOfBirth =   $("[data-qa='days']");
    public SelenideElement monthOfBirth =   $("[data-qa='months']");
    public SelenideElement yearOfBirth =   $("[data-qa='years']");
    public SelenideElement checkboxNewsletter =   $("[id='newsletter']");
    public SelenideElement checkboxOffersFromPartners  = $("[id='optin']");
    public SelenideElement firstName  = $("[data-qa='first_name']");
    public SelenideElement lastName  =  $("[data-qa='last_name']");
    public SelenideElement company  =  $("[data-qa='company']");
    public SelenideElement firstAddress  =   $("[data-qa='address']");
    public SelenideElement secondAddress  =  $("[data-qa='address2']");
    public SelenideElement country  =  $("[data-qa='country']");
    public SelenideElement state  =  $("[data-qa='state']");
    public SelenideElement city  = $("[data-qa='city']");
    public SelenideElement zipcode  = $("[data-qa='zipcode']");
    public SelenideElement mobileNumber  = $("[data-qa='mobile_number']");
    public SelenideElement buttonCreateAccount  = $("[data-qa='create-account']");
}
