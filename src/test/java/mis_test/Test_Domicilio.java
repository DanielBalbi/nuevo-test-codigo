package mis_test;


import acciones.pantalla;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Test_Domicilio {
WebDriver driver; 
//pantalla mis_acciones= new pantalla();   
   
    @BeforeMethod
    public void setUpMethod() throws Exception {     
        ChromeOptions nuevoargumento = new ChromeOptions(); 
        nuevoargumento.addArguments("--remote-allow-origins=*","--headless"); //
        driver = new ChromeDriver(nuevoargumento);
        driver.get("https://www.emaras.com.ar/");    
    }
    
    
    @Test
    public void Test_Domicilio() throws InterruptedException {
    
   //mis_acciones.maximizar();
        
    driver.findElement(By.name(pantallas.login.txt_usuario)).sendKeys(datos.consorcios.usuario);

    driver.findElement(By.name(pantallas.login.txt_clave)).sendKeys(datos.consorcios.clave);
    driver.findElement(By.id(pantallas.login.btn_ingresar)).click();
             /////////////////////////  ingresando en la pantalla de la selección del edificio
    //// seleccion del edificio. Renglón nro 3
    driver.findElement(By.cssSelector(pantallas.consorcios.nro_consorcio)).click();
    
    ///// despliega el menú "Usuarios" 
    driver.findElement(By.cssSelector(pantallas.menu.usuarios)).click();
    Thread.sleep(1000);
    // hacé click en la opción "Datos Administración" dentro del menu usuarios
    driver.findElement(By.cssSelector(pantallas.menu.administracion)).click();
    Thread.sleep(1000);  
    /// cambio datos del domicilio
    driver.findElement(By.name(pantallas.administracion.txt_domicilio)).click();
    driver.findElement(By.name(pantallas.administracion.txt_domicilio)).clear();
    driver.findElement(By.name(pantallas.administracion.txt_domicilio))
            .sendKeys(datos.consorcios.calle);
    Thread.sleep(3000);
    driver.findElement(By.cssSelector(pantallas.administracion.btn_grabar)).click();
    driver.findElement(By.cssSelector(pantallas.administracion.lnk_cerrar_sesion)).click();

    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
      driver.close();
        
    }
    
}
