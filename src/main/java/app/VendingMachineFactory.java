package app;

public class VendingMachineFactory {
    public static VendingMachine getMachine(String machineType) {
        switch (machineType) {
            case "Snack":
                return new SnackMachine();
            default:
                throw new IllegalArgumentException(machineType + " is not implemented!");
        }
    }
}
