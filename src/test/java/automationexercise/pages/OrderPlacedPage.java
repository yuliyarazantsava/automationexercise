package automationexercise.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OrderPlacedPage {
    public SelenideElement successMessage = $("[class='col-sm-9 col-sm-offset-1']");
    public SelenideElement buttonDownloadInvoice = $("[class='btn btn-default check_out']");
    public SelenideElement buttonContinue = $("[data-qa='continue-button']");
}
