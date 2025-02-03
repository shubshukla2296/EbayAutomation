//public class SearchResultsPage {
//}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage {
    private By firstItem = By.cssSelector(".s-item__link");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickFirstItem() {
        WebElement item = driver.findElement(firstItem);
        item.click();
    }
}
