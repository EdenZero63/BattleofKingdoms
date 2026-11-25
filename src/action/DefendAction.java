package action;

import character.GameCharacter;
import exception.GameException;
import game.Game;

//owner: Role 5 (attacking and defending)
//defend: 25% off the next hit, can't be stacked with the warrior's shield
public class DefendAction implements Action{

    @Override
    public String execute(Game game, GameCharacter actor) throws GameException{
        throw new UnsupportedOperationException("TODO (Role 5): actor.defend(), return a message");
    }

    @Override
    public String getName(){
        return "Defend";
    }
}
