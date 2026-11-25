package ui;

import board.Position;
import java.util.Scanner;

//owner: Role 8 (console ui)
//reads what the players type so bad input never crashes us
public class InputHelper{

    //fields
    private Scanner scanner;

    //constructor
    public InputHelper(){
        this.scanner = new Scanner(System.in);
    }

    //keeps asking until we get a whole number between min and max
    public int readInt(String prompt, int min, int max){
        throw new UnsupportedOperationException("TODO (Role 8): loop, Integer.parseInt in a try/catch NumberFormatException");
    }

    //asks for "row col", both 0-7
    public Position readPosition(String prompt){
        throw new UnsupportedOperationException("TODO (Role 8): read two numbers 0-7, return new Position");
    }

    //y/n question
    public boolean readYesNo(String prompt){
        throw new UnsupportedOperationException("TODO (Role 8): keep asking until y or n");
    }

    //closes the scanner when the game exits
    public void close(){
        scanner.close();
    }
}
