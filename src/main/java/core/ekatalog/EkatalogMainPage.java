package core.ekatalog;

import core.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EkatalogMainPage extends AbstractPage {
    @FindBy(xpath = "//a[text() = 'Гаджеты'")
    private WebElement gadgetManuItem;

    @FindBy(xpath = "//a[contains(text(), 'Мобильные')]")
    private WebElement mobilePhone;


    public EkatalogMainPage(final WebDriver driver){
        super(driver);
    }

    public void hoverGadgetMenuItem(){
        actions.moveToElement(gadgetManuItem);
    }

    public void selectMobilePhoneMenuItem(){
        wait.until(ExpectedConditions.visibilityOf(mobilePhone));
        mobilePhone.click();
    }

}
