package guru.qa.allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WebStepsTest {

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
        WebSteps step = new WebSteps();

        step.openPage();
        step.searchRepository(Repository);
        step.clickRepoLink(Repository);
        step.openIssueTab();
        step.checkIssue(Issue_Numb);
    }
}
