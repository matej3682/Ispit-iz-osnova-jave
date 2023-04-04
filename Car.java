public class Car extends Vehicle{
    private int numDoors;
    private String bodyStyle;

    public Car(String make, String model, int year, String color, int VIN, String fuelType, int numberOfDoors, String bodyStyle ) {
        super(make, model, year, color, VIN, fuelType);
        this.numDoors = numberOfDoors;
        this.bodyStyle = bodyStyle;
    }

    public int getNumberOfDoors() {
        return numDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numDoors = numberOfDoors;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public void printCar()
    {
        System.out.println("Car"+"{make="+getMake() +", model="+getModel()+", year="+getYear()+", color="+getColor()+", vin="+getVIN()+", fuelType="+getFuelType()+", numDoors="+getNumberOfDoors()+", bodyStyle="+getBodyStyle()+"}" );
    }
}
