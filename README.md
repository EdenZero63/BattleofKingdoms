# Battle for the Kingdom

A 2-player, turn-based strategy game for the Java console. Each player has a Warrior, an Archer and a Mage
on an 8x8 battlefield. You win by eliminating all 3 of the other player's characters.

The full design (classes, OOP concepts, rule decisions) is in [`Design.md`](Design.md).

## Build and run

PowerShell:
```powershell
javac -d out (Get-ChildItem -Path src -Recurse -Filter *.java).FullName
java -cp out app.Main
```

Git Bash:
```bash
javac -d out $(find src -name "*.java")
java -cp out app.Main
```

Right now the game prints `Not built yet: TODO (Role N): ...`. That's expected: the skeleton compiles, and
each `TODO` is a method someone still has to write.

---

## Team roles

| # | Role | Member | Your files |
|---|---|---|---|
| 1 | Map & Movement | [Marcelo Soria](https://github.com/EdenZero63) | `board/Position`, `board/Battlefield`, `board/MovementValidator` |
| 2 | Character base + Warrior | [Andrew Goodman](https://github.com/droobix) | `character/GameCharacter`, `character/Warrior` |
| 3 | Archer | [James Whiting](https://github.com/James-saddleback) | `character/Archer` |
| 4 | Mage | [Kerem Eren](https://github.com/qeremeren) | `character/Mage` |
| 5 | Attacking & Defending | [Sierra Hunt](https://github.com/darkgrapeman) | `action/AttackAction`, `SpecialAction`, `DefendAction`, `PassAction` |
| 6 | Trading & Inventory | [Erik Hernandez](https://github.com/PondBits) | `item/Inventory`, `HealthPotion`, `UsePotionAction`, `TransferAction` |
| 7 | Game flow | [Alexander Nguyen](https://github.com/acnguyen1259) | `game/Player`, `game/Setup`, `game/Game`, `app/Main` |
| 8 | Console UI | [Valance Fernando](https://github.com/PowerisTsutsun) | `ui/InputHelper`, `ui/BoardRenderer`, `ui/ConsoleUI` |

Already done, nothing to write: all of `exception/`, plus the `action/Action` and `item/Item` interfaces.

### Folder complexity (hardest first)

| # | Folder | Complexity | Role | TODOs | Why |
|---|---|---|---|---|---|
| 1 | `board/` | **Hard** | 1 | 15 | BFS pathfinding (queue, visited squares, step limit), the line-of-sight walk, and keeping the grid and each character's position in sync. Almost every other folder calls it, so bugs here show up everywhere |
| 2 | `game/` | **Hard** | 7 | 9 | Ties everything together: setup, the turn loop, end-of-turn order (cooldowns → victory → switch → expire Shield/Defend), removing eliminated characters, and making sure a failed action doesn't use up the turn |
| 3 | `ui/` | **Medium–Hard** | 8 | 9 | The most lines of code: menus, retry loops, input that never crashes, drawing the grid and status panel. Can only be fully tested once `game/` works |
| 4 | `character/` | **Medium** | 2, 3, 4 | 16 | Lots of methods, but each is short. The tricky parts are rounding Shield/Defend damage, when they run out, and counting the Power Shot cooldown. Split three ways: `GameCharacter` + `Warrior` (Role 2) is the biggest share, `Archer` is medium, `Mage` is the lightest |
| 5 | `action/` | **Medium** | 5 | 4 | `AttackAction` is the hardest single method in the project: ally, eliminated, melee vs ranged, same line, range, and blocked checks. The other three are a few lines each |
| 6 | `item/` | **Easy–Medium** | 6 | 8 | `ArrayList` work plus the capacity rule. `TransferAction` has 4 checks (friendly, both alive, next to each other, receiver not full) |
| 7 | `exception/` | Done | – | 0 | Already written |
| 8 | `app/` | Done | – | 0 | `Main` already works. It just calls `Setup` and `ConsoleUI` |

---

## How to work on your part

### 1. Get the code and make your branch (once)
```powershell
git clone https://github.com/EdenZero63/BattleofKingdoms.git
cd BattleofKingdoms
git checkout -b dev-<yourname>
```

### 2. Fill in your methods
Every unfinished method looks like this:
```java
public int distanceTo(Position other){
    throw new UnsupportedOperationException("TODO (Role 1): return |row diff| + |col diff|");
}
```
Delete the `throw` line and write the real code. The text after `TODO` is a hint for what the method should do.

- **Only edit your own files.** If you need something from someone else's file, message them instead of changing it.
  The Git history has to show each person's own work (it's 10% of the grade).
- **Don't rename methods or change their parameters** without telling the group first. Other people's code
  already calls them.
- Rule errors are thrown as the exceptions in `exception/` (for example `throw new InvalidMoveException("That square is taken")`).
  Write a message the player can understand, because the UI prints it as-is.
- Keep the comment style: `//` with no space, lowercase, short.

### 3. Compile before every push
If `javac` prints any error, fix it before you push.

### 4. Commit, push, open a pull request
```powershell
git add src/<your package>
git commit -m "feat: add BFS movement check"
git push -u origin dev-<yourname>
```
Then open a pull request into `main` on GitHub. Someone else reviews it, and Marcelo merges it.
Never push straight to `main`.

### 5. Stay up to date
After someone's PR is merged, pull it into your branch:
```powershell
git checkout dev-<yourname>
git pull origin main
```

---

## How the files connect

Arrows mean "uses". Files at the top are used by almost everything, so they have to work first.

```
                 Position  (Role 1)            GameCharacter  (Role 2)
                    │                                 │
        ┌───────────┼──────────────┐      ┌───────────┼─────────────┬──────────────┐
        ▼           ▼              ▼      ▼           ▼             ▼              ▼
   Battlefield  MovementValidator  Warrior / Archer / Mage    Inventory, Items   Player
    (Role 1)       (Role 1)          (Roles 2, 3, 4)            (Role 6)        (Role 7)
        │              │                    │                        │              │
        │              │                    ▼                        │              │
        │              │       AttackAction, SpecialAction,          │              │
        │              │       DefendAction, PassAction (Role 5)     │              │
        │              │       UsePotionAction, TransferAction (Role 6)             │
        │              │                    │                        │              │
        └──────────────┴────────────┬───────┴────────────────────────┴──────────────┘
                                    ▼
                          Setup  →  Game   (Role 7)
                                    │
                                    ▼
                  ConsoleUI, BoardRenderer, InputHelper   (Role 8)
                                    │
                                    ▼
                                  Main
```

### Who's waiting on your methods

| Your file | Methods others need first | Who's waiting |
|---|---|---|
| `Position` (1) | `distanceTo`, `isInLineWith`, `equals`/`hashCode` | Archer, Mage, attacks, transfers, BFS |
| `GameCharacter` (2) | `takeDamage`, `reduceDamage`, `heal`, `isEliminated`, `isAtFullHealth` | every character, every action, Game, UI |
| `Battlefield` (1) | `isInside`, `isObstacle`, `isFree`, `getCharacterAt`, `addObstacle`, `placeCharacter` | Setup, BoardRenderer |
| `Battlefield` (1) | `isLineClear`, `moveCharacter`, `removeCharacter` | Archer, AttackAction, Game |
| `Inventory` (6) | `add`, `isFull` | Setup (starting potions) |
| `Player` (7) | `addCharacter`, `getAliveCharacters`, `hasSurvivors` | Setup, Game, ConsoleUI |
| `Setup` (7) | `createDefault` | Main. Nothing shows on screen until this works |
| `Game` (7) | `moveCharacter`, `performAction`, `endTurn` | ConsoleUI |

---

## Build order

Work goes in steps. Each step only needs the steps above it, so do your part of step 1 before anything else.

### Step 1: the foundation (first 2–3 days, blocks everyone)
| Role | Do this first |
|---|---|
| 1 Marcelo | `Position`: everything. Then `Battlefield`: `isInside`, `isObstacle`, `isFree`, `getCharacterAt`, `addObstacle`, `placeCharacter` |
| 2 Andrew | `GameCharacter`: `isEliminated`, `isAtFullHealth`, `takeDamage`, `reduceDamage`, `heal` |
| 6 Erik | `Inventory`: `add`, `remove`, `isFull`, `isEmpty`, `findByName` |
| 7 Alexander | `Player`: all 3 methods |
| 8 Valance | `InputHelper`: all 3 methods (needs nobody else) |
| 3 James, 4 Kerem | `canUseSpecial` and the cooldown/heal counters, which need nobody else. Read `GameCharacter` and `Battlefield` so you know what you'll call |
| 5 Sierra | Read `GameCharacter`, `Battlefield` and `Position`. Write out the attack checks (ally? eliminated? in line? in range? blocked?) so they're ready |

### Step 2: the board shows up (end of week 1)
| Role | Task |
|---|---|
| 7 Alexander | `Setup.createDefault`: 6 characters, 2 obstacles, 2 potions |
| 8 Valance | `BoardRenderer.render` and `renderStatus` |

**Week 1 goal:** `java -cp out app.Main` prints the 8x8 board with all 6 characters and both obstacles.
Draw the initial UML now too (`docs/uml/`): everyone sends a picture of their own classes to Alexander.

### Step 3: moving and fighting (week 2)
| Role | Task |
|---|---|
| 1 Marcelo | `MovementValidator` (BFS), then `Battlefield.moveCharacter`, `removeCharacter`, `isLineClear` |
| 2 Andrew | `defend`, `startTurn`, then `Warrior` (Shield) |
| 3 James | `Archer.useSpecial` (Power Shot), `endTurn` (cooldown) |
| 4 Kerem | `Mage.useSpecial` (Heal) |
| 5 Sierra | `AttackAction`, then `SpecialAction`, `DefendAction`, `PassAction` |
| 6 Erik | `HealthPotion.use`, `UsePotionAction`, `TransferAction` |
| 7 Alexander | `Game`: `getOpponent`, `moveCharacter`, `performAction`, `removeEliminated`, `endTurn` |
| 8 Valance | `ConsoleUI`: `run`, `pickCharacter`, `askMove`, `pickAction` |

**Week 2 goal:** a full game can be played from start to winner.

### Step 4: finish (week 3)
- Everyone: tests for your own part (see the test table in `Design.md`), clear error messages, and checking that a bad action never uses up the turn.
- Final UML, this README's gameplay section, the OOP concepts report, and demo practice. Everyone presents their own part.

---

## Gameplay

*To be written in week 3: the controls, how a turn works, and an example game.*

## Testing

*To be written in week 3: how to run the tests and what they cover.*

## Known limitations

*To be written in week 3.*
