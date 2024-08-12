package Main;

import EntityClasses.Bus;
import EntityClasses.Customer;
import System.TicketReservationSystem;

import java.util.Scanner; 

public class main {
    private static TicketReservationSystem TRS = new TicketReservationSystem();
    private static Scanner SS = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nBus  Reservation System");
            System.out.println("1. Register the Customer");
            System.out.println("2. Register the Bus");
            System.out.println("3. Search for an available Buses");
            System.out.println("4. Reserve the Seat");
            System.out.println("5. Cancel your Reservation");
            System.out.println("6. Display All Reservations");
            System.out.println("7. Display Customers Details Oldest to Newest");
            System.out.println("8. Display Customers Details Newest to Oldest");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = SS.nextInt();
            SS.nextLine(); 

            switch (choice) {
                case 1:
                    registerCustomer();
                    break;
                case 2:
                    registerBus();
                    break;
                case 3:
                    searchBuses();
                    break;
                case 4:
                    reserveSeat();
                    break;
                case 5:
                    cancelReservation();
                    break;
                case 6:
                    displayReservations();
                    break;
                case 7:
                    displayCustomersOldestToNewest();
                    break;
                case 8:
                    displayCustomersNewestToOldest();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerCustomer() {
        System.out.print("Enter customer name: ");
        String name = SS.nextLine();
        System.out.print("Enter mobile number: ");
        String mobileNumber = SS.nextLine();
        System.out.print("Enter email ID: ");
        String emailId = SS.nextLine();
        System.out.print("Enter city: ");
        String city = SS.nextLine();
        System.out.print("Enter age: ");
        int age = SS.nextInt();
        SS.nextLine(); 

        Customer customer = new Customer(name, mobileNumber, emailId, city, age);
        TRS.registerCustomer(customer);
    }

    private static void registerBus() {
        System.out.print("Enter bus number: ");
        String busNumber = SS.nextLine();
        System.out.print("Enter total seats: ");
        int totalSeats = SS.nextInt();
        SS.nextLine(); 
        System.out.print("Enter starting point: ");
        String startingPoint = SS.nextLine();
        System.out.print("Enter ending point: ");
        String endingPoint = SS.nextLine();
        System.out.print("Enter starting time: ");
        String startingTime = SS.nextLine();
        System.out.print("Enter fare: ");
        double fare = SS.nextDouble();
        SS.nextLine(); 
        
        Bus bus = new Bus(busNumber, totalSeats, startingPoint, endingPoint, startingTime, fare);
        TRS.registerBus(bus);
    }
    
    private static void searchBuses() {
        System.out.print("Enter starting point: ");
        String from = SS.nextLine();
        System.out.print("Enter ending point: ");
        String to = SS.nextLine();
        TRS.searchBuses(from, to);
    }
    private static void reserveSeat() {
        System.out.print("Enter customer name: ");
        String customerName = SS.nextLine();
        Customer customer = TRS.findCustomerByName(customerName);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        System.out.print("Enter bus number: ");
        String busNumber = SS.nextLine();
        Bus bus = TRS.findBusByNumber(busNumber);
        if (bus == null) {
            System.out.println("Bus not found.");
            return;
        }
        System.out.print("Enter seat number to reserve: ");
        int seatIndex = SS.nextInt();
        SS.nextLine(); 
        TRS.reserveSeat(customer, bus, seatIndex);
    }
    private static void cancelReservation() {
        TRS.cancelReservation();
    }
    private static void displayReservations() {
        TRS.displayReservations();
    }
    private static void displayCustomersOldestToNewest() {
        TRS.displayCustomersOldestToNewest();
    }
    private static void displayCustomersNewestToOldest() {
        TRS.displayCustomersNewestToOldest();
    }
}


//Owner Keshan 