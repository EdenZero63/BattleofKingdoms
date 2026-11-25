package exception;

//owner: Role 1 (map and movement)
//move is off the map, blocked, too far, or ends on someone
public class InvalidMoveException extends GameException{

    //constructor
    public InvalidMoveException(String message){
        super(message);
    }
}
