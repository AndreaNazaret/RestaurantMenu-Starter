package es.ulpgc.eite.restaurantmenu.items;

import java.util.List;

import es.ulpgc.eite.restaurantmenu.data.MenuItem;

/**
 * Created by Luis on marzo, 2022
 */
public class ItemsState extends ItemsViewModel {

  // put the model state here
  public List<MenuItem> items;
  public MenuItem selectedItem;
}
