package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ItemSlot {
    private Item item;
    private double price;
    private int numOfItems;
}

