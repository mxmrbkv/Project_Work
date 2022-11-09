package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EventCalendarPage extends AbsPageObject {

    public EventCalendarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.dod_new-header__title")
    private WebElement header;

    @FindBy(css = ".dod_new-event__calendar-icon ~ .dod_new-event__date-text")
    private List<WebElement> webElementData;

    @FindBy(css = ".dod_new-event__clock-icon ~ .dod_new-event__date-text")
    private List<WebElement> webElementTime;


    public void pageHeaderShouldBeSameAs(String header) {
        assertThat(this.header.getText())
                .as("Header should be {%s}", header)
                .isEqualTo(header);
    }



    public LocalDate getStartEventData() {

        List<String> dataText = webElementData.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> dataTime = webElementTime.stream().map(WebElement::getText).collect(Collectors.toList());

        List<String> resaultDataStr = new ArrayList<>();
        for (int i = 0; i< dataText.size(); i++) {

            resaultDataStr.add("9 Ноября");
            resaultDataStr.add("" + "20:00");
        }

    }
}
