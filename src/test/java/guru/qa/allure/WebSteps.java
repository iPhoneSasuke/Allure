package guru.qa.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step ("Открываем главную страницу")
    public void openPage(){
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchRepository(String repo ) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").pressEnter();
    }

    @Step("Переходим по ссылке репозитрия {repo}")
    public void clickRepoLink(String repo) {
        $(byLinkText(repo)).click();
    }

    @Step("Кликаем на таб Issues")
    public void openIssueTab() {
        $(byPartialLinkText("Issues")).click();
    }
    @Step("Проверяем наличие Issue  с номером {numb}")
    public void checkIssue(int numb) {
        $(withText("#" + numb)).shouldBe(Condition.visible);
    }
}
