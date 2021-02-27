package io.qaguru.mkanin;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideIssueTest {

    private static final String BASE_URL = "https://github.com/";
    private static final String REPO_NAME = "qa_guru_5_dz";
    private static final String EXPECTED_ISSUE_NAME = "Issue for tests";

    @Test
    @DisplayName("Check issue has name " + EXPECTED_ISSUE_NAME)
    @Owner("io/qaguru/mkanin")
    @Severity(SeverityLevel.NORMAL)
    @Tags(@Tag("web"))
    @Link(name = "Base URL", value = BASE_URL)
    @Feature("Issues")
    public void checkIssueNameTest() {
        open(BASE_URL);
        $("header[role='banner']").shouldBe(visible);
        $("input[name='q']").setValue(REPO_NAME).pressEnter();
        $$(".repo-list a").first().shouldHave(text("SmileySpb/" + REPO_NAME)).click();
        $("span[data-content='Issues']").shouldBe(visible).click();
        $("div[aria-label='Issues']").shouldBe(visible);
        $("#issue_1_link").shouldHave(text(EXPECTED_ISSUE_NAME));
    }
}
