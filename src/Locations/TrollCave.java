package src.Locations;

public class TrollCave extends Location {
	int[][] _TMP_Map = {
			// 1 2 3 4 5 6 
			{1,1,1,1,1,1,1,1},// 0	  [0 tile] (1,1),(2,3),(4,3): Loot located in these tiles.
			{1,0,0,1,1,1,0,1},// 1    [0 tile] (6,0) is the entrance to the dungeon.
			{1,1,0,2,0,1,0,1},// 2    [2 tile] (3,2) activates the troll battle.
			{1,1,0,1,0,2,0,1},// 3	  [2 tile] (5,3) find a large busted cave along with the broken remains of a large pickaxe.
			{1,1,1,1,1,1,1,1} // 4
	};
	int[][] _TMP_LootMap = {
			// 1 2 3 4 5 6 
			{0,0,0,0,0,0,0,0},// 0	  [0 tile] (1,1),(2,3),(4,3): Loot located in these tiles.
			{0,3,0,0,0,0,1,0},// 1    [0 tile] (6,0) is the entrance to the dungeon.
			{0,0,0,0,0,0,0,0},// 2    [2 tile] (3,2) activates the troll battle.
			{0,0,3,0,3,0,0,0},// 3	  [2 tile] (5,3) find a large busted cave along with the broken remains of a large pickaxe.
			{0,0,0,0,0,0,0,0} // 4
	};
	int[][] _TMP_TileIDMap= {
			// 1 2 3 4 5 6 
			{0,0,0,0,0,0,0,0},// 0	  [0 tile] (1,1),(2,3),(4,3): Loot located in these tiles.
			{0,6,0,0,0,0,1,0},// 1    [0 tile] (6,0) is the entrance to the dungeon.
			{0,0,0,4,0,0,0,0},// 2    [2 tile] (3,2) activates the troll battle.
			{0,0,5,0,3,2,0,0},// 3	  [2 tile] (5,3) find a large busted cave along with the broken remains of a large pickaxe.
			{0,0,0,0,0,0,0,0} // 4
	};		//LightMagicBook = 1, Light Dagger = 2, Troll Beastiary = 3.
	
	
	
	public TrollCave() {
		_Map=_TMP_Map;
		_LootMap=_TMP_LootMap;
		_TileIDMap=_TMP_TileIDMap;
		_LootList1=1; // Light Magic Book
		_LootList2=1; // Light Dagger
		_LootList3=1; // Troll Book
		_CurrentTileID=0;
		_CurrentLootTile=0;
		_LootID=0;
		
		_mapName="Troll Cave";
		_dungeonID=2;
		
		SceneOutput00="You see the destroyed remains of the mine with bodies of those lone dead strewn about half eaten.";
		SceneOutput01="You find yourself at the entrance of the mine and see a slew of long dead soldiers. They chest appears to have suffered severe trauma with a massive foot wide cavity having been created.. Their armor and weapons long rusted away from being useful.";
		SceneOutput02="In the portion of the cave your at, you find a massive twelve foot tall cage. By it the remains of a massive chain that carried the obvious signs of being snapped, lay eeriely on top of several dead soldiers.";
		SceneOutput03="You hear quiet rumbling in the distance, was it the cave or the unknown creature? Besides the noises you notice a chest.";
		SceneOutput04="As you step in to the next area you realize you are being watched.";
		SceneOutput05="In a pile, you find a chest filled with premium weapons and armor in suprisingly good condition.";
		SceneOutput06="You find the dead remains of a Mage. In their hands was a book on Light Magic, a notoriously useless field of magic, but quite valuable...";
		
		ObserveOutput00="Nothing much of interest is in sight at the moment, but the mine's eerie sounds leave you unsettled.";
		ObserveOutput01="You take note of the flag of the Elysium Kingdom, which recently became defunct from what you heard back home.";
		ObserveOutput02="You notice several large pickaxes near by, designed for the creature to use. Presumably as a form of slave labor?";
		ObserveOutput03="You notice behind the chest is a beastiary on Cave Trolls.";
		ObserveOutput04="You notice a strange black obelisk in the middle of the room. Clearly it became a focus of the mining operation, or perhaps this is more of an archeology find?";
		ObserveOutput05="You notice a strange looking dagger laying on the ground just pocking out of under a rock. Inspecting it closer you realize it has a light runes engraved into it.";
		ObserveOutput06="Upon closer inspection of the Mage you realize that he is actually not recently dead, but had been mummified. He appears to be thousands of years old.";
		
		SceneOutput="";
		ObserveOutput="";
		_EventID=0;
		_TileType=0;
	}
}
