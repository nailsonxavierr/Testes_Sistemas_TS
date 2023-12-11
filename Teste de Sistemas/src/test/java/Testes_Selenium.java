import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;

public class Testes_Selenium {

    private WebDriver driver;

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
    public void testVerificarExistenciaElementoLogo() {
        try {
            WebElement logoElement = driver.findElement(By.id("logo"));
            assertNotNull(logoElement);
        } catch (NoSuchElementException e) {
            fail("O elemento com o ID 'logo' não foi encontrado na página.");
        }
    }

    @Test
    public void testandoClasse() {
        try {
            WebElement classElemento = driver.findElement(By.className("column_post"));
            assertNotNull(classElemento);
        } catch (NoSuchElementException e) {
            fail("O elemento com a classe 'column_post' não foi encontrado na página.");
        }
    }
        @Test
        public void testSendKeys()
        {
            WebElement pesquisa = driver.findElement(By.name("q"));
            pesquisa.sendKeys("pimba");
            pesquisa.submit();
        }

    @After
    public void sairDoSite() {
            driver.quit();
    }

}
