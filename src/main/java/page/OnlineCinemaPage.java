package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import util.Util;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OnlineCinemaPage {

    private final ElementsCollection filmDescription = $$("div.txt p");

    private final SelenideElement
            filmContainer = $("div.active"),

            filmsWidgetTab = $("a[data-show = 'movie']"),
            seriesWidgetTab = $("a[data-show = 'serial']"),
            cartoonsWidgetTab = $("a[data-show = 'animation']"),

            genresDropDownButton = filmContainer.$("button"),
            nextPageButton = $(".p-next a");


    public OnlineCinemaPage clickFilmsTab() {
        filmsWidgetTab.shouldBe(Condition.visible).click();
        Util.waitUntilLoadingDisappears();
        return this;
    }

    public OnlineCinemaPage clickSeriesTab() {
        seriesWidgetTab.shouldBe(Condition.visible).click();
        Util.waitUntilLoadingDisappears();
        return this;
    }

    public OnlineCinemaPage clickCartoonTab() {
        cartoonsWidgetTab.shouldBe(Condition.visible).click();
        Util.waitUntilLoadingDisappears();
        return this;
    }

    public OnlineCinemaPage selectGenre(String name) {
        genresDropDownButton.scrollIntoView(true).click();
        filmContainer.findAll("a span").filterBy(Condition.text(name)).first().click();
        Util.waitUntilLoadingDisappears();
        return this;
    }

    public SelenideElement getNextPageButton() {
        return nextPageButton;
    }

    public ElementsCollection getFilmDescription() {
        return filmDescription;
    }

}
