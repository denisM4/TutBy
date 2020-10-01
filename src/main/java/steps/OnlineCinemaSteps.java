package steps;

import org.testng.Assert;
import page.MainPage;
import page.OnlineCinemaPage;
import util.Util;

public class OnlineCinemaSteps {

    private String genre;

    public OnlineCinemaSteps getOnlineFilmsDescription(String genre) {

        new MainPage()
                .eventsButtonClick()
                .clickOnlineCinemaButton()
                .clickFilmsTab()
                .selectGenre(genre);

        this.genre = genre;
        return this;
    }

    public OnlineCinemaSteps getOnlineSeriesDescription(String genre) {

        new MainPage()
                .eventsButtonClick()
                .clickOnlineCinemaButton()
                .clickSeriesTab()
                .selectGenre(genre);

        this.genre = genre;
        return this;
    }

    public OnlineCinemaSteps getOnlineCartoonDescription(String genre) {

        new MainPage()
                .eventsButtonClick()
                .clickOnlineCinemaButton()
                .clickCartoonTab()
                .selectGenre(genre);

        this.genre = genre;
        return this;
    }

    public void assertOnlineCinemaDescription() {

        var onlineCinemaPage = new OnlineCinemaPage();
        boolean checkResult;

        checkResult = Util.checkTextOnAllPages(onlineCinemaPage.getFilmDescription(), genre, onlineCinemaPage.getNextPageButton());
        Assert.assertTrue(checkResult, "Genre is not have description with name - '- " + genre + " -'");

    }
}
