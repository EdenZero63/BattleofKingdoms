package action;

import character.GameCharacter;
import exception.GameException;
import game.Game;

//owner: Role 5 (attacking and defending)
//pass: does nothing and ends the turn
public class PassAction implements Action{

    @Override
    public String execute(Game game, GameCharacter actor) throws GameException{
        throw new UnsupportedOperationException("TODO (Role 5): return a message like \"Warrior passes\"");
    }

    @Override
    public String getName(){
        return "Pass";
    }
}
