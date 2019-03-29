import core.Google.GoogleMainPage;
import core.Google.GoogleSearchResultPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.List;

public class GoogleSearchHillel extends BaseTest {

//    @Test
//    public void checkGoogleMainPageTest(){
//        webDriver.get("https://www.google.com/"); //1
//        String actualTitle = webDriver.getTitle();   //2
//        String expectedTitle = "Google";     //3
//        Assert.assertEquals("There is incorrect title displayer!", expectedTitle, actualTitle);
//    }
    @Test
    public void checkGoogleSearchTest(){
        getWebDriver().get("https://www.google.com/");
        WebElement searchInput = getWebDriver().findElement(By.xpath("//input[@name='q']"));
        searchInput.sendKeys("hillel", Keys.ENTER);
        List<WebElement> serchresultLinks = getWebDriver().findElements(By.xpath("//*[@class='rc']//h3"));
        Assert.assertFalse("There are no links displayer", serchresultLinks.isEmpty());
        for (WebElement searchLink : serchresultLinks){
            String text = searchLink.getText().toLowerCase();
            String failedTestMessage = String.format("There is incorrect link [%s]", text);
            Assert.assertTrue(failedTestMessage, text.contains("hillel"));
        }
    }

    @Test
    public void checkGoogleSearchTestUsingOop(){
        getWebDriver().get("https://www.google.com/");
        final GoogleMainPage mainPage = new GoogleMainPage(getWebDriver());
        final GoogleSearchResultPage googleSearchHillel = mainPage.searFor("hillel");
        final List<String> searchResults = googleSearchHillel.getSearchResultItems();
        searchResults.forEach(item ->{
            String failedTestMessage = String.format("There is incorrect link text in link [%s]", item);
            Assert.assertTrue(failedTestMessage, item.toLowerCase().contains("hillel"));
        });
    }

}
