import core.hotline.HotlineApplePhonePageHome;
import core.utils.UrlBuilder;
import org.junit.Test;

public class HotlineTestSuiteHome extends BaseTest {

    @Test
    public void checkMobilePhoneTest(){

        final String partialItemUrl = "/mobile/mobilnye-telefony-i-smartfony/";
        final String fullPropertiesUrl = UrlBuilder.buildUrlUsingProperties("hotline.base.url", partialItemUrl);
        getWebDriver().get(fullPropertiesUrl);
        final HotlineApplePhonePageHome hotlineMainPageHome = new HotlineApplePhonePageHome(getWebDriver());
        hotlineMainPageHome.clickOnCheckBox();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hotlineMainPageHome.swipeDown();

        hotlineMainPageHome.assertText();
    }
}
