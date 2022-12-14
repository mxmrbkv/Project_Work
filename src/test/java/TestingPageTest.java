import components.MainMenuComponent;
import data.MainMenuItemsData;
import data.cources.CourcesData;
import driver.DriverFactory;
import exceptions.NotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import page.MainPage;
import pageobject.CourcesTestingPage;

import java.util.concurrent.TimeUnit;

public class TestingPageTest {

    private Logger logger = LogManager.getLogger(TestingPageTest.class);
    public WebDriver driver;

    @BeforeAll
    public static void init(){

        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void initDriver() throws NotSupportedException {
        this.driver = new DriverFactory().create(DriverManagerType.CHROME, null);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        logger.info("Driver installed");
    }
    @AfterEach
    public void close() {
        if(driver !=null) {
            driver.close();
            driver.quit();
        }
    }
    @Test
    public void testingPage() {

        new MainPage(driver)
                .open("/");
        logger.info("Open browser");

        new MainMenuComponent(driver)
                        .moveCursorToItem(MainMenuItemsData.Cources)
                        .clickCourceByTesting(CourcesData.Testing)
                        .pageHeaderShouldBeSameAs(CourcesData.Testing.getName());
        logger.info("Course page is open");

        new CourcesTestingPage(driver)
                .checkCourceTales(14);
        logger.info("Number of courses current");
    }
}
