import components.ClickCourse;
import components.MainMenuComponent;
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
import pageobject.CoursePage;

import java.util.concurrent.TimeUnit;

public class CourcePageTest {
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
    public void courcePageTest() {

        new MainPage(driver)
                .open("/");
        logger.info("Open browser");

        new MainMenuComponent(driver)
                .moveCursorToItem(MainMenuItemsData.Cources)
                .clickCourceByTesting(CourcesData.Testing)
                .pageHeaderShouldBeSameAs(CourcesData.Testing.getName());
        logger.info("Course page is open");

        ClickCourse clickCourse = new ClickCourse(driver);
        String startData = clickCourse.getStartCourceData(9);
        String period = clickCourse.getPeriodOfStudy(9);
        clickCourse.clickCoursePage(9);
        logger.info("Opening the course page");



        new CoursePage(driver)
                .checkTitle("Java QA Engineer. Basic")
                .checkDescription("Автоматизация тестирования на Java с нуля")
                .checkDataCource(period, 1)
                .checkDataCource("Online", 2)
                .checkDataCource( startData, 3);
        logger.info("Checking the course description");
    }
}
