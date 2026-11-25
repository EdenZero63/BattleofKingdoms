package board;

//owner: Role 1 (map and movement)
//a square on the battlefield, row 0-7 and col 0-7
public class Position{

    //fields
    private final int row;
    private final int col;

    //constructor
    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    //steps between two squares, no diagonals (|dr| + |dc|)
    public int distanceTo(Position other){
        throw new UnsupportedOperationException("TODO (Role 1): return |row diff| + |col diff|");
    }

    //true when both squares are on the same row or the same column
    public boolean isInLineWith(Position other){
        throw new UnsupportedOperationException("TODO (Role 1): same row or same column");
    }

    //TODO (Role 1): override equals and hashCode so Position works as a HashMap key in BFS
    //TODO (Role 1): override toString, e.g. "(2,3)"

    //getters
    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }
}
