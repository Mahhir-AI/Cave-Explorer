<https://csgitlab.reading.ac.uk/gn013660/CS1OP-TextGame>

This game is a cave exploring game where the player must explorer several different rooms, which can have chests and/or enemies in them. The player must fight the enemies and collect 7 pages scattered across the entire map, which leads to victory and escape from the cave. The game makes use of Singleton, Factory, Builder, Composite, Observer design patterns.

To run the game, you only need a keyboard with the following controls:

F = move forward a room

B = move back a room

I = check inventory

U = use item/attack

C = open chest

My game has the following assumptions:

**Player Behaviour**

- The player should read the on-screen prompts and responds with valid input only
- Only one player uses the game at a time (no multiplayer)

**Game Environment**

- The game is run in a standard terminal that supports text output
- Java must be installed and the project is run correctly from the command line
- The game is played in a single session as there is no save/load functionality is needed

**Inventory & Items**

- The player's inventory has no size limit
- The player starts with no items

**World & Rooms**

- Rooms are always traversed in a linear order - no branching paths
- All rooms must be visited to complete the game, to force boss fights
- The world is regenerated fresh each time the game starts

**Scoring**

- The score is only meaningful at the end of the game
- Negative scores, though rare, are capped at 0