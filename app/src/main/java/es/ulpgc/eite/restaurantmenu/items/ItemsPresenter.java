package es.ulpgc.eite.restaurantmenu.items;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.restaurantmenu.app.AppMediator;
import es.ulpgc.eite.restaurantmenu.app.ItemsToSectionsState;
import es.ulpgc.eite.restaurantmenu.app.SectionsToItemsState;

/**
 * Created by Luis on marzo, 2022
 */
public class ItemsPresenter implements ItemsContract.Presenter {

  public static String TAG = "RestaurantMenu.ItemsPresenter";

  private WeakReference<ItemsContract.View> view;
  private ItemsState state;
  private ItemsContract.Model model;
  private AppMediator mediator;

  public ItemsPresenter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void onCreateCalled() {
    Log.e(TAG, "onCreateCalled()");

    // initialize the state 
    state = new ItemsState();
    // TODO: insert code if necessary

    // call the model and update the state
    // TODO: insert code if necessary

    // use passed state if is necessary
    SectionsToItemsState savedState = getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model if is necessary
      // TODO: insert code if necessary

      // update the state if is necessary
      // TODO: insert code if necessary

    }
  }

  @Override
  public void onRecreateCalled() {
    Log.e(TAG, "onRecreateCalled()");

    // get the saved state
    // TODO: insert code if necessary

    // update the model if is necessary
    // TODO: insert code if necessary
  }

  @Override
  public void onResumeCalled() {
    Log.e(TAG, "onResumeCalled()");

    // call the model and update the state
    // TODO: insert code if necessary

    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressedCalled() {
    // Log.e(TAG, "onBackPressedCalled()");

    // TODO: insert code if necessary
  }

  @Override
  public void onPauseCalled() {
    // Log.e(TAG, "onPauseCalled()");

    mediator.setItemsState(state);
  }

  @Override
  public void onDestroyCalled() {
    // Log.e(TAG, "onDestroyCalled()");
  }


  @Override
  public void onFirstBtnClicked() {

    // TODO: insert code if necessary
  }

  @Override
  public void onSecondBtnClicked() {

    // TODO: insert code if necessary
  }


  private void passStateToPreviousScreen(ItemsToSectionsState state) {
    mediator.setItemsToSectionsState(state);
  }

  private SectionsToItemsState getStateFromPreviousScreen() {
    return mediator.getSectionsToItemsState();
  }

  @Override
  public void injectView(WeakReference<ItemsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ItemsContract.Model model) {
    this.model = model;
  }

}
