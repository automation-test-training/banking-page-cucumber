import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by yqin on 7/16/16.
 */
public class Hooks {

    @Before
    public void beforeScenario() {
        Configuration.screenshots = false;
        Configuration.timeout = 8000;
        Configuration.collectionsTimeout = 12000;
        open("http://localhost:8100/#/app/playlists");
    }


    @After
    public void afterScenario() {
        WebDriverRunner.closeWebDriver();
    }

}
