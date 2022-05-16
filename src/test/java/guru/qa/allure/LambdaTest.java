package guru.qa.allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTest {

    private static final String Repository = "iPhoneSasuke/JU5annotations";
    private static final int Issue_Numb = 12;
    @BeforeAll
    public static void browConfig() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1200";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @DisplayName("Поиск Issue в Гите")
    @Test
    public void selenideTest() {
        Allure.parameter("Регион", "Ленинградская область");
        Allure.parameter("Город", "Санкт-Петербург");
        step("Открываем Гит", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий " + Repository, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(Repository);
            $(".header-search-input").pressEnter();
        });
        step("Переходим по ссылке репозитория " + Repository, () -> {
            $(byLinkText("iPhoneSasuke/JU5annotations")).click();
        });
        step("кликаем на таб Issues", () -> {
            $(byPartialLinkText("Issues")).click();
        });
        step("Проверяем наличие Issue  с номером " + Issue_Numb, () -> {
            $(withText("12")).click();

        });
    }
}
