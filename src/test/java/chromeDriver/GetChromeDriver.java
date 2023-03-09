package chromeDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class GetChromeDriver {
    public static ChromeDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe");
        return new ChromeDriver();
    }
}
