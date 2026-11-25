package ui;

import board.Battlefield;
import game.Game;

//owner: Role 8 (console ui)
//turns the battlefield into text: W A M for p1, w a m for p2, X for obstacles, . for empty
public class BoardRenderer{

    //the 8x8 grid with row and col numbers on the sides
    public String render(Battlefield field){
        throw new UnsupportedOperationException("TODO (Role 8): build the grid with a StringBuilder");
    }

    //turn number, whose turn it is, and every character's hp, items and special status
    public String renderStatus(Game game){
        throw new UnsupportedOperationException("TODO (Role 8): status panel for both players");
    }
}
