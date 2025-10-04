package testCases;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pojo.User;
import utility.BaseDriver;
import utility.JSONHelper;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TestCase1_RegisterUser {
    public static void main(String[] args) throws ATUTestRecorderException, FileNotFoundException {

        // Log all console output to a file
        PrintStream fileOut = new PrintStream("reports/logs/console_output.txt"+System.currentTimeMillis());
        System.setOut(fileOut);
        System.setErr(fileOut);

        // Record the test case
        ATUTestRecorder recorder = new ATUTestRecorder("reports/test-recordings/","TestCase1_RegisterUser"+System.currentTimeMillis(),false);
        recorder.start();

        // Step 1 & 2
        WebDriver driver = BaseDriver.driver("https://automationexercise.com/");

        // Step 3
        WebElement homePageText = driver.findElement(By.xpath("//div[@class='features_items']/h2"));
        final String expectedHomePage = "FEATURES ITEMS";
        final String actualHomePage = homePageText.getText();
        Assert.assertEquals("Home page is not visible.", expectedHomePage, actualHomePage);

        // Step 4
        WebElement signUpLoginBtn = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[4]/a"));
        signUpLoginBtn.click();

        // Step 5
        WebElement newUserSignupText = driver.findElement(By.xpath("//div[3]/div/h2"));
        final String expectednewUserSignup = "New User Signup!";
        final String actualnewUserSignup = newUserSignupText.getText();
        Assert.assertEquals("New User Signup is not visible.", expectedHomePage, actualHomePage);

        // Step 6
        BaseDriver.threadWait(2);
        WebElement nameInput = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        User user = JSONHelper.read("user1");
        nameInput.sendKeys(user.getName());
        emailInput.sendKeys(user.getEmail());

        //  Step 7
        WebElement signUpBtn = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpBtn.click();

        // Step 8
        WebElement enterAccountInfoText = driver.findElement(By.xpath("//div/h2[@class='title text-center']/b"));
        final String expectedenterAccountInfo = "ENTER ACCOUNT INFORMATION";
        final String actualenterAccountInfo = enterAccountInfoText.getText();
        Assert.assertEquals("Enter Account Information is not visible.", expectedenterAccountInfo, actualenterAccountInfo);

        // Step 9
        WebElement titleBtn = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        titleBtn.click();
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id='password']"));
        passwordInput.sendKeys(user.getPassword());

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Select daysSelect = new Select(driver.findElement(By.id("days")));
        daysSelect.selectByValue(user.getDateOfBirthDay());
        Select monthsSelect = new Select(driver.findElement(By.id("months")));
        monthsSelect.selectByValue(user.getDateOfBirthMonth());
        Select yearsSelect = new Select(driver.findElement(By.id("years")));
        yearsSelect.selectByValue(user.getDateOfBirthYear());

        // Step 10
        WebElement newsletterBtn = driver.findElement(By.id("newsletter"));
        newsletterBtn.click();

        //Step 11
        WebElement offersBtn = driver.findElement(By.id("optin"));
        offersBtn.click();

        // Step 12
        User user2 = JSONHelper.read("user2");
        WebElement firstNameInput = driver.findElement(By.id("first_name"));
        firstNameInput.sendKeys(user2.getFirstName());
        WebElement lastNameInput = driver.findElement(By.id("last_name"));
        lastNameInput.sendKeys(user2.getLastName());
        WebElement companyInput = driver.findElement(By.id("company"));
        companyInput.sendKeys(user2.getCompany());
        WebElement addressInput = driver.findElement(By.id("address1"));
        addressInput.sendKeys(user2.getAddress());
        WebElement address2Input = driver.findElement(By.id("address2"));
        address2Input.sendKeys(user2.getAddress2());

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement countrySelectElement = driver.findElement(By.id("country"));
        Select countrySelect = new Select(countrySelectElement);
        countrySelect.selectByVisibleText(user2.getCountry());

        WebElement stateInput = driver.findElement(By.id("state"));
        stateInput.sendKeys(user2.getState());
        WebElement cityInput = driver.findElement(By.id("city"));
        cityInput.sendKeys(user2.getCity());
        WebElement zipCodeInput = driver.findElement(By.id("zipcode"));
        zipCodeInput.sendKeys(user2.getZipCode());
        WebElement mobileNumberInput = driver.findElement(By.id("mobile_number"));
        mobileNumberInput.sendKeys(user2.getMobileNumber());

        // Step 13
        WebElement createAccountBtn = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        createAccountBtn.click();

        // Step 14
        WebElement accountCreatedText = driver.findElement(By.xpath("//h2[@data-qa='account-created']/b"));
        final String expectedaccountCreated = "ACCOUNT CREATED!";
        final String actualaccountCreated = accountCreatedText.getText();
        Assert.assertEquals("Account Created! is not visible.", expectedaccountCreated, actualaccountCreated);

        // Step 15
        WebElement continueBtn = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueBtn.click();

        // Step 16
        WebElement loggedInAsUsernameText = driver.findElement(By.xpath("//*[@id='header']//ul/li[10]/a"));
        final String expectedloggedInAsUsername = "Logged in as "+ user2.getFirstName();
        final String actualloggedInAsUsername = loggedInAsUsernameText.getText();
        Assert.assertEquals("Logged in as "+ user2.getFirstName() +" is not visible.", expectedloggedInAsUsername, actualloggedInAsUsername);

        // Step 17
        WebElement deleteAccountBtn = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[5]/a"));
        deleteAccountBtn.click();

        // Step 18
        WebElement accountDeletedText = driver.findElement(By.xpath("//h2[@data-qa='account-deleted']/b"));
        final String expectedaccountDeleted = "ACCOUNT DELETED!";
        final String actualaccountDeleted = accountDeletedText.getText();
        Assert.assertEquals("'Account Deleted! is not visible.", expectedaccountDeleted, actualaccountDeleted);

        driver.close();
        recorder.stop();
    }
}