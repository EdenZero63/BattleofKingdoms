package exception;

//owner: shared (every role throws a subclass of this)
//base for all game rule errors, ui catches it and the player tries again
public class GameException extends Exception{

    //constructor
    public GameException(String message){
        super(message);
    }
}
