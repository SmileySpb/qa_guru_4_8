package io.qaguru.mkanin.steps.github;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageSteps {
    private static final String BASE_URL = "https://github.com/";

    @Step("The user opens GitHub URL: " + BASE_URL)
    public void openGitHub() {
        open(BASE_URL);
        $("header[role='banner']").shouldBe(visible);
    }

    @Step("The user searches repository with name: {repoName}")
    public void searchRepository(String repoName) {
        $("input[name='q']").setValue(repoName).pressEnter();
    }
}
