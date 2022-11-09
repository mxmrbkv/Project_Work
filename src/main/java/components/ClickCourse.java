package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.CoursePage;

public class ClickCourse extends AbsBaseComponent{

    public  ClickCourse(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[class='lessons'] :nth-of-type(8)")
    private WebElement clickCourse;

    public CoursePage clickCoursePage() {
        clickCourse.click();
        return new CoursePage(driver);
    }
}
