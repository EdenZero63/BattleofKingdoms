package action;

import character.GameCharacter;
import exception.GameException;
import game.Game;

//owner: Role 5 (attacking and defending)
//one thing a character does on its turn, Game runs it without knowing which kind it is
public interface Action{

    //does the action and returns a message for the ui
    //throws (and changes nothing) when it's not allowed, so the player can pick again
    String execute(Game game, GameCharacter actor) throws GameException;

    //name shown in the menu
    String getName();
}
