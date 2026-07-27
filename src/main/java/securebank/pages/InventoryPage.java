package securebank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends BasePage {

    private final By title         = By.className("title");
    private final By menuButton    = By.id("react-burger-menu-btn");
    private final By logoutLink    = By.id("logout_sidebar_link");
    private final By inventoryItems = By.className("inventory_item");
    private final By sortDropdown  = By.className("product_sort_container");
    private final By cartBadge     = By.className("shopping_cart_badge");

    public boolean isOnInventoryPage() {
        try {
            return getText(title).equals("Products");
        } catch (Exception e) {
            return false;
        }
    }

    public String getPageTitle() {
        return getText(title);
    }

    public int getItemCount() {
        return driver.findElements(inventoryItems).size();
    }

    public List<String> getItemNames() {
        return driver.findElements(By.className("inventory_item_name"))
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void sortBy(String option) {
        selectByVisibleText(sortDropdown, option);
    }

    public void addToCartByName(String productName) {
        By addBtn = By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button");
        click(addBtn);
    }

    public String getCartBadgeCount() {
        return isDisplayed(cartBadge) ? getText(cartBadge) : "0";
    }

    public void logout() {
        click(menuButton);
        click(logoutLink);
    }
}
