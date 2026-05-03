package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnlinePayment {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By paymentLogo = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2");
    private final By belkartIcon = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img");
    private final By masterCardSecureIcon = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]/img");
    private final By masterCardIcon = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img");
    private final By visaVerifiedIcon = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]/img");
    private final By visaIcon = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img");
    private final By linkHelp = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a");
    private final By dropDown = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
    private final By uslugiSviazi = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p");
    private final By domashniyInternet = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p");
    private final By rassrochka = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p");
    private final By zadoljennost = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p");
    private final By phoneNumbField = By.xpath("//*[@id=\"connection-phone\"]");
    private final By abonentNumbField = By.xpath("//*[@id=\"internet-phone\"]");
    private final By nomerSchetaRassrochka = By.xpath("//*[@id=\"score-instalment\"]");
    private final By nomerSchetaZadoljennost = By.xpath("//*[@id=\"score-arrears\"]");
    private final By sumField = By.xpath("//*[@id=\"connection-sum\"]");
    private final By internetSumField = By.xpath("//*[@id=\"internet-sum\"]");
    private final By rassrochkaSumField = By.xpath("//*[@id=\"instalment-sum\"]");
    private final By zadoljennostSumField = By.xpath("//*[@id=\"arrears-sum\"]");
    private final By emailUslugiSviazi = By.xpath("//*[@id=\"connection-email\"]");
    private final By emailDomashniyInternet = By.xpath("//*[@id=\"internet-email\"]");
    private final By emailRassrochka = By.xpath("//*[@id=\"instalment-email\"]");
    private final By emailZadoljennost = By.xpath("//*[@id=\"arrears-email\"]");
    private final By buttonContinue = By.xpath("//*[@id=\"pay-connection\"]/button");
    private final By paymentIframe = By.cssSelector("iframe[src*='bepaid'], iframe[src*='checkout']");
    private final By modalWindow = By.xpath("/html/body/app-root/div/div/div/app-payment-container");
    private final By cookieButton = By.id("cookie-agree");
    //Фрейм
    private final By descriptionCost = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/div[1]/span");
    private final By costOnSubmitButton = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button/span");
    private final By costOnAgreement = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/div[2]/span");
    private final By phoneNumbModal = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span");
    private final By visaSystemModal = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]");
    private final By masterCardSystemModal = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[2]");
    private final By belkartSystemModal = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[3]");
    private final By maestroSystemModal = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[1]");
    private final By mirSystemModal = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[2]");
    private final By cardNumberModal = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label");
    private final By validityPeriodOfCard = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label");
    private final By cvcCode = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label");
    private final By personData = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label");






    public OnlinePayment(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    private boolean isElementDisplayed(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    private void click(By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void type(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    @Step("Принять кукки")
    public void acceptCookie() {

        click(cookieButton);
    }

    @Step("Отображение названия для блока\"Онлайн пополнение без комиссии\"")
    public boolean isPaymentLogoDisplayed() {

        return isElementDisplayed(paymentLogo);
    }

    @Step("Отображение иконки платёжной системы")
    public boolean isBelkartIconDisplayed(){

        return isElementDisplayed(belkartIcon);
    }

    @Step("Отображение иконки платёжной системы")
    public boolean isMasterCardSecureIconDisplayed(){

        return isElementDisplayed(masterCardSecureIcon);
    }

    @Step("Отображение иконки платёжной системы")
    public boolean isMasterCardIconDisplayed(){

        return isElementDisplayed(masterCardIcon);
    }

    @Step("Отображение иконки платёжной системы")
    public boolean isVisaVerifiedIconDisplayed(){

        return isElementDisplayed(visaVerifiedIcon);
    }

    @Step("Отображение иконки платёжной системы")
    public boolean isVisaIconDisplayed(){

        return isElementDisplayed(visaIcon);
    }


    @Step("Кликнуть на ссылку\"Подробнее о сервисе\"")
    public void clickPaymentServiceInfoLink() {

        click(linkHelp);
    }

    public String getCurrentUrl() {

        return driver.getCurrentUrl();
    }

    @Step("Кликнуть на вариант дропдауна \"Услуги связи\"")
    public void selectService() {
        click(dropDown);
        click(uslugiSviazi);
    }

    @Step("Кликнуть на вариант дропдауна \"Домашний интернет\"")
    public void selectHomeInternet(){
        click(dropDown);
        click(domashniyInternet);
    }

    @Step("Кликнуть на вариант дропдауна \"Рассрочка\"")
    public void selectInstallmentPlan(){
        click(dropDown);
        click(rassrochka);
    }

    @Step("Кликнуть на вариант дропдауна \"Задолженность\"")
    public void selectDebt(){
        click(dropDown);
        click(zadoljennost);
    }

    @Step("Получить плейсхолдер")
    public String getPhoneNumbPlaceholder(){
        return getPlaceholder(phoneNumbField);
    }

    @Step("Получить плейсхолдер")
    public String getInetrnetPhoneNumbPlaceholder(){
        return getPlaceholder(abonentNumbField);
    }

    @Step("Получить плейсхолдер")
    public String getInstallmentPhonePlaceholder(){
        return getPlaceholder(nomerSchetaRassrochka);
    }

    @Step("Получить плейсхолдер")
    public String getDebtPhoneNumbPlaceholder(){
        return getPlaceholder(nomerSchetaZadoljennost);
    }

    @Step("Получить плейсхолдер")
    public String getConnectionSumPlaceholder(){
        return getPlaceholder(sumField);
    }

    @Step("Получить плейсхолдер")
    public String getInternetSumPlaceholder(){
        return getPlaceholder(internetSumField);
    }

    @Step("Получить плейсхолдер")
    public String getInstallmentSumPlaceholder(){
        return getPlaceholder(rassrochkaSumField);
    }

    @Step("Получить плейсхолдер")
    public String getDebtSumPlaceholder(){
        return getPlaceholder(zadoljennostSumField);
    }

    @Step("Получить плейсхолдер")
    public String getConnectionEmailPlaceholder(){
        return getPlaceholder(emailUslugiSviazi);
    }

    @Step("Получить плейсхолдер")
    public String getInternetEmailPlaceholder(){
        return getPlaceholder(emailDomashniyInternet);
    }

    @Step("Получить плейсхолдер")
    public String getInstallmentEmailPlaceholder(){
        return getPlaceholder(emailRassrochka);
    }

    @Step("Получить плейсхолдер")
    public String getDebtEmailPlaceholder(){
        return getPlaceholder(emailZadoljennost);
    }


    @Step("Заполнить поля с номером телефона и суммой")
    public void fillPaymentForm(String phoneNumber, String sum) {
        type(phoneNumbField, phoneNumber);
        type(sumField, sum);
    }

    @Step("Нажать на кнопку \"Продолжить\"")
    public void submitPayment() {

        click(buttonContinue);
    }

    @Step("Заполнить поля с номером телефона и суммой, нажать кнопку \"Продолжить\"")
    public void openPaymentModal(String phoneNumber, String sum) {
        selectService();
        fillPaymentForm(phoneNumber, sum);
        submitPayment();
    }

    @Step("Отобразить модальное окно оплаты")
    public boolean isPaymentModalDisplayed() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentIframe));
        return isElementDisplayed(modalWindow);
    }

    private String getPlaceholder(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                .getAttribute("placeholder");
    }

    @Step("Перейти во фрейм")
    public void switchToPaymentFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentIframe));
    }

    //Фрейм

    private String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    @Step("Получить текст суммы")
    public String getDescriptionCostText(){
        return getText(descriptionCost);
    }

    @Step("Получить текст кнопки")
    public String getCostOnSubmitButtonText(){
        return getText(costOnSubmitButton);
    }

    @Step("Получить текст соглашения")
    public String getCostOnAgreementText(){
        return getText(costOnAgreement);
    }

    @Step("Получить текст телефона")
    public String getPhoneNumbModalText(){
        return getText(phoneNumbModal);
    }

    @Step("Получить текст из поля номера карты")
    public String getCardNumberModalText(){
        return getText(cardNumberModal);
    }

    @Step("Получить текст из поля срока действия карты")
    public String getValidityPeriodOfCardText(){
        return getText(validityPeriodOfCard);
    }

    @Step("Получить текст из поля с кодом cvc")
    public String getCvcCodeText(){
        return getText(cvcCode);
    }

    @Step("Получить текст из поля ФИО")
    public String getPersonDataText(){
        return getText(personData);
    }

    @Step("Отображение иконки платёжной системы")
    public boolean isVisaSystemModalDisplayed(){
        return isElementDisplayed(visaSystemModal);
    }

    @Step("Отображение иконки платёжной системы")
    public boolean isMasterCardSystemModalDisplayed(){
        return isElementDisplayed(masterCardSystemModal);
    }

    @Step("Отображение иконки платёжной системы")
    public boolean isBelkartSystemModalDisplayed(){
        return isElementDisplayed(belkartSystemModal);
    }

    @Step("Отображение иконки платёжной системы")
    public boolean isMaestroSystemModalDisplayed(){
        return isElementDisplayed(maestroSystemModal);
    }

    @Step("Отображение иконки платёжной системы")
    public boolean isMirSystemModalDisplayed(){
        return isElementDisplayed(mirSystemModal);
    }

}
