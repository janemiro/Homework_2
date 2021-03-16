package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutoForm {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }


    @Test
    void successfulFillTestWithNotBestLocators() {
        open("https://demoqa.com/automation-practice-form");
        //готово имя, мейл
        $("#firstName").setValue("Koshka");
        $("#lastName").setValue("Dusya");
        $("#userEmail").setValue("dusya@gmail.com");

        //готово пол радиокнопка
        $("#gender-radio-3").doubleClick();

        //готово мобильный
        $("#userNumber").setValue("0123456789");

        //календарь жмякнуть, выбрать ГОД, МЕСЯЦ, ДЕНЬ
        $("#dateOfBirthInput").click();
        $("#react-datepicker__year-select").scrollIntoView("1991").click();
        $("#react-datepicker__month-select").find("February").click();
        $("#react-datepicker__month").find("3").click();



        //начать набирать Eng

        //галки на хобби

        //загрузить картинку
        $("#uploadPicture").click();

        //адрес
        $("#currentAddress").setValue("On the Roof, 5");
        $("#state").find("Haryana").click();
        $("#city").find("Panipat").click();

        //сабмит
        $("#submit").click();
        System.out.println("lalal");

    }
}
