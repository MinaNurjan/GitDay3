package tests.homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
SPORTS1.open browser
2.go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton
3.verify that Football is selected by default and all others are not selected.
4.Select a random sport
5.Verify that all other options are not selected
 */
public class Sports {
    @Test
    public void sport(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

       Assert.assertTrue(driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Football-input")).isSelected());
        Random random = new Random();
       String sport[]={"Baseball","Basketball","Football","Hockey","Soccer","Water Polo"};
      int a = random.nextInt(sport.length);
       driver.findElement(By.id("gwt-debug-cwRadioButton-sport-"+random.nextInt(sport.length)+"-input")).click();

        driver.navigate().refresh();




       driver.close();
    }
}
