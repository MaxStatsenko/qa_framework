package core.Google;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPageHome {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    private WebDriver driver;

    public GoogleMainPageHome(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public GoogleMainPageHome searFor (final String text){
        searchInput.sendKeys(text, Keys.ADD);
        return new GoogleMainPageHome(driver);
    }
}

