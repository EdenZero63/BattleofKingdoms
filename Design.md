# Battle for the Kingdom: Design

Java console game for 2 players on an 8x8 battlefield. Each player has a Warrior, an Archer and a Mage.
The spec is `Battle_for_the_Kingdom_Java_Project_Formatted.pdf` (3 weeks).

---

## 1. Folder structure

```
BattleofKingdoms/
├── Design.md            this file: structure, roles, rules, week plan
├── README.md            written in week 3 (spec 16.3)
├── .gitignore           out/, *.class, IDE files
├── src/
│   ├── app/             Main: entry point                                   (Role 7)
│   ├── game/            Game, Player, Setup: turns, victory, start layout   (Role 7)
│   ├── board/           Battlefield, Position, MovementValidator            (Role 1)
│   ├── character/       abstract GameCharacter, Warrior, Archer, Mage       (Roles 2-4)
│   ├── action/          Action interface + Attack/Special/Defend/Pass       (Role 5)
│   ├── item/            Item interface, HealthPotion, Inventory, transfers  (Role 6)
│   ├── ui/              ConsoleUI, BoardRenderer, InputHelper               (Role 8)
│   └── exception/       custom checked exceptions (each role adds its own)
├── test/                one test class per package (spec section 14)
└── docs/
    └── uml/             initial UML (week 1) and final UML (week 3)
```

Build and run (PowerShell):
```powershell
javac -d out (Get-ChildItem -Path src -Recurse -Filter *.java).FullName
java -cp out app.Main
```

### Planned classes

| Package | Class | What it does |
|---|---|---|
| `board` | `Position` | row and col. `equals`/`hashCode` so it can be a `HashMap` key |
| `board` | `Battlefield` | 8x8 grid, obstacles at (2,3) and (4,4), who is on each square, `isInside`, `isFree`, straight-line "is it blocked" check |
| `board` | `MovementValidator` | BFS: is there a path within the move range that avoids obstacles and characters? |
| `character` | `GameCharacter` (abstract) | name, owner, hp, maxHp, attack, moveRange, attackRange, position, inventory, defending. `takeDamage` → `reduceDamage`, `heal`, `defend`, `startTurn`/`endTurn`, abstract `useSpecial` |
| `character` | `Warrior`, `Archer`, `Mage` | stats from spec section 4 as constants. Each one overrides `useSpecial`. Warrior also overrides `reduceDamage` for Shield, and Archer overrides `endTurn` for its cooldown |
| `game` | `Player` | name and a list of 3 characters. `hasSurvivors()` |
| `game` | `Game` | battlefield, 2 players, turn number, current player. End of turn: tick cooldowns, check victory, switch players |
| `game` | `Setup` | starting positions and potions (no manual setup) |
| `action` | `Action` (interface) | `execute(Game, GameCharacter)`, throws a game exception if the action isn't allowed |
| `action` | `AttackAction`, `SpecialAction`, `DefendAction`, `PassAction` | the turn actions from spec section 7 |
| `item` | `Item` (interface) | `getName()`, `use(GameCharacter)`, so new item types are easy to add (spec 8.2) |
| `item` | `HealthPotion` | +30 HP, can't go over max, can't be used at full HP |
| `item` | `Inventory` | `ArrayList<Item>`, holds at most 3 |
| `item` | `UsePotionAction`, `TransferAction` | these implement `Action` too |
| `ui` | `ConsoleUI`, `BoardRenderer`, `InputHelper` | menus, drawing the map, reading numbers without crashing |
| `exception` | `GameException` (base), `InvalidMoveException`, `InvalidTargetException`, `AbilityUnavailableException`, `InventoryException` | the spec needs at least 2 |

### Where each OOP concept shows up (for the OOP report, spec 16.5)

| Concept | Where |
|---|---|
| Inheritance | `Warrior`/`Archer`/`Mage` extend `GameCharacter` |
| Abstraction | abstract `GameCharacter.useSpecial`, plus the `Action` and `Item` interfaces |
| Polymorphism | `character.useSpecial(...)` and `action.execute(...)` called through base references |
| Encapsulation | private fields. `takeDamage`/`heal` keep HP between 0 and max |
| Composition | `Game` owns the `Battlefield` and the `Player`s. Each `GameCharacter` owns an `Inventory` |
| Interfaces | `Action`, `Item` |
| Exceptions | the `exception` package. `ui` catches them, prints the message and lets the player retry the same turn |
| Collections / Generics | `ArrayList<GameCharacter>`, `ArrayList<Item>`, `HashMap<Position, Position>` for BFS |

---

## 2. Roles

These follow Marcelo's split: **Map/Movement**, **Classes (Warrior/Mage/Archer)** and
**Interaction (attacking/defending/trading)**. Turns (game flow) and the console UI weren't in his list,
so they're Roles 7 and 8. Each person is matched to what they built in the Warehouse project.

| # | Group | Role | Package | Owns | Member | Warehouse role it builds on |
|---|---|---|---|---|---|---|
| 1 | Map/Movement | Map & Movement | `board` | `Battlefield`, `Position`, obstacles, line-of-sight check, `MovementValidator` (BFS, bounds, occupied squares) | [Marcelo Soria](https://github.com/EdenZero63) | Navigation (BFS) |
| 2 | Classes | Character base + Warrior | `character` | abstract `GameCharacter` (HP, damage, heal, elimination, Shield/Defend reduction in `takeDamage`), `Warrior` + Shield | [Andrew Goodman](https://github.com/droobix) | Robot behavior |
| 3 | Classes | Archer | `character` | `Archer` + Power Shot (35 dmg, range 3, 2-turn cooldown) | [James Whiting](https://github.com/James-saddleback) | Tasks and dispatch |
| 4 | Classes | Mage | `character` | `Mage` + Heal (+20, within 2 squares, 2 uses per game, can heal itself) | [Kerem Eren](https://github.com/qeremeren) | Warehouse map |
| 5 | Interaction | Attacking & Defending | `action` | `Action` interface, `AttackAction` (melee next to target, archer straight line), `SpecialAction`, `DefendAction` (25%), `PassAction`, elimination message | [Sierra Hunt](https://github.com/darkgrapeman) | Charging rules |
| 6 | Interaction | Trading & Inventory | `item` | `Item`, `HealthPotion`, `Inventory` (max 3), `UsePotionAction`, `TransferAction` | [Erik Hernandez](https://github.com/PondBits) | QA and errors |
| 7 | (integration) | Game flow | `app`, `game` | `Main`, `Game`, `Player`, `Setup`, turn loop, end-of-turn cooldowns, victory check | [Alexander Nguyen](https://github.com/acnguyen1259) | Integration (tick loop) |
| 8 | (integration) | Console UI | `ui` | `ConsoleUI`, `BoardRenderer`, `InputHelper` | [Valance Fernando](https://github.com/PowerisTsutsun) | Console UI |

**UI scope (Role 8, spec section 9):**
- `BoardRenderer`: the 8x8 grid with row and column numbers 0–7. `W A M` for Player 1, `w a m` for Player 2, `X` for obstacles, `.` for empty squares. Eliminated characters disappear from the map.
- Status panel: the turn number, the current player, and each character's HP, inventory, and Shield/Defend/cooldown/heals left.
- `ConsoleUI` menus: pick a character → move (optional) → pick an action (Attack, Special, Potion, Transfer, Defend, Pass). There's also an Exit option.
- `InputHelper`: text typed where a number is expected never crashes the game. It asks again.
- Catches every `GameException`, prints its message, and lets the player retry without using up the turn.
- Prints feedback after every action: damage dealt, eliminations, the winner.

**Everyone also:**
- Writes the custom exception their package throws, in `exception/`.
- Writes the tests for their own area in `test/` (spec 14):

  | Test area | Roles |
  |---|---|
  | Initialization | 1, 2, 7 |
  | Movement | 1 |
  | Combat | 2, 5 |
  | Abilities | 2, 3, 4 |
  | Inventory | 6 |
  | Game flow | 7, 8 |
- Draws their own classes for the UML. Role 7 combines them into `docs/uml/`.
- Presents their own part in the demo and can explain the whole game (spec 12, 16.6).

**Dependencies (who needs whose code first):**
- Role 2 goes first. Roles 3, 4, 5 and 6 all build on `GameCharacter`. Agree on its method names on day 1.
- Role 1's `Battlefield` is needed by 5 (line of sight), 7 (setup) and 8 (map display).
- Archer (3) and Role 5 share the straight-line "is it blocked" check. It lives in `Battlefield` (Role 1), so it's written once.
- Roles 7 and 8 work together closely. `Game` holds the state and rules. `ui` only reads it and forwards the player's choices.

---

## 3. Rule decisions (spec gaps the team needs to agree on)

| Rule | Proposal |
|---|---|
| Distance for Heal "within 2 squares" | Manhattan distance (\|dr\| + \|dc\|), no line of sight needed |
| Archer normal attack and Power Shot | Same row or column, range 1–3, first thing in the line blocks it |
| Power Shot cooldown | Used on turn N → not allowed on the Archer's next 2 turns → allowed again on the 3rd. Counted in the Archer's own turns |
| When Shield/Defend run out | On the next hit, or when the owner's next turn starts (`Game.endTurn` calls `startTurn()` on the new player's characters) |
| Shield vs Defend | Can't have both active. Rounding down: `damage - damage * 50 / 100` with int math |
| Invalid action | Throws a `GameException`. `ui` shows the message and asks again. The turn and turn number don't change |
| Move, then action fails | The move stays and only the action is asked again (decide this together) |

---

## 4. Week plan (spec section 15)

| Week | Goal | Done when |
|---|---|---|
| 1 | Structure and foundation | Initial UML in `docs/uml/`. Board prints with all 6 characters and 2 obstacles. Stats and potions are correct |
| 2 | Core gameplay | You can play a full game: move, attack, specials, defend, potions, transfers, elimination, a winner |
| 3 | Integration and delivery | Every error case handled, tests done, final UML, README, OOP report, demo practiced |

Merge into `main` often. Don't save integration for week 3.

---

## 5. Git and code rules

- Each person works on their own branch (`dev-<name>`) and opens a PR into `main`. Never push to `main` directly.
- Someone else reviews each PR before Marcelo (the repo owner) merges it.
- Compile `main` after every merge. A PR that doesn't compile doesn't get merged.
- Unfinished methods throw `UnsupportedOperationException("TODO (Role N): ...")`. No empty bodies.
- Game rules live in `board`/`character`/`action`/`item`/`game`. `ui` only shows state and reads input.
- Commit messages look like `feat: add BFS movement check`, `fix: archer shot passes through obstacle`.
- Don't commit `out/` or `.class` files.
