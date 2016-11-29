import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;




public class LoginTests {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver(); // открыть Firefox
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// устанавливаем загрузку страниц  с таймаутом 30
        String URL = "http://80.92.229.236:81"; // Poker URL
        driver.get(URL + "/auth/login"); // открыть Poker

        // переменные для заполнения полей при создании игрока
        String user = "admin";
        String password = "123";
        String username = "qqq9876";                    // функция генерации значений отсутствует, поэтому
        String email = "ttt4567@mail.ru";               // каждый раз нужно будет изменять значения следующих полей:
        String userPassword = "12345678";               // String username(22-я строка кода), String email(23-я строка кода),
        String confirmPassword = "12345678";            // String email1(33-я строка кода) и имя юзера которое используется
        String firstName = "First Name";                // в xpath в строках кода номер 105 и 174
        String lastName = "Last Name";
        String city = "London";
        String adress = "Lenina street";
        String phone = "1234567";

        // переменные для изменения содержания полей
        String email1 = "yty3210@mail.ru";
        String firstName1 = "Oleg";
        String lastName1 = "Ivanov";
        String city1 = "Paris";
        String adress1 = "Ivanova street";
        String phone1 = "12345";

        // вход в систему
        WebElement usernameField = driver.findElement(By.id("username")); // ищем сам элемент по id
        usernameField.sendKeys(user); // вводим значение

        WebElement passwordField = driver.findElement(By.id("password")); // ищем сам элемент по id
        passwordField.sendKeys(password); // вводим значение

        WebElement loginButton = driver.findElement(By.id("logIn")); // ищем сам элемент по id
        loginButton.click(); // нажать на кнопку LogIn
        //проверка страницы
        String actualTitle = driver.getTitle();
        String expectedTitle = "Players";//создаем переменную с ожидаемым результатом
        assertText(actualTitle, expectedTitle); // проверка, что пользователь вернулся на страницу со списком игроков

        // создаем игрока
        WebElement insertButton = driver.findElement(By.xpath(".//a[@href='http://80.92.229.236:81/players/insert']")); // ищем сам элемент по xpath
        insertButton.click(); // кликнуть на кнопку Insert

        WebElement usernameInput = driver.findElement(By.id("ff14642ac1c__us_login"));// ищем сам элемент по id
        usernameInput.sendKeys(username); // вводим значение

        WebElement emailInput = driver.findElement(By.id("ff14642ac1c__us_email")); // ищем сам элемент по id
        emailInput.sendKeys(email);  // вводим значение

        WebElement userPasswordInput = driver.findElement(By.id("ff14642ac1c__us_password"));// ищем сам элемент по id
        userPasswordInput.sendKeys(userPassword);// вводим значение

        WebElement confirmPasswordInput = driver.findElement(By.id("ff14642ac1c__confirm_password"));// ищем сам элемент по id
        confirmPasswordInput.sendKeys(confirmPassword);// вводим значение

        WebElement firstNameInput = driver.findElement(By.id("ff14642ac1c__us_fname"));// ищем сам элемент по id
        firstNameInput.sendKeys(firstName);// вводим значение

        WebElement lastNameInput = driver.findElement(By.id("ff14642ac1c__us_lname"));// ищем сам элемент по id
        lastNameInput.sendKeys(lastName);// вводим значение

        WebElement cityInput = driver.findElement(By.id("ff14642ac1c__us_city")); // ищем сам элемент по id
        cityInput.sendKeys(city);// вводим значение

        WebElement adressInput = driver.findElement(By.id("ff14642ac1c__us_address"));// ищем сам элемент по id
        adressInput.sendKeys(adress);// вводим значение

        WebElement phoneInput = driver.findElement(By.id("ff14642ac1c__us_phone"));// ищем сам элемент по id
        phoneInput.sendKeys(phone);// вводим значение

        WebElement saveButton = driver.findElement(By.xpath(".//input[@value='Save']"));// ищем сам элемент по xpath
        saveButton.click();// нажать на кнопку

        //проверка страницы
        assertText(actualTitle, expectedTitle);// проверка, что пользователь вернулся на страницу со списком игроков

        // ищем созданного игрока
        WebElement playerSearchInput = driver.findElement(By.id("723a925886__login"));// ищем сам элемент по id
        playerSearchInput.sendKeys(username);// вводим значение

        WebElement searchButton = driver.findElement(By.xpath(".//input[@name='search' and @type='button']"));// ищем сам элемент по xpath
        searchButton.click(); //нажать на кнопку

        //открываем форму редактирования этого игрока
        WebElement editButton = driver.findElement(By.xpath(".//tr[.//a[text()='qqq9876']]//img[@alt='Edit']"));// найти элемент для игрока, которого ищем
        editButton.click();//нажать на кнопку

        //выполняем проверки содержания полей:email, first name, last name, city, adress, phone.
        WebElement emailField = driver.findElement(By.id("ff14642ac1c__us_email"));// ищем сам элемент по id
        String actualEmailValue = emailField.getAttribute("value");//находим его значение
        String expectedEmailValue = email;// создаем переменную с ожидаемым значением
        assertString(actualEmailValue, expectedEmailValue);// сравниваем значения используя метод assertString

        WebElement fnameField = driver.findElement(By.id("ff14642ac1c__us_fname"));// ищем сам элемент по id
        String actualFnameValue = fnameField.getAttribute("value");//находим его значение
        String expectedFnameValue = "fname";// создаем переменную с ожидаемым значением
        assertString(actualFnameValue, expectedFnameValue);// сравниваем значения используя метод assertString

        WebElement lnameField = driver.findElement(By.id("ff14642ac1c__us_lname"));// ищем сам элемент по id
        String actualLnameValue = lnameField.getAttribute("value");//находим его значение
        String expectedLnameValue = "lname";// создаем переменную с ожидаемым значением
        assertString(actualLnameValue, expectedLnameValue);// сравниваем значения используя метод assertString

        WebElement cityField = driver.findElement(By.id("ff14642ac1c__us_city"));// ищем сам элемент по id
        String actualCityValue = cityField.getAttribute("value");//находим его значение
        String expectedCityValue = "London";// создаем переменную с ожидаемым значением
        assertString(actualCityValue, expectedCityValue);// сравниваем значения используя метод assertString

        WebElement addressField = driver.findElement(By.id("ff14642ac1c__us_address"));// ищем сам элемент по id
        String actualAddressValue = addressField.getText();//находим его значение
        String expectedAddressValue = "Lenina stereet";// создаем переменную с ожидаемым значением
        assertString(actualAddressValue, expectedAddressValue);// сравниваем значения используя метод assertString

        WebElement phoneField = driver.findElement(By.id("ff14642ac1c__us_phone"));// ищем сам элемент по id
        String actualPhoneValue = phoneField.getAttribute("value");//находим его значение
        String expectedPhoneValue = "1234567";// создаем переменную с ожидаемым значением
        assertString(actualPhoneValue, expectedPhoneValue);// сравниваем значения используя метод assertString

        // очистка содержания полей: email, first name, last name, city, adress, phone.
        emailField.clear();
        fnameField.clear();
        lnameField.clear();
        cityField.clear();
        addressField.clear();
        phoneField.clear();

        // ввод новых значений в поля после того, как их очистили
        WebElement email1Input = driver.findElement(By.id("ff14642ac1c__us_email"));// ищем сам элемент по id
        email1Input.sendKeys(email1);// вводим значение

        WebElement first1NameInput = driver.findElement(By.id("ff14642ac1c__us_fname"));// ищем сам элемент по id
        first1NameInput.sendKeys(firstName1);// вводим значение

        WebElement last1NameInput = driver.findElement(By.id("ff14642ac1c__us_lname"));// ищем сам элемент по id
        last1NameInput.sendKeys(lastName1);// вводим значение

        WebElement city1Input = driver.findElement(By.id("ff14642ac1c__us_city"));// ищем сам элемент по id
        city1Input.sendKeys(city1);// вводим значение

        WebElement adress1Input = driver.findElement(By.id("ff14642ac1c__us_address"));// ищем сам элемент по id
        adress1Input.sendKeys(adress1);// вводим значение

        WebElement phone1Input = driver.findElement(By.id("ff14642ac1c__us_phone"));// ищем сам элемент по id
        phone1Input.sendKeys(phone1);// вводим значение

        WebElement save1Button = driver.findElement(By.xpath(".//input[@value='Save']"));// ищем сам элемент по xpath
        save1Button.click();// нажимаем на кнопку

        //ищем созданного игрока
        WebElement search1Button = driver.findElement(By.xpath(".//input[@name='search' and @type='button']"));//ищем элемент по xpath
        search1Button.click(); //нажимаем на кнопку
        //открываем форму редактирования игрока
        WebElement edit1Button = driver.findElement(By.xpath(".//tr[.//a[text()='qqq9876']]//img[@alt='Edit']"));//ищем элемент по xpath
        edit1Button.click();//нажимаем на кнопку


       //выполняем проверки содержания следующих полей с новыми значениями:email, first name, last name, city, adress, phone.
        WebElement emailNewField = driver.findElement(By.id("ff14642ac1c__us_email"));// ищем сам элемент по id
        String actualEmailNewValue = emailNewField.getAttribute("value");//находим его значение
        String expectedEmailNewValue = email1;// создаем переменную с ожидаемым значением
        assertString(actualEmailNewValue, expectedEmailNewValue);// сравниваем значения используя метод assertString

        WebElement fnameNewField = driver.findElement(By.id("ff14642ac1c__us_fname"));// ищем сам элемент по id
        String actualFnameNewValue = fnameNewField.getAttribute("value");//находим его значение
        String expectedFnameNewValue = "Oleg";// создаем переменную с ожидаемым значением
        assertString(actualFnameNewValue, expectedFnameNewValue);// сравниваем значения используя метод assertString

        WebElement lnameNewField = driver.findElement(By.id("ff14642ac1c__us_lname"));// ищем сам элемент по id
        String actualLnameNewValue = lnameNewField.getAttribute("value");//находим его значение
        String expectedLnameNewValue = "Ivanov";// создаем переменную с ожидаемым значением
        assertString(actualLnameNewValue, expectedLnameNewValue);// сравниваем значения используя метод assertString

        WebElement cityNewField = driver.findElement(By.id("ff14642ac1c__us_city"));// ищем сам элемент по id
        String actualCityNewValue = cityNewField.getAttribute("value");//находим его значение
        String expectedCityNewValue = "Paris";// создаем переменную с ожидаемым значением
        assertString(actualCityNewValue, expectedCityNewValue);// сравниваем значения используя метод assertString

        WebElement addressNewField = driver.findElement(By.id("ff14642ac1c__us_address"));// ищем сам элемент по id
        String actualAddressNewValue = addressNewField.getText();//находим его значение
        String expectedAddressNewValue = "Ivanova street";// создаем переменную с ожидаемым значением
        assertString(actualAddressNewValue, expectedAddressNewValue);// сравниваем значения используя метод assertString

        WebElement phoneNewField = driver.findElement(By.id("ff14642ac1c__us_phone"));// ищем сам элемент по id
        String actualPhoneNewValue = phoneNewField.getAttribute("value");//находим его значение
        String expectedPhoneNewValue = "12345";// создаем переменную с ожидаемым значением
        assertString(actualPhoneNewValue, expectedPhoneNewValue);// сравниваем значения используя метод assertString

        WebElement save2Button = driver.findElement(By.xpath(".//input[@value='Save']"));// ищем сам элемент по xpath
        save2Button.click();// нажать на кнопку

        driver.close(); //закрыть вкладку
        driver.quit(); // закрыть браузер

    }
    //метод для проверки страницы
    public static void assertText(String actualValue, String expectedValue) {
        if (actualValue.equals(expectedValue)) {
            System.out.println("Passed. The title is matched with expected title");
        } else {
            System.err.println("Failed. Expected text is " + " "
                    + expectedValue + " " + ", but Actual title is " + " " + actualValue);
        }
    }

    //метод для проверок полей
    public static void assertString(String actualResult, String expectedResult) {
        if (expectedResult.equals(actualResult)) {
            System.out.println("Passed");
        } else {
            System.err.println("Faild. Expected result is" + " " + expectedResult + " " + ". Actual result is " + " " + actualResult);


        }
    }


}
