@testinium
Feature: Testinium Test Case
  Scenario: Kullanici kitap yurdu sayfasinda roman aratir, sepete ekler ve sepetten cikarir
    Given kullanici "kitapYurduUrl" anasayfasinda
    Then kullanici ana sayfanin acildigini kontrol eder
    And kullanici roman icin arama yapar
    And kullanici rastgele bir kitap secer
    And kullanici sectigi kitabi sepete ekler
    Then kullanici sepet ikonundaki degerin "1" oldugunu kontrol eder
    And kullanici sepetim butonuna tiklar
    And kullanici sepeti git butonuna tiklar
    And kullanici ürün miktarini bir adet artirir
    And kullanici yenile butonuna tiklar
    Then kullanici Sepetiniz güncelleniyor yazisinin geldigini kontrol eder
    And kullanici carpi butonuna basar
    Then kullanici sepetin bos oldugunu kontrol eder