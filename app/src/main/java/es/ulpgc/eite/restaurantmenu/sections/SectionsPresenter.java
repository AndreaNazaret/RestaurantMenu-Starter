package es.ulpgc.eite.restaurantmenu.sections;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.restaurantmenu.app.AppMediator;
import es.ulpgc.eite.restaurantmenu.app.ItemsToSectionsState;
import es.ulpgc.eite.restaurantmenu.data.MenuItem;
import es.ulpgc.eite.restaurantmenu.data.MenuItems;
import es.ulpgc.eite.restaurantmenu.data.MenuSection;
import es.ulpgc.eite.restaurantmenu.app.SectionsToItemsState;

/**
 * Created by Luis on marzo, 2022
 */
public class SectionsPresenter implements SectionsContract.Presenter {

  public static String TAG = "RestaurantMenu.SectionsPresenter";

  private WeakReference<SectionsContract.View> view;
  private SectionsState state;
  private SectionsContract.Model model;
  private AppMediator mediator;

  public SectionsPresenter(AppMediator mediator) {
    this.mediator = mediator;

  }

  @Override
  public void onCreateCalled() {
    Log.e(TAG, "onCreateCalled()");

    // initialize the state 
    state = new SectionsState();

    // call the model and update the state
    // TODO: insert code if necessary


  }

  @Override
  public void onRecreateCalled() {
    Log.e(TAG, "onRecreateCalled()");

    // get the saved state
    state = mediator.getSectionsState();
    // TODO: insert code if necessary

    // update the model if is necessary
    // TODO: insert code if necessary
    if (state == null) {
      state = new SectionsState();
    }

    model.setSelectedPrices(mediator.getSelectedPrices());

    view.get().onDataUpdated(state);

  }


  @Override
  public void onResumeCalled() {
    Log.e(TAG, "onResumeCalled()");

    // TODO: insert code if necessary

    ItemsToSectionsState savedState = getStateFromNextScreen();
    if (savedState != null && savedState.itemSection != null) {
      // Guardamos directamente los 3 ítems en el modelo
      model.onDataFromPreviousScreen(savedState.itemSection);
    }

    // Recuperamos los ítems seleccionados para actualizar la vista
    MenuItems selectedPrices = model.getSelectedPrices();

    int totalPrice = 0;

    if (selectedPrices != null) {
      if (selectedPrices.itemsStarters != null && !selectedPrices.itemsStarters.isEmpty()) {
        state.itemStarters = selectedPrices.itemsStarters.get(0);
        totalPrice += state.itemStarters.itemPrice;
      }
      if (selectedPrices.itemsMainCourses != null && !selectedPrices.itemsMainCourses.isEmpty()) {
        state.itemMainCourses = selectedPrices.itemsMainCourses.get(0);
        totalPrice += state.itemMainCourses.itemPrice;
      }
      if (selectedPrices.itemsDesserts != null && !selectedPrices.itemsDesserts.isEmpty()) {
        state.itemDesserts = selectedPrices.itemsDesserts.get(0);
        totalPrice += state.itemDesserts.itemPrice;
      }
    }

    state.priceMenu = totalPrice;

    // Actualizamos la vista con los nuevos valores de precio
    view.get().onDataUpdated(state);


  }

  @Override
  public void onBackPressedCalled() {
    // Log.e(TAG, "onBackPressedCalled()");

    // TODO: insert code if necessary
  }


  @Override
  public void onPauseCalled() {
    Log.e(TAG, "onPauseCalled()");

    mediator.setSectionsState(state);

    mediator.setSelectedPrices(model.getSelectedPrices());
  }

  @Override
  public void onDestroyCalled() {
    // Log.e(TAG, "onDestroyCalled()");
  }

  @Override
  public void onStartersBtnClicked() {
    Log.e(TAG, "onStartersBtnClicked()");

    // TODO: insert code if necessary
    SectionsToItemsState newState = new SectionsToItemsState();
    MenuItems menuData = model.getStoredData();

    if (menuData.itemsStarters != null) {
      for (MenuItem item : menuData.itemsStarters) {
        item.itemSection = MenuSection.Starters;
      }
    }

    newState.itemsSection = menuData.itemsStarters;

    passStateToNextScreen(newState);

    view.get().navigateToNextScreen();

  }

  @Override
  public void onMainCoursesBtnClicked() {
    Log.e(TAG, "onMainCoursesBtnClicked()");

    // TODO: insert code if necessary
    SectionsToItemsState newState = new SectionsToItemsState();
    MenuItems menuData = model.getStoredData();

    if (menuData.itemsMainCourses != null) {
      for (MenuItem item : menuData.itemsMainCourses) {
        item.itemSection = MenuSection.MainCourses;
      }
    }

    newState.itemsSection = menuData.itemsMainCourses;

    passStateToNextScreen(newState);

    view.get().navigateToNextScreen();

  }

  @Override
  public void onDessertsBtnClicked() {
    Log.e(TAG, "onDessertsBtnClicked()");


    // TODO: insert code if necessary
    SectionsToItemsState newState = new SectionsToItemsState();
    MenuItems menuData = model.getStoredData();

    if (menuData.itemsDesserts != null) {
      for (MenuItem item : menuData.itemsDesserts) {
        item.itemSection = MenuSection.Desserts;
      }
    }

    newState.itemsSection = menuData.itemsDesserts;

    passStateToNextScreen(newState);

    view.get().navigateToNextScreen();

  }

  private ItemsToSectionsState getStateFromNextScreen() {
    return mediator.getItemsToSectionsState();
  }

  private void passStateToNextScreen(SectionsToItemsState state) {
    mediator.setSectionsToItemsState(state);
  }


  @Override
  public void injectView(WeakReference<SectionsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(SectionsContract.Model model) {
    this.model = model;
  }

}
