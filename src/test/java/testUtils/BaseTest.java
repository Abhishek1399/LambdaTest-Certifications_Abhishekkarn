package testUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;


    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {

        try {

                if (browser.equalsIgnoreCase("chrome")) {

                    driver = new ChromeDriver();
                } else if (browser.equalsIgnoreCase("edge")) {

                    driver = new EdgeDriver();
                }
                driver.manage().window().maximize();

        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize browser: " + browser, e);
        }
    }


    @AfterTest
    public void teardown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to quit browser", e);
            }
        }
    }
}
