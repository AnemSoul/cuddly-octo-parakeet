package com.epam.training.student_Aleksei_Guskov.fundamental.web_driver_practic.i_can_win;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageControlC {
    private static final String URL_CONTROL_C = "https://controlc.com/";
    private WebDriver driver;
    private String textForArea, textForTitle;
    @FindBy(
            xpath = "//textarea[@id='input_text']"
    )
    private WebElement textArea;
    @FindBy(
            xpath = "//input[@id='paste_title']"
    )
    private WebElement titleArea;
    @FindBy(
            xpath = "//option[text()='Yes']"
    )
    private WebElement selectHighlightingOptionYes;
    public PageControlC(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PageControlC openPage() {
        this.driver.get(URL_CONTROL_C);
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        return this;
    }
    public PageControlC pasteTextInArea(String textForArea) {
        this.textArea.sendKeys(textForArea);
        return new PageControlC(this.driver);
    }
    public PageControlC pasteTextInTitle(String textForTitle) {
        this.titleArea.sendKeys(textForTitle);
        return new PageControlC(this.driver);
    }
    public void selectorHighlightingOptionChoice () {
        this.selectHighlightingOptionYes.click();
    }
}
