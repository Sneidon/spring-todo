package za.co.mukondle.models;

import za.co.mukondle.entities.Item;
import javax.validation.Valid;

import java.util.ArrayList;

public class ItemListViewModel {
    @Valid
    private ArrayList<Item> items = new ArrayList<Item>();

    public ItemListViewModel() {
        this.items = new ArrayList<Item>();
    }

    public ItemListViewModel(Iterable<Item> items) {
        if(this.items != null) {
            items.forEach(this.items::add);
        }
    }

    public ItemListViewModel(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
