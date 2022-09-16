package stepDefinitions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.KitapYurduPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class KitapYurduStepDefinitions {

    KitapYurduPage kitapYurdu = new KitapYurduPage();


    @Given("kullanici {string} anasayfasinda")
    public void kullanici_anasayfasinda(String kitapYurduUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(kitapYurduUrl));
    }

    @Then("kullanici ana sayfanin acildigini kontrol eder")
    public void kullanici_ana_sayfanin_acildigini_kontrol_eder() {
        String expectedUrl = ConfigReader.getProperty("kitapYurduUrl").toString();
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

    }

    @And("kullanici roman icin arama yapar")
    public void kullaniciRomanIcinAramaYapar() {
        String searchResult = ReusableMethods.csvReader("src/fileResources/testinium.csv");
        kitapYurdu.textArea.sendKeys(searchResult + Keys.ENTER);
    }


    @Then("kullanici rastgele bir kitap secer")
    public void kullanici_rastgele_bir_kitap_secer() {
        Random randomSayi = new Random();
        int i = randomSayi.nextInt(24 - 4) + 4;
        WebElement product = Driver.getDriver().findElement(By.xpath("(//div[@class='image'])[" + i + "]"));
        ReusableMethods.waitForClickablility(product, 10);
        product.click();
    }

    @Then("kullanici sectigi kitabi sepete ekler")
    public void kullanici_sectigi_kitabi_sepete_ekler() {
        ReusableMethods.waitForClickablility(kitapYurdu.addToCartButton, 10);
        kitapYurdu.addToCartButton.click();
        ReusableMethods.waitFor(1);
    }

    @Then("kullanici sepet ikonundaki degerin {string} oldugunu kontrol eder")
    public void kullanici_sepet_ikonundaki_degerin_oldugunu_kontrol_eder(String expectedResult) {
        String actualResult = kitapYurdu.cartIcon.getText();
        System.out.println(actualResult);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Then("kullanici sepetim butonuna tiklar")
    public void kullanici_sepetim_butonuna_tiklar() {
        ReusableMethods.waitForClickablility(kitapYurdu.cartIcon, 10);
        kitapYurdu.cartIcon.click();
    }

    @Then("kullanici sepeti git butonuna tiklar")
    public void kullanici_sepeti_git_butonuna_tiklar() {
        ReusableMethods.waitForClickablility(kitapYurdu.goToCartButton, 10);
        kitapYurdu.goToCartButton.click();
    }

    @Then("kullanici ürün miktarini bir adet artirir")
    public void kullanici_ürün_miktarini_bir_adet_artirir() {
        String currentValue = kitapYurdu.quantityTextArea.getAttribute("value").toString();
        System.out.println("suanki deger = " + currentValue);
        int secondValue = Integer.parseInt(currentValue) + 1;
        System.out.println(secondValue);
        String secondValueInput = String.valueOf(secondValue);
        kitapYurdu.quantityTextArea.clear();
        kitapYurdu.quantityTextArea.sendKeys(secondValueInput);

    }

    @Then("kullanici yenile butonuna tiklar")
    public void kullanici_yenile_butonuna_tiklar() {
        ReusableMethods.waitForClickablility(kitapYurdu.refreshButton, 10);
        kitapYurdu.refreshButton.click();
    }

    @Then("kullanici Sepetiniz güncelleniyor yazisinin geldigini kontrol eder")
    public void kullaniciSepetinizGüncelleniyorYazisininGeldiginiKontrolEder() {
        ReusableMethods.waitForVisibility(kitapYurdu.refreshResultText, 10);
        Assert.assertTrue(kitapYurdu.refreshResultText.isDisplayed());
    }

    @Then("kullanici carpi butonuna basar")
    public void kullanici_carpi_butonuna_basar() {
        ReusableMethods.waitForClickablility(kitapYurdu.deleteButton, 10);
        kitapYurdu.deleteButton.click();
        ReusableMethods.waitFor(1);
    }

    @Then("kullanici sepetin bos oldugunu kontrol eder")
    public void kullanici_sepetin_bos_oldugunu_kontrol_eder() {
        String expectedResult = "Sepetiniz boş";
        String actualResult = kitapYurdu.cartButtonEmpty.getText();
        Assert.assertEquals(expectedResult, actualResult);
    }


}
