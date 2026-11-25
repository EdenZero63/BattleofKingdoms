package exception;

//owner: Roles 2-4 (characters)
//special on cooldown, out of heals, or shield/defend already up
public class AbilityUnavailableException extends GameException{

    //constructor
    public AbilityUnavailableException(String message){
        super(message);
    }
}
