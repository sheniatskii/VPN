package UITests;

import baseTest.BaseTest;
import org.junit.Test;


public class UITests extends BaseTest {

    @Test
    public void uiTest1(){    // проверка соотвествия прайса на сайте и в окне оплаты
        registrationPage
                        .userOpenTabIronVPN("https://ironvpn.me/?source=test")
                        .clickOnButtonGetIronVPNNow()
                        .enterTextInputEmail("qa@test.com")
                        .clickOnButtonCheckBox()
                        .clickOnButtonGetIronVPNNow2()
                        .clickOnButtonGetIronVPNNow3()
                        .checkInPrise();
    }

    @Test
    public void uiTest2(){   // проверка отображения окна повторной регистрации после нажатия на кнопку Not you?
        registrationPage
                        .userOpenTabIronVPN("https://ironvpn.me/?source=test")
                        .clickOnButtonGetIronVPNNow()
                        .enterTextInputEmail("qa@test.com")
                        .clickOnButtonCheckBox()
                        .clickOnButtonGetIronVPNNow2()
                        .clickOnButtonNotYou();
        checkExpectedResult("Is button present", registrationPage.isButtonExitPresent(), true);

    }

}
