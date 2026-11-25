package character;

import exception.GameException;
import game.Game;
import game.Player;

//owner: Role 2 (character base + warrior)
//warrior: tough melee fighter, special is shield (50% off the next hit)
public class Warrior extends GameCharacter{

    //fields
    public static final int MAX_HP = 100;
    public static final int ATTACK = 25;
    public static final int MOVE_RANGE = 2;
    public static final int ATTACK_RANGE = 1;
    private boolean shielded; //on until hit or the owner's next turn

    //constructor
    public Warrior(String name, Player owner){
        super(name, owner, MAX_HP, ATTACK, MOVE_RANGE, ATTACK_RANGE);
    }

    //turns shield on, can't be used while shield or defend is already up
    @Override
    public String useSpecial(Game game, GameCharacter target) throws GameException{
        throw new UnsupportedOperationException("TODO (Role 2): throw AbilityUnavailableException if shielded or defending, else shielded = true");
    }

    @Override
    public boolean canUseSpecial(){
        throw new UnsupportedOperationException("TODO (Role 2): not shielded and not defending");
    }

    //shield takes 50% off (rounded down), then it ends
    @Override
    protected int reduceDamage(int damage){
        throw new UnsupportedOperationException("TODO (Role 2): if shielded, damage - damage * 50 / 100 and shielded = false, else super.reduceDamage");
    }

    //shield runs out at the start of the owner's next turn
    @Override
    public void startTurn(){
        throw new UnsupportedOperationException("TODO (Role 2): super.startTurn(), shielded = false");
    }

    @Override
    public boolean isShielded(){
        return shielded;
    }

    @Override
    public boolean specialNeedsTarget(){
        return false;
    }

    @Override
    public String getSpecialName(){
        return "Shield";
    }

    @Override
    public String getType(){
        return "Warrior";
    }

    @Override
    public char getLetter(){
        return 'W';
    }
}
