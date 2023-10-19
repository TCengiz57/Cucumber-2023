

Feature: US1001 Nutella arama testi

  Scenario: TC01 Kullanici amazonda Nutella arayabilmeli

    Given kullanici amazonUrl anasayfaya gider
    Then arama kutusuna Nutella yazip aratir
    And arama sonuclarinin Nutella icerdigini test eder
    And sayfayi kapatir


    Scenario: TC02 kullanici amazonda java aratir

      Given kullanici amazonUrl anasayfaya gider
      Then arama kutusuna Java yazip aratir
      And arama sonuclarinin Java icerdigini test eder
      And sayfayi kapatir