package baseTest;

import MainPage.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver;
    protected RegistrationPage registrationPage;

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() { // настройки применяемые ко все страницах + обьявление всех страниц
        webDriver = initDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

        registrationPage = new RegistrationPage(webDriver);
    }

    private WebDriver initDriver() { //открытие драйвера в разных браузерах
        String browser = System.getProperty("browser");
        if ((browser == null) || browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("mobile")){
            WebDriverManager.chromedriver().setup();
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "Nexus 5");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            webDriver = new ChromeDriver(chromeOptions);
        }else if ("ie".equalsIgnoreCase(browser)) {
            //WebDriverManager.iedriver().setup();

            // in most cases 32bit version is needed
            WebDriverManager.iedriver().arch32().setup();
            return new InternetExplorerDriver();
        }
        return webDriver;
    }

    public void checkExpectedResult(String message, boolean actualResult, boolean expectedResult){ //метод проверки ожидаемого результата
        Assert.assertEquals(message, expectedResult, actualResult);
    }

}
