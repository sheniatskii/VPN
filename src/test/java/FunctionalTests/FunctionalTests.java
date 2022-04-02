package FunctionalTests;

import baseTest.BaseTest;
import org.junit.Test;

public class FunctionalTests extends BaseTest {

    @Test
    public void functionalTests1() {   //функционал открытия подсказок после нажатия на инпут мейла
        registrationPage
                        .userOpenTabIronVPN("https://ironvpn.me/?source=test")
                        .clickOnButtonGetIronVPNNow()
                        .clickOnInputEmail();
        checkExpectedResult("Input invisible", registrationPage.isDropdownPresent(), true);
    }

    @Test
    public void functionalTest2(){    //функционал возврата на страницу с возможностью перейти на повторную оплату
                registrationPage
                               .userOpenTabIronVPN("https://ironvpn.me/?source=test")
                               .clickOnButtonGetIronVPNNow()
                               .enterTextInputEmail("qa@test.com")
                               .clickOnButtonCheckBox()
                               .clickOnButtonGetIronVPNNow2()
                               .clickOnButtonGetIronVPNNow3()
                               .enterTextInputCardNumber("4532456618142692")
                               .enterTextInputCardExpiryDate("032029")
                               .enterTextInputCardCvv("325")
                               .enterTextInputIndex("08500")
                               .clickOnSubmitButton()
                               .clickOnButtonTryAgain();

    }
}
