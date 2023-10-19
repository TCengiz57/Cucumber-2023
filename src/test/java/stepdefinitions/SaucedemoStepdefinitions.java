package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SauceDemoPage;

public class SaucedemoStepdefinitions {
    SauceDemoPage sauceDemoPage = new SauceDemoPage();
    String ilkUrunIsmi;

    public SaucedemoStepdefinitions() {
    }

    @Then("Username kutusuna {string} yazar")
    public void username_kutusuna_yazar(String gecerliusername) {
        this.sauceDemoPage.userNameBox.sendKeys(new CharSequence[]{gecerliusername});
    }

    @Then("Password kutusuna {string} yazar")
    public void password_kutusuna_yazar(String gecerliPassword) {
        this.sauceDemoPage.passwordBox.sendKeys(new CharSequence[]{gecerliPassword});
    }

    @Then("Login tusuna basar")
    public void login_tusuna_basar() {
        this.sauceDemoPage.loginButton.click();
    }

    @When("Ilk urunun ismini kaydeder ve bu urunun sayfasina gider")
    public void ilk_urunun_ismini_kaydeder_ve_bu_urunun_sayfasina_gider() {
        this.ilkUrunIsmi = this.sauceDemoPage.ilkUrunElement.getText();
        this.sauceDemoPage.ilkUrunElement.click();
    }

    @When("Add to Cart butonuna basar")
    public void add_to_cart_butonuna_basar() {
        this.sauceDemoPage.addToCartButton.click();
    }

    @Then("Alisveris sepetine tiklar")
    public void alisveris_sepetine_tiklar() {
        this.sauceDemoPage.alisverisSepeti.click();
    }

    @Then("Sectigi urunun basarili olarak sepete eklendigini kontrol eder")
    public void sectigi_urunun_basarili_olarak_sepete_eklendigini_kontrol_eder() {
        String actualUrunIsmi = this.sauceDemoPage.sepetUrunElement.getText();
        Assert.assertEquals(this.ilkUrunIsmi, actualUrunIsmi);
    }
}
