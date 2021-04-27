package tests;

import config.ConfigForLogin;
import config.ConfigURLs;
import config.TestConfig;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.EW25M1Page;
import pages.MailRuGetOrderPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class SendOrderBottomFormTest {

    private static final Logger LOGGER = Logger.getLogger(SendOrderBottomFormTest.class);

    EW25M1Page sitePage = new EW25M1Page();
    MailRuGetOrderPage mailRu = new MailRuGetOrderPage();

    @Before
    public void setUp() {
        LOGGER.info("Test started");
        TestConfig.initConfig();
        open(ConfigURLs.EW25M1);
    }

    @Test
    public void SendOrderTest() {
        sitePage.scrollDownAndEnterName();
        sitePage.enterPhoneNumberBottom();
        sitePage.enterEmail();
        sitePage.enterQuestion();
        sitePage.clickSendButtonBottomForm();
        open(ConfigURLs.MAILRU);
        mailRu.enterEmailAndSubmit();
        mailRu.enterPassAndSubmit();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mailRu.enterToEmail();
        Assert.assertTrue(mailRu.getName(ConfigForLogin.TEST_USER_NAME).matches(ConfigForLogin.TEST_USER_NAME));
        Assert.assertEquals(mailRu.getPhoneBottomForm(ConfigForLogin.TEST_USER_PHONE_RUS),ConfigForLogin.TEST_USER_PHONE_RUS);
        Assert.assertTrue(mailRu.getEmail(ConfigForLogin.TEST_EMAIL).matches(ConfigForLogin.TEST_EMAIL));
        Assert.assertTrue(mailRu.getQuestionText(ConfigForLogin.TEST_QUESTION).matches(ConfigForLogin.TEST_QUESTION));
    }

    @After
    public void deleteEmail() {
        mailRu.clickDeleteButton();
        closeWebDriver();
    }
}
