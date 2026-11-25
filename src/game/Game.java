package game;

import action.Action;
import board.Battlefield;
import board.MovementValidator;
import board.Position;
import character.GameCharacter;
import exception.GameException;
import exception.InvalidMoveException;

//owner: Role 7 (game flow)
//the whole game state: battlefield, both players, whose turn it is
//ui calls these methods, it never changes the state itself
public class Game{

    //fields
    private Battlefield battlefield;
    private MovementValidator validator;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private int turnNumber;
    private Player winner; //null until someone wins

    //constructor
    public Game(Battlefield battlefield, Player player1, Player player2){
        this.battlefield = battlefield;
        this.validator = new MovementValidator();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.turnNumber = 1;
    }

    public Player getOpponent(Player p){
        throw new UnsupportedOperationException("TODO (Role 7): the other player");
    }

    //checks the path then moves, nothing changes if the move is not allowed
    public void moveCharacter(GameCharacter c, Position to) throws InvalidMoveException{
        throw new UnsupportedOperationException("TODO (Role 7): must be current player's and alive, validator.checkMove, battlefield.moveCharacter");
    }

    //runs one action for the selected character and returns what happened for the ui
    //if it throws, the turn is not used up and the player picks again
    public String performAction(GameCharacter actor, Action action) throws GameException{
        throw new UnsupportedOperationException("TODO (Role 7): action.execute, then removeEliminated, add its messages");
    }

    //takes eliminated characters off the map, returns one message per elimination ("" if none)
    public String removeEliminated(){
        throw new UnsupportedOperationException("TODO (Role 7): for each eliminated character still on the map, battlefield.removeCharacter");
    }

    //end of turn: endTurn() on the current player's characters, check victory,
    //then switch players, turnNumber++, and startTurn() on the new player's characters
    public void endTurn(){
        throw new UnsupportedOperationException("TODO (Role 7): cooldowns, victory check, switch players");
    }

    public boolean isGameOver(){
        return winner != null;
    }

    //getters
    public Battlefield getBattlefield(){
        return battlefield;
    }

    public Player getPlayer1(){
        return player1;
    }

    public Player getPlayer2(){
        return player2;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public int getTurnNumber(){
        return turnNumber;
    }

    public Player getWinner(){
        return winner;
    }
}
