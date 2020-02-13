package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookingMainPage;
import pages.BookingSearchPage;

import java.util.List;

import static org.testng.Assert.*;

public class SearchSteps {

    private static final String BOOKING_URL = "https://www.booking.com/searchresults.en-gb.html";
    private WebDriver driver;
    private BookingMainPage mainPage;


    @Given("User on the search page")
    public void userOnTheSearchPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BOOKING_URL);
        mainPage = new BookingMainPage(driver);
    }

    @And("Hotel name is {string}")
    public void hotelNameIs(String hotel) {
        mainPage.inputHotel(hotel);
    }

    @When("User performs search")
    public void userPerformsSearch() {
        mainPage.search();
    }

    @Then("{string} appears in the search")
    public void appearsInTheSearch(String hotel) {
        BookingSearchPage page = new BookingSearchPage(driver);
        page.isPageLoaded();
        List<String> hotelsFound = page.getResultLinks();
        boolean isHotelFoundInTheList = hotelsFound.contains(hotel);
        assertFalse(isHotelFoundInTheList, "The hotel wasn't found");
    }

    @And("Hotel has rating {string}")
    public void hotelHasRating(String rating) {
        BookingSearchPage page = new BookingSearchPage(driver);
        List<String> ratingsFromTheList = page.getRating();
        assertEquals(ratingsFromTheList.get(0), rating, "Another rating was expected");
    }

}
