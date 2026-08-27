<https://csgitlab.reading.ac.uk/gn013660/CS1OP-TextGame>

Module Code: CS1OP

Assignment report Title: Java Cave Explorer

Student Number (e.g. 25098635): 34013660

Actual hrs spent for the assignment: 45

Which Artificial Intelligence tools used (if applicable): Claude

**Introduction**

This game is a cave exploring game where the player must explorer several different rooms, which can have chests and/or enemies in them. The player must fight the enemies and collect 7 pages scattered across the entire map, which leads to victory and escape from the cave. The game makes use of Singleton, Factory, Builder, Composite, Observer design patterns.

**Analysis of AI Support in Software Development**

I used Claude as an aid to implement difficult bits of the program. I found it extremely useful because I asked it to give me hints and a step-by-step guide on how to approach an issue I had. A limitation, however, is that I have to constantly send my code to Claude, which uses up session limits massively and makes newer inputs delayed and sometimes incorrect. Overall, I found it more beneficial to aid my programming.

**Analysis of Software Patterns in the Project**

I used Singleton, Factory, Builder, Composite, and Observer design patterns.

- **Singleton -** Game.java uses a private constructor and a getInstance() method to ensure only one game world exists at a time. The single instance holds the room list and RNG, accessible globally without passing it between classes.
- **Factory** - EnemyFactory, ItemFactory, and RoomFactory each take a string input and return the correct object. This means the rest of the code never needs to call new Goblin() or new Sword() directly - object creation is centralised.
- **Builder** - RoomBuilder constructs rooms step by step using chained method calls (setChest(), setEnemy()) before a final build(). This separates room configuration from room creation.
- **Composite-** The Item class acts as a common base for all items and weapons. Inventory stores and interacts with everything as an Item, regardless of whether it's a Sword, HealthPotion, or Shield. This allows uniform handling across the inventory system.
- **Observer** - PageCollectionTracker implements the Observer interface and monitors page collection. When a page is picked up, the observable notifies the tracker, which checks if the win condition (7 pages) has been met.

The benefits of patterns were:

- Patterns provide proven, well-understood solutions to common problems, reducing design time
- They make the codebase easier to read and maintain, meaning other developers recognise the structure immediately
- They enforce separation of concerns, keeping creation logic, game state, and notifications in their own dedicated classes
- They make the code more extensible, e.g. adding a new enemy type only requires a new class and one extra case in EnemyFactory, with no changes elsewhere

Overall, the patterns significantly improved the structure and maintainability of the project. Object creation is clean and centralised, game state is consistently managed through a single source of truth, and the page collection win condition is decoupled from the main game loop.

**Ethical and Legal Considerations**

AI and LLM's, such as ChatGPT and Claude, are used almost every day in workplaces, education, and everyday life. Despite it's various benefits, there are some important nuances that must be addressed regarding their usage.

First of all, there is a saying that goes, "If something is free, you are the product". And it's no different in this scenario - our conversations are used to make the same AI models smarter and more efficient. Our data is taken from us, not just in the messages but via cookies and trackers that websites and apps implement on browsers and devices. This leads to data brokers creating detailed profiles of individuals online, which they can then sell to third parties for advertising. As a result, consumers often do not know what data is being sold or who is buying it. There are regulations in place, such as GDPR, to allow people to request the data that companies have on them as well as to request its deletion - however, this isn't enforced to its fullest extent as people often don't bother with checking their online footprints.

There's also a psychological disadvantage that comes with daily LLM use. Young children are extremely prone to using them for their homework, which diminishes the actual purpose of homework - rather than tackling a problem by themselves first, then asking for help, students tend to simply ask an AI the question and copy down the answer. Not only does this nullify the actual purpose of homework, but it prevents children from developing critical thinking and problem-solving skills. Adults are also in a similar boat - many people are known to depend on LLM's too much, to the point where they share personal information and treat them like a confidant. Aside from the dangers of personal data I mentioned above, talking to AI like a therapist doesn't bring the benefits of talking to a real person. This can lead to over-reliance and addiction.

Another ethical concern in AI systems is bias. Because LLM's are trained on large datasets from the internet, they are prone to reflecting real-life stereotypes and biases - this could lead to misleading or offensive outputs, which is extremely dangerous in areas such as hiring. As a result of this bias, people are at risk of being misrepresented and treated unfairly.

One final point which is worth mentioning is the rise of AI-generated media; that is, pictures and videos of real or fake people being made to say or do things which they have not done. This deepfake technology presents significant ethical and legal risks. Spreading misleading information, which has been proven to be about 70% more believable than real news, creates false ideas in people's minds about what's going on in the world. Innocent people, particularly the elderly, are targeted by scammers by creating a clone of a loved one and pretend to be in need of money. These are just two of the various threats AI-generated media poses on us.

**Testing**

**Weapons & Combat**

- Enter a room with an enemy and no weapon in inventory. Confirm a weapon is automatically given to you before the fight starts

_See Test1.png_

**Navigation**

- Try to move back from the first room. It should print an error, not crash

_See Test2.png_

**Input Handling**

- Type gibberish at every input prompt. The game should never crash, should print an error message

_See Test3.png_

- Type an item name that isn't in your inventory when prompted. It should say item not found

_See Test4.png_

- Test for game functionality until the end, plus inventory manager

The game uses the following inputs:

F - move forward a room

B - move back a room

I - check inventory

A - attack

U - use/eat

C - open chest

The current room is: Starter Room

You have collected 0 pages.

Your health is: 100 / 100

Enter your choice:

F

The current room is: Small Room

You have collected 0 pages.

Your health is: 100 / 100

Enter your choice:

F

The current room is: Small Room

You have collected 0 pages.

Your health is: 100 / 100

Enter your choice:

F

The current room is: Small Room

You have collected 0 pages.

Your health is: 100 / 100

Enter your choice:

F

The current room is: Small Room

This room has a basic chest in it.

You have collected 0 pages.

Your health is: 100 / 100

Enter your choice:

C

You opened the chest and found: Electrical wire

The current room is: Small Room

You have collected 0 pages.

Your health is: 100 / 100

Enter your choice:

F

The current room is: Small Room

You have collected 0 pages.

Your health is: 100 / 100

Enter your choice:

F

The current room is: Small Room

You have collected 0 pages.

Your health is: 100 / 100

Enter your choice:

F

The current room is: Small Room

You have collected 0 pages.

Your health is: 100 / 100

Enter your choice:

F

The current room is: Small Room

You have collected 0 pages.

Your health is: 100 / 100

Enter your choice:

F

The current room is: Small Room

You have collected 0 pages.

Your health is: 100 / 100

Enter your choice:

F

The current room is: Small Room

You have collected 0 pages.

Your health is: 100 / 100

Enter your choice:

F

You found a page in this room and added it to your inventory!

The current room is: Mid Room

This room has a major chest in it.

You have collected 1 pages.

Your health is: 100 / 100

Enter your choice:

C

You opened the chest and found: Map of different cave

The current room is: Mid Room

You have collected 1 pages.

Your health is: 100 / 100

Enter your choice:

F

You found a page in this room and added it to your inventory!

The current room is: Mid Room

You have collected 2 pages.

Your health is: 100 / 100

Enter your choice:

F

You found a page in this room and added it to your inventory!

The current room is: Mid Room

You have collected 3 pages.

Your health is: 100 / 100

Enter your choice:

F

The current room is: Mid Room

You have collected 3 pages.

Your health is: 100 / 100

Enter your choice:

F

The current room is: Mid Room

This room has a major chest in it.

You have collected 3 pages.

Your health is: 100 / 100

Enter your choice:

C

You opened the chest and found: Old coins

The current room is: Mid Room

You have collected 3 pages.

Your health is: 100 / 100

Enter your choice:

F

The current room is: Mid Room

This room has a major chest in it.

You have collected 3 pages.

Your health is: 100 / 100

Enter your choice:

C

You opened the chest and found: Torn cloth

The current room is: Mid Room

You have collected 3 pages.

Your health is: 100 / 100

Enter your choice:

F

You found a page in this room and added it to your inventory!

The current room is: Big Room

This room has a superior chest in it.

You have collected 4 pages.

Your health is: 100 / 100

Enter your choice:

C

You opened the chest and found: Old coins

The current room is: Big Room

You have collected 4 pages.

Your health is: 100 / 100

Enter your choice:

F

You found a page in this room and added it to your inventory!

The current room is: Big Room

This room has a superior chest in it.

You have collected 5 pages.

Your health is: 100 / 100

Enter your choice:

C

You opened the chest and found: Health Potion

The current room is: Big Room

You have collected 5 pages.

Your health is: 100 / 100

Enter your choice:

F

You found a page in this room and added it to your inventory!

The current room is: Big Room

This room has a superior chest in it.

You have collected 6 pages.

Your health is: 100 / 100

Enter your choice:

C

You opened the chest and found: Rotten apple core

The current room is: Big Room

You have collected 6 pages.

Your health is: 100 / 100

Enter your choice:

I

Electrical wire

Page

Map of different cave

Page

Page

Old coins

Torn cloth

Page

Old coins

Page

Health Potion

Page

Rotten apple core

The current room is: Big Room

You have collected 6 pages.

Your health is: 100 / 100

Enter your choice:

F

You found a page in this room and added it to your inventory!

You have collected all 7 pages!

Congratulations, you won the game!

Your final score is: 1000