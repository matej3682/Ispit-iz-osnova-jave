public class Vehicle {

    private String make;
    private String model;
    private int year;
    private String color;
    private int VIN;
    private String fuelType;

    public Vehicle(String make, String model, int year, String color, int VIN, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.VIN = VIN;
        this.fuelType = fuelType;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public int getVIN() {
        return VIN;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }


}
