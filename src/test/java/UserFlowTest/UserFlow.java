package UserFlowTest;

import baseTest.BaseTest;
import org.junit.Test;

public class UserFlow extends BaseTest {

    @Test
    public void userFlowTest (){
        registrationPage
                        .userOpenTabIronVPN("https://ironvpn.me/?source=test")
                        .clickOnButtonGetIronVPNNow()
                        .enterTextInputEmail("qa@test.com")
                        .clickOnButtonCheckBox()
                        .clickOnButtonGetIronVPNNow2()
                        .clickOnButtonGetIronVPNNow3()
                        .enterTextInputCardNumber("4532456618142692")
                        .enterTextInputCardExpiryDate("032029")
                        .enterTextInputCardCvv("967")
                        .enterTextInputIndex("08500")
                        .clickOnSubmitButton()
                        .checkInMassegePresent("Payment was successful!");



    }
}
