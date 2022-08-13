import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchBox extends BasePage {

    By searchBoxLocator = By.id("search-input");
    By submitButtonLocator = new By.ByCssSelector("span.common-sprite.button-search");
    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        type(searchBoxLocator, text);
        click(submitButtonLocator);
    }
}
