package components;

import data.MainMenuItemsData;
import data.cources.CourcesData;
import data.cources.ICourcesData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.CourcesTestingPage;
import pageobject.EventCalendarPage;

public class MainMenuComponent extends AbsBaseComponent {

    public MainMenuComponent(WebDriver driver) {
        super(driver);
    }

    private String mainMenuTemplateLocator = "//*[contains(@class, 'header2-menu_main')]/*[contains(@class, 'header2-menu__item')]";
    private String mainMenuITemLocator = mainMenuTemplateLocator + "[.//*[contains(text(), '%s')]]";
    private String subMenuTemplateLocator = mainMenuTemplateLocator + "//a[@title='%s']";

    public MainMenuComponent moveCursorToItem(MainMenuItemsData mainMenuItemsData) {
        String locator =  String.format(mainMenuTemplateLocator, mainMenuItemsData
                .getName());

        WebElement mainMenu = driver.findElement(By.xpath(locator));
        actions
                .moveToElement(mainMenu).build().perform();

        return this;
    }

    public CourcesTestingPage clickCourceByTesting(ICourcesData courcesData) {

        String locator = String.format(mainMenuITemLocator, CourcesData.Testing
                .getName());
        WebElement subMenu = driver.findElement(By.xpath(locator));

        String courcesLocator = String.format(subMenuTemplateLocator, courcesData
                .getName());

        actions
                .moveToElement(subMenu)
                .click(driver.findElement(By.xpath(courcesLocator))).build().perform();

        return new CourcesTestingPage(driver);
    }

    public EventCalendarPage clickEventCalendar(ICourcesData courcesData) {

        String locator = String.format(mainMenuITemLocator, CourcesData.EventsCalendar
                .getName());
        WebElement subMenu = driver.findElement(By.xpath(locator));

        String courcesLocator = String.format(subMenuTemplateLocator, courcesData
                .getName());

        actions
                .moveToElement(subMenu)
                .click(driver.findElement(By.xpath(courcesLocator))).build().perform();

        return new EventCalendarPage(driver);
    }
}
