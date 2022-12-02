package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ENote {
    N50(50),N20(20);

    private int value;

    public static boolean contains(double value)
    {
        for(ENote note:values())
            if (note.value == value)
                return true;
        return false;
    }
}
