package com.thoughtworks.training.banking.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import com.thoughtworks.training.banking.IonicHelpers;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by yqin on 7/18/16.
 */
public class AccountStepdefs {
  @Given("^a user has 2 accounts$")
  public void a_user_has_more_than_one_account() throws Throwable {
    IonicHelpers.open_side_menu();
    IonicHelpers.click_side_menu_item("Login");

    $("ion-modal-view").$("select").selectOptionByValue("heaton");
    $("ion-modal-view").$("form").submit();
  }

  @When("^I refresh account$")
  public void i_refresh_account() throws Throwable {
    WebDriverRunner.getWebDriver().navigate().refresh();
  }

  @Then("^I should see accounts and balances:$")
  public void i_should_see_accounts(DataTable table) throws Throwable {
    List<Map<String, String>> accountsBalancesMap = table.asMaps(String.class, String.class);
    Map<String, String> account0 = accountsBalancesMap.get(0);
    Map<String, String> account1 = accountsBalancesMap.get(1);

    ElementsCollection accounts = $("ion-side-menu-content").$("ion-content").$("ion-list").$$("ion-item");
    accounts.shouldHaveSize(2);

    accounts.get(0).$$("div").shouldHaveSize(3).shouldHave(exactTexts(account0.get("account"),
        account0.get("cny balance"),
        account0.get("usd balance")));

    accounts.get(1).$$("div").shouldHaveSize(2).shouldHave(exactTexts(account1.get("account"),
        account1.get("cny balance")));
  }
}
