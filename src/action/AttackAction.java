package action;

import character.GameCharacter;
import exception.GameException;
import game.Game;

//owner: Role 5 (attacking and defending)
//normal attack: warrior and mage hit next to them, archer shoots up to 3 in a straight clear line
public class AttackAction implements Action{

    //fields
    private GameCharacter target;

    //constructor
    public AttackAction(GameCharacter target){
        this.target = target;
    }

    @Override
    public String execute(Game game, GameCharacter actor) throws GameException{
        throw new UnsupportedOperationException("TODO (Role 5): no allies, no eliminated, in line, in range, isLineClear, then target.takeDamage(actor.getAttack())");
    }

    @Override
    public String getName(){
        return "Attack";
    }
}
