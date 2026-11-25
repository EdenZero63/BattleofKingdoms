package game;

import character.GameCharacter;
import java.util.ArrayList;

//owner: Role 7 (game flow)
//one of the two players and their 3 characters
public class Player{

    //fields
    private String name;
    private int number; //1 or 2
    private ArrayList<GameCharacter> characters;

    //constructor
    public Player(String name, int number){
        this.name = name;
        this.number = number;
        this.characters = new ArrayList<GameCharacter>();
    }

    //used by Setup
    public void addCharacter(GameCharacter c){
        throw new UnsupportedOperationException("TODO (Role 7): add c to characters");
    }

    //characters still on the map
    public ArrayList<GameCharacter> getAliveCharacters(){
        throw new UnsupportedOperationException("TODO (Role 7): new list with every character that is not eliminated");
    }

    //false once all 3 are eliminated
    public boolean hasSurvivors(){
        throw new UnsupportedOperationException("TODO (Role 7): at least one character not eliminated");
    }

    //getters
    public String getName(){
        return name;
    }

    public int getNumber(){
        return number;
    }

    public ArrayList<GameCharacter> getCharacters(){
        return characters;
    }
}
