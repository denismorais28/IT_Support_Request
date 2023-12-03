import java.util.Scanner;

class Main {

    // Global variables
    private static Scanner scanner = new Scanner(System.in);
    private static ITStore itStore = new ITStore();

    public static void main(String[] args) {
        try {
            menu();
        } catch (Exception e) {
            System.out.println("Internal error: " + e.getMessage());
            System.out.println("Exiting the application!");
        }
    }

    /**
     * Console main menu
     */
    public static void menu() {
        int choice = 0;
        while (choice != 6) {
            System.out.println("Application Menu - Item Type: IT Request");
            System.out.println("1- Enter the details of an item");
            System.out.println("2- Display the details of the last entered item");
            System.out.println("3- Display the IT Request with the highest priority");
            System.out.println("4- Display the IT Request with the lowest priority");
            System.out.println("5- Display the average priority of all the IT Request entered until that point");
            System.out.println("6- Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            if (choice < 0 || choice > 6) {
                System.out.println("Invalid choice. Please try again.");
            }
            switch (choice) {
                case 1:
                    createMenu();
                    break;
                case 2:
                    System.out.println(itStore.getLastITRequest());
                    break;
                case 3:
                    System.out.println(itStore.getHighestPriority());
                    break;
                case 4:
                    System.out.println(itStore.getLowestPriority());
                    break;
                case 5:
                    averageMenu();
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
        System.out.println("Thank you!");
    }

    /**
     * Console Average menu
     */
    public static void averageMenu() {
        float avgCalc = itStore.getAverageValue();
        int avgPriority = itStore.getAveragePriority();
        if (avgPriority == 0 || avgCalc == 0) {
            System.out.println("Without requests at moment!");
        } else if (avgPriority == 4) {
            System.out.println("All the request priorities are equals!");
        } else {
            System.out.println(
                    "The value of average priority is: " + avgCalc + "_" + ITRequest.priorityStatus((int) avgCalc));
            System.out.println("The most repeated priority is: " + ITRequest.priorityStatus(avgPriority));
        }
    }

    /**
     * Console Creation menu
     */
    public static void createMenu() {
        try {
            int priority;
            String description, requester;
            float cost;
            System.out.println("Create Menu - IT Requests");
            System.out.println("Insert an integer priority value: (valid numbers: 1 - HIGH , 2 - MEDIUM e 3 - LOW)");
            priority = scanner.nextInt();
            scanner.nextLine(); // remove trash enter
            System.out.println("Insert a description: (text)");
            description = scanner.nextLine();
            System.out.println("Insert the requester name: (text)");
            requester = scanner.nextLine();
            System.out.println("Insert the request cost: (decimal value)");
            cost = scanner.nextFloat();
            scanner.nextLine(); // remove trash enter

            // validation chain
            if (priority < 1 || priority > 3) {
                throw new Exception("Priority inserted is invalid. Valid numbers: 1 - HIGH , 2 - MEDIUM e 3 - LOW");
            }

            if (description == null || description.isEmpty()) {
                throw new Exception("Description can not be null!");
            }

            if (requester == null || requester.isEmpty()) {
                throw new Exception("Requester name can not be null!");
            }

            if (cost < 0) {
                throw new Exception("Cost can not be negative!");
            }

            ITRequest request = new ITRequest(priority, description, requester, cost);
            itStore.addITRequest(request);
            System.out.println("Created with success.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Failure!");
        }
    }

}
