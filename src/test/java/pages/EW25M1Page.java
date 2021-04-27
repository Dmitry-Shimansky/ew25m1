package pages;

import com.codeborne.selenide.Condition;
import config.ConfigForLogin;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class EW25M1Page {

    private final String TOP_CALLBACK_BUTTON = "//div[@class = 'container']/div//a[@class = 'callback']";
    private final String ENTER_NAME_FIELD = "//input[@class = 'callback-form__input input']";
    private final String ENTER_PHONE_NUMBER = "//input[@class = 'callback-form__input input mask']";
    private final String SEND_ORDER_BUTTON = "//button[@data-value = 'TARGET']";

//Top form
    public void clickStayOrderButton() {
        $(By.xpath(TOP_CALLBACK_BUTTON)).click();
        $(By.id("callback")).should(Condition.visible);
    }

    public void enterName() {
        $(By.xpath(ENTER_NAME_FIELD)).setValue(ConfigForLogin.TEST_USER_NAME);
        System.out.println(ConfigForLogin.TEST_USER_NAME);
    }

    public void enterPhoneNumberTop() {
        $x(ENTER_PHONE_NUMBER).click();
        $x(ENTER_PHONE_NUMBER).setValue(ConfigForLogin.TEST_USER_PHONE);
    }

    public void clickButtonSendTopForm() {
        $x(SEND_ORDER_BUTTON).click();
    }

    //Bottom form
    public void scrollDownAndEnterName() {
        $(By.xpath("//input[@name = 'Имя']")).scrollTo().sendKeys(ConfigForLogin.TEST_USER_NAME);
    }

    public void enterPhoneNumberBottom() {
        $(By.xpath("//input[@name = 'Номер']")).sendKeys(ConfigForLogin.TEST_USER_PHONE_RUS);
    }

    public void enterEmail() {
        $(By.xpath("//input[@name = 'email']")).sendKeys(ConfigForLogin.TEST_EMAIL);
    }

    public void enterQuestion() {
        $(By.xpath("//input[@name = 'Вопрос']")).sendKeys(ConfigForLogin.TEST_QUESTION);
    }

    public void clickSendButtonBottomForm() {
        $(By.xpath("//button[text() = 'Отправить']")).click();
    }
}
