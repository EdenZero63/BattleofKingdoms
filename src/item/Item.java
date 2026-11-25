package item;

import character.GameCharacter;
import exception.InventoryException;

//owner: Role 6 (trading and inventory)
//anything a character can carry, a new item type just implements this
public interface Item{

    //name shown in the inventory
    String getName();

    //uses the item on a character, throws if it can't be used (e.g. potion at full hp)
    void use(GameCharacter user) throws InventoryException;
}
