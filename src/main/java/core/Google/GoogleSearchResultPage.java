package core.Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class GoogleSearchResultPage {

    @FindBys({
            @FindBy(xpath = "//div[@class='rc']//h3")
    })
    private List<WebElement> searchResults;
    private WebDriver driver;

    public GoogleSearchResultPage(final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public List<String> getSearchResultItems(){
        return searchResults.stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }
}
