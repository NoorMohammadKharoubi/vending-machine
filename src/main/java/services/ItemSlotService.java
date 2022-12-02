package services;

import exceptions.NoSelectedItemException;
import exceptions.NotFoundItemException;
import exceptions.SoldOutItemException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.Item;
import models.ItemSlot;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemSlotService {
    private ItemSlot currentItemSlot;
    private HashMap<String, ItemSlot> mapOfItemSlots = new HashMap<>();

    public void setItem(String code, Item item, double price, int count) {
        mapOfItemSlots.put(code, new ItemSlot(item,price,count));
    }

    public void selectItem(String code){
        if(mapOfItemSlots.containsKey(code)) {
            ItemSlot item = mapOfItemSlots.get(code);
            if(isItemAvailable(code)){
                currentItemSlot = item;
                return;
            }
            throw new SoldOutItemException(item.getItem().getName());
        }
        throw new NotFoundItemException(code);
    }

    public void cancelItem(){
        currentItemSlot=null;
    }

    public Item BuyItem(){
        Item item = currentItemSlot.getItem();
        reduceItem();
        currentItemSlot=null;
        return item;
    }
    public double getPriceForSelectedItem(){
        if(currentItemSlot != null){
            return currentItemSlot.getPrice();
        }
        throw new NoSelectedItemException();
    }

    public String getNameOfItem(String code){
        return getMapOfItemSlots().get(code).getItem().getName();
    }
    public double getPriceOfItem(String code){
        return getMapOfItemSlots().get(code).getPrice();
    }
    public boolean isItemAvailable(String code){
        return mapOfItemSlots.get(code).getNumOfItems()>0;
    }
    public void reduceItem(){
        getCurrentItemSlot().setNumOfItems(getCurrentItemSlot().getNumOfItems()-1);
    }
}
