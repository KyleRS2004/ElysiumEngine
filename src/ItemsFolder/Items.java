package src.ItemsFolder;

public class Items {
	int ItemID;
	String _ItemName;
	ItemType _Type;
	String KeyTextFromBook;
	int _Damage;
	int _Value;
	int _Special; // 0 for normal unenchanted items, 1 For light magic.
	int _item_X;
	int _item_Y;
	int _numberOf;
	
	public String GetBooksText() {
		return KeyTextFromBook;
	}
	
	public int GetTotalInInventory() {
		return _numberOf;
	}
	
	public int GetItemX() {
		return _item_X;
	}
	public int GetItemY() {
		return _item_Y;
	}
	
	
	public int GetItemID() {
		return ItemID;
	}
	public String GetItemName() {
		return _ItemName;
	}
	public int GetDamage() {
		return _Damage;
	}
	
	public void SetNumberOf(int changeAmount) {
		_numberOf=_numberOf+changeAmount;
	}
}
