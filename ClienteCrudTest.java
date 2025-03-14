/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ClienteCrudTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pichau\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("http://localhost:8080/TesteCrud5/");
    }

    @Test
    public void testCadastroCliente() throws InterruptedException {
        driver.findElement(By.id("cliNome")).sendKeys("João Teste");
        driver.findElement(By.id("cliEmail")).sendKeys("joao@teste.com");
        driver.findElement(By.id("cliSenha")).sendKeys("123456");
        driver.findElement(By.id("cliGenero")).sendKeys("Masculino");
        driver.findElement(By.id("cliDataNascimento")).sendKeys("2000-01-01");
        driver.findElement(By.id("cpf")).sendKeys("123.456.789-00");
        driver.findElement(By.id("cliTelefoneTipo")).sendKeys("Celular");
        driver.findElement(By.id("cliTelefoneDdd")).sendKeys("11");
        driver.findElement(By.id("cliTelefoneNumero")).sendKeys("999999999");

        driver.findElement(By.tagName("button")).click();
        Thread.sleep(2000); // Espera para a tabela atualizar

        WebElement tabela = driver.findElement(By.id("clienteTableBody"));
        assertTrue(tabela.getText().contains("João Teste"));
    }

    @Test
public void testExcluirCliente() throws InterruptedException {
    // Aguarda até que o cliente "João Teste" esteja na tabela antes de excluir
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("clienteTableBody"), "João Teste"));

    // Localiza o botão de exclusão
    WebElement botaoExcluir = driver.findElement(By.xpath("//td[contains(text(),'João Teste')]/following-sibling::td/button[contains(text(),'Excluir')]"));
    botaoExcluir.click();

    // Aguarda 2 segundos para atualização da tabela
    Thread.sleep(2000);

    // Verifica se o cliente foi removido da tabela
    WebElement tabela = driver.findElement(By.id("clienteTableBody"));
    assertFalse(tabela.getText().contains("João Teste"));
}

    
    @Test
public void testCadastroClienteInvalido() throws InterruptedException {
    driver.findElement(By.id("cliNome")).sendKeys(""); // Nome vazio
    driver.findElement(By.id("cliEmail")).sendKeys("email-invalido"); // Email inválido
    driver.findElement(By.id("cliSenha")).sendKeys("123"); // Senha curta
    driver.findElement(By.id("cpf")).sendKeys("00000000000"); // CPF inválido
    driver.findElement(By.tagName("button")).click();

    // Espera 2 segundos para checar as mensagens de erro
    Thread.sleep(2000);

    // Verifica se o formulário não permitiu o cadastro
    WebElement tabela = driver.findElement(By.id("clienteTableBody"));
    assertFalse(tabela.getText().contains("email-invalido"));
}

@Test
public void testListagemClientes() throws InterruptedException {
    driver.navigate().refresh();
    
    // Espera o carregamento da tabela
    Thread.sleep(2000);

    // Verifica se há pelo menos um cliente na lista
    WebElement tabela = driver.findElement(By.id("clienteTableBody"));
    assertTrue(tabela.getText().length() > 0);
}

@Test
public void testExcluirClienteInexistente() throws InterruptedException {
    // Aguarda até que a tabela seja carregada
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clienteTableBody")));

    // Tenta excluir um cliente com ID alto que não existe
    driver.get("http://localhost:8080/TesteCrud5/");
    driver.navigate().refresh();

    // Espera 2 segundos para garantir atualização
    Thread.sleep(2000);

    WebElement tabela = driver.findElement(By.id("clienteTableBody"));
    assertFalse(tabela.getText().contains("9999"));
}

@Test
public void testCadastroClienteCamposVazios() {
    driver.findElement(By.tagName("button")).click();

    String mensagemErro = driver.findElement(By.id("cliNome")).getAttribute("validationMessage");
    assertFalse(mensagemErro.isEmpty());
}
    
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}



