package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ENote {
    N20(20), N50(50);

    private int notes;
}
