package app;

/**
 * Vending machine factory
 */
public class VendingMachineFactory {

    /**
     * Gets the types of VM that will be initialized
     * @param machineType
     * @return
     */
    public static VendingMachine getMachine(String machineType) {
        switch (machineType) {
            case "Snack":
                return new SnackMachine();
            default:
                throw new IllegalArgumentException(machineType + " is not implemented!");
        }
    }
}
