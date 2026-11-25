package exception;

//owner: Role 5 (attacking and defending)
//target is an ally, eliminated, out of range, or blocked
public class InvalidTargetException extends GameException{

    //constructor
    public InvalidTargetException(String message){
        super(message);
    }
}
