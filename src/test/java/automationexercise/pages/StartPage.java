package automationexercise.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class StartPage {
    public SelenideElement sliderLoginPage = $("[id='slider-carousel']");
    public SelenideElement buttonLogin = $("[href='/login']");
}
