package HW3.tests;


import HW3.pages.PlayersPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class CRUDUserTests {

    WebDriver driver; // Declare var
    PlayersPage playersPage;


    @BeforeTest
    public void beforeTest() {

        //open browser
        driver = new FirefoxDriver(); //initialize/create object/open firefox
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * Preconditions:
     * Open application LOgin Page URL
     */
    @BeforeMethod
    public void beforeMethod() {
        playersPage = new PlayersPage(driver);
        playersPage.open(); //open poker URL

    }

    /**
     * Steps to reproduce:
     * 1. Set username to "admin"
     * 2. Set password to "123"
     * 3. Click on 'Login' button
     * 4. Verify that title of the page equals to "Players"
     * 5. Verify that URL equals to Login Page URL
     */
    @Test
    public void createUserTest() {

        String randomValue = RandomStringUtils.randomAlphanumeric(10);
        playersPage.setUsername("admin");
        playersPage.setPassword("123");
        playersPage.clickOnLogin();
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after login");
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL + "/players", "You are still on login page.");
        /**
         * 6. Click on the 'Insert' button
         * 7. Verify that URL equals to Insert Page URL
         * 8. Verify that title of the page equals to "Players - Insert"
         * 9. Assign to "nameUser" variable "randomValue" value
         * 10. Set a value from nameUser variable to username field
         * 11. Set a value from email variable to email field
         * 12. Set a value from passw variable to password field
         * 13. Set a value from confirmPassword variable to confirm password field
         * 14. Set a value from fname variable to first name field
         * 15. Set a value from lname variable to last name field
         * 16. Set a value from city variable to city field
         * 17. Set a value from address variable to address field
         * 18. Set a value from phone variable to phone field
         * 19. Click Save button
         * 20. Verify that URL equals to Players Page URL
         * 21. Verify that title of the page equals to "Players"
         */
        playersPage.clickOnInsert();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL + "/players/insert", "You are NOT on insert page.");
        Assert.assertEquals(driver.getTitle(), "Players - Insert", "Wrong title after unsuccessful click insert btn");
        String nameUser = randomValue;
        playersPage.setUserName(nameUser);
        String email = nameUser + "@mail.ru";
        playersPage.setEmail(email);
        String passw = "43965435";
        playersPage.setPassw(passw);
        String confirmPassword = "43965435";
        playersPage.setConfirmPassword(confirmPassword);
        String firstName = "first name";
        playersPage.setFirstName(firstName);
        String lastName = "last name";
        playersPage.setLastName(lastName);
        String city = "London";
        playersPage.setCity(city);
        String address = "Lenina street";
        playersPage.setAddress(address);
        String phone = "123456789";
        playersPage.setPhone(phone);
        playersPage.clickOnSave();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL + "/players", "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful user creating");
        /**
         * 22. Assign to variable "searchField" value "nameUser"
         * 23. Set searchField to search field
         * 24. Click Search button
         * 25. Verify that URL equals to Players Page URL
         * 26. Verify that title of the page equals to "Players"
         */
        String searchField = nameUser;
        playersPage.setSearchField(searchField);
        playersPage.clickOnSearch();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL + "/players", "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful user searching");
        /**
         * 27. Click Edit button near the usename
         * 28. Verify that title of the page equals to "Players - Insert"
         */
        playersPage.clickOnEditBtnNear(nameUser);
        Assert.assertEquals(driver.getTitle(), "Players - Edit", "Wrong title after unsuccessful edit btn click");
        /**
         * 29. Verify that email field value equals expectedEmailResult
         * 30. Verify that first name field value equals expectedFnameResult
         * 31. Verify that last name field value equals expectedELnameResult
         * 32. Verify that city field value equals expectedCityResult
         * 33. Verify that address field value equals expectedAddressResult
         * 34. Verify that phone field value equals expectedPhoneResult
         * 35. Click Save button
         * 36. Verify that URL equals to Players Page URL
         * 37. Verify that title of the page equals to "Players"
         */
        String actualEmailResult = playersPage.getEmailValue();
        String expectedEmailResult = nameUser + "@mail.ru";
        Assert.assertEquals(actualEmailResult, expectedEmailResult, "email does not match");

        String actualFnameResult = playersPage.getFnameValue();
        String expectedFnameResult = firstName;
        Assert.assertNotEquals(actualFnameResult, expectedFnameResult, "first name matches");

        String actualLnameResult = playersPage.getLnameValue();
        String expectedLnameResult = lastName;
        Assert.assertNotEquals(actualLnameResult, expectedLnameResult, "last name matches");

        String actualCityResult = playersPage.getCityValue();
        String expectedCityResult = city;
        Assert.assertEquals(actualCityResult, expectedCityResult, "city does not match");

        String actualAddressResult = playersPage.getAddressValue();
        String expectedAddressResult = address;
        Assert.assertNotEquals(actualAddressResult, expectedAddressResult, "address matches");

        String actualPhoneResult = playersPage.getPhoneValue();
        String expectedPhoneResult = "phone";
        Assert.assertEquals(actualPhoneResult, expectedPhoneResult, "phone does not match");

        playersPage.clickOnSave();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL + "/players", "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful user saving");

    /*


   @Test
    public void editUserTest(){
   }
*/

    }

    @AfterTest
    public void afterTest () {
        //close browser
        driver.quit();
    }



}






