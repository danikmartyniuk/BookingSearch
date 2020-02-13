package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingMainPage extends BasePage{

    @FindBy(id = "ss")
    private WebElement searchInput;

    public BookingMainPage(WebDriver driver) {
        super(driver);
    }

    public void inputHotel (String keyword) {
        searchInput.sendKeys(keyword);
    }

    public void search () {
        searchInput.sendKeys(Keys.ENTER);
    }
}
