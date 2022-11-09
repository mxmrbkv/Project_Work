package pageobject;

import data.CourceInfoData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbsBasePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CoursePage extends AbsBasePage {

    public CoursePage(WebDriver driver) {
        super(driver);
    }

    private String title = "course-header2__title";

    private String discription = "h1.course-header2__subtitle";

    private String dataCources = "//*[contains(@class, 'course-header2-bottom__item')]//*[contains(text(), '%s')]";


    public CoursePage checkTitle(CourceInfoData courceInfoData) {

        String locator = String.format(title, courceInfoData.getName());
        String checkTitle = driver.findElement(By.cssSelector(locator))
                .getText();

        assertThat(checkTitle).as("Title of page should be {}",courceInfoData)
                .isEqualTo(courceInfoData);

        return this;
    }

    public CoursePage checkDescription(CourceInfoData courceInfoData) {

        String locator = String.format(discription, courceInfoData.getName());
        String checkTitle = driver.findElement(By.cssSelector(locator))
                .getText();

        assertThat(checkTitle).as("Description of page should be {}",courceInfoData)
                .isEqualTo(courceInfoData);

        return this;
    }

    public CoursePage checkDataCource(CourceInfoData courceInfoData) {

        String locator = String.format(dataCources, courceInfoData.getName());
        String checkTitle = driver.findElement(By.xpath(locator))
                .getText();

        assertThat(checkTitle).as("Error: value in input field {} should be {}",courceInfoData)
                .isEqualTo(courceInfoData);

        return this;
    }
}
