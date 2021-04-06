package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutoForm {

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "2100x1080";
    }

    String firstName = "Koshka",
            lastName = "Dusya",
            userEmail = "dusya@gmail.com",
            gender = "Other",
            userNumber = "1234567890",
            dayOfBirth = "03",
            monthOfBirth = "June",
            yearOfBirth = "1984",
            subject1 = "English",
            subject2 = "Computer Science",
            hobby1 = "Reading",
            hobby2 = "Music",
            currentAddress = "On the Roof, 5",
            state = "Haryana",
            city = "Panipat",
            picture = "1.png";

    @Test
    void successfulFillTestWithNotBestLocators() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(userEmail);
        $(byText(gender)).click();
        $("#userNumber").val(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $$(".react-datepicker__day--0" + dayOfBirth)
                .filter(not(cssClass("react-datepicker__day--outside-month")))
                .first().click();
        // предметы
        $("#subjectsInput").val(subject1).pressEnter();
        $("#subjectsInput").val(subject2);
        $(".subjects-auto-complete__menu-list").$(byText(subject2)).click();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").val(currentAddress);
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();

    }

    public void check() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subject1 + ", " + subject2));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobby1 + ", " + hobby2));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("1.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(state + " " + city));

    }

}
