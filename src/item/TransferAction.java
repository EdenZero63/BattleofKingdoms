package item;

import action.Action;
import character.GameCharacter;
import exception.GameException;
import game.Game;

//owner: Role 6 (trading and inventory)
//gives one item to a friendly character standing right next to the actor
public class TransferAction implements Action{

    //fields
    private GameCharacter receiver;
    private Item item;

    //constructor
    public TransferAction(GameCharacter receiver, Item item){
        this.receiver = receiver;
        this.item = item;
    }

    @Override
    public String execute(Game game, GameCharacter actor) throws GameException{
        throw new UnsupportedOperationException("TODO (Role 6): same owner, both alive, distance 1, receiver not full, then move the item");
    }

    @Override
    public String getName(){
        return "Transfer Item";
    }
}
