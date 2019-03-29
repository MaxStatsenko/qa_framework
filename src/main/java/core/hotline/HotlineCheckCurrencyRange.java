package core.hotline;

import core.AbstractPage;
import core.BaseUrl;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
@BaseUrl(value = "https://hotline.ua")
public class HotlineCheckCurrencyRange extends AbstractPage {
    public HotlineCheckCurrencyRange(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/mobile/']")
    private WebElement mobileButton;

    public void hoverOnButton(){
        actions.moveToElement(mobileButton);
    }

}
