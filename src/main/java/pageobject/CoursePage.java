package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbsBasePage;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CoursePage extends AbsBasePage {

    public CoursePage(WebDriver driver) {
        super(driver);
    }

    private String title = "course-header2__title";

    private String discription = "h1.course-header2__subtitle";


    @FindBy(css = "p.course-header2-bottom__item-text")
    private List<WebElement> headerInfoTiles;


    public CoursePage checkTitle(String value) {

        String checkTitle = driver.findElement(By.cssSelector(title))
                .getText();

        assertThat(checkTitle).as("Title of page should be {}", value)
                .isEqualTo(value);

        return this;
    }

    public CoursePage checkDescription(String value) {

        String checkDescription = driver.findElement(By.cssSelector(discription))
                .getText();

        assertThat(checkDescription).as("Description of page should be {}",value)
                .isEqualTo(value);

        return this;
    }

    public CoursePage checkDataCource(String value, int i) {


        String checkDataCource = headerInfoTiles.get(--i)
                .getText();

        assertThat(checkDataCource).as("Error: value should be {}",value)
                .isEqualTo(value);

        return this;
    }
}
