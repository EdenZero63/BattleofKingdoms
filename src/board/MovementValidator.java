package board;

import exception.InvalidMoveException;

//owner: Role 1 (map and movement)
//checks a move with BFS: a real path around obstacles and characters, within the move range
public class MovementValidator{

    //true when 'to' can be reached from 'from' in maxSteps steps or less
    public boolean canReach(Battlefield field, Position from, Position to, int maxSteps){
        throw new UnsupportedOperationException("TODO (Role 1): BFS with a LinkedList queue, skip obstacles and occupied squares");
    }

    //throws with a message that says why the move is not allowed
    public void checkMove(Battlefield field, Position from, Position to, int maxSteps) throws InvalidMoveException{
        throw new UnsupportedOperationException("TODO (Role 1): off the map / obstacle / occupied / too far -> InvalidMoveException");
    }
}
