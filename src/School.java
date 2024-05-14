import java.util.Arrays;
import java.util.Scanner;

public class School {
    public Classroom[] classroomList;

    public School() {
        this.classroomList = new Classroom[2];
    }

    public void addClassRoom(int id, Scanner scanner) {
        for (Classroom classroom : classroomList) {
            if (classroom != null && classroom.uniqueId == id) {
                System.out.println("Classroom id must be unique!");
                return;
            }
        }

        for (int i = 0; i < classroomList.length; i++) {
            if (classroomList[i] == null) {
                Teacher teacher = (Teacher) getHuman(true, scanner);
                classroomList[i] = new Classroom(id, teacher);
                return;
            }
        }

        Classroom[] list = new Classroom[classroomList.length * 2];
        for (int i = 0; i < classroomList.length; i++) {
            list[i] = classroomList[i];
        }
        Teacher teacher = (Teacher) getHuman(true, scanner);
        list[classroomList.length] = new Classroom(id, teacher);
        classroomList = list;
        list = null;
        System.out.println(Arrays.toString(classroomList));
    }

    public static Human getHuman(boolean isTeacher, Scanner scanner) {
        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Enter surname:");
        String surname = scanner.nextLine();

        System.out.println("Enter age:");
        int age = scanner.nextInt();

        Human human;
        if (isTeacher) {
            human = getTeacher(name, surname, age, scanner);
        } else {
            human = getStudent(name, surname, age, scanner);
        }

        return human;
    }

    public static Teacher getTeacher(String name, String surname, int age, Scanner scanner) {
        System.out.println("Enter salary:");
        double salary = scanner.nextDouble();

        return new Teacher(name, surname, age, salary);
    }

    public static Student getStudent(String name, String surname, int age, Scanner scanner) {
        System.out.println("Enter point:");
        int point = scanner.nextInt();

        return new Student(name, surname, age, point);
    }

    public void showAllClassrooms() {
        for (Classroom cl : classroomList) {
            if (cl != null) {
                System.out.println(cl.toString());
            }
        }
    }

    public void showAllTeachers() {
        for (Classroom cl : classroomList) {
            if (cl != null && cl.teacher != null) {
                System.out.println(cl.teacher.toString());
            }
        }
    }

    public void showAllStudents() {
        for (Classroom cl : classroomList) {
            if (cl != null) {
                for (Student st : cl.students) {
                    if (st != null) {
                        System.out.println(st.toString());
                    }
                }
            }
        }
    }

    public void showAllStudentsByClassroom(int classroomId) {
        for (Classroom cl : classroomList) {
            if (cl != null && cl.uniqueId == classroomId) {
                for (Student st : cl.students) {
                    if (st != null) {
                        System.out.println(st.toString());
                    }
                }
            }
        }
    }

    public void addStudentToClassroom(int classroomId, Scanner scanner) {
        for (int i = 0; i < classroomList.length; i++) {
            if (classroomList[i] != null && classroomList[i].uniqueId == classroomId) {
                for (int j = 0; j < classroomList[i].students.length; j++) {
                    if (classroomList[i].students[j] == null) {
                        classroomList[i].students[j] = (Student) getHuman(false, scanner);
                        return;
                    }
                }
            }
        }
    }
}
