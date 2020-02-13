package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class BookingSearchPage extends BasePage{

    @FindBy(xpath = "//span[@class='sr-hotel__name\n']")
    private List<WebElement> resultsLinks;

    @FindBy(xpath = "//div[@class='bui-review-score__badge']")
    private List<WebElement> ratings;

    public BookingSearchPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getResultLinks () {
        return resultsLinks.stream().map(result->result.getAttribute("innerText"))
                .filter(result-> !result.isEmpty()).collect(Collectors.toList());
    }

    public List<String> getRating () {
        return ratings.stream().map(result->result.getAttribute("innerText"))
                .filter(result-> !result.isEmpty()).collect(Collectors.toList());
    }

    public void isPageLoaded () {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("map-header-cta"))));
    }
}
