
package action;

import character.GameCharacter;
import exception.GameException;
import game.Game;

/**
 * Represents an action a character can perform during a turn.
 *
 * Owner: Role 5 (Attacking and Defending)
 *
 * All game actions implement this interface.
 * This allows the Game class to execute different actions
 * without knowing their specific implementations.
 */
public interface Action {

    /**
     * Executes the selected action.
     *
     * @param game current game instance
     * @param actor character performing the action
     * @return message describing the result
     * @throws GameException if the action cannot be performed
     */
    String execute(Game game, GameCharacter actor) throws GameException;

    /**
     * Returns the action name displayed in the menu.
     *
     * @return action name
     */
    String getName();

    /**
     * Returns a description of what the action does.
     *
     * @return action description
     */
    default String getDescription() {
        return getName();
    }

    /**
     * Checks whether the action is available to the character.
     *
     * @param game current game instance
     * @param actor character performing the action
     * @return true if the action is available
     */
    default boolean isAvailable(Game game, GameCharacter actor) {
        return actor != null;
    }

    /**
     * Returns the action's menu display information.
     *
     * @return formatted action information
     */
    default String getMenuOption() {
        return getName() + " - " + getDescription();
    }
}
