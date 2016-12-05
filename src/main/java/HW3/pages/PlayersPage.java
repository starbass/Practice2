package HW3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PlayersPage {

    private WebDriver driver;
    public static final String URL = "http://80.92.229.236:81";
    public PlayersPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(URL + "/auth/login");
    }

    public void setUsername(String username) {
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void setPassword(String password) {
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickOnLogin() {
        WebElement loginButton = driver.findElement(By.id("logIn"));
        loginButton.click();
    }

    public void clickOnInsert() {
        WebElement insertButton = driver.findElement(By.xpath(".//a[@href='http://80.92.229.236:81/players/insert']")); // Find login button
        insertButton.click();
    }

    public void setUserName(String nameuser) {
        WebElement nameuserInput = driver.findElement(By.id("ff14642ac1c__us_login"));
        nameuserInput.clear();
        nameuserInput.sendKeys(nameuser);
    }

    public void setEmail(String email) {
        WebElement emailInput = driver.findElement(By.id("ff14642ac1c__us_email"));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void setPassw(String passw) {
        WebElement passwInput = driver.findElement(By.id("ff14642ac1c__us_password"));
        passwInput.clear();
        passwInput.sendKeys(passw);
    }

    public void setConfirmPassword(String confirmPassword) {
        WebElement confirmPasswordInput = driver.findElement(By.id("ff14642ac1c__confirm_password"));
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void setFirstName(String firstName) {
        WebElement firstNameInput = driver.findElement(By.id("ff14642ac1c__us_fname"));
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        WebElement lastNameInput = driver.findElement(By.id("ff14642ac1c__us_lname"));
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void setCity(String city) {
        WebElement cityInput = driver.findElement(By.id("ff14642ac1c__us_city"));
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void setAddress(String address) {
        WebElement addressInput = driver.findElement(By.id("ff14642ac1c__us_address"));
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void setPhone(String phone) {
        WebElement phoneInput = driver.findElement(By.id("ff14642ac1c__us_phone"));
        phoneInput.clear();
        phoneInput.sendKeys("phone");
    }

    public void clickOnSave() {
        WebElement saveButton = driver.findElement(By.xpath(".//input[@value='Save']"));
        saveButton.click();
    }

    public void setSearchField(String searchField) {
        WebElement searchFieldInput = driver.findElement(By.id("723a925886__login"));
        searchFieldInput.sendKeys(searchField);
    }

    public void clickOnSearch() {
        WebElement searchButton = driver.findElement(By.xpath(".//input[@name='search' and @type='button']"));
        searchButton.click();
    }

    public void clickOnEditBtnNear(String userName) {
        WebElement editButton = driver.findElement(By.xpath(".//tr[.//a[text()='" + userName + "']]//img[@alt='Edit']"));// найти элемент для игрока, которого ищем
        editButton.click();
    }

    public String getEmailValue(){
        WebElement getEmailValue = driver.findElement(By.id("ff14642ac1c__us_email"));
        String emailValue = getEmailValue.getAttribute("value");
        return emailValue;
    }
    public String getFnameValue(){
        WebElement getFnameValue = driver.findElement(By.id("ff14642ac1c__us_fname"));
        String fnameValue = getFnameValue.getAttribute("value");
        return fnameValue;
    }
    public String getLnameValue(){
        WebElement getLnameValue = driver.findElement(By.id("ff14642ac1c__us_lname"));
        String lnameValue = getLnameValue.getAttribute("value");
        return lnameValue;
    }
    public String getCityValue(){
        WebElement getCityValue = driver.findElement(By.id("ff14642ac1c__us_city"));
        String cityValue = getCityValue.getAttribute("value");
        return cityValue;
    }
    public String getAddressValue(){
        WebElement getAddressValue = driver.findElement(By.id("ff14642ac1c__us_address"));
        String addressValue = getAddressValue.getText();
        return addressValue;
    }

    public String getPhoneValue(){
        WebElement getPhoneValue = driver.findElement(By.id("ff14642ac1c__us_phone"));
        String phoneValue = getPhoneValue.getAttribute("value");
        return phoneValue;
    }

}



