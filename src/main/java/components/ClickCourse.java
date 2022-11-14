package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.CoursePage;

public class ClickCourse extends AbsBaseComponent{

    public  ClickCourse(WebDriver driver) {
        super(driver);
    }

    private String clickCourceTamplate =  "div[class='lessons'] :nth-of-type(%d)";

    public CoursePage clickCoursePage(int i) {
        String selector = String.format(clickCourceTamplate, i);
        driver.findElement(By.cssSelector(selector)).click();
        return new CoursePage(driver);
    }

    public String getStartCourceData(int i) {

        String selector = String.format(clickCourceTamplate, i);
        WebElement tile = driver.findElement(By.cssSelector(selector));
        String startData = tile.findElement(By.xpath(".//div[@class = 'lessons__new-item-start']"))
                .getText()
                .replace("С", "")
                .trim();

        return startData;
    }

    public String getPeriodOfStudy(int i){

        String selector = String.format(clickCourceTamplate, i);
        WebElement tile = driver.findElement(By.cssSelector(selector));
        String periodData = tile.findElement(By.xpath(".//div[@class = 'lessons__new-item-time']"))
                .getText();


        return periodData;
    }
}
