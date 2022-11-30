package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;


public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {Configuration.browser = "FIREFOX"; }
    @BeforeAll
    static void beforeAll2() {Configuration.browserSize = "2100x1080"; }


    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Diana");
        $("#lastName").setValue("Beck");
        $("#userEmail").setValue("dd@dd.dd");
        $(byText("Female")).click();
        // вариант из видео пропишу здесь для себя, потому что хочу оставить
        // всё же свой допертый умом и потом вариант
        // $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8988978977");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1997");
        $x("//div[contains(@aria-label,\"February 20th, 1997\")]").click();
        //мой вариант с датой:$("#dateOfBirthInput").setValue("16 Feb 2022").pressEscape();
        //но так поле заполнялось с ошибкой
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/picture1.png");
        $("#currentAddress").setValue("some street 123");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();


        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Diana Beck"),text("dd@dd.dd"),text("Female"),
                text("8988978977"),text("20 February,1997"),text("Maths"),text("Music"),text("picture1.png"),text("some street 123"),
                text("Haryana Karnal"));





    }
}
