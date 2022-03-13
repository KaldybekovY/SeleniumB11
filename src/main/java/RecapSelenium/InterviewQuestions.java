package RecapSelenium;

public class InterviewQuestions {
    /*
    1) What are advantages and disadvantages of Selenium?
    Advantages: * Free open source
                * It supports multiple language java, python, c#
                * Big community
                * It supports multiple browsers
    Disadvantages: 1) You can't automate the captcha, pictures, mobile application...
    * There is no direct call for the error report
    * It only automates the web application
    * It doesn't have reporting system, we use TestNG reports.

    2) What type of testing can you automate with Selenium?
    *Smoke
    *Regression
    *Functional test(positive and negative)

    3) What are the test types do not automate with Selenium?
    *Performance testing
    *Manual Testing
    *Non-functional testing
    *Load testing
    *Stress testing

    4) What is locator? What are the locator types?
    Locator is a way to find the element from DOM(development tool/page)
    Types: id, className, name, xpath, TagName, LinkText, PartialLinkText, CSS.

    5) How do you handle the dynamic elements?
    In my project I faced many dynamic elements I use different ways to handle it.
    I used parent/child relationship to locate the element.
    I used special element types like following::siblings, preceding-siblings, contains.

    6) Difference between driver.get() and driver.navigate.to()?
    driver.get-it will wait all webElements in page class to be loaded.
    navigate.to-it doesn't wait webElements page to be loaded. It has methods: back(), refresh(), forward(), to().

    7) Difference between driver.close() and driver.quit()?

    close()->it specifically closes the window that you are currently working(where your driver is located)

    quit()->it closes all windows

    8) What is Xpath? Can you tell me about types of Xpath?
    Xpath is a way of finding elements by using HTML structure.
    There are two types of Xpath: absolute, relative. Absolute goes from paren to child step by step. Relative directly focuses on child.

    9) What is the difference between Absolute and Relative Xpath?
    Absolute Xpath: parent-child relationship, it has single slash for the path, syntax is different
    Relative Xpath: directly child relationship, it has double slash for the path, syntax is different

    10) How do you handle static drop down menu?
    In my project i was handling static dropdown with different ways. I would definitely check the tag of the location.
    If the location has Select tag I use Select class.
    If location doesn't have Select Tag->I use locators to locate my elements.
    I can also use Action class to hoverOver my element.

    11) What are the methods of Select?
    Select methods are SelectByVisibleText(), SelectByValue(), SelectByIndex(). To be able to use select class, element must have Select tag.

    12) What kind of Exceptions did you face in Selenium?
    NoSuchElementException, NullPointerException, StaleElementException, ElementIsNotIntractable, TimeOutException, NoSuchFrameException, NoSuchWindowException.

    13) In what condition do you get StaleElementReferenceException?How do you handle it?
    In my project, I had a hard time with StaleElementException.
    *Once the element is not in DOM
    *Navigate to the another page and come back(element needs little time to be loaded)
    I can handle this exception either putting some time to be uploaded(Thread.sleep)
    I reinitialize my element before I do my actions on it.
    You can also refresh the page.

    14) How do you do handle Alerts?
    There are different types of alerts I faced in my framework
    1) Operating system alert: I can not handle id directly. I need to use ROBOT class.
    2) HTML alerts: I need to find the element and click it.
    3) JavaScript Alert(pop-up): I handle these alerts with Alert class.

    15) For the Alert Interface what kind of methods what kind of methods do you know?
    First, Alert is an interface I agree, but the methods are coming from RemoteAlertClass.
    We have 4 methods of AlertClass: accept(), dismiss(), sendKeys(), getText().

    16) What do you know about selenium.iframe?Can you tell me the type that you used before?
    How do you handle the iframe in selenium?
    Iframe is HTML inside another HTML. The reason people are using iframe because they would like to get extra protection for their data like(advertisement, videos).
    I can deal with iframe elements by switching my driver(driver.switch.frame())

    17) What do you know about action class?
    Action class is basically does the functionality of my mouse and keyboard. I can say it is really useful in my project
    to handle some elements. Some important methods actions class have: *DoubleClick()
                                                                        *SendKeys()
                                                                        *ContextClick()-->right click
                                                                        *ClickAndHold.Release()
                                                                        *DragAndDrop
                                                                        *MoveToElements()
                                                                        *click()
                                                                        *perform()
    18) What is the difference between find element and find Elements?
    Find element returns single element.
    Find elements returns list of elements.

    19) What are the driver and WebElement methods?
    driver.get().navigate().getTitle().findElement/s().getPageSource().
    WebElement.sendKeys().click().getText().clear().submit().getAttribute().

    20) What is the difference between check-box and radio button?
    CheckBox you can click multiple boxes.
    RadioButton you can choose only one.

    21) Differences between isDisplayed, isSelected, isEnabled?
    All of them return boolean condition.
    IsDisplayed-checks the elements visible or not
    IsEnabled-it checks the element is enabled or not
    isSelected-it checks the element is Selected or not

    22) How do you switch the multiple windows?
    I can use driver.WindowHandle and driver.WindowHandles method to switch my windows and handle the elements from other websites.
    We use set to store our page ids.

    23) How do you scroll down to the page from Web Browser?
    I would use JavaScript with scrollIntoView and Point Class.

    24) How do you download and upload file?
    Find the element and send the keys of path.

    25) What is the difference between assert and softAssert?

    Assert is a class that have some methods to validate the actual and expected data with the methods like assert.assertEquals, assert.assertTrue...
    When it fails, it immediately throws and exception stop the executing next code.

    SoftAssert: is a class that have some methods to validate the actual and expected data with the methods like assert.assertEquals, assert.assertTrue...
    When it fails, it doesn't throws and exception then it keeps executing the next codes.
    In the end you have to softAssert.assertAll

    SoftAssert softAssert=new SoftAssert();

    26) Can you tell me about Singleton? Have you ever used it in your project?

    I was working on my driver, I was getting lots of NullPointer exception. But with the help of singleton pattern
    design, I made my driver more safe and reliable.
    How do I create Singleton Design pattern is:
        1) I need to have private WebDriver
        2) I need to have private Constructor (because i do not want anyone to create object from this class)
        3) I create a public method to be called by other classes
        4) I use if conditions like (if driver==null and initialize my driver) and return it.

    27) Can you tell me how you provide pictures once you find the BUG?
    In my project I have a perfect implementation for the screenShot. It means once my tests fail, my system takes screenshot of them and store.

    28) Do you know anything about DataProvider?What do you do with the same test with different scenarios?
    DataProvider is a way to run your different set of data with the same test.

    29) What do you know about wait times?Difference between implicit and explicit wait?
    Implicit wait-waits for specific time while locating the elements.
    When it doesn't find the element on a certain time you provide, it throws NoSuchElement.
    Explicit wait-waits to a particular webElement until expected condition specified is met.
    When it doesn't find the element on a certain time you provide, it throws TimeOutException.

    30) We have different customers for the specific website login. I would like to test our all customers' login functionality is working or not.
    How would you test it?
    I would use DataProvider. 
     */
}
