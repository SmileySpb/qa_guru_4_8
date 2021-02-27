package io.qaguru.mkanin;

import io.qaguru.mkanin.steps.github.MainPageSteps;
import io.qaguru.mkanin.steps.github.RepositorySteps;
import io.qaguru.mkanin.steps.github.SearchPageSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class MethodsIssueTest {

    private final MainPageSteps mainPageSteps = new MainPageSteps();
    private final RepositorySteps repositorySteps = new RepositorySteps();
    private final SearchPageSteps searchPageSteps = new SearchPageSteps();

    private static final String BASE_URL = "https://github.com/";
    private static final String REPO_NAME = "qa_guru_5_dz";
    private static final String FULL_REPO_PATH = "SmileySpb/" + REPO_NAME;
    private static final String EXPECTED_ISSUE_NAME = "Issue for tests";

    @Test
    @DisplayName("Check issue has name " + EXPECTED_ISSUE_NAME)
    @Owner("io/qaguru/mkanin")
    @Severity(SeverityLevel.NORMAL)
    @Tags(@Tag("web"))
    @Link(name = "Base URL", value = BASE_URL)
    @Feature("Issues")
    public void checkIssueNameTest() {
        mainPageSteps.openGitHub();
        mainPageSteps.searchRepository(REPO_NAME);
        searchPageSteps.selectRepoByPath(FULL_REPO_PATH);
        repositorySteps.checkIssuesTabContentIsVisible();
        repositorySteps.checkIssueHasName(EXPECTED_ISSUE_NAME);
    }
}
