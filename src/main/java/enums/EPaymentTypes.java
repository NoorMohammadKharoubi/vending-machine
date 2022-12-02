package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EPaymentTypes {
    Coin("Coin","1"),Note("Note","2"),Card("Card","3");

    private String name;
    private String code;

}
