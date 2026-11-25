package character;

import exception.GameException;
import game.Game;
import game.Player;

//owner: Role 3 (archer)
//archer: ranged fighter, special is power shot (35 damage, range 3, then a cooldown)
public class Archer extends GameCharacter{

    //fields
    public static final int MAX_HP = 70;
    public static final int ATTACK = 20;
    public static final int MOVE_RANGE = 3;
    public static final int ATTACK_RANGE = 3;
    public static final int POWER_SHOT_DAMAGE = 35;
    public static final int POWER_SHOT_RANGE = 3;
    public static final int COOLDOWN_TURNS = 2;
    private int cooldown; //turns left before power shot is back, 0 = ready

    //constructor
    public Archer(String name, Player owner){
        super(name, owner, MAX_HP, ATTACK, MOVE_RANGE, ATTACK_RANGE);
    }

    //35 damage to an enemy in a straight clear line, up to 3 squares, then starts the cooldown
    @Override
    public String useSpecial(Game game, GameCharacter target) throws GameException{
        throw new UnsupportedOperationException("TODO (Role 3): check ready, enemy, in line, in range, isLineClear, then damage and cooldown");
    }

    @Override
    public boolean canUseSpecial(){
        throw new UnsupportedOperationException("TODO (Role 3): cooldown == 0");
    }

    //counts the cooldown down when the owner's turn ends
    @Override
    public void endTurn(){
        throw new UnsupportedOperationException("TODO (Role 3): lower cooldown by 1, never below 0 (see Design.md rule table)");
    }

    @Override
    public boolean specialNeedsTarget(){
        return true;
    }

    @Override
    public String getSpecialName(){
        return "Power Shot";
    }

    @Override
    public String getType(){
        return "Archer";
    }

    @Override
    public char getLetter(){
        return 'A';
    }

    //getters
    public int getCooldown(){
        return cooldown;
    }
}
