package acciones;

import org.openqa.selenium.WebDriver;

public class pantalla {
    WebDriver driver;
    
    public void maximizar(){
        driver.manage().window().maximize();
    }
    
}
