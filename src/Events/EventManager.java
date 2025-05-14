package src.Events;

import java.util.Random;

public class EventManager {

	int[][] WorldEventMap = { // 1 for in accessible areas, (0,2,3) for different EventGen Zones.
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,3,3,3,3,3,1},
			{1,0,0,0,0,0,0,1,3,3,3,3,3,3,3,3,3,3,3,3,1},
			{1,0,0,1,0,1,1,1,3,3,3,3,3,3,3,3,3,3,3,3,1},
			{1,0,0,0,1,1,3,3,3,3,3,3,3,3,3,3,3,3,3,3,1},
			{1,0,0,1,1,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,1},
			{1,0,0,1,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,1},
			{1,0,0,1,3,3,3,3,1,1,3,3,3,3,3,3,3,3,3,3,1},
			{1,1,1,1,3,3,3,3,1,1,1,3,3,3,3,3,3,3,3,3,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,3,3,3,3,3,3,3,3,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,3,3,3,3,3,3,3,3,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},	
	};
	
	int SouthZone=2;
	int MidZone=0;
	int NorthZone=3;
	
	int EventID=0;
	boolean _DungeonState=false;
	int _DungeonID=0;
	
	int _x=3;
	int _y=4;
	
	/*
	 * South Zone is the zone where the player starts. (3/4)
	 * 	It should have weaker variants of enemies and shouldn't
	 *  have any Trolls or Skeletons.
	 * 
	 * Mid Zone is the zone where the player will start to
	 * seriously encounter the games story. Here they'll
	 * find the remains of Elysium's ancient dark empire.
	 * 		Should even at the start of the game have more
	 * 		dangerous enemies including the ones listed above,
	 * 		but they should be at a weaker level or rare.
	 * 
	 * North Zone is the town zone, enemies should be rare
	 * and human interaction much more common here.
	 * 		Primary enemies here should be bandits and some Goblins.
	 * */
	
	public void EventGenerator() {
		int _Event=(int) GetRandomnumber();
		switch (_DungeonID) {
		case 0:	
			switch (WorldEventMap[_y][_x]) {
			case 2:
				//South Zone
				if (_Event<=15) {
					if (_Event<=2) {
						EventID=4;
					} else if (_Event<=8) {
						EventID=5;
					} else if (_Event<=13) {
						EventID=6;
					}
					else {
						EventID=0;
					}
					
				}
				break;
			case 0:
				// Mid Zone
				if (_Event<=15) {
					if (_Event==1) {
						EventID=1;
					} else if (_Event==2) {
						EventID=2;
					} else if (_Event==3) {
						EventID=3;
					} else if (_Event==5) {
						EventID=4;
					} else if (_Event==6) {
						EventID=5;
					} else if (_Event<=8) {
						EventID=6;
					} else if (_Event<=13) {
						EventID=7;
					} else if (_Event<=15) {
						EventID=8;
					}
					else {
						EventID=0;
					}
					
				}	
				break;
			case 3:
				// North Zone
				if (_Event<=15) {
					if (_Event<3) {
						EventID=1;
					} else if (_Event<=5) {
						EventID=2;
					} else if (_Event<=8) {
						EventID=3;
					} else if (_Event==12) {
						EventID=4;
					} else if (_Event<=14) {
						EventID=5;
					} else if (_Event==15) {
						EventID=6;
					}
					
					else {
						EventID=0;
					}
					
				}	
				break;
			}
			break;
		case 1:
			// Insert Event Manager for Cave 1
			
			break;
		
		}
	}
	
	
	// Player X and Y is fed in and whether the player is in a dungeon is checked.
	public int GetEvent(int x, int y, boolean dungeonstate, int dungeonid) {
		_x=x;
		_y=y;
		_DungeonState=dungeonstate;
		_DungeonID=dungeonid;
		EventGenerator();
		return EventID;
	}
	
	
	public float GetRandomnumber() {
    	int _random;
    	Random random = new Random();
    	
    	int min = 1;
    	int max = 20;
    	_random = (random.nextInt(max - min + 1) + min);
    	
    	return _random;
    }
	
	
	
	
}
