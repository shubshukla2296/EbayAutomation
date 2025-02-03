//public class CartPage {
//}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By cartCount = By.cssSelector("#gh-cart-n");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartUpdated() {
        return driver.findElement(cartCount).getText().equals("1");
    }
}
