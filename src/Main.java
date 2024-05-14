import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Classroom classroom = new Classroom();
        School school = new School(classroom);

        System.out.println("Enter unique id for classroom:");

        classroom.uniqueId = scanner.nextInt();
        classroom.teacher = (Teacher) getHuman(true);

        System.out.println("How many students you want to add?");
        int studentCount = scanner.nextInt();
        int count = 0;
        Student[] students = new Student[studentCount];
        while (count < studentCount) {
            students[count] = (Student) getHuman(false);
            count++;
        }

        System.out.println(Arrays.toString(students));
        classroom.students = students;
    }

    public static Human getHuman(boolean isTeacher) {
        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Enter surname:");
        String surname = scanner.nextLine();

        System.out.println("Enter age:");
        int age = scanner.nextInt();

        Human human;
        if (isTeacher) {
            human = getTeacher(name, surname, age);
        } else {
            human = getStudent(name, surname, age);
        }

        return human;
    }

    public static Teacher getTeacher(String name, String surname, int age) {
        System.out.println("Enter salary:");
        double salary = scanner.nextDouble();

        return new Teacher(name, surname, age, salary);
    }

    public static Student getStudent(String name, String surname, int age) {
        System.out.println("Enter point:");
        int point = scanner.nextInt();

        return new Student(name, surname, age, point);
    }
}