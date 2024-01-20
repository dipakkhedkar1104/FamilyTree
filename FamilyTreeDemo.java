package ProjectTreeProgs;

import java.util.Scanner;
public class FamilyTreeDemo{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the root person (e.g., Grandfather): ");
        String rootName = scanner.nextLine();

        System.out.print("Enter the maximum number of children each person can have: ");
        int maxChildren = scanner.nextInt();

        FamilyTree familyTree = new FamilyTree(rootName, maxChildren);

        while (true){
        	int choice;
            System.out.println("\n1. Add family member");
            System.out.println("2. Display family tree");
            System.out.println("3. Check relationship");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    int check = 1;
                    System.out.print("Enter the name of the parent: ");
                    String parentName = scanner.nextLine();
                    while (check != 0) {
                        System.out.print("Enter the name of the child: ");
                        String childName = scanner.nextLine();
                        familyTree.addChild(parentName, childName);
                        System.out.print("Do you want to continue adding children of " + parentName + "? Choose Yes/No (1/0): ");
                        check = scanner.nextInt();
                        scanner.nextLine();
                    }
                    System.out.println("Current Tree:╕ ");
                    familyTree.displayFamilyTree();
                    break;

                case 2:
                    System.out.println("\nFamily Tree:");
                    familyTree.displayFamilyTree();
                    break;

                case 3:
                	check=1;
                    System.out.print("Enter the name of the first person: ");
                    String name1 = scanner.nextLine();
                    while (check != 0) {
                        System.out.print("Enter the name of the second person: ");
                        String name2 = scanner.nextLine();
                        System.out.println(familyTree.getRelationship(name1, name2));
                        System.out.print("\nDo you want to find more Relationship with person " + name1 + " -> Yes/No (1/0): ");
                        check = scanner.nextInt();
                        scanner.nextLine();
                    }
                    break;
                    
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                                  
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }       
        }
    } 
}
