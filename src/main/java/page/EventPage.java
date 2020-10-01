package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class EventPage {

    private final SelenideElement
            onlineCinemaButton = $("a[href*='online-cinema']");


    public OnlineCinemaPage clickOnlineCinemaButton() {
        onlineCinemaButton.shouldBe(Condition.visible).click();
        return new OnlineCinemaPage();
    }
}
