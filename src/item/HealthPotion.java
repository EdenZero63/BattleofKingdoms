package item;

import character.GameCharacter;
import exception.InventoryException;

//owner: Role 6 (trading and inventory)
//health potion: +30 hp, never over max, can't be used at full hp
public class HealthPotion implements Item{

    //fields
    public static final int HEAL_AMOUNT = 30;

    @Override
    public void use(GameCharacter user) throws InventoryException{
        throw new UnsupportedOperationException("TODO (Role 6): throw if user.isAtFullHealth(), else user.heal(HEAL_AMOUNT)");
    }

    @Override
    public String getName(){
        return "Health Potion";
    }
}
