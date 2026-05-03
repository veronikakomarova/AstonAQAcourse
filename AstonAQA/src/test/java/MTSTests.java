import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.OnlinePayment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Проверки для блока \"Онлайн пополнение без комиссии\"")
public class MTSTests {

    private WebDriver driver;
    private OnlinePayment onlinePayment;

    @BeforeAll
    public static void loadDriver() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    public void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://www.mts.by/");
        onlinePayment = new OnlinePayment(driver);
        onlinePayment.acceptCookie();
    }

    @AfterEach
    void quitDriver() {
        driver.quit();
    }

    @DisplayName("Проверка отображения названия для блока\"Онлайн пополнение без комиссии\"")
    @Test
    void checkPaymentLogoDisplayed() {
        assertTrue(onlinePayment
                .isPaymentLogoDisplayed());
    }

    @DisplayName("Проверка отображения иконок для платёжных систем")
    @Test
    void checkPaymentIconsDisplayed() {
        assertTrue(onlinePayment.isBelkartIconDisplayed());
        assertTrue(onlinePayment.isMasterCardSecureIconDisplayed());
        assertTrue(onlinePayment.isMasterCardIconDisplayed());
        assertTrue(onlinePayment.isVisaVerifiedIconDisplayed());
        assertTrue(onlinePayment.isVisaIconDisplayed());
    }

    @DisplayName("Проверка работоспособности ссылки \"Подробнее о сервисе\"")
    @Test
    void checkPaymentServiceInfoLinkRedirect() {

        final String expectedRedirectionUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

        onlinePayment
                .clickPaymentServiceInfoLink();

        String actualUrl = onlinePayment.getCurrentUrl();
        assertEquals(expectedRedirectionUrl, actualUrl);
    }

    @DisplayName("Проверка работоспособности кнопки\"Продолжить\"")
    @Test
    void checkPaymentButtonOpenModal() {
        onlinePayment
                .openPaymentModal("297777777", "15");
        assertTrue(onlinePayment.isPaymentModalDisplayed());
    }

    @DisplayName("Проверка отображения плейсхолдеров для варианта\"Услуги связи\"")
    @Test
    void checkConectionFieldsPlaceholders(){
        onlinePayment.selectService();
        assertEquals("Номер телефона", onlinePayment.getPhoneNumbPlaceholder());
        assertEquals("Сумма", onlinePayment.getConnectionSumPlaceholder());
        assertEquals("E-mail для отправки чека", onlinePayment.getConnectionEmailPlaceholder());
    }

    @DisplayName("Проверка отображения плейсхолдеров для варианта\"Домашний интернет\"")
    @Test
    void checkHomeInternetFieldsPlaceholders(){
        onlinePayment.selectHomeInternet();
        assertEquals("Номер абонента", onlinePayment.getInetrnetPhoneNumbPlaceholder());
        assertEquals("Сумма", onlinePayment.getInternetSumPlaceholder());
        assertEquals("E-mail для отправки чека", onlinePayment.getInternetEmailPlaceholder());
    }

    @DisplayName("Проверка отображения плейсхолдеров для варианта\"Рассрочка\"")
    @Test
    void checkInstallmentFieldsPlaceholders(){
        onlinePayment.selectInstallmentPlan();
        assertEquals("Номер счета на 44", onlinePayment.getInstallmentPhonePlaceholder());
        assertEquals("Сумма", onlinePayment.getInstallmentSumPlaceholder());
        assertEquals("E-mail для отправки чека", onlinePayment.getInstallmentEmailPlaceholder());
    }

    @DisplayName("Проверка отображения плейсхолдеров для варианта\"Задолженность\"")
    @Test
    void checkDebtFieldsPlaceholders(){
        onlinePayment.selectDebt();
        assertEquals("Номер счета на 2073", onlinePayment.getDebtPhoneNumbPlaceholder());
        assertEquals("Сумма", onlinePayment.getDebtSumPlaceholder());
        assertEquals("E-mail для отправки чека", onlinePayment.getDebtEmailPlaceholder());
    }

    @DisplayName("Проверка заполнения и отображения данных для варианта \"Услуги связи\"")
    @Test
    void checkModalWindowFields(){
        onlinePayment.openPaymentModal("297777777", "15");
        onlinePayment.switchToPaymentFrame();

        assertTrue(onlinePayment.getDescriptionCostText().contains("15.00"));
        assertTrue(onlinePayment.getCostOnSubmitButtonText().contains("15.00"));
        assertTrue(onlinePayment.getCostOnAgreementText().contains("15.00"));
        assertTrue(onlinePayment.getPhoneNumbModalText().contains("297777777"));
        assertEquals("Номер карты", onlinePayment.getCardNumberModalText());
        assertEquals("Срок действия", onlinePayment.getValidityPeriodOfCardText());
        assertEquals("CVC", onlinePayment.getCvcCodeText());
        assertEquals("Имя и фамилия на карте", onlinePayment.getPersonDataText());
        assertTrue(onlinePayment.isVisaSystemModalDisplayed());
        assertTrue(onlinePayment.isMasterCardSystemModalDisplayed());
        assertTrue(onlinePayment.isBelkartSystemModalDisplayed());
        assertTrue(onlinePayment.isMaestroSystemModalDisplayed());
        assertTrue(onlinePayment.isMirSystemModalDisplayed());

    }
}
