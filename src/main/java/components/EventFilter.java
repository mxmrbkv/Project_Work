package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventFilter extends AbsBaseComponent {

    public EventFilter(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='dod_new-events-dropdown__input'][.//*[contains(text(), 'Все мероприятия')]]")
    private WebElement clickEventFilter;

    public DropDownMenu dropDownMenu() {
        clickEventFilter.click();
        return new DropDownMenu(driver);
    }
}
