package app;

import game.Game;
import game.Setup;
import ui.ConsoleUI;

//owner: Role 7 (game flow)
//starts the game: builds the default setup and hands it to the console ui
public class Main{

    public static void main(String[] args){
        try{
            Game game = Setup.createDefault();
            ConsoleUI ui = new ConsoleUI(game);
            ui.run();
        }catch(UnsupportedOperationException e){
            //skeleton only for now, this shows which part still needs building
            System.out.println("Not built yet: " + e.getMessage());
        }
    }
}
