package src.Records;

public class WorldData {
	
	/*
	 * 	World data is used to identfy completed content, and to provide dynamic
	 *  changing content. Players actions should change options, if they choose
	 *  to do good or evil, there may be consquences. Choices not made can
	 *  have consquences as well. Some of these wont manifest truely to the end
	 *  in the ending slides, or rather ending scroll where the text is slowly
	 *  typed out in star wars intro outro style.
	 * 
	 *List:
	 * 	Dynamic encounters
	 * 	Quests available and way they flow
	 *  Characters able to be talked to
	 *  Fates of different parts of Elysium
	 *  The way factions view and interact with you.
	 *  Etc
	 *  End Slide.
	 * 
	 * */
	
	
	int[][] DungeonFinished = { // 1 = done, 0 = not done.
			{}, //World Map
			{}, //Ancient League of Light Supply Depot, now Rat Nest - Cave1
			{}, //Troll Cave
	};
	
	public void SetFinished(int DungeonID, int contentDone) {
		DungeonFinished[DungeonID][contentDone]=1;
	}
	
	public boolean GetFinished(int DungeonID, int contentDone) {
		boolean _IsFinished = false;
		if (DungeonFinished[DungeonID][contentDone]==1) {
			_IsFinished = true;
			return _IsFinished;
		}
		return _IsFinished;
	}
	
	
}
