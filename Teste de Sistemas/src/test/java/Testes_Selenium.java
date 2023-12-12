import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;

public class Testes_Selenium {

    private WebDriver driver;

    //pré-configuração realizada antes de qualquer teste 
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.infoescola.com/");
    }

    @Test
    public void testarUrl() {
        String currentUrl = driver.getCurrentUrl();
        String expected = "https://www.infoescola.com/";
        assertEquals(expected, currentUrl);
    }

    @Test
    public void testVerificarLogo() {
        try {
            WebElement logoElement = driver.findElement(By.id("logo"));
            assertNotNull(logoElement);
        } catch (NoSuchElementException e) {
            fail("O elemento com o ID 'logo' não foi encontrado na página.");
        }
    }

    @Test
    public void testeExisteClasse() {
        try {
            WebElement classElemento = driver.findElement(By.className("column_post"));
            assertNotNull(classElemento);
        } catch (NoSuchElementException e) {
            fail("O elemento com a classe 'column_post' não foi encontrado na página.");
        }
    }
        @Test
        public void testUsandoSendKeys()
        {
            WebElement pesquisa = driver.findElement(By.name("q"));
            pesquisa.sendKeys("pimba");
            pesquisa.submit();
        }

    @Test
    public void testVerificarExistenciaElementoRecomendacoes() {
        try {
            WebElement recomendacoesElement = driver.findElement(By.id("recomendacoes"));
            assertNotNull(recomendacoesElement);
        } catch (NoSuchElementException e) {
            fail("O elemento com o ID 'recomendacoes' não foi encontrado na página.");
        }
    }

    @Test
    public void testVerificarTituloDaPagina() {
        String expectedTitle = "InfoEscola - Navegando e Aprendendo - InfoEscola";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }
    @Test
    public void testeColuna()
    {
         try {
            WebElement colunaElement = driver.findElement(By.id("column-right"));
            assertNotNull(colunaElement);
        } catch (NoSuchElementException e) {
            fail("O elemento com o ID 'column-right' não foi encontrado na página.");
        }
       
    }
     @BeforeEach
    public void testeMoverAte_Menu()
    {
         try {
            WebElement patrocinioElement = driver.findElement(By.id("menu_main"));
            Actions acao = new Actions(driver);
            acao.moveToElement(patrocinioElement).perform();
        } catch (NoSuchElementException e) {
            fail("O elemento com o ID 'menu_main' não foi encontrado na página.");
        }
    }
    @Test
    public void pegarTextoMenu()
    {
        try {
            WebElement patrocinioElement = driver.findElement(By.id("menu_main"));
            patrocinioElement.getText();
            assertFalse(!patrocinioElement.equals(patrocinioElement));
        } catch (NoSuchElementException e) {
            fail("O elemento com o ID 'menu_main' não foi encontrado na página.");
        }
    }
    @Test
    public void verificarTextoLink()
    {
        try {
            WebElement centerElement = driver.findElement(By.tagName("center"));
            WebElement linkElement = centerElement.findElement(By.linkText("« Anterior"));
            String textoDoLink = linkElement.getText();
            assertEquals("« Anterior", textoDoLink);
        } catch (NoSuchElementException e) {
            fail("Elementos não encontrados na página.");
        }
    }   
    @Test
    public void testeSeExisteAgrupamentoColunas()
    {
        try {
           WebElement agrupamento = driver.findElement(By.id("content"));
            assertTrue(agrupamento.equals(agrupamento));
        } catch (NoSuchElementException e) {
            fail("Elemento não encontrado na página.");
        }
    }
   

    @After
    public void sairDoSite() {
            driver.quit();
    }

}
