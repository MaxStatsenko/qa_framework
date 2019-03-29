import core.Google.GoogleMainPageHome;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSearchHillelHome {
    private WebDriver webDriver;
    @Before
    public void driverSetUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }
//    @Test
//    public void checkGoogleSearchHillel() {
//        webDriver.get("https://www.google.com/");
//        WebElement searchInput = webDriver.findElement(By.xpath("//input[@name='q']"));
//        searchInput.sendKeys("hillel");
//
//        List<WebElement> findAllElements = webDriver.findElements(By.xpath("//*[@role='option']/div/span"));
//        Assert.assertFalse("There are no links displayer", findAllElements.isEmpty());
//        for (int count=0; count < findAllElements.indexOf(9); count++) {
//            for (WebElement findText : findAllElements) {
//                String text = findText.getText().toLowerCase();
//                String failedTestMessage = String.format("There is incorrect link [%s]", text);
//                Assert.assertTrue(failedTestMessage, text.contains("hillel"));
//            }
//        }
//    }
    @Test
    public void checkGoogleSearchTestUsingOop() {
        webDriver.get("https://www.google.com/");
        final GoogleMainPageHome mainPageHome = new GoogleMainPageHome(webDriver);
        final GoogleMainPageHome googleSearchHillel = mainPageHome.searFor("hillel");
//        mainPageHome.GoogleMainPadActions("hillel");
        final  List<WebElement> findAllElements = webDriver.findElements(By.xpath("//*[@role='option']/div/span"));
        Assert.assertFalse("There are no links displayer", findAllElements.isEmpty());
        for (int count = 0; count < findAllElements.indexOf(9); count++) {
            for (WebElement findText : findAllElements) {
                String text = findText.getText().toLowerCase();
                String failedTestMessage = String.format("There is incorrect link [%s]", text);
                Assert.assertTrue(failedTestMessage, text.contains("hillel"));

            }
        }
    }
    @After
    public void driverTearDown(){
        webDriver.close();
        webDriver.quit();
    }
}
