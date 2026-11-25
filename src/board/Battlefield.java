package board;

import character.GameCharacter;
import exception.InvalidMoveException;

//owner: Role 1 (map and movement)
//the 8x8 grid: where the obstacles are and who stands on each square
public class Battlefield{

    //fields
    public static final int SIZE = 8;
    private GameCharacter[][] squares; //null when empty
    private boolean[][] obstacles;

    //constructor
    public Battlefield(){
        squares = new GameCharacter[SIZE][SIZE];
        obstacles = new boolean[SIZE][SIZE];
    }

    //false for anything off the map
    public boolean isInside(Position pos){
        throw new UnsupportedOperationException("TODO (Role 1): row and col both 0 to SIZE-1");
    }

    public boolean isObstacle(Position pos){
        throw new UnsupportedOperationException("TODO (Role 1): check obstacles[row][col]");
    }

    //inside the map, no obstacle, nobody standing there
    public boolean isFree(Position pos){
        throw new UnsupportedOperationException("TODO (Role 1): inside, not an obstacle, not occupied");
    }

    //null when the square is empty
    public GameCharacter getCharacterAt(Position pos){
        throw new UnsupportedOperationException("TODO (Role 1): return squares[row][col]");
    }

    //used by Setup at the start
    public void addObstacle(Position pos){
        throw new UnsupportedOperationException("TODO (Role 1): mark the square as an obstacle");
    }

    //puts a character on an empty square and sets its position
    public void placeCharacter(GameCharacter c, Position pos) throws InvalidMoveException{
        throw new UnsupportedOperationException("TODO (Role 1): check isFree, set the square, c.setPosition(pos)");
    }

    //moves a character, the path was already checked by MovementValidator
    public void moveCharacter(GameCharacter c, Position to) throws InvalidMoveException{
        throw new UnsupportedOperationException("TODO (Role 1): clear the old square, fill the new one, c.setPosition(to)");
    }

    //takes an eliminated character off the map
    public void removeCharacter(GameCharacter c){
        throw new UnsupportedOperationException("TODO (Role 1): clear its square, c.setPosition(null)");
    }

    //true when nothing stands between from and to (same row or col only)
    //used by archer attacks and power shot
    public boolean isLineClear(Position from, Position to){
        throw new UnsupportedOperationException("TODO (Role 1): walk the squares in between, any obstacle or character blocks it");
    }
}
