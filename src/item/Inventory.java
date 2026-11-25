package item;

import exception.InventoryException;
import java.util.ArrayList;

//owner: Role 6 (trading and inventory)
//each character's own bag, holds at most 3 items
public class Inventory{

    //fields
    public static final int CAPACITY = 3;
    private ArrayList<Item> items;

    //constructor
    public Inventory(){
        this.items = new ArrayList<Item>();
    }

    //throws when the bag is full
    public void add(Item item) throws InventoryException{
        throw new UnsupportedOperationException("TODO (Role 6): throw if isFull(), else items.add(item)");
    }

    //throws when the item isn't in here
    public void remove(Item item) throws InventoryException{
        throw new UnsupportedOperationException("TODO (Role 6): throw if missing, else items.remove(item)");
    }

    public boolean isFull(){
        throw new UnsupportedOperationException("TODO (Role 6): items.size() >= CAPACITY");
    }

    public boolean isEmpty(){
        throw new UnsupportedOperationException("TODO (Role 6): items.size() == 0");
    }

    //first item with this name, null if there isn't one
    public Item findByName(String name){
        throw new UnsupportedOperationException("TODO (Role 6): loop items, compare getName()");
    }

    //getters
    //a copy, so nobody can add items without the capacity check
    public ArrayList<Item> getItems(){
        return new ArrayList<Item>(items);
    }
}
