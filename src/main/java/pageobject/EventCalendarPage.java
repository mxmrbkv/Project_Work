package pageobject;

import data.NameOfMonthsDate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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



    private List<LocalDateTime> getStartEventData() {

        List<String> dataText = webElementData.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> dataTime = webElementTime.stream().map(WebElement::getText).collect(Collectors.toList());

        List<String> resaultDataStr = new ArrayList<>();
        for (int i = 0; i< dataText.size(); i++) {

            resaultDataStr.add(i, dataText.get(i) + " " + LocalDate.now().getYear() + " " + dataTime.get(i));
        }


        return resaultDataStr.stream().map(dataStr -> {
            String[] strSplit = dataStr.split("\\s+");
            String month = strSplit[1];
            String str = dataStr.replace(month, String.format("%d", monthDate(month)));
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MM yyyy HH:mm", Locale.ROOT);
            return LocalDateTime.parse(str, dateTimeFormatter);
        }).collect(Collectors.toList());
    }

    public EventCalendarPage checkEventData() {
        getStartEventData().forEach(startEventData -> {
            assertThat(startEventData.isAfter(LocalDateTime.now())).as("Header should be {%s}").isTrue();
        });

        return this;
    }

    public int monthDate(String data) {
        for(NameOfMonthsDate nameOfMonthsDate: NameOfMonthsDate.values()){

            if(nameOfMonthsDate.getName().equals(data)) {

                return nameOfMonthsDate.getNum();
            }
        }

        return -1;
    }
}
