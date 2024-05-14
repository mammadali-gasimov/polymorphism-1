import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static School school = new School();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            getUserChoice();
        }
    }

    public static void showMenu() {
        System.out.println("Enter 1 to show all classrooms:");
        System.out.println("Enter 2 to show all teachers:");
        System.out.println("Enter 3 to show all students:");
        System.out.println("Enter 4 to show students by classroom id:");
        System.out.println("Enter 5 to add classroom:");
        System.out.println("Enter 6 to add a student to classroom:");
    }

    public static void getUserChoice() {
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                school.showAllClassrooms();
                break;
            case 2:
                school.showAllTeachers();
                break;
            case 3:
                school.showAllStudents();
                break;
            case 4:
                System.out.println("Enter classroom id to get all students in that classroom:");
                int id = scanner.nextInt();
                school.showAllStudentsByClassroom(id);
                break;
            case 5:
                System.out.println("Enter unique classroom id:");
                school.addClassRoom(scanner.nextInt(), scanner);
                break;
            case 6:
                System.out.println("Enter classroom id:");
                school.addStudentToClassroom(scanner.nextInt(), scanner);
                break;
        }
    }
}