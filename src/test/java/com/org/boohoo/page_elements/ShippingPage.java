package com.org.boohoo.page_elements;

import com.org.boohoo.driver.DriverManager;
import com.org.boohoo.utils.RandomNumberHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShippingPage  extends DriverManager {

    @FindBy(css="input.firstName")
    private WebElement FirstName;

    @FindBy(css="input.lastName")
    private WebElement LastName;

    @FindBy(css="input.emailAddress")
    private WebElement EmailAddress;

    @FindBy(css="input.emailConfirm")
    private WebElement ConfirmEmailAddress;

    @FindBy(css="input.address1")
    private WebElement Address1;

    @FindBy(css="input.city")
    private WebElement City;

    @FindBy(css="input.postal")
    private WebElement PostalCode;

    @FindBy(css="input.phone")
    private WebElement Phone;

    @FindBy(css = "div.js-delivery-row")
    private List<WebElement> DeliveryOptions;

    @FindBy(css="button.js-checkout-next-step-btn")
    private WebElement ProceedToBilling;

    public void enterFirstName( String firstName){
        FirstName.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        LastName.sendKeys(lastName);
    }
    public void enterEmailAddress(String emailAddress){
        EmailAddress.sendKeys(emailAddress);
    }
    public void enterConfirmEmailAddress(String confirmEmailAddress){
        ConfirmEmailAddress.sendKeys(confirmEmailAddress);
    }
    public void enterAddress1(String address1){
        Address1.sendKeys(address1);
    }
    public void enterCity(String city){
        City.sendKeys(city);
    }
    public void enterPostalCode(String postalCode){
        PostalCode.sendKeys(postalCode);
    }
    public void enterPhone(String phone){
        Phone.sendKeys(phone);
    }

    public void chooseRandomDeliveryOptions(){
        int deliveryOptionsSize = DeliveryOptions.size();
        System.out.println(deliveryOptionsSize);
        int randomDeliveryOption = new RandomNumberHelper().generateRandomNumber(deliveryOptionsSize);
        WebElement selectedDeliveryOption = DeliveryOptions.get(randomDeliveryOption);
        selectedDeliveryOption.click();
    }
    public void clickProceedToBilling(){
        ProceedToBilling.click();
    }


}
