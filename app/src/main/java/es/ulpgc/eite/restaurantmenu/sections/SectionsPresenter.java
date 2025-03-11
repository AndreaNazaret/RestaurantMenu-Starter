package es.ulpgc.eite.restaurantmenu.sections;

import android.util.Log;

import java.lang.ref.WeakReference;

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
    // TODO: insert code if necessary

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

  }


  @Override
  public void onResumeCalled() {
    Log.e(TAG, "onResumeCalled()");

    // use passed state if is necessary
    ItemsToSectionsState savedState = getStateFromNextScreen();
    if (savedState != null) {

      // update the model if is necessary
      // TODO: insert code if necessary

      // update the state if is necessary
      // TODO: insert code if necessary

    }

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
    Log.e(TAG, "onPauseCalled()");

    mediator.setSectionsState(state);
  }

  @Override
  public void onDestroyCalled() {
    // Log.e(TAG, "onDestroyCalled()");
  }

  @Override
  public void onStartersBtnClicked() {

    // TODO: insert code if necessary
  }

  @Override
  public void onMainCoursesBtnClicked() {

    // TODO: insert code if necessary
  }

  @Override
  public void onDessertsBtnClicked() {

    // TODO: insert code if necessary
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
