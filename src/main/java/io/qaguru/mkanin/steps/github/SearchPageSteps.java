package io.qaguru.mkanin.steps.github;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPageSteps {
    @Step("The user selects repository by full path {repoPath}")
    public void selectRepoByPath(String repoPath) {
        $$(".repo-list a").first().shouldHave(text(repoPath)).click();
    }
}
