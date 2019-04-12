package core.hotline;

import core.AbstractPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class HotlineOneMobilePhonePage extends AbstractPage {

    @FindBy(xpath = "//span[@class='price-lg']")
    private WebElement autoMobilePriceResult;

    @FindBys({
            @FindBy(xpath = "//a[@data-tracking-id='goprice-3']")
    })
    private List<WebElement> manualMobilePriceResult;

    public HotlineOneMobilePhonePage(WebDriver driver) {
        super(driver);
    }

    public List<Integer> getAutoMobilePriceResult() {
        final String text = autoMobilePriceResult.getText();
        final String[] splitterText = StringUtils.split(text, "–");
        String lowerPriceAuto = splitterText[0].replaceAll("[^0-9]", "");
        String higherPriceAuto = splitterText[1].replaceAll("[^0-9]", "");
        final List<Integer> listAuto = new LinkedList<>();
        listAuto.add(Integer.getInteger(lowerPriceAuto));
        listAuto.add(Integer.getInteger(higherPriceAuto));
        return listAuto;
    }

    private static String replaceText(final WebElement webElement) {
        return webElement.getText().trim();
    }

    public List<Integer> getManualMobilePriceResult() {
        return manualMobilePriceResult.stream()
                .map(HotlineOneMobilePhonePage::replaceText)
                .map(i -> (int) Double.parseDouble(i.replaceAll("\\s", "").replaceAll(",", ".")))
                .collect(Collectors.toList());
    }

    public List<Integer> getMaxMinManualMobilePriceResult(){
        Integer lowerPriceManual = getManualMobilePriceResult().stream()
                .max(Comparator.comparing(Integer::valueOf))
                .get();
        Integer higherPriceManual = getManualMobilePriceResult().stream()
                .min(Comparator.comparing(Integer::valueOf))
                .get();
        final List<Integer> listManual = new LinkedList<>();
        listManual.add(Integer.getInteger(String.valueOf(lowerPriceManual)));
        listManual.add(Integer.getInteger(String.valueOf(higherPriceManual)));
        return listManual;
    }
}
