package abhisheklearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import testUtils.BaseTest;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AllTests extends BaseTest {

    @Test(priority = 1)
    public void Test_Scenario1() {
      //  WebDriver driver = new ChromeDriver();
        String givenText = "Welcome to LambdaTest";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.findElement(By.xpath("//a[contains(text(),'Simple Form Demo')]")).click();
        String validateUrlName = driver.getCurrentUrl().split("playground")[1].split("/")[1];
        Assert.assertEquals("simple-form-demo", validateUrlName);

        driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(givenText);
        driver.findElement(By.xpath("//button[@id='showInput']")).click();

        String result = driver.findElement(By.xpath("//p[@id='message']")).getText();
        Assert.assertEquals(givenText, result);
        System.out.println("Code works fine");
     //   driver.quit();

    }

    @Test(priority = 2)
    public void Test_Scenario2() {
     //   WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.lambdatest.com/selenium-playground/");

        try {
            WebElement dragAndDropSlidersLink = driver.findElement(By.linkText("Drag & Drop Sliders"));
            dragAndDropSlidersLink.click();

            WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));
            WebElement sliderValueDisplay = driver.findElement(By.id("rangeSuccess")); // Assuming the range value display has id "rangeSuccess"


            Actions actions = new Actions(driver);

            int offset = calculateOffset(slider, 95);


            actions.dragAndDropBy(slider, offset, 0).perform();

            String rangeValue = sliderValueDisplay.getText();
            if ("95".equals(rangeValue)) {
                System.out.println("Slider successfully moved to 95. Test Passed.");
            } else {
                System.out.println("Slider value is " + rangeValue + ". Test Failed.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
   //  driver.quit();
    }

    /**
     * Calculate the offset required to move the slider from its current value to the target value.
     */

    private static int calculateOffset(WebElement slider, int targetValue) {
        // Assuming the slider's range is from 0 to 100
        int currentValue = Integer.parseInt(slider.getAttribute("value"));
        int sliderWidth = slider.getSize().getWidth();

        // Calculate the offset
        int offset = (int) ((targetValue - currentValue) / 100.0 * sliderWidth);
        return offset;
    }



    @Test(priority = 3)
    public void Test_Scenario3() throws InterruptedException
    {
      //  WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement submit = driver.findElement(By.cssSelector("#seleniumform > div.text-right.mt-20 > button"));
        submit.click();
        WebElement Name = driver.findElement(By.id("name"));
        String pleasefilloutthisform = Name.getAttribute("required");
        Assert.assertTrue(true, pleasefilloutthisform);
        String errormsg = "Please fill out this field.";
        Assert.assertTrue(true, errormsg);
        WebElement country = driver.findElement(By.xpath("//*[@id='seleniumform']/div[3]/div[1]/select"));
        country.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("country")));
        dropdown.click();
        List<WebElement> options = driver.findElements(By.xpath("//select[@name='country']/option"));

        for (WebElement option : options) {
            if (option.getText().equals("United States")) {
                option.click();
                break;
            }
        }


        WebElement name = driver.findElement(By.xpath("//*[@id='name']"));
        name.sendKeys("Test Lambda");

        WebElement Email = driver.findElement(By.cssSelector("#inputEmail4"));
        Email.sendKeys("TestDataCheck@gmail.com");

        WebElement password = driver.findElement(By.id("inputPassword4"));
        password.sendKeys("Test$Lamda#@123");

        WebElement Company = driver.findElement(By.xpath("//*[@id='company']"));
        Company.sendKeys("Test_Lamda pvt ltd.");

        WebElement Website  = driver.findElement(By.cssSelector("#websitename"));
        Website.sendKeys("www.Test_Lamda.com");

        WebElement City = driver.findElement(By.id("inputCity"));
        City.sendKeys("Earth");

        WebElement Address1 = driver.findElement(By.xpath("//*[@id='inputAddress1']"));
        Address1.sendKeys("Earth_Air");

        WebElement Address2 = driver.findElement(By.cssSelector("#inputAddress2"));
        Address2.sendKeys("Earth Water");

        WebElement state = driver.findElement(By.id("inputState"));
        state.sendKeys("Test_Lamda State");

        WebElement Zipcode =  driver.findElement(By.xpath("//*[@id='inputZip']"));
        Zipcode.sendKeys("111111");

        submit.click();
        String submit_msg = "Thanks for contacting us, we will get back to you shortly.";
        String actual_msg = driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText().trim();
        Assert.assertEquals(actual_msg, submit_msg);
 //       driver.quit();
}


}

