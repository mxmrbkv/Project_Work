package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.FilteredWebinarPage;

public class DropDownMenu extends AbsBaseComponent {

    public DropDownMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class, 'dod_new-events-dropdown_opened')] //a[@title='Открытый вебинар']")
    private WebElement openWebinar;

    public FilteredWebinarPage clickOpenWebinar() {
        openWebinar.click();
        return new FilteredWebinarPage(driver);
    }
}
