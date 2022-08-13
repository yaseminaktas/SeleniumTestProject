import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Add_Product_To_Cart extends BaseTest {

    HomePage homePage ;
    ProductsPage productsPage ;
    ProductDetailPage productDetailPage ;
    CartPage cartPage ;


    @Test
    @Order(1)
    public void search_a_product(){
        homePage= new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("roman");
        Assertions.assertTrue(productsPage.isOnProductPage());   //arama butonuna roman yazıp aratıyor.
    }

    @Test
    @Order(2)
    public void select_a_product(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(2);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(), "Not On Product Detail Page!");  //ürünü seçiyor
    }

    @Test
    @Order(3)
    public void add_product_to_cart(){
        productDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountUp());
    }
    @Test
    @Order(4)
    public void clickCart(){
        homePage.clickCart();
    }

    @Test
    @Order(5)
    public void go_to_cart(){
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfTheProductAdded(),  "Product was not added to cart!");
    }

    @Test
    @Order(6)
    public  void go_cart_update(){
        homePage.cart_update();

    }

    @Test
    @Order(7)
    public void removeCart(){
        homePage.removeCart();
        Assertions.assertFalse(cartPage.checkIfTheProductAdded(), "Page is not null ");
    }
}