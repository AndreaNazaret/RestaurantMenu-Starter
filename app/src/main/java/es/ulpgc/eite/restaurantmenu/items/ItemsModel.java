package es.ulpgc.eite.restaurantmenu.items;

import java.util.List;

import es.ulpgc.eite.restaurantmenu.data.MenuItem;

/**
 * Created by Luis on marzo, 2022
 */
public class ItemsModel implements ItemsContract.Model {

  public static String TAG = "RestaurantMenu.ItemsModel";

  private List<MenuItem> data;


  public ItemsModel() {
    //data=new ArrayList<>();
  }

  @Override
  public List<MenuItem> getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return data;
  }

  @Override
  public void onRestartScreen(List<MenuItem> data) {
    // Log.e(TAG, "onRestartScreen()");
  }

  @Override
  public void onDataFromNextScreen(List<MenuItem> data) {
    // Log.e(TAG, "onDataFromNextScreen()");
  }

  @Override
  public void onDataFromPreviousScreen(List<MenuItem> data) {
    // Log.e(TAG, "onDataFromPreviousScreen()");

  }
}