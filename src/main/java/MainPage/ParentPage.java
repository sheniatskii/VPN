package MainPage;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class ParentPage {

    Logger logger = Logger.getLogger(getClass()); // обявление логера для всех страниц
    public WebDriver webDriver; // обявление вебдрайвера для всех страниц
    WebDriverWait webDriverWait10, webDriverWait15; //обьявление ожидания 10 секунд для всех методов


    public ParentPage(WebDriver webDriver) { //Конструктор для вебдрайвера
        this.webDriver = webDriver;
//        PageFactory.initElements(webDriver,this); // строка работает в веб-елементами в чистом виде
        PageFactory.initElements(
                new HtmlElementDecorator(
                        new HtmlElementLocatorFactory(webDriver))
                , this);
    }

    protected void enterTextToElement(WebElement webElement, String text) { // Общий метод ввода текста в инпут
        try {
            webElement.click();
            webElement.clear();
            webElement.sendKeys(text);
            logger.info("'" + text + "' was inputted in element" + getElementName(webElement));
        } catch (Exception e) {
            writeErrorAndStopTest(e);
        }
    }

    public String getElementName(WebElement webElement) { // Метод получения имя елемента
        String elementName = "";
        if (webElement instanceof TypifiedElement) {
            elementName = " '" + ((TypifiedElement) webElement).getName() + "' ";
        }
        return elementName;
    }

    void writeErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);

    }

    protected void clickOnElement(WebElement webElement) { //Общий метод нажатия на елемент
        try {
            webElement.click();
            logger.info(getElementName(webElement) + " Element was clicked");
        } catch (Exception e) {
            writeErrorAndStopTest(e);
        }
    }

    public boolean isElementPresent(WebElement webElement) { // Метод опредиления появления елемента
        try {
            boolean state = webElement.isDisplayed();
            if (state) {
                logger.info(getElementName(webElement) + " Element present ");
            } else {
                logger.info(getElementName(webElement) + " Element is not present");
            }
            return true;
        } catch (Exception e) {
            logger.info(getElementName(webElement) + " Element is not present ");
            return false;
        }
    }

}
