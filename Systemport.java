package GAMEd;

import GAMEd.Container;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Systemport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Container> containerStack = new ArrayDeque<>();
        ArrayDeque<Ship> shipQueue = new ArrayDeque<>();

        int choice;

        do {
            System.out.println("\n=== Port Container Management System ===");
            System.out.println("[1] Store container (push)");
            System.out.println("[2] View port containers");
            System.out.println("[3] Register arriving ship (enqueue)");
            System.out.println("[4] View waiting ships");
            System.out.println("[5] Load next ship (pop container + poll ship)");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter container ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter description: ");
                    String description = sc.nextLine();
                    System.out.print("Enter weight (ex 500kg): ");
                    String weight = sc.nextLine();

                    Container c = new Container(id, description, weight);
                    containerStack.push(c);
                    System.out.println("\n"
                    		+ "Stored: " + c);
                    break;

                case 2:
                    if (containerStack.isEmpty()) {
                        System.out.println("\n"
                        		+ "No containers at the port.");
                    } else {
                        System.out.println("\n"
                        		+ "TOP >");
                        for (Container cont : containerStack) {
                            System.out.println(cont);
                        }
                        System.out.println("<"
                        		+ " BOTTOM");
                    }
                    break;

                case 3: 
                    System.out.print
                    ("Enter ship name: ");
                    String name = sc.nextLine();
                    System.out.print
                    ("Enter captain's name: ");
                    String captain = sc.nextLine();

                    Ship s = new Ship(name, captain);
                    shipQueue.add(s);
                    System.out.println("\n"
                    		+ "Registered: " + s);
                    break;

                case 4:
                    if (shipQueue.isEmpty()) {
                        System.out.println("\n"
                        		+ "No ships waiting.");
                    } else
                    {
                        System.out.println("\n"
                        		+ "FRONT >");
                        for (Ship ship : shipQueue)
                        {
                            System.out.println(ship);
                        }
                        System.out.println("< REAR");
                    }
                    break;

                case 5:
                    if (containerStack.isEmpty())
                    {
                        System.out.println("\n"
                        		+ "No containers available to load.");
                    } else if (shipQueue.isEmpty())
                    {
                        System.out.println("\n"
                        		+ "No ships waiting to load.");
                    } else 
                    {
                        Container loadedContainer = containerStack.pop();
                        Ship targetShip = shipQueue.poll();

                        System.out.println("\nLoaded: " + loadedContainer + " → " + targetShip);
                        System.out.println("Remaining containers: " + containerStack.size());
                        System.out.println("Remaining ships waiting: " + shipQueue.size());
                    }
                    break;

                case 0:
                    System.out.println("\n"
                    		+ "Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("\n"
                    		+ "Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}