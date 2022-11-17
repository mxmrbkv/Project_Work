import components.EventFilter;
import components.MainMenuComponent;
import components.DropDownMenu;
import data.MainMenuItemsData;
import data.cources.CourcesData;
import driver.DriverFactory;
import exceptions.NotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.MainPage;
import pageobject.EventCalendarPage;

import java.util.concurrent.TimeUnit;

public class EventCalendarTest {

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
    public void eventCalendarTest() {

        new MainPage(driver)
                .open("/");
        logger.info("Open browser");

        new MainMenuComponent(driver)
                .moveCursorToItem(MainMenuItemsData.Developments)
                .clickEventCalendar(CourcesData.EventsCalendar);
        logger.info("Hover over event calendar");

        new EventCalendarPage(driver)
                .getLoadOfEventStyle()
                .checkEventData();
        logger.info("Checking dates for upcoming events");

        new EventFilter(driver)
                .dropDownMenu();
        logger.info("Event filter openings");

        new DropDownMenu(driver)
                .clickOpenWebinar();
        logger.info("Clicking on an open webinar");

        new EventCalendarPage(driver)
                .checkFiltered();
        logger.info("Сhecking the public webinar filter");
    }
}
