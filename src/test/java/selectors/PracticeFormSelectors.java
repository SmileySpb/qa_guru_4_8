package selectors;

public final class PracticeFormSelectors {
    public static final String MAIN_HEADER = ".main-header";
    public static final String FIRST_NAME_ID = "#firstName";
    public static final String LAST_NAME_ID = "#lastName";
    public static final String EMAIL_ID = "#userEmail";
    public static final String GENDER_BY_TYPE = "input[name='gender'][value='%s']+label";
    public static final String MOBILE_NUMBER_ID = "#userNumber";
    public static final String DATE_OF_BIRTH_INPUT = "#dateOfBirthInput";
    public static final String DATEPICKER = ".react-datepicker__month-container";
    public static final String DATEPICKER_MONTH = ".react-datepicker__month-select";
    public static final String DATEPICKER_YEAR = ".react-datepicker__year-select";
    public static final String DATE_BY_NUMBER = ".react-datepicker__day--0%s";
    public static final String SUBJECTS = "#subjectsContainer";
    public static final String HOBBY_BY_NAME = "//label[contains(@for,'hobbies-checkbox-') and .='%s']";
    public static final String UPLOAD_PICTURE_ID = "#uploadPicture";
    public static final String CURRENT_ADDRESS_ID = "#currentAddress";
    public static final String STATE_INPUT = "#state input";
    public static final String CITY_INPUT = "#city input";
    public static final String SUBMIT_ID = "#submit";
    public static final String MODAL_SETTING_VALUE_BY_NAME = "//div[@class='modal-body']//td[.='%s']//following-sibling::td";
}
