package src.Quests;

public class Quests {

	/* This is a template for future quests.
	 * 
	 * Quest: <Name>
	 * Description:
	 *  <
	 *  
	 * 	>
	 * Plot-line
	 * 	Beginning:
	 * 		+
	 * 	Rising Action:
	 * 		+
	 * 		+
	 * 	Climax:
	 * 		+
	 * 	Falling Action:
	 * 		+
	 * 		+
	 * 	Resolution:
	 * 		+
	 * 
	 * 
	 * Important side details and Characters:
	 * 		+
	 * 		+ 
	 * 		+
	 *  
	 * */
	
	String QuestName="";
	int QuestID;
	int QuestXPGranted;
	
	
	boolean SubQuest1Done = false;
	boolean SubQuest2Done = false;
	boolean SubQuest3Done = false;
	boolean QuestRequirementsCompleted = false;
	
	
	String QuestDialogue01;
	String QuestDialogue02;
	String QuestDialogue03;
	String QuestDialogue04;
	String QuestDialogue05;
	String QuestDialogue06;
	String QuestDialogue07;
	String QuestDialogue08;
	String QuestDialogue09;
	String QuestDialogue10;
	String QuestDialogue11;
	String QuestDialogue12;
	String QuestDialogue13;
	String QuestDialogue14;
	String QuestDialogue15;
	String QuestDialogue16;
	String QuestDialogue17;
	String QuestDialogue18;
	String QuestDialogue19;
	String QuestDialogue20;
	
	public String GetDialogue(int DialogueID) {
		String _CurrentDialogue="";
		switch (DialogueID) {
		case 1:
			_CurrentDialogue=QuestDialogue01;
			break;
		case 2:
			_CurrentDialogue=QuestDialogue02;
			break;
		case 3:
			_CurrentDialogue=QuestDialogue03;
			break;
		case 4:
			_CurrentDialogue=QuestDialogue04;
			break;
		case 5:
			_CurrentDialogue=QuestDialogue05;
			break;
		case 6:
			_CurrentDialogue=QuestDialogue06;
			break;
		case 7:
			_CurrentDialogue=QuestDialogue07;
			break;
		case 8:
			_CurrentDialogue=QuestDialogue08;
			break;
		case 9:
			_CurrentDialogue=QuestDialogue09;
			break;
		case 10:
			_CurrentDialogue=QuestDialogue10;
			break;
		case 11:
			_CurrentDialogue=QuestDialogue11;
			break;
		case 12:
			_CurrentDialogue=QuestDialogue12;
			break;
		case 13:
			_CurrentDialogue=QuestDialogue13;
			break;
		case 14:
			_CurrentDialogue=QuestDialogue14;
			break;
		case 15:
			_CurrentDialogue=QuestDialogue15;
			break;
		case 16:
			_CurrentDialogue=QuestDialogue16;
			break;
		case 17:
			_CurrentDialogue=QuestDialogue17;
			break;
		case 18:
			_CurrentDialogue=QuestDialogue18;
			break;
		case 19:
			_CurrentDialogue=QuestDialogue19;
			break;
		case 20:
			_CurrentDialogue=QuestDialogue20;
			break;
		}
		
		return _CurrentDialogue;
	}
	
	public String GetQuestName() {
		return QuestName;
	}
	public int GetQuestID() {
		return QuestID;
	}
	public int GetQuestXPGranted() {
		return QuestXPGranted;
	}
	public boolean GetQuestCondition1() {
		return SubQuest1Done;
	}
	public boolean GetQuestCondition2() {
		return SubQuest2Done;
	}
	public boolean GetQuestCondition3() {
		return SubQuest3Done;
	}
	public boolean GetQuestCompleted() {
		if ((SubQuest1Done==true)&&(SubQuest2Done==true)&&(SubQuest3Done==true)) {
			QuestRequirementsCompleted=true;
		}
		return QuestRequirementsCompleted;
	}
	public void SetQuestCompleted() {
		QuestRequirementsCompleted=true;
	}
	public boolean GetBasicQuestCompleted() {
		return QuestRequirementsCompleted;
	}
	
	public void SetQuestConditionTrue(int ConditionID) {
		switch (ConditionID) {
		case 1:
			SubQuest1Done=true;
			break;
		case 2:
			SubQuest2Done=true;
			break;
		case 3:
			SubQuest3Done=true;
			break;
		}
	}
}
