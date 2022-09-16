package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class KitapYurduPage {

    public KitapYurduPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='search-input']")
    public WebElement textArea;

    /*
    @FindBy(xpath = "(//div[@class='grid_7 omega'])[3]")
    public WebElement product;

     */

    @FindBy(xpath = "//a[@id='button-cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[@id='cart-items']")
    public WebElement cartIcon;

    @FindBy(xpath = "//a[@id='js-cart']")
    public WebElement goToCartButton;

    @FindBy(xpath = "//input[@style='width:22px']")
    public WebElement quantityTextArea;

    @FindBy(xpath = "//i[@title='Güncelle']")
    public WebElement refreshButton;

    @FindBy(xpath = "//*[text()='Sepetiniz güncelleniyor!']")
    public WebElement refreshResultText;

    @FindBy(xpath = "//tbody//div[1]//div[1]//a")
    public List<WebElement> productList;

    @FindBy(xpath = "//i[@title='Kaldır']")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@id='cart-items-empty']")
    public WebElement cartButtonEmpty;

}
