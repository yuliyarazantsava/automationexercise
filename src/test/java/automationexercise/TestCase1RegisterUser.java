package automationexercise;

import automationexercise.pages.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestCase1RegisterUser extends TestBase {
    private static final Logger logger = LogManager.getLogger(TestCase1RegisterUser.class);

    @Test
    void registerUser() {
        String randomEmail = "max" + new Random().nextInt() + "@bialoleka.poland";

        logger.info("Open main page of website");
        open("http://automationexercise.com");

        logger.info("Verify that home page is visible successfully");
        step("Verify that home page is visible successfully", () -> {
            StartPage startPage = new StartPage();
            startPage.sliderLoginPage.shouldBe(Condition.visible);
            startPage.buttonLogin.click();
        });

        LoginPage loginPage = new LoginPage();
        logger.info("Verify 'New User Signup!' is visible");
        step("Verify 'New User Signup!' is visible", () -> {
            loginPage.titleSignup.shouldHave(Condition.text("New User Signup!"));
        });
        logger.info("Enter name and email address");
        step("Enter name and email address", () -> {
            loginPage.signupName.setValue(TestData.SIGNUP_NAME);
            loginPage.signupEmail.setValue(randomEmail);
            loginPage.buttonSignup.click();
        });

        AccountInformationPage accountInformationPage = new AccountInformationPage();
        logger.info("Fill details: Title, Name, Email, Password, Date of birth");
        step("Fill details: Title, Name, Email, Password, Date of birth", () -> {
            accountInformationPage.titleAccountInformationPage.shouldHave(Condition.text("ENTER ACCOUNT INFORMATION"));
            accountInformationPage.buttonGender.click();
            accountInformationPage.signupName.setValue(TestData.SIGNUP_NAME);
            accountInformationPage.userPassword.setValue(TestData.USER_PASSWORD);
            accountInformationPage.dayOfBirth.selectOption(TestData.DAY_OF_BIRTH);
            accountInformationPage.monthOfBirth.selectOption(TestData.MONTH_OF_BIRTH);
            accountInformationPage.yearOfBirth.selectOption(TestData.YEAR_OF_BIRTH);
        });
        logger.info("Select checkbox about newsletter and offers from partners");
        step("Select checkbox about newsletter and offers from partners", () -> {
            accountInformationPage.checkboxNewsletter.scrollTo().click();
            accountInformationPage.checkboxOffersFromPartners.click();
        });
        logger.info("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
        step("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number", () -> {
            accountInformationPage.firstName.setValue(TestData.SIGNUP_NAME);
            accountInformationPage.lastName.setValue(TestData.USER_LAST_NAME);
            accountInformationPage.company.setValue(TestData.NAME_OF_COMPANY);
            accountInformationPage.firstAddress.setValue(TestData.FIRST_ADDRESS);
            accountInformationPage.secondAddress.setValue(TestData.SECOND_ADDRESS);
            accountInformationPage.country.selectOption(TestData.COUNTRY);
            accountInformationPage.state.setValue(TestData.STATE);
            accountInformationPage.city.setValue(TestData.CITY);
            accountInformationPage.zipcode.setValue(TestData.ZIPCODE);
            accountInformationPage.mobileNumber.setValue(TestData.MOBILE_NUMBER);
            accountInformationPage.buttonCreateAccount.scrollTo().click();
        });


        logger.info("Verify that 'ACCOUNT CREATED!' is visible");
        step("Verify that 'ACCOUNT CREATED!' is visible", () -> {
            AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
            accountCreatedPage.titleAccountCreated.shouldHave(Condition.text("ACCOUNT CREATED!"));
            accountCreatedPage.buttonContinue.click();
            Selenide.sleep(5000);
        });

        UserMenuPage userMenuPage = new UserMenuPage();
        logger.info("Verify that 'Logged in as username' is visible");
        step("Verify that 'Logged in as username' is visible", () -> {
            userMenuPage.getElementByText("Max").shouldHave(Condition.visible);
        });
        logger.info("Delete page");
        step("Delete page", () -> {
            userMenuPage.buttonDelete.click();
        });

        logger.info("Verify that 'ACCOUNT DELETED!' ");
        step("Verify that 'ACCOUNT DELETED!' ", () -> {
            FinishPage finishPage = new FinishPage();
            finishPage.titleAccountDeleted.shouldHave(Condition.text("ACCOUNT DELETED!"));
            finishPage.buttonContinue.click();
        });

    }

}
