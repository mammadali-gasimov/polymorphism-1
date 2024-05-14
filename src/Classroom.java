public class Classroom {
    public int uniqueId;
    public Student[] students;
    public Teacher teacher;

    public Classroom(int uniqueId, Teacher teacher) {
        this.uniqueId = uniqueId;
        this.teacher = teacher;
        this.students = new Student[10];
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "uniqueId=" + uniqueId +
                '}';
    }
}
