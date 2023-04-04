import java.util.List;

public interface VehicleManager {


    abstract void addVehicle(Vehicle vehicle);

    void searchWithMake(String make);
    void searchWithModel(String model);
    void searchWithVIN(int VIN);

    void printList();

    int deleteVehicle(int VIN);
}
