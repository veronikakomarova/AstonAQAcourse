import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.OnlinePayment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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


    @Test
    void checkPaymentLogoDisplayed() {
        assertTrue(onlinePayment
                .isPaymentLogoDisplayed());
    }

    @Test
    void checkPaymentIconsDisplayed() {
        assertTrue(onlinePayment.isBelkartIconDisplayed());
        assertTrue(onlinePayment.isMasterCardSecureIconDisplayed());
        assertTrue(onlinePayment.isMasterCardIconDisplayed());
        assertTrue(onlinePayment.isVisaVerifiedIconDisplayed());
        assertTrue(onlinePayment.isVisaIconDisplayed());
    }

    @Test
    void checkPaymentServiceInfoLinkRedirect() {

        final String expectedRedirectionUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

        onlinePayment
                .clickPaymentServiceInfoLink();

        String actualUrl = onlinePayment.getCurrentUrl();
        assertEquals(expectedRedirectionUrl, actualUrl);
    }

    @Test
    void checkPaymentButtonOpenModal() {
        onlinePayment
                .openPaymentModal("297777777", "15");
        assertTrue(onlinePayment.isPaymentModalDisplayed());
    }

    @Test
    void checkConectionFieldsPlaceholders(){
        onlinePayment.selectService();
        assertEquals("Номер телефона", onlinePayment.getPhoneNumbPlaceholder());
        assertEquals("Сумма", onlinePayment.getConnectionSumPlaceholder());
        assertEquals("E-mail для отправки чека", onlinePayment.getConnectionEmailPlaceholder());
    }

    @Test
    void checkHomeInternetFieldsPlaceholders(){
        onlinePayment.selectHomeInternet();
        assertEquals("Номер абонента", onlinePayment.getInetrnetPhoneNumbPlaceholder());
        assertEquals("Сумма", onlinePayment.getInternetSumPlaceholder());
        assertEquals("E-mail для отправки чека", onlinePayment.getInternetEmailPlaceholder());
    }

    @Test
    void checkInstallmentFieldsPlaceholders(){
        onlinePayment.selectInstallmentPlan();
        assertEquals("Номер счета на 44", onlinePayment.getInstallmentPhonePlaceholder());
        assertEquals("Сумма", onlinePayment.getInstallmentSumPlaceholder());
        assertEquals("E-mail для отправки чека", onlinePayment.getInstallmentEmailPlaceholder());
    }

    @Test
    void checkDebtFieldsPlaceholders(){
        onlinePayment.selectDebt();
        assertEquals("Номер счета на 2073", onlinePayment.getDebtPhoneNumbPlaceholder());
        assertEquals("Сумма", onlinePayment.getDebtSumPlaceholder());
        assertEquals("E-mail для отправки чека", onlinePayment.getDebtEmailPlaceholder());
    }

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
