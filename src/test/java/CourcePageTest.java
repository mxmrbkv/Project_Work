import components.ClickCourse;
import components.MainMenuComponent;
import data.CourceInfoData;
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

        new MainMenuComponent(driver)
                .moveCursorToItem(MainMenuItemsData.Cources)
                .clickCourceByTesting(CourcesData.Testing)
                .pageHeaderShouldBeSameAs(CourcesData.Testing.getName());

        new ClickCourse(driver)
                .clickCoursePage();


        new CoursePage(driver)
                .checkTitle(CourceInfoData.TITLE)
                .checkDescription(CourceInfoData.DISCRIPTION)
                .checkDataCource(CourceInfoData.DURATIONOFTRANING)
                .checkDataCource(CourceInfoData.FORMAT)
                .checkDataCource(CourceInfoData.STARTLESSON);
    }
}
