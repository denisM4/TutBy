package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement
            topMenu = $(".b-topbar-i"),
            eventsButton = topMenu.$("a[title='Афиша']");


    public EventPage eventsButtonClick() {
        eventsButton.shouldBe(Condition.visible).click();
        return new EventPage();
    }


}
