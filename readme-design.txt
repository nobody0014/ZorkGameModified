All classes and interface and design 
All of them are subject to changes. If you want the main flow of the game ZorkGame and ZorkRunner are where to look at and dont bother with the rest, they're my afterthought into creation.
I cant finish this on time.... this is too much... i need sleep.

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
		-Most important function is the evaluator 
			-This is so that new commands can be easily added into the game
				-it also allows commands to be changed easily 
	-Initialization
		-Create a player
		-Create a Dictionary linking String:Rooms, this is to connect rooms and such together
		-Create a hub with NPCS and throw player into it
			-> Obviously hub is also thrown in to the dictionary
	-Given Command (From the ZorkGame)
		-Go into evaluate command function.
		-Call propropriate function to the command.
		-If the termination command is hit or the player died, do necessary reporting and end return false
			-else return do necessary reporting and return true
			-This is done so that ZorkGame can continue running or quiting 
	-Important functions
		-EvaluateCommand(Command cmd)
			-This is called by ZorkGame 
				-Contain bunch of ifs for the command
					-It is possible to use case stuff instead of ifs
					-Command has name to be identified for 
			-Used the command to throw into necessary function 
		-Functions used to do commands given by the user
			-These functions will do the interaction between the player and such and the game
			-It will also call other classes 

Phraser Class:
-CommandParser Class
	-Usual String parsing and stuffs.
	-Create Command Interface/Abstract (Command status has not been decided yet) classes
	-Give out Command instance back


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
-Weapon class:
	-extended from equipment
		-Took up the weapon slot in player
	-Equipable when met with stat
-Glove Class
	-Same as weapon except for the slot
-Armor Class
	-Same as weapon except for the slot
-Pants Class
	-Same as weapon except for the slot
-Shoe Class
	-Same as weapon except for the slot
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

-Hub Class
	-Extended from room
	-Special kind of room that contain all the type of non-monster NPCs and such 
		-yes non-monster NPC are attackable and such but they drop preset items/skills or not at all.


-Rooms Class
	-Description
		-Contain Rooms
		-Govern the creation of room
			-Meaning that it must be given terrain and such
	-Technically, rooms are act as a single level of a dungeon

Quest Class:
-Quest Class
	-Contain by player class
	-Rooms will check for quests in player when making room to take into the consideration for what the player has to gain

Skill Class:
-Skill (interface):
	-no fucking clue
-ActiveSkill Class:
	-Also no fucking clue
-PassiveSkill Class:
	-Totally No FUCKING CLUE

Static Classes or Factory Classes:
-BadCommandUsage Class
	-Description 
		-Class with all static methods
		-Specifically used when users input correct commands but was unable in the given context/situation
-InformationPrinter Class
	-Description
		-Class with all static mehtods


Factory classes will allow me to create items/monster/others easily
-MonsterFactory Class
	-Create monster of different type rarity/level/status/abilities 
		-Rarity rule is its own rule on its own

-ItemFactory Class
	-May subject to further changes to make it more concentrated since item is an abstract class().
	-Consumable and such give stat 















	
		

