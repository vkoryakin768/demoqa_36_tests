package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void practiceFormTest() {
        open("/automation-practice-form");

        //Name
        $("#firstName").setValue("Egor");
        $("#lastName").setValue("Egorov");

        //Email
        $("#userEmail").setValue("Egor@egorov.com");

        //Gender
        $("label[for='gender-radio-1']").click();

        //Mobile
        $("#userNumber").setValue("9995553377");

        //DateOfBirth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__day--023").click();

        //Subjects
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#subjectsInput").setValue("Physics").pressEnter();

        //Hobbies
        $("label[for='hobbies-checkbox-1']").click();

        //Picture
        $("#uploadPicture").uploadFromClasspath("Screenshot_2.png");

        //CurrentAddress
        $("#currentAddress").setValue("Street 1");

        //StateAndCity
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Gurgaon").pressEnter();

        //Submit
        $("#submit").click();

        //
        $(".table-responsive").shouldHave(text("Egor Egorov"));
        $(".table-responsive").shouldHave(text("Egor@egorov.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9995553377"));
        $(".table-responsive").shouldHave(text("23 July,1996"));
        $(".table-responsive").shouldHave(text("Maths, Physics"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Screenshot_2.png"));
        $(".table-responsive").shouldHave(text("Street 1"));
        $(".table-responsive").shouldHave(text("NCR Gurgaon"));

    }

}
