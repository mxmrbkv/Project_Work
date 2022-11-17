package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.EventCalendarPage;

public class DropDownMenu extends AbsBaseComponent {

    public DropDownMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class, 'dod_new-events-dropdown_opened')] //a[@title='Открытый вебинар']")
    private WebElement openWebinar;

    public EventCalendarPage clickOpenWebinar() {
        openWebinar.click();
        return new EventCalendarPage(driver);
    }
}
