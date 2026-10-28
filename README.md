<https://csgitlab.reading.ac.uk/gn013660/CS1OP-TextGame>

This game is a cave exploring game where the player must explorer several different rooms, which can have chests and/or enemies in them. The player must fight the enemies and collect 7 pages scattered across the entire map, which leads to victory and escape from the cave. The game makes use of Singleton, Factory, Builder, Composite, Observer design patterns.

To run the game, you only need a keyboard with the following controls:

F = move forward a room

B = move back a room

I = check inventory

U = use item/attack

C = open chest

Some key facts about the game:

**Player Behaviour**

- The player should read the on-screen prompts and respond with valid input only
- No multiplayer, only one player at a time 

**Game Environment**

- The game is run in a standard terminal, e.g. VS Code, that supports text output
- Java must be installed
- The project is run correctly from the command line
- The game is played in a single session as there is no save/load functionality (yet)

**World & Rooms**

- Rooms are always traversed in a linear order - no branching paths
- All rooms must be visited to complete the game
- The world is regenerated fresh each time the game starts
