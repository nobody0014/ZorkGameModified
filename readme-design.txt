All classes and interface and design 
All of them are subject to changes. If you want the main flow of the game ZorkGame and ZorkRunner are where to look at and dont bother with the rest, they're my afterthought into creation.
I cant finish this on time.... this is too much... i need sleep.


Game Flow: (sth like from the diagram)
Start at ZorkGame
Take username
Create ZorkRunner and set everything up
Wait for user input
take user input to create command
pass the command for the zorkRunner to run


In case of invalid inputs
-there is a command for it. CommandParser will create that command for the zorkRunner to execute and the player will know that the input they put is invalid
-If the command is correct but the input is wrong
	- the command will notice
		- most cases have been taken care

You will notice alot of bugs. Yea.... i bit off more than i could chew. Feel free to deduct my mark... i feel bad too.


Main Game Loop Classes:
-At the start the game, you will be ask to put the username
-ZorkGame class
	-Description
		ZorkGame contains the main() function so the game will start there.
		ZorkGame will create ZorkRunner and initializes it.
		ZorkGame will then go into an infinite while loop.
	-main game loop: --> explanation of the flow of the game 
		Take in input.
		input then given to CommandParser to evaluate and Command will be given out.
		Command will be given to the Zork Runner to run Command and be returned with a boolean.
		The boolean will be used to break the loop or continue the game.

-ZorkRunner Class
	-Description
		-This guy does everything that happen in the game
		-It takes in the command  and execute it
	-Initialization
		-Create a player
		-Create a Dictionary linking String:Rooms, this is to connect rooms and such together
		-Create a hub with NPCS and throw player into it
			-> Obviously hub is also thrown in to the dictionary
	-Given Command (From the ZorkGame)
		-it sets the parameter of the command and then execute it

Phraser Class:
-CommandParser Class
	-Usual String parsing and stuffs.
	-Create Command Abstract (Command status has not been decided yet) classes
	-Give out Command instance back
	-have a abstract method help() and execute() for the extended class to implement


Unit Classes:
-Unit classes are the ones with stat and such and there's those similarity that group them together
-Unit class (abstract, where all other classes in these classes get from)
	-Description
		-A skeleton for all the classes under it
		-Act as a law for all unit classes
-Player Class
	-extended from unit
	-Description 
		-A class from the abstract class called Unit
		-If this guy's hp turned 0, the game end :D
		-bunch of command is associated to this guy 

(below classes are subject to change heavily)
-NPC Class (abstract)
	-extended from unit
	-Description
		-Everyone interactable are NPC but they implement different interfaces to give them abilities and such
		-Hp turned 0, give the exp to the player
		-May drop loot
		-May give it's skill to the player as look if player still do not have the skill
		-Some monster may be forced to engage at first while some are not
		-has isAggro
			-Meaning will attack and will not for some
-Monster Class
	-Extended from NPC 
	-Description
		-Has rarity
		-Has level
		-Yied different type of abilities


Item Classes:
-I have no clue on how to implement the classes yet, but this is my design, therefore i cannt really give details on Item
-Item class (abstract):
	-Sellable/buyable/dropable
	-Used to check with these commands too
	-Items class stuff will at first be stored in player's bag --> usually why the these classes extended from item class
(equipment classes are used to check with the equip command)
-Equipment class (abstract):
	-exteneded from item cus u know... sellable/buyable/dropable/etc
	-Give stats/effect to player
	-Have type: as enum --> this is so that we dont have to have so many classes
		-Weapon 
		-Glove
		-Armor
		-Pants
		-Shoe
-Consumable Class:
	-extended from item class
		-Look do i really have to write much more other than because it made sense?
		-Sellable/buyable/dropable/givable/blah blah blah
	-Usable
		-Will drop in quantity
	-Give effects too for some
-Non-Consumable Class:
	-extended from item class
		-Not gonna even say why anymore 
	-Usually used for quests but is something that you would get easily
-Quest-Essential Class:
	-extended from item class
		-Except it is not sellable/buyable/dropable
	-was not implemented


Room-related Classes:
-Room Class
	-Description
		-Can contain monster, npc, and items and random events
	-has exits Obviously
		-exits are in dictionary 
	-There are rules govern room
		-eg: clear monster first, status effects and such, random 
	-Has terrain
		-eg: terrain can give status to skill and such --> this is getting way too complicated for my coding skills
-Level Class
	-Description
		-Contain Rooms
		-Govern the creation of room
	-contains the location of the player in the dungeon

Quest Class: (NOT IMPLEMENTED)
-Quest Class
	-Contain by player class and also Quest-Giver
	-Rooms will check for quests in player when making room to take into the consideration for what the player has to gain
	-This system was not implemented

Skill Class: (NOT IMPLEMENTED)

Factory Classes:
-ZorkView Class
	-Description 
		-Class with certain methods that mant classes used. Usually related with things that have to be printed all the time
-ConsumableFactory Class
	-Description
		-Has names of all consumable
		-Can create the consumable at view
		-Even have the hashmap
-EquipmentFactory Class
	-Description
		-Pretty much the same as ConsumableFactory except this is equipment
-LevelFactory Class
	-Create Levels
-RoomFactory Class
	-Create Room
	-Can even create room with random loots and monster













	
		

