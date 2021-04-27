package pages;

import config.ConfigForLogin;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MailRuGetOrderPage {

    //Login
    public void enterEmailAndSubmit() {
        $(By.xpath("//input[@placeholder = 'Имя ящика']")).sendKeys(ConfigForLogin.USER_MAILRU_LOGIN);
        $(By.xpath("//button[contains(text(), 'Ввести пароль')]")).click();
    }

    public void enterPassAndSubmit() {
        $(By.xpath("//input[@name = 'password']")).sendKeys(ConfigForLogin.USER_MAILRU_PASSWORD);
        $(By.xpath("//button[contains(text(), 'Войти')]")).click();
    }

    //Find order
    public void enterToEmail() {
        if ($(By.xpath("//*[text() = 'Заявка с сайта ew25m1.ru']")).isDisplayed()) {
            $(By.xpath("//*[text() = 'Заявка с сайта ew25m1.ru']")).click();
        } else {
            $(By.xpath("//*[text() = 'Рассылки']")).click();
            $(By.xpath("//*[text() = 'Заявка с сайта ew25m1.ru']")).click();
        }
    }

    public String getName(String name) {
        return $(By.xpath("//td[contains(text(), '" + name + "')]")).getText();
    }

    public void clickDeleteButton() {
        $(By.xpath("//span[@class = 'button2__txt' and text() = 'Удалить']"));
    }

    public String getPhoneBottomForm(String phone) {
        return $(By.xpath("//span[text() = '" + phone + "']")).getText();
    }

    public String getPhoneTopForm(String phone) {
        return $(By.xpath("//span[text() = '+7 (926) 111-22-33']")).getText();
    }

    public String getEmail(String email) {
        return $(By.xpath("//a[text() = '" + email + "']")).getText();
    }

    public String getQuestionText(String text) {
        return $(By.xpath("//td[text() = '" + text + "']")).getText();
    }
}
