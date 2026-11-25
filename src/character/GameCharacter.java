package character;

import board.Position;
import exception.AbilityUnavailableException;
import exception.GameException;
import game.Game;
import game.Player;
import item.Inventory;

//owner: Role 2 (character base)
//stats and behavior shared by warrior, archer and mage
public abstract class GameCharacter{

    //fields
    private String name;
    private Player owner;
    private int hp;
    private int maxHp;
    private int attack;
    private int moveRange;
    private int attackRange;
    private Position position; //null once eliminated
    private Inventory inventory;
    private boolean defending; //on until hit or the owner's next turn

    //constructor
    public GameCharacter(String name, Player owner, int maxHp, int attack, int moveRange, int attackRange){
        this.name = name;
        this.owner = owner;
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.attack = attack;
        this.moveRange = moveRange;
        this.attackRange = attackRange;
        this.inventory = new Inventory();
    }

    //takes a hit: reduceDamage first, hp never goes below 0, defend ends
    public void takeDamage(int damage){
        throw new UnsupportedOperationException("TODO (Role 2): damage = reduceDamage(damage), subtract, stop at 0, defending = false");
    }

    //shrinks incoming damage, defend is 25% off rounded down
    //warrior overrides this to add shield
    protected int reduceDamage(int damage){
        throw new UnsupportedOperationException("TODO (Role 2): if defending, damage - damage * 25 / 100");
    }

    //adds hp up to maxHp, does nothing to an eliminated character
    public void heal(int amount){
        throw new UnsupportedOperationException("TODO (Role 2): add amount, stop at maxHp, skip if eliminated");
    }

    public boolean isEliminated(){
        throw new UnsupportedOperationException("TODO (Role 2): hp == 0");
    }

    public boolean isAtFullHealth(){
        throw new UnsupportedOperationException("TODO (Role 2): hp == maxHp");
    }

    //turns defend on, can't stack with itself or with the warrior's shield
    public void defend() throws AbilityUnavailableException{
        throw new UnsupportedOperationException("TODO (Role 2): throw if defending or isShielded(), else defending = true");
    }

    //called when the owner's turn starts: defend runs out
    public void startTurn(){
        throw new UnsupportedOperationException("TODO (Role 2): defending = false");
    }

    //called when the owner's turn ends
    //most characters have nothing to count down, archer overrides this for its cooldown
    public void endTurn(){
    }

    //only the warrior can be shielded, it overrides this
    public boolean isShielded(){
        return false;
    }

    //each type does its own special: shield, power shot, heal
    //target is null for the warrior's shield
    public abstract String useSpecial(Game game, GameCharacter target) throws GameException;

    //false when on cooldown, out of heals, or shield already up
    public abstract boolean canUseSpecial();

    //true when the special needs a target (power shot and heal)
    public abstract boolean specialNeedsTarget();

    public abstract String getSpecialName();

    //"Warrior", "Archer" or "Mage"
    public abstract String getType();

    //W, A or M, the ui makes it lowercase for player 2
    public abstract char getLetter();

    //getters
    public String getName(){
        return name;
    }

    public Player getOwner(){
        return owner;
    }

    public int getHp(){
        return hp;
    }

    public int getMaxHp(){
        return maxHp;
    }

    public int getAttack(){
        return attack;
    }

    public int getMoveRange(){
        return moveRange;
    }

    public int getAttackRange(){
        return attackRange;
    }

    public Position getPosition(){
        return position;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public boolean isDefending(){
        return defending;
    }

    //setters
    public void setPosition(Position position){
        this.position = position;
    }
}
