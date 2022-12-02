package enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ECoin {
    C10(0.10), C20(0.20), C50(0.50), DOLLAR(1);
    private double coins;

}
