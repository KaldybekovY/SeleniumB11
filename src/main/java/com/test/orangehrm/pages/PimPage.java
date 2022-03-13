package com.test.orangehrm.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PimPage {

    public PimPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "menu_pim_viewPimModule")
    WebElement clickPim;

    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement addBtn;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "employeeId")
    WebElement employeeId;

    @FindBy(xpath = "//input[@id='photofile']")
    WebElement upload;

    @FindBy(id = "btnSave")
    WebElement saveBtn;

    @FindBy(id = "personal_txtEmpFirstName")
    WebElement nameValidation;

    @FindBy(id = "personal_txtEmpLastName")
    WebElement lastNameValidation;

    @FindBy(xpath = "//input[@id='personal_txtEmployeeId']")
    WebElement empId;

    @FindBy(xpath = "//input[@id='personal_optGender_1']")
    WebElement gender;

    @FindBy(xpath = "//select[@id='personal_cmbNation']")
    WebElement nationality;

    @FindBy(xpath = "//select[@id='personal_cmbMarital']")
    WebElement marital;

    @FindBy(xpath = "//input[@id='personal_DOB']")
    WebElement yearOfBirth;

    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement editBtn;

    @FindBy(xpath = "//option[@value='93']")
    WebElement validKazakh;

    @FindBy(xpath = "//select[@name='personal[cmbMarital]']//option[@value='Married']")
    WebElement validMarital;



    public void personalDetails(){


        this.editBtn.click();
        this.gender.click();
        BrowserUtils.SelectBy(nationality,"93","value");
        BrowserUtils.SelectBy(marital,"Married","value");
        this.yearOfBirth.clear();
        this.yearOfBirth.sendKeys("1991-03-03");
        this.editBtn.click();

    }

    public void addEmployeeForPIM(String name, String lastName, String employeeId, String uploadFile) throws InterruptedException {

        this.clickPim.click();
        this.addBtn.click();
        this.firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);
        this.employeeId.sendKeys(employeeId);
        this.upload.sendKeys(uploadFile);
        Thread.sleep(1000);
        this.saveBtn.click();
        Thread.sleep(1000);

    }

    public String nameValid(){

        return nameValidation.getAttribute("value");

    }

    public String lastValid(){

        return lastNameValidation.getAttribute("value");
    }

    public boolean empIdValid(String employeeId){

        return empId.getAttribute("value").endsWith(employeeId);

    }

    public String validateNationality(){
        Select select=new Select(nationality);
        return select.getFirstSelectedOption().getText().trim();
    }

    public String validateMarital(){
        Select select=new Select(marital);
        return select.getFirstSelectedOption().getText().trim();
    }
}
