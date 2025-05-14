package src.NPCs;

public class NPC {
	String _npcName;
	int _health;
	int _maxHealth;
	int _mana;
	int _maxMana;
	int _ActualDP;
	int _charisma;
	int _intelligence;
	
	
	int _grantedXP;
	
	int _strength;
	public void ChangeHealth(int hp) {
		_health=_health+hp;
	}
	public void ChangeMana(int mana) {
		_mana=_mana+mana;
	}
	
	public int GetHP() {
		return _health;
	}
	public int GetMaxHP() {
		return _maxHealth;
	}
	public int GetMana() {
		return _mana;
	}
	public int GetMaxMana() {
		return _maxMana;
	}
	
	public int GetCharisma() {
		return _charisma;
	}
	public int GetIntelligence() {
		return _intelligence;
	}
	public int GetActualDP() {
		return _ActualDP;
	}
	public int GetGrantedXP() {
		return _grantedXP;
	}
	public String GetName() {
		return _npcName;
	}
}
