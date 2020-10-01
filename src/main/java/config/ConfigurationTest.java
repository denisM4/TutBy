package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class ConfigurationTest {

    private static void configDriver() {

        Configuration.baseUrl = "https://www.tut.by";
        Configuration.headless = true;
        Configuration.timeout = 6000;
    }

    @BeforeMethod
    public void init() {
        configDriver();
        open("/");
    }

    @AfterTest(alwaysRun = true)
    public void close() {
        Selenide.closeWebDriver();
    }
}
