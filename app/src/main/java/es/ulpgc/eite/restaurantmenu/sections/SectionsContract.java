package es.ulpgc.eite.restaurantmenu.sections;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.restaurantmenu.data.MenuItem;
import es.ulpgc.eite.restaurantmenu.data.MenuItems;

/**
 * Created by Luis on marzo, 2022
 */
public interface SectionsContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(SectionsViewModel viewModel);

    void navigateToNextScreen();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void onResumeCalled();

    void onCreateCalled();

    void onRecreateCalled();

    void onBackPressedCalled();

    void onPauseCalled();

    void onDestroyCalled();

    void onStartersBtnClicked();

    void onMainCoursesBtnClicked();

    void onDessertsBtnClicked();
  }

  interface Model {
    MenuItems getStoredData();

    public void setSelectedPrices(MenuItems prices);

    void onDataFromNextScreen(MenuItems data);

    void onRestartScreen(MenuItems data);

    public MenuItems getSelectedPrices();

    void onDataFromPreviousScreen(MenuItem data);
  }

}
