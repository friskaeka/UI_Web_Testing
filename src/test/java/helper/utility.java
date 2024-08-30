package helper;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class utility {
    public static WebDriver driver;

    public static File getJsonSchemaFile(String JSONFile) {
        return new File("src/test/java/helper/JSONSchemaData/" + JSONFile);
    }

    public static String generateRandomEmail(){
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_" + ".";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10);
        email = temp + "@tesdata.com";
        return email;
    }

    public static void startDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public static void quitDriver(){
        driver.quit();
    }
}
