package stepDefinitions;

import io.cucumber.java.After;
import utilities.ContextConfiguration;

public class QuitBrowser {
    ContextConfiguration contextConfiguration;

    public QuitBrowser(ContextConfiguration contextConfiguration) {
        this.contextConfiguration = contextConfiguration;
    }

    @After
    public void AfterScenario() {
        contextConfiguration.driver.quit();
    }

}
