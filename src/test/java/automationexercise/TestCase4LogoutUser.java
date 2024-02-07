package automationexercise;

import automationexercise.pages.UserMenuPage;
import automationexercise.pages.FinishPage;
import automationexercise.pages.LoginPage;
import automationexercise.pages.StartPage;
import com.codeborne.selenide.Condition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestCase4LogoutUser extends TestBase {
    private static final Logger logger = LogManager.getLogger(TestCase1RegisterUser.class);

    @Test
    void logoutUser() {

        logger.info("Open main page of website");
        open("http://automationexercise.com");

        logger.info("Verify that home page is visible successfully");
        step("Verify that home page is visible successfully", () -> {
            StartPage startPage = new StartPage();
            startPage.sliderLoginPage.shouldBe(Condition.visible);
            startPage.buttonLogin.click();
        });

        LoginPage loginPage = new LoginPage();
        logger.info("Verify 'Login to your account' is visible");
        step("Verify 'Login to your account' is visible", () -> {
            loginPage.titleLogin.shouldHave(Condition.text("Login to your account"));
        });
        logger.info("Enter correct email and password address");
        step("Enter correct email and password address", () -> {
            loginPage.loginEmail.setValue(TestData.LOGIN_EMAIL);
            loginPage.loginPassword.setValue(TestData.USER_PASSWORD);
            loginPage.buttonLogin.click();
        });

        UserMenuPage userMenuPage = new UserMenuPage();
        logger.info("Verify that 'Logged in as username' is visible");
        step("Verify that 'Logged in as username' is visible", () -> {
            userMenuPage.getElementByText("Max").shouldHave(Condition.visible);
        });
        logger.info("Logout");
        step("Logout", () -> {
            userMenuPage.buttonLogout.click();
        });

        logger.info("Verify 'Login to your account' is visible");
        step("Verify 'Login to your account' is visible", () -> {
            loginPage.titleLogin.shouldHave(Condition.text("Login to your account"));
        });


    }

}
