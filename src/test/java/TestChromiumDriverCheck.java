//import org.junit.jupiter.api.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.Color;
//
//
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.function.Consumer;
//
//import static org.openqa.selenium.support.locators.RelativeLocator.with;
//
//public class TestChromiumDriverCheck {
//
//    private final Color RGB_COLOUR_WHITE = Color.fromString("rgb(255, 255, 255)");
//
//    static WebDriver driver;
//
//    @BeforeEach
//    void webDriverInit() {
//
//        driver = new ChromeDriver();
//    }
//
//    @Test
//    @DisplayName("Testing Selenium")
//    void chromiumTest() {
//
//        driver.navigate().to("https://selenium.dev");
//        driver.get("https://www.selenium.dev/about/");
//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().refresh();
//        System.out.println(driver.getTitle());
//
//    }
//
//    @Test
//    void switchBetweenWindows() {
//        //Store the ID of the original window
//        String originalWindow = driver.getWindowHandle();
//        //Check we don't have other windows open already
//        assert driver.getWindowHandles().size() == 1;
//        //Click the link which opens in a new window
//        driver.findElement(By.linkText("new window")).click();
//        //Wait for the new window or tab
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//        //Loop through until we find a new window handle
//        for (String windowHandle : driver.getWindowHandles()) {
//            if (!originalWindow.contentEquals(windowHandle)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }
//        //Wait for the new tab to finish loading content
//        wait.until(ExpectedConditions.titleIs("Selenium documentation"));
//        driver.switchTo().window(originalWindow);
//    }
//
//    @Test
//    void getElementWithRelativeLocator() {
//        // Returns the WebElement, which appears below to the specified element
//        WebElement emailAddressField = driver.findElement(By.id("email"));
//        WebElement passwordField = driver.findElement(with(By.tagName("input")).below(emailAddressField));
//    }
//
//    @Test
//    void getWebElementWithTimerToLoad() {
//        // Initialize and wait till element(link) became clickable - timeout in 10 seconds
//        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
//
//    }
//
//    @Test
//    void typeKeySequenceDOMElement() {
//        // The sendKeys types a key sequence in DOM element
//        WebElement firstResult = driver.findElement(By.cssSelector("#cheese #cheddar"));
//        firstResult.sendKeys("q" + Keys.ENTER);
//    }
//
//    @Test
//    void checkColor() {
//        Color loginButtonColour = Color.fromString(driver.findElement(By.id("login")).getCssValue("color"));
//        Assertions.assertEquals(RGB_COLOUR_WHITE, loginButtonColour);
//    }
//
//    @Test
//    void checkSelect() {
//        WebElement selectElement = driver.findElement(By.id("selectElementID"));
//        Select selectObject = new Select(selectElement);
//        selectObject.selectByVisibleText("Bread");
//    }
//
//    @Test
//    void checkMouse() {
//        try {
//            // Navigate to Url
//            driver.get("https://google.com");
//
//            // Store 'google search' button web element
//            WebElement searchBtn = driver.findElement(By.linkText("Sign in"));
//            Actions actionProvider = new Actions(driver);
//            // Perform click-and-hold action on the element
//            actionProvider.clickAndHold(searchBtn).build().perform();
//            // Perform release action on the element
//            actionProvider.release().build().perform();
//        } finally {
//            driver.quit();
//        }
//    }
//
//    @Test
//    void checkAddCookies() {
//        try {
//            driver.get("http://www.example.com");
//
//            // Adds the cookie into current browser context
//            driver.manage().addCookie(new Cookie("key", "value"));
//        } finally {
//            driver.quit();
//        }
//    }
//
//    @Test
//    void checkSendCookies() {
//        try {
//            driver.get("http://www.example.com");
//            driver.manage().addCookie(new Cookie("foo", "bar"));
//
//            // Get cookie details with named cookie 'foo'
//            Cookie cookie1 = driver.manage().getCookieNamed("foo");
//            System.out.println(cookie1);
//        } finally {
//            driver.quit();
//        }
//    }
//
//    @Test
//    void checkDevToolsChromiumDriverGPS() {
//        ChromeDriver driver = new ChromeDriver();
//        Map<String, Object> coordinates = new HashMap<>() {{
//            put("latitude", 50.2334);
//            put("longitude", 0.2334);
//            put("accuracy", 1.0);
//        }};
//        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
//        driver.get("<your site url>");
//    }
//
//    @Test
//    public void jsExceptionsExample() {
//        ChromeDriver driver = new ChromeDriver();
//        DevTools devTools = driver.getDevTools();
//        devTools.createSession();
//
//        List<JavascriptException> jsExceptionsList = new ArrayList<>();
//        Consumer<JavascriptException> addEntry = jsExceptionsList::add;
//        devTools.getDomains().events().addJavascriptExceptionListener(addEntry);
//
//        driver.get("<your site url>");
//
//        WebElement link2click = driver.findElement(By.linkText("<your link text>"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
//                link2click, "onclick", "throw new Error('Hello, world!')");
//        link2click.click();
//
//        for (JavascriptException jsException : jsExceptionsList) {
//            System.out.println("JS exception message: " + jsException.getMessage());
//            System.out.println("JS exception system information: " + jsException.getSystemInformation());
//            jsException.printStackTrace();
//        }
//    }
//
//    @AfterAll
//    static void closeWindows() {
//        driver.close();
//    }
//}
