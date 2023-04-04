import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VehicleManagerImpl implements VehicleManager{
    private List<Vehicle> flota = new ArrayList<>();

    public VehicleManagerImpl(List<Vehicle> flota)
    {this.flota = flota;
    }

    /**
     * @param x vozilo
     * Dodajemo vozilo u flotu
     */
    public void addVehicle(Vehicle x)
    {flota.add(x);
    }

    /**
     * printamo sva vozila u listu, ispis ovisi radi li se o 'car'-u ili 'truck'-u
     */
    public void printList()
    {
        for(Vehicle v: flota)
           {
               if(v instanceof Car)
                  ((Car) v).printCar();
               if(v instanceof Truck)
                 ((Truck) v).printTruck();
           }
    }

    /**
     * Tražimo vozilo s određenim proizvođačem u listi i ispisujemo ga
     * @param make
     */
    public void searchWithMake(String make)
    {
        for(Vehicle v : flota) {
            if (v.getMake().equals(make)) {
                if (v instanceof Car)
                    ((Car) v).printCar();
                if (v instanceof Truck)
                    ((Truck) v).printTruck();
            }
        }
    }

    /**
     * Tražimo vozilo s određenim modelom u listi i ispisujemo ga
     * @param model
     */
    public void searchWithModel(String model)
    {
        for(Vehicle v : flota)
        {
            if(v.getModel().equals(model)){
                if(v instanceof Car)
                    ((Car) v).printCar();
                 if(v instanceof Truck)
                ((Truck) v).printTruck();
             }
        }
    }

    /**
     * Tražimo vozilo s određenim VIN-om u listi i ispisujemo ga
     * @param vin
     */
    public void searchWithVIN(int vin)
    {
        for(Vehicle v : flota) {
            if (v.getVIN()==vin) {
                if (v instanceof Car)
                    ((Car) v).printCar();
                if (v instanceof Truck)
                    ((Truck) v).printTruck();
            }
        }
    }

    /**
     * Brišemo vozilo iz liste
     * @param vin
     * @return check
     * Vraćamo check jer nam treba za dio u 'mainu' gdje ćemo baciti NoSuchVehicleException
     */
    public int deleteVehicle(int vin)
    {
       int check=1;
        for(Vehicle v : flota)
            if (v.getVIN() == vin)
            {flota.remove(v);
                check=0;}
        return check;
    }


}
