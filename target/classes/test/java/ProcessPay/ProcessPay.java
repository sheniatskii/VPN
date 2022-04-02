package ProcessPay;

import baseTest.BaseTest;
import org.junit.Test;

public class ProcessPay extends BaseTest {
   @Test
    public void validProcessPayTest () {    // валидная оплата
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

   @Test
    public void invalidProcessPayTest () {  //не валидная оплата
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
                       .clickOnSubmitButton();
       checkExpectedResult("Button present", registrationPage.isButtonPresent(), true);

   }
}
