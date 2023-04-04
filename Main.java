import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) throws NoSuchVehicleException {
        List<Vehicle> flota = new ArrayList<>();

        Logger LOGGER = Logger.getLogger(Main.class.getName());

        try {
            FileHandler fileHandler = new FileHandler("log.txt");
            LOGGER.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            LOGGER.warning("Log file could not be created" + e.getMessage());
        }

        VehicleManagerImpl listFlota = new VehicleManagerImpl(flota);
        String input;
        do {
            System.out.println();
            System.out.println("Vehicle Fleet Management System");
            System.out.println("-------------------------------");
            System.out.println("1. Add a vehicle to the fleet");
            System.out.println("2. Search for vehicles by make or model");
            System.out.println("3. Print all vehicles in the fleet");
            System.out.println("4. Delete a vehicle from the fleet");
            System.out.println("5. Quit");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a command: ");
            input = scanner.nextLine();


            switch (input) {

                case "1": {
                    Scanner scanner1 = new Scanner(System.in);
                    String input1;
                    System.out.println("What type of vehicle would you like to add?");
                    System.out.print("Enter 'car' or 'truck': ");
                    int check=1;
                    do {
                        input1 = scanner1.nextLine();
                        if(input1.equals("car") || input1.equals("truck"))
                            check=1;
                        else {
                            System.out.println("You need to enter 'car' or 'truck'. Try again.");
                            check = 0;
                        }
                    }
                    while (check==0);


                    System.out.print("Enter make: ");
                    String make = scanner1.nextLine();

                    System.out.print("Enter model: ");
                    String model = scanner1.nextLine();

                    System.out.print("Enter year: ");
                    int year = Integer.parseInt(scanner1.nextLine());

                    System.out.print("Enter color: ");
                    String color = scanner1.nextLine();

                    System.out.print("Enter VIN: ");
                    int vin = Integer.parseInt(scanner1.nextLine());

                    int checkCarTruck = 1;
                    for (Vehicle v : flota) {
                        if (v.getVIN() == vin)
                            checkCarTruck = 0;
                    }
                        try {
                            if (checkCarTruck == 0)
                                 throw new DuplicateVehicleException("There is already a vehicle with the same VIN number in the fleet.");
                        } catch (DuplicateVehicleException e) {
                            System.out.println("Error: "+e.getMessage());
                            LOGGER.warning("Error: "+e.getMessage());
                            continue;
                        }



                    System.out.print("Enter fuel type: ");
                    String fuelType = scanner1.nextLine();

                    if (input1.equals("car")) {
                        System.out.print("Enter number of doors: ");
                        int numDoors = Integer.parseInt(scanner1.nextLine());
                        System.out.print("Enter body style: ");
                        String bodyStyle = scanner1.nextLine();

                        listFlota.addVehicle(new Car(make, model, year, color, vin, fuelType, numDoors, bodyStyle));
                    }

                    if (input1.equals("truck")) {
                        System.out.print("Enter towing capacity: ");
                        double maxPayLoad = Double.parseDouble(scanner1.nextLine());
                        listFlota.addVehicle(new Truck(make, model, year, color, vin, fuelType, maxPayLoad));
                    }

                    System.out.println("Vehicle added successfully.");

                    break;

                }

                case "2": {
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("How would you like to search for vehicles?");
                    System.out.println("1. Search by make");
                    System.out.println("2. Search by model");
                    System.out.println("3. Search by VIN");
                    String trazi;
                    do {
                        System.out.print("Enter command: ");
                        trazi = scanner2.nextLine();
                        // ako nije broj, baci grešku!!
                        switch (trazi) {
                            case "1": {
                                System.out.print("Enter make: ");
                                String make = scanner2.nextLine();
                                System.out.println("Search results: ");
                                listFlota.searchWithMake(make);
                                break;
                            }

                            case "2": {
                                System.out.print("Enter model: ");
                                String model = scanner2.nextLine();
                                System.out.println("Search results: ");
                                listFlota.searchWithModel(model);
                                break;
                            }

                            case "3": {
                                System.out.print("Enter VIN: ");
                                int vin = Integer.parseInt(scanner2.nextLine());
                                System.out.println("Search results: ");
                                listFlota.searchWithVIN(vin);
                                break;
                            }
                            default: {
                                //throw new IllegalStateException("Unexpected value: " + trazi);
                                System.out.println("Invalid command. Please enter a number between 1 and 3.");
                            }
                        }


                    } while (!trazi.equals("1") && !trazi.equals("2") && !trazi.equals("3"));


                    break;
                }

                    case "3": {
                        System.out.println("All vehicles in the fleet: ");
                        listFlota.printList();
                        break;
                    }

                    case "4": {
                        System.out.println("Enter VIN of vehicle to delete: ");
                        Scanner scanner4 = new Scanner(System.in);
                        int input4 = Integer.parseInt(scanner4.nextLine());
                        int check = listFlota.deleteVehicle(input4);

                            try {
                                if(check==1)
                                      throw new NoSuchVehicleException("There is no a vehicle with VIN = "+input4);
                            } catch (NoSuchVehicleException e) {
                                System.out.println("Error: "+e.getMessage());
                                LOGGER.warning("Error: "+e.getMessage());
                                continue;
                            }

                        if (check==0)
                          System.out.println("Vehicle with VIN " + input4 + " deleted successfully.");

                        break;
                    }

                    case "5": {
                        break;
                    }

                    default: {
                        System.out.println("Invalid command. Please enter a number between 1 and 5.");
                        break;
                    }

                }
            } while (!input.equals("5")) ;
        }
    }