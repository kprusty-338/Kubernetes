import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        while (true) {
            System.out.println("\n--- User CRUD Menu ---");
            System.out.println("1. Create User");
            System.out.println("2. Read User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. List All Users");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    User user = userService.createUser(username, password);
                    System.out.println("Created: " + user);
                    break;
                case 2:
                    System.out.print("Enter user id: ");
                    int readId = scanner.nextInt();
                    scanner.nextLine();
                    User readUser = userService.readUser(readId);
                    System.out.println(readUser != null ? readUser : "User not found.");
                    break;
                case 3:
                    System.out.print("Enter user id: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    boolean updated = userService.updateUser(updateId, newUsername, newPassword);
                    System.out.println(updated ? "User updated." : "User not found.");
                    break;
                case 4:
                    System.out.print("Enter user id: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    boolean deleted = userService.deleteUser(deleteId);
                    System.out.println(deleted ? "User deleted." : "User not found.");
                    break;
                case 5:
                    List<User> users = userService.getAllUsers();
                    if (users.isEmpty()) {
                        System.out.println("No users found.");
                    } else {
                        users.forEach(System.out::println);
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
