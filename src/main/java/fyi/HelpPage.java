package fyi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelpPage extends BasePage{
    public HelpPage(WebDriver driver) {
        super(driver);
    }

    private final By CONTACT_US = By.cssSelector("[title=\"Contact us\"]");


    public void clickOnContactUsButton() {
        click(CONTACT_US);
    }
}
