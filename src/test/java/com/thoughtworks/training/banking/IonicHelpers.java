package com.thoughtworks.training.banking;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by yqin on 7/18/16.
 */
public class IonicHelpers {
  public static void open_side_menu() {
    $("div.nav-bar-block[nav-bar=\"active\"]").$("button.button.button-icon.button-clear.ion-navicon").click();
  }

  public static void click_side_menu_item(String itemText) {
    $("ion-side-menu").$("ion-list").$$("ion-item").find(Condition.exactText(itemText)).click();
  }
}
