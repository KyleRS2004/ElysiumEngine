package src.Locations;

public class Cave1 extends Location {
	int[][] _TMP_Map = {
			// 1 2 3 4 5 6 7
			{1,1,1,1,1,1,1,1}, // 0
			{1,0,0,0,0,0,0,1}, // 1
			{1,1,1,1,0,1,0,1}, // 2
			{1,1,1,5,0,0,1,1}, // 3
			{1,1,0,0,1,0,0,1}, // 4
			{1,1,1,1,1,1,1,1}  // 5
	};
	int[][] _TMP_LootMap = {
			{0,0,0,0,0,0,0,0}, // 0 (1,1) Dagger
			{0,1,0,0,0,0,0,0}, // 1 (6,2) Rusted Key
			{0,0,0,0,0,0,1,0}, // 2
			{0,0,0,0,0,0,0,0}, // 3
			{0,0,0,0,0,0,0,0}, // 4
			{0,0,0,0,0,0,0,0}  // 5
	};
	int[][] _TMP_TileIDMap= {
			
			{0,0,0,0,0,0,0,0}, // 0
			{0,1,0,0,2,0,0,0}, // 1
			{0,0,0,0,0,0,3,0}, // 2
			{0,0,0,0,4,0,0,0}, // 3
			{0,0,5,0,0,0,6,0}, // 4
			{0,0,0,0,0,0,0,0}  // 5
			
	};
	int[][] _TMP_CurrentRoomInteractive = {
			
			{0,0,0,0,0,0,0,0}, // 0
			{0,0,0,0,0,0,0,0}, // 1
			{0,0,0,1,0,0,0,0}, // 2
			{0,0,0,0,0,0,0,0}, // 3
			{0,0,0,0,0,0,0,0}  // 4
			
	};
	
	public Cave1() {
		_Map=_TMP_Map;
		_LootMap=_TMP_LootMap;
		_TileIDMap=_TMP_TileIDMap;
		_CurrentRoomInteractive = _TMP_CurrentRoomInteractive;
		
		
		_CurrentTileID=0;
		_CurrentLootTile=0;
		_LootID=0;
		
		_LootList1=1;
		_LootList2=1;
		
		_mapName="Rat Cave";
		_dungeonID=1;
		
		SceneOutput00="There is nothing here of interest. Just distant echos...";
		SceneOutput01="As you enter the cave you hear the distant squeeking of Cave Rats.";
		SceneOutput02="You arrive at a crossing of paths. You can continue this way or turn right and head further north in the cave.";
		SceneOutput03="Arrive to find a scene of carnage from a bygone era. Fourty skeletons dressed in rusted armored plating surrounded a ledge and a single long dead man with a mighty warhammer remained in his final moments with multiple swords impaling his torso. To the side there is chest, pressed up against the caves wall and just barely visible from down the cave's halls.";
		SceneOutput04="You arrive at anothering cross roads, with a path further into the cave sealed by an ancient iron door that requires a key or to head the opposite direction and proceed possibly out of the cave.";
		SceneOutput05="The Cave Rats have noticed you and have gathered forces. Twenty have shown up and will attempt to kill and eat you.";
		SceneOutput06="You find an alternate exit to the entrance you came through.";
		
		
		ObserveOutput00="You notice nothing interesting. Just the cold dead stone halls of the cave.";
		ObserveOutput01="Laying by the edge of the wall you find a dead man, dressed in ragged clothing that based on his wounds appears that he was mauled by something and by his side you see a large dagger.";
		ObserveOutput02="You see in the distance what appears to be a chest just slightly peaking around a corner.";
		ObserveOutput03="You notice in the chest was an old rusted key. It might prove useful.";
		ObserveOutput04="You hear screeching beyond the door and then notice several cave rat sized holes in the stone leading from the main cave into the ancient structure.";
		ObserveOutput05="Now having time to have a look around, you notice scraps of clay tablets laying on the various workbenches and desks. Taking a look at them you realize they were battle reports of sorts. Most of it unintelligible.";
		ObserveOutput06="As you observe the area, you notice from outside the cave in the day sun a slight flash of light from what looks like a pouch of gold coins.";
		
		SceneOutput="";
		ObserveOutput="";
		_EventID=0;
		_TileType=0;
	}
	
}
