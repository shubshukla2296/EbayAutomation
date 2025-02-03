//public class AddToCartTest {
//}
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddToCartTest extends BaseTest {

    @Test
    public void verifyItemCanBeAddedToCart() {
        driver.get("https://www.ebay.com");

        HomePage homePage = new HomePage(driver);
        homePage.searchItem("book");

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.clickFirstItem();

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCartUpdated(), "Cart was not updated!");
    }
}
