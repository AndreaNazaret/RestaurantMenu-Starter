package es.ulpgc.eite.restaurantmenu;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import android.content.pm.ActivityInfo;
import android.os.RemoteException;

import androidx.test.uiautomator.UiDevice;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenuEspressoSteps {

    @Given("app start screen {string}")
    public void appStartScreen(String screen) {

        try {

            Thread.sleep(1000);

        } catch (Exception e) {

        }
    }

    @And("app show text {string} on section {string}")
    public void appShowTextOnSection(String text, String section) {
        int sectionId = getSectionId(section);
        onView(withId(sectionId)).check(matches(withText(text)));
    }

    @And("app show price {string} on section {string}")
    public void appShowPriceOnSection(String price, String section) {
        int priceId = getSectionPriceId(section);
        onView(withId(priceId)).check(matches(withText(price)));
    }

    /*
    public void appShowTextOnItem(String text, String item) {
        int itemId = getItemId(item);
        onView(withId(itemId)).check(matches(withText(text)));
    }
    */

    @And("app show price {string} on item {string}")
    public void appShowPriceOnItem(String price, String item) {
        int priceId = getItemPriceId(item);
        onView(withId(priceId)).check(matches(withText(price)));
    }

    @When("user press section {string}")
    public void userPressSection(String section) {
        int sectionId = getPressedSectionId(section);
        onView(withId(sectionId)).perform(click());
    }

    @When("user press item {string}")
    public void userPressItem(String item) {
        int itemId = getPressedItemId(item);
        onView(withId(itemId)).perform(click());
    }

    @And("user rotate screen")
    public void userRotateScreen(int orientation) {

        try {

            UiDevice device = UiDevice.getInstance(getInstrumentation());

            if (orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                device.setOrientationNatural();

            } else {
                device.setOrientationLeft();
            }

        } catch (RemoteException e) {
        }

    }

    @Then("app resume screen {string}")
    public void appResumeScreen(String screen) {
        appStartScreen(screen);
    }

    @When("user press back on screen {string}")
    public void userPressBackOnScreen(String screen) {
        pressBack();
    }

    /*
    public void resetTest() {
        AppMediator.resetInstance();
    }
    */

    private int getPressedSectionId(String section) {
        switch(section) {
            case "Starters":
                return R.id.btnStarters;
            case "Main Courses":
                return R.id.btnMainCourses;
            case "Desserts":
                return R.id.btnDesserts;
            default:
                return -1;
        }
    }

    private int getSectionId(String section) {
        switch(section) {
            case "Starters":
                return R.id.tvItemStarters;
            case "Main Courses":
                return R.id.tvItemMainCourses;
            case "Desserts":
                return R.id.tvItemDesserts;
            case "Total Price":
                return R.id.tvTotalPrice;
            default:
                return -1;
        }
    }

    private int getSectionPriceId(String section) {
        switch(section) {
            case "Starters":
                return R.id.tvPriceStarters;
            case "Main Courses":
                return R.id.tvPriceMainCourses;
            case "Desserts":
                return R.id.tvPriceDesserts;
            case "Total Price":
                return R.id.tvPriceMenu;
            default:
                return -1;
        }
    }

    private int getPressedItemId(String item) {
        switch(item) {
            case "First Starter":
                return R.id.btnFirst;
            case "Second Starter":
                return R.id.btnSecond;
            case "First Main Course":
                return R.id.btnFirst;
            case "Second Main Course":
                return R.id.btnSecond;
            case "First Dessert":
                return R.id.btnFirst;
            case "Second Dessert":
                return R.id.btnSecond;
            default:
                return -1;
        }
    }


    private int getItemId(String item) {
        switch(item) {
            case "First Starter":
                return R.id.tvNameFirst;
            case "Second Starter":
                return R.id.tvNameSecond;
            case "First Main Course":
                return R.id.tvNameFirst;
            case "Second Main Course":
                return R.id.tvNameSecond;
            case "First Dessert":
                return R.id.tvNameFirst;
            case "Second Dessert":
                return R.id.tvNameSecond;
            default:
                return -1;
        }
    }

    private int getItemPriceId(String item) {
        switch(item) {
            case "First Starter":
                return R.id.tvPriceFirst;
            case "Second Starter":
                return R.id.tvPriceSecond;
            case "First Main Course":
                return R.id.tvPriceFirst;
            case "Second Main Course":
                return R.id.tvPriceSecond;
            case "First Dessert":
                return R.id.tvPriceFirst;
            case "Second Dessert":
                return R.id.tvPriceSecond;
            default:
                return -1;
        }
    }

}
