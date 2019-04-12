package core.hotline;

import core.AbstractPage;
import core.BaseUrl;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

@Data
@BaseUrl(value = "https://hotline.ua")
public class HotlineCheckCurrencyRange extends AbstractPage {
    public HotlineCheckCurrencyRange(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/mobile/']")
    private WebElement mainMobileButton;

    @FindBy(xpath = "//span[@class='telefony-i-garnitury']")
    private WebElement childMobileButton;

    @FindBy(xpath = "(//a[@class='mobilnye-telefony-i-smartfony'])[1]")
    private WebElement superChildMobileButton;

    public void hoverOnButton() {
        actions.moveToElement(mainMobileButton).build().perform();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.moveToElement(childMobileButton).click().build().perform();

    }
    public HotlineMobilePhonePage selectMobilePhonesPage(){
        wait.until(ExpectedConditions.visibilityOf(superChildMobileButton));
        superChildMobileButton.click();
        return new HotlineMobilePhonePage(driver);
    }
}
