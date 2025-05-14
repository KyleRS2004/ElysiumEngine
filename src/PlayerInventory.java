package src;

import java.util.ArrayList;
import src.ItemsFolder.*;

public class PlayerInventory {
	// OVERALL INVENTORY VARIABLES
	int[] items = {};
	int _positionInventory;
	int _Item;
	boolean _ItemFound;
	String _queriedItem;
	//ITEMS
	ArrayList<Items> ItemsArray = new ArrayList<Items>();
	DaggerItem daggerItem = new DaggerItem();
	CaveTrollBeastiary caveTrollBeastiary = new CaveTrollBeastiary();
	Enchanted_LightDagger lightdagger = new Enchanted_LightDagger();
	NoviceLightMagicBook novicemagicbook = new NoviceLightMagicBook();
	RustedKey_Cave1 rustedkey_cave1 = new RustedKey_Cave1();
	IronSword ironsword = new IronSword();
	int gold=0;
	
	public int GetInventoryLength() {
		return items.length;
	}
	
	// Item ID 0 is nothing.
	public void AddItem2(int ItemID) {
		if (ItemID==1) {
			if (ItemsArray.contains(daggerItem)) {
				System.out.println("true");
				daggerItem.SetNumberOf(1);
			} else {
				ItemsArray.add(daggerItem);
				daggerItem.SetNumberOf(1);
			}
		}
		if (ItemID==2) {
			if (ItemsArray.contains(caveTrollBeastiary)) {
				System.out.println("true");
				caveTrollBeastiary.SetNumberOf(1);
			} else {
				ItemsArray.add(caveTrollBeastiary);
				caveTrollBeastiary.SetNumberOf(1);
			}
		}
		if (ItemID==3) {
			if (ItemsArray.contains(lightdagger)) {
				System.out.println("true");
				lightdagger.SetNumberOf(1);
			} else {
				ItemsArray.add(lightdagger);
				lightdagger.SetNumberOf(1);
			}
		}
		if (ItemID==4) {
			if (ItemsArray.contains(novicemagicbook)) {
				System.out.println("true");
				novicemagicbook.SetNumberOf(1);
			} else {
				ItemsArray.add(novicemagicbook);
				novicemagicbook.SetNumberOf(1);
			}
		}
		if (ItemID==5) {
			if (ItemsArray.contains(rustedkey_cave1)) {
				System.out.println("true");
				rustedkey_cave1.SetNumberOf(1);
			} else {
				ItemsArray.add(rustedkey_cave1);
				rustedkey_cave1.SetNumberOf(1);
			}
		}
		if (ItemID==6) {
			if (ItemsArray.contains(ironsword)) {
				System.out.println("true");
				ironsword.SetNumberOf(1);
			} else {
				ItemsArray.add(ironsword);
				ironsword.SetNumberOf(1);
			}
		}
	}
	
	public void AddItem(String Item) {
		if (Item=="Dagger") {
			if (ItemsArray.contains(daggerItem)) {
				System.out.println("true");
				daggerItem.SetNumberOf(1);
			} else {
				ItemsArray.add(daggerItem);
				daggerItem.SetNumberOf(1);
			}
		}
	}
	
	// Call a query with SetQueriedItem() and then use GetItemStored() when checking for a specific item.
	
	public void SetQueriedItem(String queriedItem) {
		_queriedItem=queriedItem;
	}
	
	public boolean GetItemStored2(int ItemID) {
		for (Items i : ItemsArray) {
			if (i.GetItemID()==ItemID) {
				return true;
			}
		}
		
		
		
		return false;
	}
	
	
	public String GetItemStored() {
		_ItemFound=false;
		for (Items i : ItemsArray) {
			System.out.println(i);
			if (i.equals(daggerItem)) {
				if (daggerItem.GetItemName()==_queriedItem) {
					System.out.println("Object found and in the query.");
					_ItemFound=true;
					_queriedItem="";
					return "Dagger";
				}
				else {
				System.out.println("Object found, but not in the query.");
				}
			}
			
			
			

			if (_ItemFound==false){
				_positionInventory++;
			}
		}
		
		return "Item Not Found";

	}

	public PlayerInventory(){
		
	}


	public String GetInventory() {
		String _TotalInventory="";
		for (Items i : ItemsArray) {
			_TotalInventory = _TotalInventory + "\n" + i.GetItemName()+" (x"+i.GetTotalInInventory()+")";
			
			
		}
		if (ItemsArray.isEmpty()) {
			_TotalInventory = "Your Inventory is Empty";
		}
		
		return _TotalInventory;
	}
}
