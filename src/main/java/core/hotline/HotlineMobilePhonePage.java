package core.hotline;

import core.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotlineMobilePhonePage extends AbstractPage {

    @FindBy(xpath = "(//a[@class='btn-orange btn-cell'])[1]")
    private WebElement buttonCheckPrice;

    public HotlineMobilePhonePage(WebDriver driver) {
        super(driver);
    }

    public void checkUrlPage(){
        String URL = driver.getCurrentUrl();
        Assert.assertEquals("Wrong URL", URL, "https://hotline.ua/mobile/mobilnye-telefony-i-smartfony/");
    }

    public HotlineOneMobilePhonePage clickButtonCheckPrice(){
        wait.until(ExpectedConditions.visibilityOf(buttonCheckPrice));
        buttonCheckPrice.click();
        return new HotlineOneMobilePhonePage(driver);
    }
}
