package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.PracticeFormPage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static pages.PracticeFormPage.assertPracticeForm;

@ExtendWith({SoftAssertsExtension.class})
public class PracticeFormTests extends TestBase {
    @Test
    @Tag("web")
    public void practiceFormTest() {
        Configuration.assertionMode = SOFT;
        Map<String, String> settings = getExpectedSettings();
        new PracticeFormPage()
                .openUrl()
                .withFirstname(settings.get("Student Name").split(" ")[0])
                .withLastname(settings.get("Student Name").split(" ")[1])
                .withEmail(settings.get("Student Email"))
                .withGender(settings.get("Gender"))
                .withMobileNumber(settings.get("Mobile"))
                .withDateOfBirth(Integer.parseInt(settings.get("Date of Birth")
                                .split(",")[0]
                                .split(" ")[0]),
                        settings.get("Date of Birth")
                                .split(",")[0]
                                .split(" ")[1],
                        settings.get("Date of Birth")
                                .split(",")[1])
                .withSubjects(settings.get("Subjects").split(","))
                .withHobbies(settings.get("Hobbies").replaceAll(" ", "").split(","))
                .withUploadedPicture(settings.get("Picture"))
                .withAddress(settings.get("Address"))
                .withStateAndCity(settings.get("State and City").split(" ")[0]
                        , settings.get("State and City").split(" ")[1])
                .submit();
        assertPracticeForm(settings);
    }

    private Map<String, String> getExpectedSettings() {
        Map<String, String> map = new HashMap<>();
        Faker faker = new Faker();
        String name = faker.name().firstName() + " " + faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().subscriberNumber(10);
        String address = faker.address().fullAddress();
        map.put("Student Name", name);
        map.put("Student Email", email);
        map.put("Gender", "Male");
        map.put("Mobile", phone);
        map.put("Date of Birth", "17 November,1989");
        map.put("Subjects", "Maths, Chemistry");
        map.put("Hobbies", "Sports, Reading, Music");
        map.put("Picture", "qa.png");
        map.put("Address", address);
        map.put("State and City", "NCR Noida");
        return map;
    }
}
