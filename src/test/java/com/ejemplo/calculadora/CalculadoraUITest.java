package com.ejemplo.calculadora;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CalculadoraUITest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8080/api/calculadora/");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSumar() {
        WebElement num1Input = driver.findElement(By.name("num1"));
        WebElement num2Input = driver.findElement(By.name("num2"));
        WebElement operacion = driver.findElement(By.name("operacion"));
        WebElement boton = driver.findElement(By.cssSelector("button[type='submit']"));

        num1Input.sendKeys("5");
        num2Input.sendKeys("3");
        operacion.sendKeys("Sumar");
        boton.click();

        WebElement resultado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
        Assertions.assertTrue(resultado.getText().contains("Resultado: 8"));
    }
}
