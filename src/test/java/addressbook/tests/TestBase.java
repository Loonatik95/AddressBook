package addressbook.tests;

import addressbook.appmanager.ApplicationManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.BrowserType;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeAll
    public static void setUp() {
        app.init();
    }

    @AfterAll
    public static void tearDown() {
        app.stop();
    }

}
