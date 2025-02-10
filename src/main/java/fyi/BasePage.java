package fyi;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor js;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions=new Actions(driver);
        js=(JavascriptExecutor) driver;
    }

    public void clickAndSwitchTab(By by) {
        click(by);
        switchToTab(1);
    }
    public void clickAndSwitchTab(By by,int index) {
        click(by,index);
        switchToTab(1);
    }
    public void click(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public void click(By by, int index) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        wait.until(ExpectedConditions.elementToBeClickable(getElement(by,index)));
        driver.findElements(by).get(index).click();
    }


    public WebElement getElement(By by) {
        return driver.findElement(by);
    }

    public WebElement getElement(By by, int index) {
        return driver.findElements(by).get(index);
    }

    public List<WebElement> getElementsList(By by) {
        return driver.findElements(by);
    }

    public List<String> getTextFromElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickElementByText(By by, String text) {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

        for (WebElement element : elements) {
            if (element.getText().trim().equalsIgnoreCase(text)) {
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                break;
            }
        }
    }


    public void typeText(By by, String key) {
        driver.findElement(by).sendKeys(key);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void switchToTab(int index) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    public void closeTab() {
        driver.close();
        switchToTab(0);
    }

    public String getText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    public boolean isDisplayed(By by) {
        try {wait.until(ExpectedConditions.visibilityOfElementLocated(by));}
        catch (Exception e){}
        return driver.findElement(by).isDisplayed();

    }
    public boolean isDisplayed(By by, int index) {
        try {wait.until(ExpectedConditions.visibilityOf(getElement(by,index)));}
        catch(Exception e){}
        return driver.findElements(by).get(index).isDisplayed();
    }

    public boolean isClickable(By by, int index) {
        try {wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
             wait.until(ExpectedConditions.elementToBeClickable(getElement(by,index)));
            return true;
        }catch(Exception e){return false;}

    }


    public void moveToElement(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        actions.moveToElement(getElement(by)).perform();
    }
    public void moveToElement(By by,int index){
        wait.until(ExpectedConditions.visibilityOf(getElement(by,index)));
        actions.moveToElement(getElement(by,index)).perform();

    }
    public void scrollTheWebPageTillEnd(){
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void backToPrevioesPage(){
        driver.navigate().back();
    }
}


