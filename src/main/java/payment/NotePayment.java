package payment;

import enums.ECoin;
import enums.ENote;
import utils.Keypad;

public class NotePayment implements Payment{

    @Override
    public double insert(double value) {
        return insert();
    }

    @Override
    public double insert() {
        System.out.println("Please insert note");
        double insertedNote = Double.parseDouble(Keypad.readFromUser());
        if (ENote.contains(insertedNote)){
            return insertedNote;
        }else{
            System.out.println("Note not valid");
        }
        return 0;
    }
}
