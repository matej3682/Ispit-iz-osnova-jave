public class Truck extends Vehicle{

    private double maxPayload; //towingCapacity;
    public Truck(String make, String model, int year, String color, int VIN, String fuelType, double towingCapacity) {
        super(make, model, year, color, VIN, fuelType);
        this.maxPayload = towingCapacity;
    }

    public double getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(double maxPayload) {
        this.maxPayload = maxPayload;
    }
    public void printTruck()
    {
        System.out.println(getClass().getSimpleName()+"{make="+getMake()+", model="+getModel()+", year="+getYear()+", color="+getColor()+", vin="+getVIN()+", fuelType="+getFuelType()+", maxPayload="+ getMaxPayload()+"}");
    }
}
