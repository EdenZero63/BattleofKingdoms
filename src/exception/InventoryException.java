package exception;

//owner: Role 6 (trading and inventory)
//inventory full, item missing, or a bad transfer
public class InventoryException extends GameException{

    //constructor
    public InventoryException(String message){
        super(message);
    }
}
