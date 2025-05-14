package src;

import java.util.ArrayList;

import src.Quests.*;

public class PlayersQuests {
	int[] Quests = {};
	int _positionInQuestList;
	int _Quest;
	boolean _QuestFound;
	int _queriedQuest;
	//ITEMS
	ArrayList<Quests> QuestArray = new ArrayList<Quests>();
	TrollCaveQuest TrollCaveQuest = new TrollCaveQuest();
	
	public int GetQuestArrayLength() {
		return Quests.length;
	}
	
	public void AddQuest(int QuestID) {
		switch (QuestID) {
		case 1:
			//TrollCaveQuest
			QuestArray.add(TrollCaveQuest);
			break;
			
			
		}
	}
	
	
	
	
	
	public void SetQueriedQuest(int QuestID) {
		_queriedQuest=QuestID;
	}
	
	public boolean GetQuest() {
		
		_QuestFound=false;
		for (Quests i : QuestArray) {
			System.out.println(i);
			if (i.equals(TrollCaveQuest)) {
				if (TrollCaveQuest.GetQuestID()==_queriedQuest) {
					System.out.println("Object found and in the query.");
					_QuestFound=true;
					_queriedQuest=0;
					return true;
				}
				else {
				System.out.println("Object found, but not in the query.");
				}
			}
			
			
			

			if (_QuestFound==false){
				_positionInQuestList++;
			}
		}
		
		return false;

	}
	
	
	public String GetQuests() {
		String _QuestCompleted="(Finished)";
		String _QuestNotCompleted="(Active)";
		String _TotalQuestList="";
		for (Quests i : QuestArray) {
			if (i.GetQuestCompleted()==true) {
				_TotalQuestList = _TotalQuestList + "\n" + i.GetQuestName()+" "+_QuestCompleted;
			}
			else {
				_TotalQuestList = _TotalQuestList + "\n" + i.GetQuestName()+" "+_QuestNotCompleted;
			}
			
			
		}
		if (QuestArray.isEmpty()) {
			_TotalQuestList = "You have no quests";
		}
		
		return _TotalQuestList;
	}
	
}
