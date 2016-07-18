package com.thoughtworks.training.banking.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.thoughtworks.training.banking.IonicHelpers;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Stepdefs {
    @Given("^I start App$")
    public void i_start_App() throws Throwable {
        $("body").should(appear);
    }

    @Then("^I should see main menu:$")
    public void i_should_see_main_menu(DataTable mainMenuItems) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        SelenideElement mainMenu = $("ion-side-menu-content").$("ion-list");
        mainMenu.should(appear);
        ElementsCollection elements = mainMenu.$$("ion-item");
        elements.shouldHaveSize(6);

        String[] items = mainMenuItems.asList(String.class).toArray(new String[6]);
        elements.shouldBe(CollectionCondition.texts(items));
    }

    @When("^I click \"([^\"]*)\"$")
    public void i_click(String menuItem) throws Throwable {
        $(By.linkText(menuItem)).click();
    }

    @Then("^I should see \"([^\"]*)\"$")
    public void i_should_see(String playlist) throws Throwable {
        $("ion-side-menu-content").$("ion-view[nav-view=\"active\"]").shouldBe(text(playlist));
    }

    @When("^I click side menu icon$")
    public void i_click_side_menu_icon() throws Throwable {
        IonicHelpers.open_side_menu();
    }

    @Then("^I should see menu items:$")
    public void i_should_see_menu_items(DataTable sideMenuTexts) throws Throwable {
        SelenideElement sideMenu = $("ion-side-menu").$("ion-list");
        sideMenu.should(appear);
        ElementsCollection elements = sideMenu.$$("ion-item");
        elements.shouldHaveSize(4);

        String[] items = sideMenuTexts.asList(String.class).toArray(new String[4]);
        elements.shouldBe(CollectionCondition.texts(items));
    }

    @Given("^I see menu items$")
    public void i_see_menu_items() throws Throwable {
        IonicHelpers.open_side_menu();

        SelenideElement sideMenu = $("ion-side-menu").$("ion-list");
        sideMenu.should(appear);
        sideMenu.$$("ion-item").shouldHaveSize(4);
    }

    @When("^I press back$")
    public void i_press_back() throws Throwable {
        AndroidDriver webDriver = (AndroidDriver) WebDriverRunner.getWebDriver();
        webDriver.navigate().back();
    }

    @Then("^I should see main menu$")
    public void i_should_see_main_menu() throws Throwable {
        SelenideElement mainMenu = $("ion-side-menu-content").$("ion-list");
        mainMenu.should(appear);
        mainMenu.$$("ion-item").shouldHaveSize(6);
    }

    @Then("^I should not see side menu$")
    public void i_should_not_see_side_menu() throws Throwable {
        SelenideElement sideMenu = $("ion-side-menu").$("ion-list");
//        sideMenu.should(disappear);
    }
}
