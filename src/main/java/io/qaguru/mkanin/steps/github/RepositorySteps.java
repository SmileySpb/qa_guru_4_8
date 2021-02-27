package io.qaguru.mkanin.steps.github;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class RepositorySteps {
    private static final String ISSUES = "Issues";

    @Step("The user checks that " + ISSUES + " block is visible")
    public void checkIssuesTabContentIsVisible() {
        selectTabByName(ISSUES);
        $x(format("//div[@aria-label='%s']", ISSUES)).shouldBe(visible);
    }

    @Step("The user checks that issue has name: {issueName}")
    public void checkIssueHasName(String issueName) {
        $("#issue_1_link").shouldHave(text(issueName));
    }

    @Step("The user selects tab by name: {tabName}")
    private void selectTabByName(String tabName) {
        $x(format("//span[@data-content='%s']", tabName)).shouldBe(visible).click();
    }
}
