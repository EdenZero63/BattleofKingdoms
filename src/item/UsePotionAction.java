package item;

import action.Action;
import character.GameCharacter;
import exception.GameException;
import game.Game;

//owner: Role 6 (trading and inventory)
//uses an item from the actor's own inventory, then it's gone
public class UsePotionAction implements Action{

    //fields
    private Item item;

    //constructor
    public UsePotionAction(Item item){
        this.item = item;
    }

    @Override
    public String execute(Game game, GameCharacter actor) throws GameException{
        throw new UnsupportedOperationException("TODO (Role 6): item must be in actor's inventory, item.use(actor), then remove it");
    }

    @Override
    public String getName(){
        return "Use Potion";
    }
}
