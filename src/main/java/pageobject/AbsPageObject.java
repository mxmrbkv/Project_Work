package pageobject;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public abstract class AbsPageObject {

    protected WebDriver driver;
    protected Actions actions;

    public AbsPageObject(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    private WebElement header;


    public void pageHeaderShouldBeSameAs(String header) {
        assertThat(this.header.getText()).as("Header should be {%s}", header).isEqualTo(header);

    }

}
