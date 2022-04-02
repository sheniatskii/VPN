package MainPage;

import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends ParentPage{
    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy (xpath = ".//a[@class=' btn-cta initchackout']//span")
    WebElement buttonGetIronVPNNow;
    @FindBy (xpath = ".//input[@class='inp-email']")
    WebElement inputEmail;
    @FindBy (xpath = ".//i[@class='checkplace']//img")
    WebElement checkBox;
    @FindBy (xpath = ".//button[@id='validate']//a//span")
    WebElement buttonGetIronVPNNow2;
    @FindBy (xpath = ".//div[@class='item']//a[@class='btn btn-cta initchackout']")
    WebElement buttonGetIronVPNNow3;
    @FindBy (xpath = ".//div[@class='card_view']//div//div//input")
    WebElement inputCardNumber;
    @FindBy (xpath = ".//div[@data-testid='cardExpiryDate']//input")
    WebElement inputCardExpiryDate;
    @FindBy (xpath = ".//input[@name='cardCvv']")
    WebElement inputCardCvv;
    @FindBy (xpath = ".//input[@placeholder='XXXXX']")
    WebElement inputIndex;
    @FindBy (xpath = ".//button[@name='submitButton']//span")
    WebElement buttonSubmitForm;
    @FindBy (xpath = ".//h3[text()='Payment was successful!']")
    WebElement actualText;
    @FindBy (xpath = ".//button[@class='tryAgain']")
    WebElement buttonTryAgain;
    @FindBy (xpath = ".//div[@class='input-box__input-list show']")
    WebElement listShow;
    @FindBy (xpath = ".//div[@class='price']//span[@class='subPrice']")
    WebElement priseSite;
    @FindBy (xpath = ".//div[@class='row']//div[@class='col-6 text-right timeOut']")
    WebElement prisePay;
    @FindBy (xpath = ".//p[@class='not-you']")
    WebElement buttonNotYou;
    @FindBy (xpath = ".//button[@class='hystmodal__close ']")
    WebElement buttonExit;



    public RegistrationPage userOpenTabIronVPN(String url) {
        webDriver.get(url);
        return this;
    }

    public RegistrationPage clickOnButtonGetIronVPNNow() {
        clickOnElement(buttonGetIronVPNNow);
        return this;
    }

    public RegistrationPage enterTextInputEmail(String email) {
        enterTextToElement(inputEmail, email);
        return this;
    }

    public RegistrationPage clickOnButtonCheckBox() {
        clickOnElement(checkBox);
        return this;
    }

    public RegistrationPage clickOnButtonGetIronVPNNow2() {
        clickOnElement(buttonGetIronVPNNow2);
        return this;
    }

    public RegistrationPage clickOnButtonGetIronVPNNow3() {
        clickOnElement(buttonGetIronVPNNow3);
        return this;
    }

    public RegistrationPage enterTextInputCardNumber(String card) {
        WebElement frame = webDriver.findElement(By.xpath(".//iframe[@id='solid-payment-form-iframe']"));
        webDriver.switchTo().frame(frame);
        enterTextToElement(inputCardNumber, card);
        webDriver.switchTo().defaultContent();
        return this;
    }

    public RegistrationPage enterTextInputCardExpiryDate(String date) {

        WebElement frame = webDriver.findElement(By.xpath(".//iframe[@id='solid-payment-form-iframe']"));
        webDriver.switchTo().frame(frame);
        clickOnElement(inputCardExpiryDate);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        enterTextToElement(inputCardExpiryDate, date);
        webDriver.switchTo().defaultContent();
        return this;
    }


    public RegistrationPage enterTextInputCardCvv(String cvv) {
        WebElement frame = webDriver.findElement(By.xpath(".//iframe[@id='solid-payment-form-iframe']"));
        webDriver.switchTo().frame(frame);
        enterTextToElement(inputCardCvv, cvv);
        webDriver.switchTo().defaultContent();
        return this;
    }

    public RegistrationPage enterTextInputIndex(String index) {
        WebElement frame = webDriver.findElement(By.xpath(".//iframe[@id='solid-payment-form-iframe']"));
        webDriver.switchTo().frame(frame);
        enterTextToElement(inputIndex, index);
        webDriver.switchTo().defaultContent();
        return this;
    }

    public RegistrationPage clickOnSubmitButton() {
        WebElement frame = webDriver.findElement(By.xpath(".//iframe[@id='solid-payment-form-iframe']"));
        webDriver.switchTo().frame(frame);
        clickOnElement(buttonSubmitForm);
        webDriver.switchTo().defaultContent();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }


    public RegistrationPage checkInMassegePresent(String text) {
        String actualText1 = actualText.getText();
        Assert.assertEquals("Text is present", text, actualText1);
        logger.info(" Text Payment was successful! was present");
        return this;
    }

    public RegistrationPage openPayPage(String url) {
        webDriver.get(url);
        return this;
    }

    public RegistrationPage checkInPrise() {
        String actualText2 = prisePay.getText();
        String prise = priseSite.getText();
        String actualText3 = prise + "$";
        Assert.assertEquals("Text is present", actualText3, actualText2);
        logger.info(" prisePay equals priseSite");
        return this;
    }

    public boolean isButtonPresent() {
        return isElementPresent(buttonTryAgain);
    }


    public boolean isDropdownPresent() {
        return isElementPresent(listShow);
    }

    public RegistrationPage clickOnInputEmail() {
        clickOnElement(inputEmail);
        return this;
    }

    public RegistrationPage clickOnButtonTryAgain() {
        clickOnElement(buttonTryAgain);
        return this;
    }

    public RegistrationPage enterTextInputEmailUITest(String text) {
        enterTextToElement(inputEmail, text);
        inputEmail.clear();
        return this;
    }

    public RegistrationPage clickOnInputDate() {
        WebElement frame = webDriver.findElement(By.xpath(".//iframe[@id='solid-payment-form-iframe']"));
        webDriver.switchTo().frame(frame);
        clickOnElement(inputCardExpiryDate);
        webDriver.switchTo().defaultContent();
        return this;
    }

    public RegistrationPage clickOnButtonNotYou() {
        clickOnElement(buttonNotYou);
        return this;
    }

    public boolean isButtonExitPresent() {
        return isElementPresent(buttonExit);
    }
}
