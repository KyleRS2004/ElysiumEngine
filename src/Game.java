package src;

import java.util.Random;

import src.Events.*;
import src.NPCs.*;
import src.Locations.*;
import src.Magic.LightCastSpell;
import src.Quests.*;

public class Game {
	Cave1 cave1 = new Cave1();
	TrollCave trollcave = new TrollCave();
	
	
	client Client = new client();
	Player player = new Player();
	
	PlayerInventory playerInventory = new PlayerInventory();
	PlayersQuests playerquests = new PlayersQuests();
	PlayerSpells playerspells = new PlayerSpells();
	EventManager eventmanager = new EventManager();
	
	
	public Game() {
		
		Client.setVisible(true);

		GameSession();
		
	}
	
	boolean NewGame=true;
	boolean GameActive=false;
	boolean DungeonState=false;
	int DungeonID=0;			// Generally unused, but for fallback purposes 0 is for main world.
	int EntranceSide=0;
	boolean CombatMode=false;
		 
	String[] ActiveEnemies = {"","","","",""};
	
	int Tick;
	int EventID=0;
	int movementDirection = 0; // 0, 1 - north, 2 - south, 3 - west, 4 - east
	
	String _Input;
	
	
	boolean _lootInDungeon=false;
	int _XOfTmpLoot=0;
	int _YOfTmpLoot=0;
	int _TmpLootID[]= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

	
	int[][] WorldMap = { // 1 For mountains. 0 For walkable space. 9 For the "Grand River". 5 For Towns and large Dungeons 3 For Dungeons Entrances.
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,3,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1},
			{1,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1},
			{1,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1},
			{1,0,0,3,0,0,0,9,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,5,0,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,9,0,0,0,0,5,5,3,0,0,0,0,0,0,0,0,0,1},
			{1,9,9,9,0,0,0,0,5,5,5,0,0,0,0,0,0,0,0,0,1},
			{1,9,9,9,9,9,9,9,5,5,5,5,0,0,0,0,0,0,0,0,1},
			{1,9,9,9,9,9,9,9,9,5,5,5,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},	
	};
	
	//Static loot
	boolean cave1_e2_gold=true; // True means the loot is still at the second entrance to cave 1.
	boolean cave1_e1_internal_dagger = true;
	
	String Map=
			"";
			  
	
	
	
	
	
	public void InitiatializeGame() {
		// Load Main Menu
		
	}
	
	public void LoadGame() {
		if (NewGame==false) {
			// Load XML save file.
		}
		else {
			// Create New Game
		}
	}
	
	public void GameSession() {
		GameActive=true;
		if (NewGame==true) {
			Client._newGameOutput=true;
			Client.SceneOutput("");
			Client._newGameOutput=false;
			
		}
		
		
		while (GameActive==true) {
			if (Tick>2000) { // Necessary because the GUI cannot handle the command variable being checked constantly.
			if (player.GetHP()<=0) {
				GameActive=false;
				break;
			}
			if ((DungeonState==false)&&(_XOfTmpLoot!=player.GetPlayerX())&&(_YOfTmpLoot!=player.GetPlayerY())) {
				_XOfTmpLoot=0;
				_YOfTmpLoot=0;
			}
			if ((DungeonState==true)&&(_XOfTmpLoot!=player.GetPlayerXinDungeon())&&(_YOfTmpLoot!=player.GetPlayerYinDungeon())) {
				_XOfTmpLoot=0;
				_YOfTmpLoot=0;
			}
				
			player.SetCurrentActualDP();
			//EventID=0; // Temporary for testing dungeons without having to fight everything outside them everywhere.
			
			DungeonEvents();
			if (EventID != 0) {
				if (DungeonState==false) {
					_XOfTmpLoot=player.GetPlayerX();
					_YOfTmpLoot=player.GetPlayerY();
				}
				else {
					_XOfTmpLoot=player.GetPlayerXinDungeon();
					_YOfTmpLoot=player.GetPlayerYinDungeon();
				}
				switch (EventID) {
				case 1:
					//System.out.println("Player has encountered a Merchant");
					Client.GenericOutputBoxOut("\nYou encounter a Merchant.\n");
					
					Tick=1;
					EventID=0;
					break;
				case 2:
					//System.out.println("Player has encountered a Guard");
					Client.GenericOutputBoxOut("\nYou encounter a Guard.\n");
					
					Tick=1;
					EventID=0;
					break;
				case 3:
					//System.out.println("Player has encountered a Villager");
					Client.GenericOutputBoxOut("\nYou encounter a Villager.\n");
					
					Tick=1;
					EventID=0;
					break;
				case 4:
					//System.out.println("Player has encountered a Bandit");
					Client.GenericOutputBoxOut("\nYou encounter a Bandit.\n");
					EventCombat();
					SetLoot(1);
					Tick=1;
					EventID=0;
					break;
				case 5:
					//System.out.println("Player has encountered a Rat");
					Client.GenericOutputBoxOut("\nYou encounter a Rat.\n");
					EventCombat();
					Tick=1;
					EventID=0;
					break;
				case 6:
					//System.out.println("Player has encountered a Goblin");
					Client.GenericOutputBoxOut("\nYou are jumped by a Goblin.\n");
					EventCombat();
					SetLoot(1);
					Tick=1;
					EventID=0;
					
					break;
				case 7:
					//System.out.println("Player has encountered a Troll");
					Client.GenericOutputBoxOut("\nYou encounter a Troll.\n");
					EventCombat();
					Tick=1;
					EventID=0;
					QuestCompleted();
					break;
				case 8:
					//System.out.println("Player has encountered a Skeleton");
					Client.GenericOutputBoxOut("\nYou encounter a Skeleton.\n");
					EventCombat();
					Tick=1;
					EventID=0;
					break;
				}
			}
			
			if (Client.CommandMode==true) {
				_Input=Client.UserInput;
				_Input.toLowerCase();
				Client.ClearInputBox();
				
				
					if (_Input.contains("go")) {
						if (_Input.contains("north")) {
							if (DungeonState==false) {
								MoveNorthCMD();
							}
							else {
								DungeonGoNorth();
							}
						}
						if (_Input.contains("south")) {
							if (DungeonState==false) {
								MoveSouthCMD();
							}
							else {
								DungeonGoSouth();
							}
						}
						if (_Input.contains("west")) {
							if (DungeonState==false) {
								MoveWestCMD();
							}
							else {
								DungeonGoWest();
							}
						}
						if (_Input.contains("east")) {
							if (DungeonState==false) {
								MoveEastCMD();
							}
							else {
								DungeonGoEast();
							}
						}
					} //END OF GO LOGIC//
					
					else if (_Input.contains("observe")) {
						ObserveCMD();
					}
					else if (_Input.contains("take")) {
						TakeItemCMD();
					}
					else if (_Input.contains("talk")) {
						// Call a Method
					} else if (_Input.contains("open")) {
						// Call a Method
					}
					else if (_Input.contains("enter")) {
						enterDungeonCMD();
					}
					else if (_Input.contains("leave")) {
						leaveDungeonCMD();
					}
					else if (_Input.contains("unlock")) {
						// Call a Method
					}
					else if (_Input.contains("lock")) {
						// Call a Method
					}
					else if (_Input.contains("close")) {
						// Call a Method
					} else if (_Input.contains("steal")) {
						// Call a Method
					}
					else if (_Input.contains("barter")) {
						// Call a Method
					}
					else if (_Input.contains("trick")) {
						// Call a Method
					}
					else if (_Input.contains("points")||_Input.contains("assign")) {
						AssignPoints();
						
					}
					else if (_Input.contains("equip")) {
						EquipItemCMD();
					}
					else if (_Input.contains("spells")) {
						// Call a Method
					}
					else if (_Input.contains("help")) {
						HelpCMD();
					}
					else if (_Input.contains("map")) {
						if (_Input.contains("world")) {
							Client.GenericOutputBoxOut(Map);
						}
						else if (_Input.contains("local")) {
							//Will add later
						}
						else {
							Client.GenericOutputBoxOut(Map);
						}
						
					}
					Client.CommandMode=false;
				}
				
			Levelup();
			
			Client._StatsInventory=("Inventory: "+playerInventory.GetInventory()+"\n"+"Gold: "+playerInventory.gold+"\n"+"Character: "+player.GetName()+"\nHealth: "+player.GetHP()+"/"+player.GetMaxHP()+"\nLevel: "+player.GetLVL()+"\nPoints: "+player.GetPoints()+"\nXP: "+player.GetXP()+"/"+player.GetMaxXP()+"\nMana: "+player.GetMana()+"/"+player.GetMaxMana()+"\nStrength: "+player.GetStrength()+"\nCharisma: "+player.GetCharisma()+"\nIntelligence: "+player.GetIntelligence()+"\nCarry Capacitiy: "+player.GetWeightCapacity());
			Client.StatsAndInventoryUpdate();
			Tick=1;
			}
			Tick++;
			}
			
}
	
	public void unlockInteractive() {
		int _WorldX = player.GetPlayerX();
		int _WorldY = player.GetPlayerY();
		
		int _DungeonX = player.GetPlayerXinDungeon();
		int _DungeonY = player.GetPlayerYinDungeon();
		switch (DungeonID) {
		case 0:
			// Nothing for now.
			break;
		case 1:
			// Unlock Cave1's Locked Door.
			if (cave1.IsLockedDoor(_DungeonX, _DungeonY)==1) {
				if (playerInventory.GetItemStored2(5)==true) {
					cave1.UnlockDoor(_DungeonX, _DungeonY, null);
				}
			}
			else {
				Client.GenericOutputBoxOut("\n<Already unlocked or not interactive.>\n");
				break;
			}
			
			break;
		case 2:
			// Nothing
			break;
		}
	}
	public void lockInteractive() {
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public void QuestCompleted() {
		boolean _QuestCompleted=false;
		switch (DungeonID) {
		case 1:
			
			break;
		case 2:
			if ((player.GetPlayerXinDungeon()==3)&&(player.GetPlayerYinDungeon()==2)&&(player.GetHP()>1)) {
						playerquests.TrollCaveQuest.SetQuestCompleted();
						player.ChangeXP(playerquests.TrollCaveQuest.GetQuestXPGranted());
						Client.GenericOutputBoxOut("\n<Quest Completed: + "+playerquests.TrollCaveQuest.GetQuestXPGranted()+"xp for defeating the Cave Troll>\n");
			}
			break;
		}
	}
	
	public void DungeonEvents() {
		boolean _QuestCompleted=false;
		switch (DungeonID) {
		case 1:
			
			break;
		case 2:
			if ((player.GetPlayerXinDungeon()==6)&&(player.GetPlayerYinDungeon()==1)) {
				playerquests.SetQueriedQuest(1);
				if (playerquests.GetQuest()==false) {
					playerquests.AddQuest(2);
				}
			}
			if ((player.GetPlayerXinDungeon()==3)&&(player.GetPlayerYinDungeon()==2)) {
				if (playerquests.TrollCaveQuest.GetBasicQuestCompleted()==false) {
					EventID=7;
				}
			}
			break;
		}
	}
	
	
	public void leaveDungeonCMD() {
		if (DungeonState==false) {
			//Nothing for now.
		}
		else {
			if (DungeonID==1) {
				if ((player._playerXinDungeon==1)&&(player._playerYinDungeon==1)) {
					DungeonID=0;
					DungeonState=false;
					EntranceSide=0;
					EventID=0;
					Client.GenericOutputBoxOut2("");
					player._playerX=3;
					player._playerY=5;
				}
				else if ((player._playerXinDungeon==6)&&(player._playerYinDungeon==4)) {
					DungeonID=0;
					DungeonState=false;
					EntranceSide=0;
					EventID=0;
					Client.GenericOutputBoxOut2("");
					player._playerX=3;
					player._playerY=7;
				}
				
				Client.SceneUpdate(player.GetPlayerX(),player.GetPlayerY());
			}
			if (DungeonID==2) {
				if ((player._playerXinDungeon==6)&&(player._playerYinDungeon==1)){
					DungeonID=0;
					DungeonState=false;
					EntranceSide=0;
					EventID=0;
					Client.GenericOutputBoxOut2("");
				}
				Client.SceneUpdate(player.GetPlayerX(),player.GetPlayerY());
			}
		}
	}
	
	public void enterDungeonCMD() {
		if (DungeonState==true) {
			//Nothing for now. Might make sub-rooms or other actions.
		}
		else {
			if ((player.GetPlayerX()==8)&&(player.GetPlayerY()==1)) {
				DungeonID=2;
				DungeonState=true;
				EntranceSide=1;
				Client.GenericOutputBoxOut2("");
				player._playerXinDungeon=6;
				player._playerYinDungeon=1;
				Client.SceneDungeonOutput(trollcave.GetScene(player.GetPlayerXinDungeon(),player.GetPlayerYinDungeon())+"\n");
				}
			if ((player.GetPlayerX()==3)&&(player.GetPlayerY()==5)) {
				DungeonID=1;
				DungeonState=true;
				EntranceSide=1;
				EventID=0;
				Client.GenericOutputBoxOut2("");
				DungeonScene();
			}
			else if ((player.GetPlayerX()==3)&&(player.GetPlayerY()==7)) {
				DungeonID=1;
				DungeonState=true;
				EntranceSide=2;
				EventID=0;
				Client.GenericOutputBoxOut2("");
				DungeonScene();
			}
			
			else {
				System.out.println("Player is not at a dungeon.");
			}
		}
	}
	
	public int AddTMPLoot() {
		int _SearchedID=0;
		if (_Input.contains("dagger")){
			_SearchedID = 1;
		}
		else {
			Client.GenericOutputBoxOut("<Item not found.>");
		}
		if (_SearchedID != 0) {
			boolean _ItemFound=false;
			for (int i : _TmpLootID) {
				int _position = 0;
				if (i == _SearchedID) {
					_TmpLootID[_position]=0;
					return _SearchedID;
				}
				if (_position+1<=_TmpLootID.length) {
					_position=_position+1;
				}
			}
			if (_ItemFound=false) {
				Client.GenericOutputBoxOut("<Item not found.>");
			}
		}
		return 0;
	}
	
	public void TakeItemCMD() {
		if ((DungeonState==false)&&(_lootInDungeon==false)) {
			if ((_XOfTmpLoot==player.GetPlayerX())&&(_YOfTmpLoot==player.GetPlayerY())) {
				playerInventory.AddItem2(AddTMPLoot());
			}
		} else if ((DungeonState==true)&&(_lootInDungeon==true)){
			if ((_XOfTmpLoot==player.GetPlayerXinDungeon())&&(_YOfTmpLoot==player.GetPlayerYinDungeon())) {
				playerInventory.AddItem2(AddTMPLoot());
			}
		
		}
		
		if (DungeonState==true) {
			switch (DungeonID) {
			case 1:
				// Cave 1
				if ((player.GetPlayerXinDungeon()==1)&&(player.GetPlayerYinDungeon()==1)&&(cave1.IsLooted(1)==false)) {
					playerInventory.AddItem2(1);
					cave1.SetLooted(1);
					Client.GenericOutputBoxOut("\n"+playerInventory.daggerItem.GetItemName()+"\n");
				}
				if ((player.GetPlayerXinDungeon()==6)&&(player.GetPlayerYinDungeon()==2)&&(cave1.IsLooted(2)==false)) {
					playerInventory.AddItem2(5);
					cave1.SetLooted(2);
					Client.GenericOutputBoxOut("\n"+playerInventory.rustedkey_cave1.GetItemName()+"\n");
				}
				break;
			case 2:
				// Troll Cave
				if (DungeonID==2) {
					if ((player.GetPlayerXinDungeon()==4)&&(player.GetPlayerYinDungeon()==3)&&(trollcave.IsLooted(3)==false)) {
						playerInventory.AddItem2(2);
						trollcave.SetLooted(3);
						Client.GenericOutputBoxOut("\n"+playerInventory.caveTrollBeastiary.GetBooksText()+"\n");
					}
					if ((player.GetPlayerXinDungeon()==2)&&(player.GetPlayerYinDungeon()==3)&&(trollcave.IsLooted(2)==false)) {
						playerInventory.AddItem2(3);
						trollcave.SetLooted(2);
						Client.GenericOutputBoxOut("\n"+playerInventory.lightdagger.GetItemName()+"\n");
					}
					if ((player.GetPlayerXinDungeon()==1)&&(player.GetPlayerYinDungeon()==1)&&(trollcave.IsLooted(1)==false)) {
						playerInventory.AddItem2(4);
						trollcave.SetLooted(1);
						playerspells.UnlockSpell(1, 1);
						Client.GenericOutputBoxOut("\n"+playerInventory.novicemagicbook.GetBooksText()+"\n");
					}
					
				}
				break;
				
			}
			
		}
		
		//Y:7
		if ((player.GetPlayerX()==3)&&(player.GetPlayerY()==7)){
			if (_Input.contains("coin")) {
				if (cave1_e2_gold==true) {
					playerInventory.gold=playerInventory.gold+10;
					cave1_e2_gold=false;
				}
				else {
					Client.GenericOutputBoxOut("You already took the item. It should be in your inventory.\n");
				}
			}
		}
	}
	
	public void EquipItemCMD() {
		if (_Input.contains("dagger")) {
			playerInventory.SetQueriedItem("Dagger");
			if (playerInventory.GetItemStored()=="Dagger") {
				Client.EquipItemOut(0,"Dagger");
				player.EquippedWeapon="Dagger";
				player.SetEquippedWeapon(playerInventory.daggerItem.GetDamage());
			}
			else {
				Client.EquipItemOut(1," ");
			}
		} 
		
		else if (player.EquippedWeapon!="") {
			Client.EquipItemOut(3,player.EquippedWeapon);
			player.EquippedWeapon="";
			player.SetUnequippedWeapon();
		}
		else {
			Client.EquipItemOut(2," ");
		}
	}
	
	
	public void HelpCMD() {
		String _Help="Commands you can use. These are checked in your sentence, meaning you can type in plain English, but you need these key words.\n\nObserve: Observes the scene or room you are in.\n\nTake (item): If no item is specified which ever item is the default in the scene/room will be taken.\n\nTalk (person name): If no name is specified who ever is the default in the scene/room will be talked to.\n\nOpen <object>: Doors, crates, chests, etc.\n\nEnter: Enters a room.\n\nUnlock <object>: Unlocks doors, crates, chests, etc. May require a key in some cases.\n\nLock <object>: Locks doors, crates, chests, etc. May require a key in some cases.\n\nClose <object>: Doors, crates, chests, etc.\n\nSteal (item): If no item is specified which ever item is the default in the scene/room will be taken. Owner will become hostile if he realizes what happen.\n\nBarter (person name): If no name is specified who ever is the default in the scene/room will be bartered with.\n\nTrick (person name): If no name is specified who ever is the default in the scene/room will be tricked.\n\nEquip <item>: Equips an item from your inventory, such as a dagger.\n\n";
		Client.HelpOut(_Help);
	}
	
	public void ObserveCMD() {
		if (DungeonState==false) {
			if ((player.GetPlayerX()==3)&&(player.GetPlayerY()==4)) {
				Client._Observe="You see a dark menacing tower in the far distance past mountains. To your immediate surroundings is plain forest, with nothing much of interesting.";
				Client.Observe();
			}
			else if ((player.GetPlayerX()==3)&&(player.GetPlayerY()==5)) {
				Client._Observe="You notice a a glint of light from inside the cave.";
				Client.Observe();
			}
			else if ((player.GetPlayerX()==3)&&(player.GetPlayerY()==7)) {
				Client._Observe="Laying on the ground by the cave is the remains of a long dead aventure. You notice by the skeleton's feet a small pouch of possibly gold coins.";
				Client.Observe();
			}
			else if ((player.GetPlayerX()==3)&&(player.GetPlayerY()==12)) {
				Client._Observe="You notice a large lock, easily the size of a small boulder, left on the ground by the tower's large imposing entrance door. Its long rusted and worn metal structure shredded by something...";
				Client.Observe();
			}
			else if ((player.GetPlayerX()==10)&&(player.GetPlayerY()==17)) {
				Client._Observe="Among the busy buzz of merchant caravans traveling to and fro the city grate, you notice a strange elderly man cloaked in black robes and with a large grey beard surrounded by a crowd. He yelled out, doom is upon the land! the Ancient Dark Lord has return!!!";
				Client.Observe();
			}
			
			
			else {
				// Default if this isn't a particular Scene/Location
				// Might eventually factor EventIDs in to create random observable content.
				Client._Observe="You don't see anything interesting.";
				Client.Observe();
			}
		}
		if (DungeonState==true){
			switch (DungeonID) {
			case 1:
				
				Client._Observe=cave1.GetObserve(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon());
				Client.Observe();
				
				break;
			case 2:
				
				Client._Observe=trollcave.GetObserve(player._playerXinDungeon, player._playerYinDungeon);
				Client.Observe();
				
				break;
			}
		}
	}
	
	public void MoveNorthCMD() {
		int _y = player.GetPlayerY();
		int _x = player.GetPlayerX();
		if (WorldMap[_y+1][_x]==0) {
			// Generic Walkable area.
			player.ChangePositionY(1);
			Client.SceneUpdate(player.GetPlayerX(),player.GetPlayerY());
			EventID=eventmanager.GetEvent(player.GetPlayerX(), player.GetPlayerY(), DungeonState, DungeonID);
		}
		else if (WorldMap[_y+1][_x]==1) {
			// Mountain - Not possible to go through this cell.
			Client.SceneOutputAppend("\n<You cannot cross the mountain.>\n");
		}
		else if (WorldMap[_y+1][_x]==3) {
			// Entrance to a Dungeon
			Client.SceneOutput("");
			player.ChangePositionY(1);
			Client.SceneUpdate(player.GetPlayerX(),player.GetPlayerY());
			
			Client.SceneOutputAppend("\n<Entrance to a Dungeon.>\n");
		}
		else if (WorldMap[_y+1][_x]==5) {
			// Walled of Dungeon Area - Not possible to go through this cell.
			Client.SceneOutputAppend("\n<Not the entrance to the Dungeon.>\n");
		}
		else if (WorldMap[_y+1][_x]==9) {
			// River - Not possible to go through this cell.
			Client.SceneOutputAppend("\n<You cannot cross the Grand River.>\n");
		}

	}	
	public void MoveSouthCMD() {
		int _y = player.GetPlayerY();
		int _x = player.GetPlayerX();
		if (WorldMap[_y-1][_x]==0) {
			// Generic Walkable area.
			player.ChangePositionY(-1);
			Client.SceneUpdate(player.GetPlayerX(),player.GetPlayerY());
			EventID=eventmanager.GetEvent(player.GetPlayerX(), player.GetPlayerY(), DungeonState, DungeonID);
		}
		else if (WorldMap[_y-1][_x]==1) {
			// Mountain - Not possible to go through this cell.
			Client.SceneOutputAppend("\n<You cannot cross the mountain.>\n");
			}
		else if (WorldMap[_y-1][_x]==3) {
			// Entrance to a Dungeon
			Client.SceneOutput("");
			player.ChangePositionY(-1);
			Client.SceneUpdate(player.GetPlayerX(),player.GetPlayerY());
			
			Client.SceneOutputAppend("\n<Entrance to a Dungeon.>\n");
		}
		else if (WorldMap[_y-1][_x]==5) {
			// Walled of Dungeon Area - Not possible to go through this cell.
			Client.SceneOutputAppend("\n<Not the entrance to the Dungeon.>\n");
			}
		else if (WorldMap[_y-1][_x]==9) {
			// River - Not possible to go through this cell.
			Client.SceneOutputAppend("\n<You cannot cross the Grand River.>\n");
		}
	}
	public void MoveWestCMD() {
		
		int _x = player.GetPlayerX();
		int _y = player.GetPlayerY();
		if (WorldMap[_y][_x+1]==0) {
			// Generic Walkable area.
			player.ChangePositionX(1);
			Client.SceneUpdate(player.GetPlayerX(),player.GetPlayerY());
			EventID=eventmanager.GetEvent(player.GetPlayerX(), player.GetPlayerY(), DungeonState, DungeonID);
		}
		else if (WorldMap[_y][_x+1]==1) {
			// Mountain - Not possible to go through this cell.
			Client.SceneOutputAppend("\n<You cannot cross the mountain.>\n");
		}
		else if (WorldMap[_y][_x+1]==3) {
			// Entrance to a Dungeon
			Client.SceneOutput("");
			player.ChangePositionX(1);
			Client.SceneUpdate(player.GetPlayerX(),player.GetPlayerY());
			
			Client.SceneOutputAppend("\n<Entrance to a Dungeon.>\n");
		}
		else if (WorldMap[_y][_x+1]==5) {
			// Walled of Dungeon Area - Not possible to go through this cell.
			Client.SceneOutputAppend("\n<Not the entrance to the Dungeon.>\n");
		}
		else if (WorldMap[_y][_x+1]==9) {
			// River - Not possible to go through this cell.
			Client.SceneOutputAppend("\n<You cannot cross the Grand River.>\n");
		}
	}
	public void MoveEastCMD() {
		int _x = player.GetPlayerX();
		int _y = player.GetPlayerY();
		if (WorldMap[_y][_x-1]==0) {
			// Generic Walkable area.
			player.ChangePositionX(-1);
			Client.SceneUpdate(player.GetPlayerX(),player.GetPlayerY());
			EventID=eventmanager.GetEvent(player.GetPlayerX(), player.GetPlayerY(), DungeonState, DungeonID);
		}
		else if (WorldMap[_y][_x-1]==1) {
			// Mountain - Not possible to go through this cell.
			Client.SceneOutputAppend("\n<You cannot cross the mountain.>\n");
		}
		else if (WorldMap[_y][_x-1]==3) {
			// Entrance to a Dungeon
			Client.SceneOutput("");
			player.ChangePositionX(-1);
			Client.SceneUpdate(player.GetPlayerX(),player.GetPlayerY());
			
			Client.SceneOutputAppend("\n<Entrance to a Dungeon.>\n");
		}
		else if (WorldMap[_y][_x-1]==5) {
			// Walled of Dungeon Area - Not possible to go through this cell.
			Client.SceneOutputAppend("\n<Not the entrance to the Dungeon.>\n");
		}
		else if (WorldMap[_y][_x-1]==9) {
			// River - Not possible to go through this cell.
			Client.SceneOutputAppend("\n<You cannot cross the Grand River.>\n");
		}
	}	
	
	public void DungeonScene() {
		String _SceneOutputDungeon="";
		switch (DungeonID) {
		case 1:
			// Cave 1   - Mainly entrance and turns need to have observes. A few other areas of interest as well.
			
			/*
			// Top right 2 is Cave1 Entrance 3,5. Bottom left 2 is Cave1 Entrance 3,7.
	 	 	// 1s are walls. 0s are walkable.
			 {1,1,1,1,1,1,1,1},
			 {1,2,0,0,0,0,0,1},
			 {1,1,1,1,0,1,0,1},
			 {1,1,0,0,0,0,1,1},
			 {1,1,0,0,1,0,2,1},
			 {1,1,1,1,1,1,1,1}
			 */			
			
			if ((player._playerXinDungeon==1)&&(player._playerYinDungeon==1)) {
				if (EntranceSide==1) {
					_SceneOutputDungeon="As you enter the cave you hear the distant squeeking of Cave Rats.";
				}
				if (EntranceSide==2) {
					_SceneOutputDungeon="You arrive to the opposing cave entrance. Presumably on the other side of the mountain.";
				}
				if (EntranceSide==0) {
					_SceneOutputDungeon="You see the Cave Entrance again.";
				}
			}
			else if ((player._playerXinDungeon==6)&&(player._playerYinDungeon==4)) {
				if (EntranceSide==1) {
					_SceneOutputDungeon="You notice quickly the bright light peaking through the cave wall and find yourself standing at the entrance of the cave.";
				}
				if (EntranceSide==2) {
					_SceneOutputDungeon="You arrive to the opposing cave entrance. Presumably on the other side of the mountain.";
				}
				if (EntranceSide==0) {
					_SceneOutputDungeon="You see the Cave Entrance again.";
				}
			}
			
			
			
			
			
			
			
			else {
				int __i = ((int) GetRandomnumber3()); // 1 - 6
				switch (__i) {
				case 1:	
					_SceneOutputDungeon="Not even the barest of interest can be grasped from these surroundings.";
					break;
				case 2:
					_SceneOutputDungeon="You see nothing of note in the darkness of this part of the cave.";
					break;
				case 3:
					_SceneOutputDungeon="The silence of the Cave as echos quietly stop creates a unnerving backdrop, to nothing.";
					break;
				default:
					_SceneOutputDungeon="Echos drift through the cave and you find nothing interesting near you at the moment.";
					break;
				}
			}
			
			Client.SceneDungeonOutput(_SceneOutputDungeon+"\n");
			break;
		case 2:
			//DarkTower
			break;
		}
	}
	
	
	public void DungeonGoNorth() {
		String _SceneOutputDungeon="";
		switch (DungeonID) {
		case 1:
			// Cave1

			if (cave1.CanPlayerGoNorth(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon())==true) {
				player._playerYinDungeon=player._playerYinDungeon+1;
				_SceneOutputDungeon=cave1.GetScene(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon());
				Client.SceneDungeonOutput(_SceneOutputDungeon+"\n");
			} else {
				System.out.println("You can't go that way.");
				Client.GenericOutputBoxOut("You can't go that way.");
			}
			
			break;
		case 2:
			//TrollCave
			if (trollcave.CanPlayerGoNorth(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon())==true){
				player._playerYinDungeon=player._playerYinDungeon+1;
				_SceneOutputDungeon=trollcave.GetScene(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon());
				Client.SceneDungeonOutput(_SceneOutputDungeon+"\n");
			} else {
				System.out.println("You can't go that way.");
				Client.GenericOutputBoxOut("You can't go that way.");
			}
			break;
		}
	}
	public void DungeonGoSouth() {
		String _SceneOutputDungeon="";
		switch (DungeonID) {
		case 1:
			//Cave1
			
			if (cave1.CanPlayerGoSouth(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon())==true) {
				player._playerYinDungeon=player._playerYinDungeon-1;
				_SceneOutputDungeon=cave1.GetScene(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon());
				Client.SceneDungeonOutput(_SceneOutputDungeon+"\n");
			} else {
				System.out.println("You can't go that way.");
				Client.GenericOutputBoxOut("You can't go that way.");
			}
			
			break;
		case 2:
			//TrollCave
			if (trollcave.CanPlayerGoSouth(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon())==true){
				player._playerYinDungeon=player._playerYinDungeon-1;
				_SceneOutputDungeon=trollcave.GetScene(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon());
				Client.SceneDungeonOutput(_SceneOutputDungeon+"\n");
			} else {
				System.out.println("You can't go that way.");
				Client.GenericOutputBoxOut("You can't go that way.");
			}
			break;
		}
	}
	public void DungeonGoWest() {
		String _SceneOutputDungeon="";
		switch (DungeonID) {
		case 1:
			// Cave1
			
			if (cave1.CanPlayerGoWest(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon())==true) {
				player._playerXinDungeon=player._playerXinDungeon-1;
				_SceneOutputDungeon=cave1.GetScene(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon());
				Client.SceneDungeonOutput(_SceneOutputDungeon+"\n");
			}
			else {
				
				if (cave1.CheckIfInteractive(player.GetPlayerXinDungeon()-1, player.GetPlayerYinDungeon())) {
					// Requires further work to ID what type of interactive content it is dealing with.
					System.out.println("You can't go that way.");
					Client.GenericOutputBoxOut("The path is blocked by a locked door. Find the key for this door.");
				}
				else {
					System.out.println("You can't go that way.");
					Client.GenericOutputBoxOut("You can't go that way.");
				}
			}
			
			
			break;
		case 2:
			//TrollCave
			if (trollcave.CanPlayerGoWest(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon())==true){
				player._playerXinDungeon=player._playerXinDungeon-1;
				_SceneOutputDungeon=trollcave.GetScene(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon());
				Client.SceneDungeonOutput(_SceneOutputDungeon+"\n");
			} else {
				System.out.println("You can't go that way.");
				Client.GenericOutputBoxOut("You can't go that way.");
			}
			break;
		}
	}
	public void DungeonGoEast() {
		String _SceneOutputDungeon="";
		switch (DungeonID) {
		case 1:
			// Cave1
			if (cave1.CanPlayerGoEast(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon())==true) {
				player._playerXinDungeon=player._playerXinDungeon+1;
				_SceneOutputDungeon=cave1.GetScene(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon());
				Client.SceneDungeonOutput(_SceneOutputDungeon+"\n");
			} else {
				System.out.println("You can't go that way.");
				Client.GenericOutputBoxOut("You can't go that way.");
			}
			
			break;
		case 2:
			// Troll Cave
			if (trollcave.CanPlayerGoEast(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon())==true){
				player._playerXinDungeon=player._playerXinDungeon+1;
				_SceneOutputDungeon=trollcave.GetScene(player.GetPlayerXinDungeon(), player.GetPlayerYinDungeon());
				Client.SceneDungeonOutput(_SceneOutputDungeon+"\n");
			} else {
				System.out.println("You can't go that way.");
				Client.GenericOutputBoxOut("You can't go that way.");
			}
			break;
		}
	}
	
	
	
	public float GetRandomnumber3() {
    	int _random;
    	Random random = new Random();
    	
    	int min = 1;
    	int max = 5;
    	_random = (random.nextInt(max - min + 1) + min);
    	
    	return _random;
    }
	public float GetRandomnumber2() {
    	int _random;
    	Random random = new Random();
    	
    	int min = 1;
    	int max = 10;
    	_random = (random.nextInt(max - min + 1) + min);
    	
    	return _random;
    }
	public float GetRandomnumber() {
    	int _random;
    	Random random = new Random();
    	
    	int min = 1;
    	int max = 20;
    	_random = (random.nextInt(max - min + 1) + min);
    	
    	return _random;
    }
	
	
	public void AssignPoints() {
		if (player._points>=2) {
			if (_Input.contains("strength")) {
				
				if (_Input.contains("all")) {
					while (player._points>=2) {
						player._points=player._points-2;
						player._strength++;
					}
				}
				else {
					player._points=player._points-2;
					player._strength++;
				}
				
			} else if (_Input.contains("weight")||_Input.contains("carry")) {
				
				if (_Input.contains("all")) {
					while (player._points>=2) {
						player._points=player._points-2;
						player._weightCapacity++;
					}
				}
				else {
					player._points=player._points-2;
					player._weightCapacity++;
				}
				
			} else if (_Input.contains("charisma")) {
				
				if (_Input.contains("all")) {
					while (player._points>=2) {
						player._points=player._points-2;
						player._charisma++;
					}
				}
				else {
					player._points=player._points-2;
					player._charisma++;
				}
				
			}
			
			else if (_Input.contains("intell")) {
				
				if (_Input.contains("all")) {
					while (player._points>=2) {
						player._points=player._points-2;
						player._intelligence++;
					}
				}
				else {
					player._points=player._points-2;
					player._intelligence++;
				}
				
			}
			else {
				Client.GenericOutputBoxOut("<assign point Strength, Carry, Charisma, Intelligence. Specify all if you wish to use all of your points leveling up that trait.>\n");
			}
			/*
			 	int _strength = 4;			// How hard a Player can hit or what types of weapons they can use.
				int _weightCapacity = 4;	// This affects how much loot the player can carry.
				int _charisma = 4;			// This affects trade and talking with NPCs.
				int _intelligence = 4;		// This affects observe. Also effects combat.
			 * */
		}
		player.SetCurrentActualDP();
	}
	
	public void Levelup() {
		if (player._xp>=player._maxXP) {
			
			while (player._xp>=player._maxXP) {
				player._xp=player._xp-player._maxXP;
				player._lvl++;
				player._points=player._points+2;
				player._maxXP=player._maxXP+10;
				player._maxHealth=player._maxHealth+10;
				player._health=player._maxHealth;
			}
		}
		
		
		
	}
	
	public boolean TmpLootCheck() {
		for (int i : _TmpLootID) {
			if (i==0) {
				return true;
			}
		}
		
		return false;
	}
	
	//&&(_XOfTmpLoot!=player.GetPlayerX())&&(_YOfTmpLoot!=player.GetPlayerY())
	//&&(_XOfTmpLoot!=player.GetPlayerXinDungeon())&&(_YOfTmpLoot!=player.GetPlayerYinDungeon())
	public void SetLoot(int lootID) {
		if (DungeonState==false) {
			_XOfTmpLoot=player.GetPlayerX();
			_YOfTmpLoot=player.GetPlayerY();
			boolean _TmpLootSpaceCheck = TmpLootCheck();
			if (_TmpLootSpaceCheck==true) {
				for (int i : _TmpLootID) {
					if (i == 0) {
						_TmpLootID[i]=lootID;
					}
				}
			}
			else {
				_TmpLootID[1]=lootID;
			}
			
			_lootInDungeon=false;
		}
		if (DungeonState==true) {
			_XOfTmpLoot=player.GetPlayerXinDungeon();
			_YOfTmpLoot=player.GetPlayerYinDungeon();
			boolean _TmpLootSpaceCheck = TmpLootCheck();
			if (_TmpLootSpaceCheck==true) {
				for (int i : _TmpLootID) {
					if (i == 0) {
						_TmpLootID[i]=lootID;
					}
				}
			}
			else {
				_TmpLootID[1]=lootID;
			}
			_lootInDungeon=true;
		}
	}
	
	
	
	public void EventCombat() {
		player.SetCurrentActualDP();
		//Skeleton skeleton = new Skeleton();
		//Troll troll = new Troll();
		Goblin goblin = new Goblin();
		Bandit bandit = new Bandit();
		Rat rat = new Rat();
		Troll troll = new Troll();
		Skeleton skeleton = new Skeleton();
		

		String _EnemyName="";
		int _EnemyHealth=0;
		int _EnemyIntelligence=0;
		int _tmp_Intelligence=0;
		int _EnemyActualDP=0;
		
		int _GrantedXP = 0;
		
		String _sEscape="You escaped the ";
		
		switch (EventID) {
		case 4: // Bandit
			_EnemyName=bandit.GetName();
			_EnemyHealth=bandit.GetHP();
			_EnemyIntelligence = bandit.GetIntelligence();
			_EnemyActualDP = bandit.GetActualDP();
			_GrantedXP = bandit.GetGrantedXP();
			break;
		case 5: // Rat
			_EnemyName=rat.GetName();
			_EnemyHealth=rat.GetHP();
			_EnemyIntelligence = rat.GetIntelligence();
			_EnemyActualDP = rat.GetActualDP();
			_GrantedXP = rat.GetGrantedXP();
			break;
		case 6: // Goblin
			_EnemyName=goblin.GetName();
			_EnemyHealth=goblin.GetHP();
			_EnemyIntelligence = goblin.GetIntelligence();
			_EnemyActualDP = goblin.GetActualDP();
			_GrantedXP = goblin.GetGrantedXP();
			
			break;
		case 7: // Troll
			_EnemyName=troll.GetName();
			_EnemyHealth=troll.GetHP();
			_EnemyIntelligence = troll.GetIntelligence();
			_EnemyActualDP = troll.GetActualDP();
			_GrantedXP = troll.GetGrantedXP();
			break;
		case 8: // Skeleton
			_EnemyName=skeleton.GetName();
			_EnemyHealth=skeleton.GetHP();
			_EnemyIntelligence = skeleton.GetIntelligence();
			_EnemyActualDP = skeleton.GetActualDP();
			_GrantedXP = skeleton.GetGrantedXP();
			break;
		}

		
		CombatMode=true;
		while (CombatMode==true) {
			Tick++;
			if (Client.CommandMode==true) {
				_Input=Client.UserInput;
				_Input.toLowerCase();
				Client.ClearInputBox();
				while (Client.CommandMode==true) {
					if (_Input.contains("go")) {
						if (GetRandomnumber2()<5) {
							CombatMode=false;
							Client.GenericOutputBoxOut(_sEscape+_EnemyName+"\n");
							if (_Input.contains("north")) {
								MoveNorthCMD();
								break;
							}
							if (_Input.contains("south")) {
								MoveSouthCMD();
								break;
							}
							if (_Input.contains("west")) {
								MoveWestCMD();
								break;
							}
							if (_Input.contains("east")) {
								MoveEastCMD();
								break;
							}
						}
					} //END OF GO LOGIC//
					if (_Input.contains("attack")) {
						if (player.GetIntelligence()>=(GetRandomnumber2()/2)) {
							_EnemyHealth=_EnemyHealth-player._ActualDP;
							
							Client.GenericOutputBoxOut("You did "+player._ActualDP+" damage.");
						}
						else {
							Client.GenericOutputBoxOut("You missed.");
						}
						
					}
					if ((_EnemyName==troll.GetName())&&(_Input.contains("rock")&&(_Input.contains("feet"))||(_Input.contains("foot")))) {
						if (player.GetIntelligence()>=(GetRandomnumber2()/2)) {
							_EnemyHealth=_EnemyHealth-player._ActualDP;
							_EnemyIntelligence=0;
							Client.GenericOutputBoxOut("You did "+player._ActualDP+" damage.");
						}
						else {
							Client.GenericOutputBoxOut("You missed.");
						}
					}
					if ((_EnemyName==skeleton.GetName())&&(_Input.contains("cast")&&(playerspells.CheckSpellLock(1, 1)==false)&&(_Input.contains("pulse"))||(_Input.contains("light")))) {
						if (player.GetIntelligence()>=(GetRandomnumber2()/2)) {
							_EnemyHealth=_EnemyHealth-playerspells.lightmagicspell.GetSpellDamage();
							
							Client.GenericOutputBoxOut("You did "+playerspells.lightmagicspell.GetSpellDamage()+" damage and weaken the Dark Lords necromatic powers over the skeleton.");
							_EnemyHealth=_EnemyHealth-900;
						}
						else {
							Client.GenericOutputBoxOut("You missed.");
						}
					}
					
					Client.CommandMode=false;
				}
			
			
			}
			if (Tick>1000000000) {
				if (_EnemyHealth>0) {
					Tick=1;
					if (_EnemyIntelligence<=0) {
						if (7>=(GetRandomnumber2())) {
							switch (EventID) {
							case 8:
								_EnemyIntelligence = troll.GetIntelligence();
								Client.GenericOutputBoxOut("Troll refocuses on you.");
								break;
							}
						}
						else {
							Client.GenericOutputBoxOut("Troll remains distracted by his feet hurting.");
						}
					}
					if (_EnemyIntelligence>=(GetRandomnumber2()/2)) {
						player._health=player._health-_EnemyActualDP;
						Client.GenericOutputBoxOut("The "+_EnemyName+" did "+(_EnemyActualDP)+" damage.");
					}
					else {
						Client.GenericOutputBoxOut("The "+_EnemyName+" missed.");
					}
					} else if (_EnemyHealth<=0) {
						CombatMode=false;
						Client.GenericOutputBoxOut("The "+_EnemyName+" is dead.");
						player._xp=player._xp+_GrantedXP;
						break;
					}
					if (player._health<=0) {
						CombatMode=false;
						Client.GenericOutputBoxOut("You are dead.");
					}
					Levelup();
					Client._StatsInventory=("Inventory: "+playerInventory.GetInventory()+"\n"+"Gold: "+playerInventory.gold+"\n"+"Character: "+player.GetName()+"\nHealth: "+player.GetHP()+"/"+player.GetMaxHP()+"\nLevel: "+player.GetLVL()+"\nPoints: "+player.GetPoints()+"\nXP: "+player.GetXP()+"/"+player.GetMaxXP()+"\nMana: "+player.GetMana()+"/"+player.GetMaxMana()+"\nStrength: "+player.GetStrength()+"\nCharisma: "+player.GetCharisma()+"\nIntelligence: "+player.GetIntelligence()+"\nCarry Capacitiy: "+player.GetWeightCapacity());
					Client.StatsAndInventoryUpdate();
				}
		}
		
	}
		
}
