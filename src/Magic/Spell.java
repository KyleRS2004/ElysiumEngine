package src.Magic;

public class Spell {
	int SpellID;
	String SpellName;
	int Damage;
	
	MagicType SpellType;
	
	public int GetSpellID() {
		return SpellID;
	}
	public String GetSpellName() {
		return SpellName;
	}
	public MagicType GetSpellType() {
		return SpellType;
	}
	public int GetSpellDamage() {
		return Damage;
	}
}
