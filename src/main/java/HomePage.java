import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    SearchBox searchBox;
    By cartCountLocator= By.id("cart-items");
    By clickCart = By.id("sprite-cart-icon");
    By cartContainerLocator = By.id("js-cart");

    By cartUpdate = new By.ByCssSelector("i.fa.fa-refresh.green-icon");
    By removeCart = new By.ByCssSelector("i.fa.fa-times.red-icon");

    public HomePage(WebDriver driver){
        super(driver);
        searchBox= new SearchBox(driver);
    }
    public SearchBox searchBox() {
        return this.searchBox;
    }
    public boolean isProductCountUp() {
        return getCartCount() > 0;
    }
    public void clickCart(){
        click(clickCart);
    }
    public void goToCart() {
        click(cartContainerLocator);
    }
    public void cart_update(){
        click(cartUpdate);
    }
    public void removeCart(){
        click(removeCart);
    }
    private int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }
}
