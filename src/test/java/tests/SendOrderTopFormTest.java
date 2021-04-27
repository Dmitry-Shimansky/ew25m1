package tests;

import config.ConfigForLogin;
import config.ConfigURLs;
import config.TestConfig;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.MailRuGetOrderPage;
import pages.EW25M1Page;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class SendOrderTopFormTest {

    private static final Logger LOGGER = Logger.getLogger(SendOrderTopFormTest.class);

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

        sitePage.clickStayOrderButton();
        sitePage.enterName();
        sitePage.enterPhoneNumberTop();
        sitePage.clickButtonSendTopForm();
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
        Assert.assertEquals("+7 (926) 111-22-33",mailRu.getPhoneTopForm(ConfigForLogin.TEST_USER_PHONE));
    }

    @After
    public void deleteEmail() {
        mailRu.clickDeleteButton();
        closeWebDriver();
    }
}
