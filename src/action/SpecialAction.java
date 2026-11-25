package action;

import character.GameCharacter;
import exception.GameException;
import game.Game;

//owner: Role 5 (attacking and defending)
//uses the character's special, each type does its own thing (polymorphism)
public class SpecialAction implements Action{

    //fields
    private GameCharacter target; //null for the warrior's shield

    //constructor
    public SpecialAction(GameCharacter target){
        this.target = target;
    }

    @Override
    public String execute(Game game, GameCharacter actor) throws GameException{
        throw new UnsupportedOperationException("TODO (Role 5): throw AbilityUnavailableException if !actor.canUseSpecial(), else return actor.useSpecial(game, target)");
    }

    @Override
    public String getName(){
        return "Special Ability";
    }
}
