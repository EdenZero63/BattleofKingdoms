package character;

import exception.GameException;
import game.Game;
import game.Player;

//owner: Role 4 (mage)
//mage: strong melee hits, special is heal (+20 to a friend within 2 squares, twice per game)
public class Mage extends GameCharacter{

    //fields
    public static final int MAX_HP = 60;
    public static final int ATTACK = 30;
    public static final int MOVE_RANGE = 2;
    public static final int ATTACK_RANGE = 1;
    public static final int HEAL_AMOUNT = 20;
    public static final int HEAL_RANGE = 2;
    public static final int MAX_HEALS = 2;
    private int healsLeft;

    //constructor
    public Mage(String name, Player owner){
        super(name, owner, MAX_HP, ATTACK, MOVE_RANGE, ATTACK_RANGE);
        this.healsLeft = MAX_HEALS;
    }

    //heals a friend (or itself) within 2 squares, can't revive or go over max hp
    @Override
    public String useSpecial(Game game, GameCharacter target) throws GameException{
        throw new UnsupportedOperationException("TODO (Role 4): check heals left, same owner, alive, distance <= 2, then heal and healsLeft--");
    }

    @Override
    public boolean canUseSpecial(){
        throw new UnsupportedOperationException("TODO (Role 4): healsLeft > 0");
    }

    @Override
    public boolean specialNeedsTarget(){
        return true;
    }

    @Override
    public String getSpecialName(){
        return "Heal";
    }

    @Override
    public String getType(){
        return "Mage";
    }

    @Override
    public char getLetter(){
        return 'M';
    }

    //getters
    public int getHealsLeft(){
        return healsLeft;
    }
}
