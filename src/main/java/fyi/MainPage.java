package fyi;

import enums.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By COPYRIGHT_TEXT = By.cssSelector("[class='u-small-text u-text u-text-variant u-text-1']");
    private final By HAMBURGER_ICON = By.xpath("//*[@id='menu-hamburger']/parent::a/parent::div");
    private final By MENU_LINKS = By.cssSelector("div[class=\"u-black u-container-style u-inner-container-layout u-sidenav\"] li a");


    public String getCopyRightText() {
        return getText(COPYRIGHT_TEXT);
    }

    public void clickOnMenuHamburgerIcon() {
        click(HAMBURGER_ICON);
    }
    public void clickOnMenuLink(String link) {
        clickElementByText(MENU_LINKS,link);
    }

    public List<String> getListOfMenuItems() {
        return getTextFromElements(MENU_LINKS);
    }


    public void openFYIPage() {
        openPage(Url.FYI_URL.getUrl());
    }

}




