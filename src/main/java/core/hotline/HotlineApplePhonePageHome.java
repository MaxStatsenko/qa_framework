package core.hotline;

import core.AbstractPage;
import core.BaseUrl;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@BaseUrl(value = "https://hotline.ua")
public class HotlineApplePhonePageHome extends AbstractPage {

    public HotlineApplePhonePageHome(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//a[@data-eventlabel = 'Apple[294245]']) [1]")
    private WebElement checkBoxApple;

    @FindBys({
            @FindBy(xpath = "//a[@data-tracking-id='catalog-10']")
    })
    public List<WebElement> filterItems;

    public void clickOnCheckBox() {
        checkBoxApple.click();
        waitForJsToLoad();
    }

    public void swipeDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public List<String> getFilterItems() {
        return filterItems.stream()
                .map(this ::replaceText)
                .collect(Collectors.toList());
    }

    private String replaceText(final WebElement webElement) {
        return webElement.getText().trim();
    }

    public void assertText() {
        getFilterItems().forEach(item ->{
            final String text = item.toLowerCase();
            final String find = "apple";
            final String filterItemText = String.format("There is incorrect filter item text displayed! Expected [%s], Actual [%s]", find, text);
            Assert.assertTrue(filterItemText, text.contains(find));
        });
    }
}
