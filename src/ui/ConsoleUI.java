package ui;

import action.Action;
import character.GameCharacter;
import game.Game;

//owner: Role 8 (console ui)
//the main loop: show the board, pick a character, move, pick an action, repeat
//only shows stuff and passes choices to Game, no game rules in here
public class ConsoleUI{

    //fields
    private Game game;
    private InputHelper input;
    private BoardRenderer renderer;

    //constructor
    public ConsoleUI(Game game){
        this.game = game;
        this.input = new InputHelper();
        this.renderer = new BoardRenderer();
    }

    //runs until someone wins or a player picks exit
    public void run(){
        throw new UnsupportedOperationException("TODO (Role 8): loop until game.isGameOver(), close input at the end");
    }

    //lists the current player's alive characters and returns the one they pick
    private GameCharacter pickCharacter(){
        throw new UnsupportedOperationException("TODO (Role 8): numbered list with hp, readInt");
    }

    //asks for a square (or skip) and calls game.moveCharacter, retries on InvalidMoveException
    private void askMove(GameCharacter c){
        throw new UnsupportedOperationException("TODO (Role 8): readPosition, catch InvalidMoveException and ask again");
    }

    //builds the Action they picked: attack, special, potion, transfer, defend or pass
    private Action pickAction(GameCharacter c){
        throw new UnsupportedOperationException("TODO (Role 8): action menu, ask for a target or item when needed");
    }
}
