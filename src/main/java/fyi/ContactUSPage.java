package fyi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ContactUSPage  extends BasePage{
    public ContactUSPage(WebDriver driver) {
        super(driver);
    }

    private final By SEARCH = By.cssSelector("input[placeholder=\"Search\"]");
    private final By SEARCH_RESULT_SUBHEADING = By.cssSelector("h1[class=\"search-results-subheading\"]");


    public void searchByText(String text) {
        typeText(SEARCH,text);
        getElement(SEARCH).sendKeys(Keys.ENTER);
    }
    public String getSearchSubHeadingText(){
        return getText(SEARCH_RESULT_SUBHEADING);
    }
}
