package es.ulpgc.eite.restaurantmenu;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import android.os.Bundle;
import android.widget.TextView;

import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;

import es.ulpgc.eite.restaurantmenu.items.ItemsActivity;
import es.ulpgc.eite.restaurantmenu.sections.SectionsActivity;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Created by Luis on mayo, 2022
 */
public class MenuRobolectricSteps {


  private ActivityController<ItemsActivity> itemTestCtrl;
  private ActivityController<SectionsActivity> sectionTestCtrl;


  @Given("app start screen {string}")
  public void appStartScreen(String screen) {

    if(screen.contains("Sections")) {
      sectionTestCtrl = Robolectric.buildActivity(SectionsActivity.class);
      sectionTestCtrl.create().resume().visible();

    }

    if(screen.contains("Items")) {
      sectionTestCtrl.pause();

      itemTestCtrl = Robolectric.buildActivity(ItemsActivity.class);
      itemTestCtrl.create().resume().visible();

    }
  }


  @Then("app resume screen {string}")
  public void appResumeScreen(String screen) {

    if(screen.contains("Sections")) {
      sectionTestCtrl.resume();
    }
  }

  @When("user press back on screen {string}")
  public void userPressBackOnScreen(String screen) {

    if(screen.contains("Items")) {
      ItemsActivity activity = itemTestCtrl.get();
      activity.onBackPressed();
    }

  }


  @When("user press section {string}")
  public void userPressSection(String section) {

    SectionsActivity activity = sectionTestCtrl.get();

    if(section.contains("Starters")) {
      activity.findViewById(R.id.btnStarters).performClick();
    }

    if(section.contains("Courses")) {
      activity.findViewById(R.id.btnMainCourses).performClick();
    }

    if(section.contains("Desserts")) {
      activity.findViewById(R.id.btnDesserts).performClick();
    }

  }


  @And("app show text {string} on section {string}")
  public void appShowTextOnSection(String text, String section) {


    SectionsActivity activity = sectionTestCtrl.get();

    if(section.contains("Starters")) {
      TextView tv = activity.findViewById(R.id.tvItemStarters);
      assertThat(tv.getText().toString(), equalTo(text));

    }

    if(section.contains("Courses")) {
      TextView tv = activity.findViewById(R.id.tvItemMainCourses);
      assertThat(tv.getText().toString(), equalTo(text));
    }

    if(section.contains("Desserts")) {

      TextView tv = activity.findViewById(R.id.tvItemDesserts);
      assertThat(tv.getText().toString(), equalTo(text));
    }
  }

  @And("app show price {string} on section {string}")
  public void appShowPriceOnSection(String price, String section) {

    SectionsActivity activity = sectionTestCtrl.get();

    if(section.contains("Starters")) {
      TextView tv = activity.findViewById( R.id.tvPriceStarters);
      assertThat(tv.getText().toString(), equalTo(price));

    }

    if(section.contains("Courses")) {
      TextView tv = activity.findViewById(R.id.tvPriceMainCourses);
      assertThat(tv.getText().toString(), equalTo(price));
    }

    if(section.contains("Desserts")) {
      TextView tv = activity.findViewById(R.id.tvPriceDesserts);
      assertThat(tv.getText().toString(), equalTo(price));
    }

    if(section.contains("Total")) {
      TextView tv = activity.findViewById(R.id.tvPriceMenu);
      assertThat(tv.getText().toString(), equalTo(price));
    }
  }



  @And("app show price {string} on item {string}")
  public void appShowPriceOnItem(String price, String item) {

    ItemsActivity activity = itemTestCtrl.get();

    if(item.contains("First")) {
      TextView tv = activity.findViewById(R.id.tvPriceFirst);
      assertThat(tv.getText().toString(), equalTo(price));
    }

    if(item.contains("Second")) {
      TextView tv = activity.findViewById(R.id.tvPriceSecond);
      assertThat(tv.getText().toString(), equalTo(price));
    }
  }

  @When("user press item {string}")
  public void userPressItem(String item) {

    ItemsActivity activity = itemTestCtrl.get();

    if(item.contains("First")) {
      activity.findViewById(R.id.btnFirst).performClick();
    }

    if(item.contains("Second")) {
      activity.findViewById(R.id.btnSecond).performClick();
    }
  }



  @When("user rotate screen {string}")
  public void userRotateScreen(String screen) {


    Bundle bundle = new Bundle();

    if(screen.equals("Sections")) {
      sectionTestCtrl
          .saveInstanceState(bundle)
          .pause()
          .stop()
          .destroy();

      sectionTestCtrl = Robolectric.buildActivity(SectionsActivity.class)
          .create(bundle)
          .restoreInstanceState(bundle)
          .resume()
          .visible();
    }

    if(screen.equals("Items")) {
      itemTestCtrl
          .saveInstanceState(bundle)
          .pause()
          .stop()
          .destroy();

      itemTestCtrl = Robolectric.buildActivity(ItemsActivity.class)
          .create(bundle)
          .restoreInstanceState(bundle)
          .resume()
          .visible();

    }

  }

  /*
  public void resetTest() {
      AppMediator.resetInstance();
  }
  */

}
