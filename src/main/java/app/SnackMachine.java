package app;

import enums.EPaymentTypes;
import models.Item;
import services.ItemSlotService;
import services.PaymentService;
import utils.CommonHelper;

import java.util.Properties;

public class SnackMachine extends VendingMachine {

    @Override
    public void initMachine(){
        // get app properties
        Properties prop = CommonHelper.getProperties();

        // init services
        setItemSlotService(new ItemSlotService());

        // set app properties
        String[] itemNames = prop.getProperty("SNACK_VM_ITEM_NAMES").split("\\s*,\\s*");
        String[] itemPrices = prop.getProperty("SNACK_VM_ITEM_PRICES").split("\\s*,\\s*");
        String[] itemCodes = prop.getProperty("SNACK_VM_ITEM_CODES").split("\\s*,\\s*");

        setCurrentAmount(0);
        setCodes(itemCodes);
        setCOLS(Integer.parseInt(prop.getProperty("SNACK_VM_COLS_COUNT")));
        setROWS(Integer.parseInt(prop.getProperty("SNACK_VM_ROWS_COUNT")));

        for(int i=0; i<getCodes().length; i++){
            getItemSlotService().setItem(itemCodes[i], new Item(itemNames[i]), Double.parseDouble(itemPrices[i]) , 10);
        }
    }

    @Override
    public EPaymentTypes[] getPaymentTypes() {
        return new EPaymentTypes[]{EPaymentTypes.Coin,EPaymentTypes.Note,EPaymentTypes.Card};
    }
}
