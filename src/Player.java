package src;

public class Player {
	
	String EquippedWeapon="";
	int _WeaponDP=0;
	int weapontype=0; // 0 for no weapon, 1 for melee, 2 for ranged, 3 for magic.
	
	String _playerName ="";
	
	int _playerX = 3;
	int _playerY = 4;
	
	int _playerXinDungeon = 1;
	int _playerYinDungeon = 1;
	
	int _health = 100;
	int _maxHealth = 100;
	
	int _lvl = 1;
	int _xp = 0;
	int _maxXP = 10;
	int _mana = 4;
	int _maxMana = 4;
	int _points;
	// Points are used to increase these character traits.
	int _strength = 4;			// How hard a Player can hit or what types of weapons they can use.
	int _weightCapacity = 4;	// This affects how much loot the player can carry.
	int _charisma = 4;			// This affects trade and talking with NPCs.
	int _intelligence = 4;		// This affects observe.
	
	int _ActualDP=_strength;
	
	
	
	
	
	
	
	
	public void SetCurrentActualDP() {
		if (weapontype==0) {
			_ActualDP=_strength;
		}
		else if (weapontype==1) {
			_ActualDP=_WeaponDP+_strength;
		}
		else if (weapontype==2) {
			_ActualDP=_WeaponDP;
		}
		else if (weapontype==3) {
			_ActualDP=_WeaponDP*(_mana/_maxMana); // Massive damage, but limited number of magic attacks.
		}
	}
	
	public void SetEquippedMagicWeapon(int weaponDamage) {
		_ActualDP=weaponDamage;
		weapontype=3;
		_WeaponDP=0;
	}
	
	public void SetEquippedRangeWeapon(int weaponDamage) {
		_ActualDP=weaponDamage;
		weapontype=2;
		_WeaponDP=0;
	}
	
	public void SetEquippedWeapon(int weaponDamage) {
		_ActualDP=_strength+weaponDamage;
		System.out.println(_ActualDP);
		_WeaponDP=weaponDamage;
		weapontype=1;
	}
	
	public void SetUnequippedWeapon() {
		_ActualDP=_strength;
		_WeaponDP=0;
		weapontype=0;
	}
	
	
	public void weightCapacityIncrease(int increase) {
		_weightCapacity=_weightCapacity+increase;
	}
	public void charismaIncrease(int increase) {
		_charisma=_charisma+increase;
	}
	public void intelligenceIncrease(int increase) {
		_intelligence=_intelligence+increase;
	}
	public void strengthIncrease(int increase) {
		_strength=_strength+increase;
	}
	
	public void ChangeName(String name) {
		_playerName = name;
	}
	
	
	public void ChangeLVL(int lvl) {
		_lvl=_lvl+lvl;
		_maxHealth=_maxHealth+5;
		_mana=_mana+1;
		_points=_points+2;
		_maxXP=_maxXP+8;
		_xp=0;
	}
	public void ChangeXP(int xp) {
		_xp=_xp+xp;
	}
	public void ChangeMana(int mana) {
		_mana=_mana+mana;
	}
	public void ChangePoints(int points) {
		_points=_points+points;
	}
	public void ChangeHealth(int hp) {
		_health=_health+hp;
	}
	
	public void ChangePositionX(int X) {
		_playerX=_playerX+X;
	}
	public void ChangePositionY(int Y) {
		_playerY=_playerY+Y;
	}
	public void ChangePositionXinDungeon(int X) {
		_playerXinDungeon=_playerXinDungeon+X;
	}
	public void ChangePositionYinDungeon(int Y) {
		_playerYinDungeon=_playerYinDungeon+Y;
	}
	
	public int GetHP() {
		return _health;
	}
	public int GetMaxHP() {
		return _maxHealth;
	}
	public int GetXP() {
		return _xp;
	}
	public int GetMaxXP() {
		return _maxXP;
	}
	public int GetLVL() {
		return _lvl;
	}
	public int GetPoints() {
		return _points;
	}
	public int GetMana() {
		return _mana;
	}
	public int GetMaxMana() {
		return _maxMana;
	}
	public int GetStrength() {
		return _strength;
	}
	public int GetWeightCapacity() {
		return _weightCapacity;
	}
	public int GetCharisma() {
		return _charisma;
	}
	public int GetIntelligence () {
		return _intelligence;
	}
	
	public int GetPlayerX() {
		return _playerX;
	}
	public int GetPlayerY() {
		return _playerY;
	}
	
	public int GetPlayerXinDungeon() {
		return _playerXinDungeon;
	}
	public int GetPlayerYinDungeon() {
		return _playerYinDungeon;
	}
	
	public String GetName() {
		return _playerName;
	}
	
}
