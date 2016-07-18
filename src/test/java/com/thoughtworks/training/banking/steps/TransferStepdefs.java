package com.thoughtworks.training.banking.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.thoughtworks.training.banking.IonicHelpers;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.math.BigDecimal;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;


public class TransferStepdefs {
  @Given("^I have accounts:$")
  public void i_have_accounts(DataTable table) throws Throwable {
    List<List<String>> expectedAccounts = table.asLists(String.class);

    ElementsCollection accounts = $("ion-side-menu-content").$("ion-content").$("ion-list").$$("ion-item");
    accounts.shouldHaveSize(2);

    accounts.get(0).$$("div").shouldHave(texts(expectedAccounts.get(0).get(0),
        expectedAccounts.get(0).get(1), ""));
    accounts.get(1).$$("div").shouldHave(texts(expectedAccounts.get(1).get(0),
        expectedAccounts.get(1).get(1)));

  }

  @When("^I transfer (\\d+) cny from \"([^\"]*)\" to \"([^\"]*)\"$")
  public void i_transfer_cny_from_to(BigDecimal amount, String from, String to) throws Throwable {
    IonicHelpers.open_side_menu();
    IonicHelpers.click_side_menu_item("Transfer");

    SelenideElement form = $("ion-side-menu-content").$("form");
    form.$("input").sendKeys(amount.toString());
    form.$("select[ng-model=\"from.accountNumber\"]").selectOption(from);
    form.$("select[ng-model=\"to.accountNumber\"]").selectOption(to);
    form.submit();
  }

  @Then("^my balance should be:$")
  public void my_balance_should_be(DataTable table) throws Throwable {
    IonicHelpers.open_side_menu();
    IonicHelpers.click_side_menu_item("Account");
    refresh();
    List<List<String>> expectedAccounts = table.asLists(String.class);

    ElementsCollection accounts = $("ion-side-menu-content").$("ion-content").$("ion-list").$$("ion-item");
    accounts.shouldHaveSize(2);

    accounts.get(0).$$("div").shouldHave(texts(expectedAccounts.get(0).get(0),
        expectedAccounts.get(0).get(1), ""));
    accounts.get(1).$$("div").shouldHave(texts(expectedAccounts.get(1).get(0),
        expectedAccounts.get(1).get(1)));
  }
}
