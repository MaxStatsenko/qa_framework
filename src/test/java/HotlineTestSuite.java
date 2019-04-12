import core.hotline.HotlineCheckCurrencyRange;
import core.hotline.HotlineMobilePhonePage;
import core.hotline.HotlineOneMobilePhonePage;
import org.junit.Assert;
import org.junit.Test;

public class HotlineTestSuite extends BaseTest {

    @Test
    public void openMobilePhonePage() {
        getWebDriver().get("https://hotline.ua");
        final HotlineCheckCurrencyRange hotlineCheckCurrencyRange = new HotlineCheckCurrencyRange(getWebDriver());
        hotlineCheckCurrencyRange.hoverOnButton();

        final HotlineMobilePhonePage hotlineMobilePhonePage = hotlineCheckCurrencyRange.selectMobilePhonesPage();
        hotlineMobilePhonePage.checkUrlPage();

        final HotlineOneMobilePhonePage hotlineOneMobilePhonePage = hotlineMobilePhonePage.clickButtonCheckPrice();
        hotlineOneMobilePhonePage.getAutoMobilePriceResult();
        hotlineOneMobilePhonePage.getManualMobilePriceResult();
        Assert.assertEquals("There is incorrect mobile price",
                hotlineOneMobilePhonePage.getAutoMobilePriceResult(),
                hotlineOneMobilePhonePage.getMaxMinManualMobilePriceResult());
    }
}
