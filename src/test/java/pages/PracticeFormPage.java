package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static selectors.PracticeFormSelectors.*;

public class PracticeFormPage {

    private static final String BASE_URL = "https://demoqa.com/automation-practice-form";

    @Step("Open DemoQA URL: " + BASE_URL)
    public PracticeFormPage openUrl() {
        open(BASE_URL);
        $(MAIN_HEADER).shouldBe(Condition.visible);
        return this;
    }

    @Step("Fill first name: {firstName}")
    public PracticeFormPage withFirstname(String firstName) {
        $(FIRST_NAME_ID).setValue(firstName);
        return this;
    }

    @Step("Fill last name: {lastName}")
    public PracticeFormPage withLastname(String lastName) {
        $(LAST_NAME_ID).setValue(lastName);
        return this;
    }

    @Step("Fill e-mail: {email}")
    public PracticeFormPage withEmail(String email) {
        $(EMAIL_ID).setValue(email);
        return this;
    }

    @Step("Specify gender: {type}")
    public PracticeFormPage withGender(String type) {
        $(format(GENDER_BY_TYPE, type)).click();
        return this;
    }

    @Step("Specify mobile number: {number}")
    public PracticeFormPage withMobileNumber(String number) {
        SelenideElement mobileNumber = $(MOBILE_NUMBER_ID);
        mobileNumber.setValue(number);
        mobileNumber.shouldHave(Condition.match("entered phone number", phone -> {
            String actualNumber = executeJavaScript("return document.querySelector('#userNumber').value;");
            return number.equals(actualNumber);
        }));
        return this;
    }

    @Step("Specify date of birth: {day}, {month}, {year}")
    public PracticeFormPage withDateOfBirth(int day, String month, String year) {
        $(DATE_OF_BIRTH_INPUT).click();
        SelenideElement datePicker = $(DATEPICKER);
        datePicker.shouldBe(visible);
        datePicker.$(DATEPICKER_MONTH).selectOption(month);
        datePicker.$(DATEPICKER_YEAR).selectOption(year);
        datePicker.$(format(DATE_BY_NUMBER, day)).click();
        datePicker.shouldBe(not(visible));
        return this;
    }

    @Step("Select objects: {objects}")
    public PracticeFormPage withSubjects(String... objects) {
        for (String object : objects) {
            $(SUBJECTS).$("input").setValue(object).pressEnter();
        }
        return this;
    }

    @Step("Select hobbies: {hobbies}")
    public PracticeFormPage withHobbies(String... hobbies) {
        for (String hobby : hobbies) {
            $x(format(HOBBY_BY_NAME, hobby)).click();
        }
        return this;
    }

    @Step("Upload file: {fileName}")
    public PracticeFormPage withUploadedPicture(String fileName) {
        $(UPLOAD_PICTURE_ID).uploadFile(new File("src/test/resources/images/" + fileName));
        return this;
    }

    @Step("Specify address: {address}")
    public PracticeFormPage withAddress(String address) {
        $(CURRENT_ADDRESS_ID).setValue(address);
        return this;
    }

    @Step("Select state: {state} and city {city}")
    public PracticeFormPage withStateAndCity(String state, String city) {
        $(STATE_INPUT).setValue(state).pressEnter();
        $(CITY_INPUT).setValue(city).pressEnter();
        return this;
    }

    @Step("Click on SUBMIT button")
    public void submit() {
        $(SUBMIT_ID).submit();
    }

    @Step("Verify practice values the same as: {settingsMap}")
    public static void assertPracticeForm(Map<String, String> settingsMap) {
        settingsMap.forEach((key, value) -> $x(format(MODAL_SETTING_VALUE_BY_NAME, key)).shouldHave(exactText(value)));
    }
}
