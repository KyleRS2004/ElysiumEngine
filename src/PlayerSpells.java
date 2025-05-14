package src;

import src.Magic.*;

public class PlayerSpells {
	LightCastSpell lightmagicspell = new LightCastSpell();
	
	
	int[][] SpellsLocked= {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},	//Light
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},	//Dark
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},	//Earth
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},	//Conjuration
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}  	//Enchanting
	};
	
	public void UnlockSpell(int x, int y) {
		SpellsLocked[y][x] = 0;
	}
	
	public boolean CheckSpellLock(int x, int y) {
		if (SpellsLocked[y][x] == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
