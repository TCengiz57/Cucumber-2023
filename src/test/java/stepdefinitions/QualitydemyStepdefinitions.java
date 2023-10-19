package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.QualitydemyPage;
import utilities.ConfigReader;

public class QualitydemyStepdefinitions {

    QualitydemyPage qualitydemyPage = new QualitydemyPage();

    public QualitydemyStepdefinitions() {
    }

    @Then("ilk login linkine tiklar")
    public void ilk_login_linkine_tiklar() {
        this.qualitydemyPage.ilkLoginLinki.click();
    }

    @Then("username kutusuna {string} yazar")
    public void username_kutusuna_yazar(String kullaniciEmail) {
        this.qualitydemyPage.emailKutusu.sendKeys(new CharSequence[]{ConfigReader.getProperty(kullaniciEmail)});
    }

    @Then("password kutusuna {string} yazar")
    public void password_kutusuna_yazar(String password) {
        this.qualitydemyPage.passwordKutusu.sendKeys(new CharSequence[]{ConfigReader.getProperty(password)});
    }

    @Then("login butonuna basar")
    public void login_butonuna_basar() {
        this.qualitydemyPage.loginButonu.click();
    }

    @Then("basarili giris yapildigini test eder")
    public void basarili_giris_yapildigini_test_eder() {
        Assert.assertTrue(this.qualitydemyPage.basariliGirisElementi.isDisplayed());
    }

    @Then("basarili giris yapilamadigini test eder")
    public void basariliGirisYapilamadiginiTestEder() {
        Assert.assertTrue(this.qualitydemyPage.emailKutusu.isDisplayed());
    }

}
