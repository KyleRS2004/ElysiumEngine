package src.Locations;

import src.ItemsFolder.Items;

public class Location {
	int[][] _Map;
	int[][] _LootMap;
	int[][] _TileIDMap;
	int _CurrentTileID;
	int _CurrentLootTile;
	int[][] _CurrentRoomInteractive;
	Items correctkey;
	int _LootList1;
	int _LootList2;
	int _LootList3;
	int _LootID;
	String _mapName;
	int _dungeonID;
	
	String SceneOutput00;
	String SceneOutput01;
	String SceneOutput02;
	String SceneOutput03;
	String SceneOutput04;
	String SceneOutput05;
	String SceneOutput06;
	
	String ObserveOutput00;
	String ObserveOutput01;
	String ObserveOutput02;
	String ObserveOutput03;
	String ObserveOutput04;
	String ObserveOutput05;
	String ObserveOutput06;
	
	String SceneOutput;
	String ObserveOutput;
	int _EventID;
	int _TileType;
	
	
	
	
	/*
	 * 	EventID:
	 * 		0 Nothing
	 * 		1 Combat
	 * 		2 Story
	 * 		3 Boss fight
	 * 		4 Trap
	 * 		5 Wall
	 * 
	 * */
	
	public boolean CheckIfInteractive(int x, int y) {
		boolean _IsInteractive=false;
		if (_Map[y][x]==5) {
			_IsInteractive=true;
		}
		
		return _IsInteractive;
	}
	
	public int IsLockedDoor(int x, int y) {
		int _DoorIsLocked=0;
		if (_CurrentRoomInteractive[y][x]==1) {
			_DoorIsLocked=1;
		}
		
		return _DoorIsLocked;
	}
	
	public void UnlockDoor(int x, int y, Items item) {
		if (IsLockedDoor(x,y)==1) {
			_CurrentRoomInteractive[y][x]=2;
		}
		else {
			// Maybe change to be else if (lockpick) { random number to check success then output lock or unlocked}
		}
	}
	
	public void LockDoor(int x, int y) {
		if (_CurrentRoomInteractive[y][x]==1) {
			// Do nothing, its already locked.
		}
		else if (_CurrentRoomInteractive[y][x]==2) {
			// Lock the door
			_CurrentRoomInteractive[y][x]=1;
		}
	}
	
	public boolean CanPlayerGoNorth(int x, int y) {
		if (_Map[y+1][x]==0) {
			_TileType=0;
			return true;
		} else if (_Map[y+1][x]==1) {
			_TileType=5;
			return false;
		} else if (_Map[y+1][x]==2) {
			_TileType=2;
			return true;
		}
		else {
			return false;
		}
	}
	public boolean CanPlayerGoSouth(int x, int y) {
		if (_Map[y-1][x]==0) {
			_TileType=0;
			return true;
		} else if (_Map[y-1][x]==1) {
			_TileType=5;
			return false;
		} else if (_Map[y-1][x]==2) {
			_TileType=2;
			return true;
		}
		else {
			return false;
		}
	}
	public boolean CanPlayerGoWest(int x, int y) {
		if (_Map[y][x-1]==0) {
			_TileType=0;
			return true;
		} else if (_Map[y][x-1]==1) {
			_TileType=5;
			return false;
		} else if (_Map[y][x-1]==2) {
			_TileType=2;
			return true;
		}
		else {
			return false;
		}
	}
	public boolean CanPlayerGoEast(int x, int y) {
		if (_Map[y][x+1]==0) {
			_TileType=0;
			return true;
		} else if (_Map[y][x+1]==1) {
			_TileType=5;
			return false;
		} else if (_Map[y][x+1]==2) {
			_TileType=2;
			return true;
		}
		else {
			return false;
		}
	}
	
	public String GetScene(int x, int y) {
		_CurrentTileID=_TileIDMap[y][x];
		switch (_CurrentTileID) {
		case 0:
			// Generic Cells
			
			SceneOutput=SceneOutput00;
			break;
		case 1:
			
			SceneOutput=SceneOutput01;
			break;
		case 2:
			
			SceneOutput=SceneOutput02;
			break;
		case 3:
			
			SceneOutput=SceneOutput03;
			break;
		case 4:
			
			SceneOutput=SceneOutput04;
			break;
		case 5:
			
			SceneOutput=SceneOutput05;
			break;
		case 6:
			
			SceneOutput=SceneOutput06;
			break;	
			
		}
		
		
		
		return SceneOutput;
	}

	public String GetObserve(int x, int y) {
		_CurrentTileID=_TileIDMap[y][x];
		switch (_CurrentTileID) {
		case 0:
			// Generic Cells
			
			ObserveOutput=ObserveOutput00;
			break;
		case 1:
			
			ObserveOutput=ObserveOutput01;
			break;
		case 2:
			
			ObserveOutput=ObserveOutput02;
			break;
		case 3:
			
			ObserveOutput=ObserveOutput03;
			break;
		case 4:
			
			ObserveOutput=ObserveOutput04;
			break;
		case 5:
			
			ObserveOutput=ObserveOutput05;
			break;
		case 6:
			
			ObserveOutput=ObserveOutput06;
			break;
		}
		
		return ObserveOutput;
	}
	
	public int GetItemID(int x, int y) {
		_CurrentLootTile=_LootMap[y][x];

		return _LootID;
	}
	public boolean IsLooted(int loot) {
		boolean _LootStatus=false;
		switch (loot) {
		case 1:
			if (_LootList1==0) {
				_LootStatus=true;
			}
			break;
		case 2:
			if (_LootList2==0) {
				_LootStatus=true;
			}
			break;
		case 3:	
			if (_LootList3==0) {
				_LootStatus=true;
			}
			break;
		}
		
		
		return _LootStatus;
	}
	public void SetLooted(int loot) {
		switch (loot) {
		case 1:
			_LootList1=0;
			break;
		case 2:
			_LootList2=0;
			break;
		case 3:	
			_LootList3=0;
			break;
		}
	}
	
	
}
