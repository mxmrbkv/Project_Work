package pageobject;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbsBasePage;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CourcesTestingPage extends AbsBasePage {

    public CourcesTestingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.lessons__new-item-bg")
    private List<WebElement> courceTales;

    public CourcesTestingPage checkCourceTales(int amount) {

        assertThat(courceTales.size()).as("The number of courses should be{}", amount).isEqualTo(amount);

        return this;
    }
}
