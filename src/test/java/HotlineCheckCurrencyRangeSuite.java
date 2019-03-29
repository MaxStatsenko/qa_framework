import core.hotline.HotlineCheckCurrencyRange;
import org.junit.Test;

public class HotlineCheckCurrencyRangeSuite extends BaseTest {

    @Test
    public void openMobilePhonePage(){
        getWebDriver().get("https://hotline.ua");
        final HotlineCheckCurrencyRange hotlineMainPageHome = new HotlineCheckCurrencyRange(getWebDriver());
        hotlineMainPageHome.hoverOnButton();
    }

}
