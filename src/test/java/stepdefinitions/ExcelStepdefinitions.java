package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelStepdefinitions {
    String dosyaYolu = "src/test/resources/ulkeler.xlsx";
    FileInputStream fis;
    Workbook workbook;
    Sheet sayfa1;
    FileOutputStream fos;

    public ExcelStepdefinitions() {
    }

    @Given("kullanici ulkeler excelinde Sayfa1'e kadar ayarlari yapar")
    public void kullanici_ulkeler_excelinde_sayfa1_e_kadar_ayarlari_yapar() throws IOException {
        this.fis = new FileInputStream(this.dosyaYolu);
        this.workbook = WorkbookFactory.create(this.fis);
        this.sayfa1 = this.workbook.getSheet("Sayfa1");
    }

    @Then("{int}.sutunu olusturur")
    public void sutunu_olusturur(Integer sutunNo) {
    }

    @Then("baslik satirinda besinci hucreye yeni bir cell olusturur")
    public void baslik_satirinda_besinci_hucreye_yeni_bir_cell_olusturur() {

        this.sayfa1.getRow(0).createCell(4);
    }

    @Then("Olusturdugu hucreye {string} yazdirir")
    public void olusturdugu_hucreye_yazdirir(String sutunBasligi) {
        this.sayfa1.getRow(0).getCell(4).setCellValue(sutunBasligi);
    }

    @Then("{int}.satir ulke nufusu kolonuna {int} yazdirir")
    public void satir_ulke_nufusu_kolonuna_yazdirir(Integer satirNo, Integer ulkeNufus) {
        this.sayfa1.getRow(satirNo - 1).createCell(4).setCellValue((double)ulkeNufus);
    }

    @Then("Dosyayi kaydeder")
    public void dosyayi_kaydeder() throws IOException {
        this.fos = new FileOutputStream(this.dosyaYolu);
        this.workbook.write(this.fos);
    }

    @Then("stream'leri kapatir")
    public void stream_leri_kapatir() throws IOException {
        this.workbook.close();
        this.fis.close();
        this.fos.close();
    }

    @Then("excel'de {int}.satirin ulke nufusunun {int} oldugunu test eder")
    public void excel_de_satirin_ulke_nufusunun_oldugunu_test_eder(Integer satirNo, Integer expectedNufus) {
        Integer actualNufus = (int)this.sayfa1.getRow(satirNo - 1).getCell(4).getNumericCellValue();
        Assert.assertEquals(expectedNufus, actualNufus);
    }
}
