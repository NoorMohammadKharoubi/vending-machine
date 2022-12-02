package enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ECoin {
    DOLLAR(1), C50(0.50), C20(0.20), C10(0.10);
    private double value;

    public static boolean contains(double value)
    {
        for(ECoin coin:values())
            if (coin.value == value)
                return true;
        return false;
    }

}
