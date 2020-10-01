import config.ConfigurationTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.OnlineCinemaSteps;

public class OnlineCinemaTest extends ConfigurationTest {

    @DataProvider(name = "Genre")
    public Object[][] getData() {
        Object[][] data = {{"Ужасы"}, {"Боевик"}, {"Детектив"}, {"Фэнтези"}, {"Фантастика"}, {"Комедия"}};
        return data;
    }

    @Test(dataProvider = "Genre", description = "Check films descriptions")
    public void checkEqualFilmsGenres(String genre) {

        var onlineCinemaSteps = new OnlineCinemaSteps();

        onlineCinemaSteps
                .getOnlineFilmsDescription(genre)
                .assertOnlineCinemaDescription();
    }

    @Test(dataProvider = "Genre", description = "Check series descriptions")
    public void checkEqualSeriesGenres(String genre) {

        var onlineCinemaSteps = new OnlineCinemaSteps();

        onlineCinemaSteps
                .getOnlineSeriesDescription(genre)
                .assertOnlineCinemaDescription();
    }

    @Test(dataProvider = "Genre", description = "Check cartoon descriptions")
    public void checkEqualCartoonGenres(String genre) {

        var onlineCinemaSteps = new OnlineCinemaSteps();

        onlineCinemaSteps
                .getOnlineCartoonDescription(genre)
                .assertOnlineCinemaDescription();
    }
}
