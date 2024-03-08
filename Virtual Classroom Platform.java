import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Class representing a Student
class Student {
    private String name;
    private String studentId;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    // Additional methods can be added here based on requirements
}

// Class representing a Course
class Course {
    private String courseId;
    private String courseName;
    private Map<String, Student> enrolledStudents;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.enrolledStudents = new HashMap<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.put(student.getStudentId(), student);
    }

    public List<Student> getEnrolledStudents() {
        return new ArrayList<>(enrolledStudents.values());
    }

    // Additional methods can be added here based on requirements
}

// Class representing a Virtual Classroom
class VirtualClassroom {
    private List<Course> courses;

    public VirtualClassroom() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    // Additional methods can be added here based on requirements
}

public class Main {
    public static void main(String[] args) {
        // Create students
        Student student1 = new Student("John", "S001");
        Student student2 = new Student("Alice", "S002");

        // Create courses
        Course course1 = new Course("C001", "Java Programming");
        Course course2 = new Course("C002", "Web Development");

        // Enroll students in courses
        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        course2.enrollStudent(student2);

        // Create virtual classroom
        VirtualClassroom virtualClassroom = new VirtualClassroom();
        virtualClassroom.addCourse(course1);
        virtualClassroom.addCourse(course2);

        // Display enrolled students in each course
        for (Course course : virtualClassroom.getCourses()) {
            System.out.println("Course: " + course.getCourseName());
            System.out.println("Enrolled Students:");
            for (Student student : course.getEnrolledStudents()) {
                System.out.println("- " + student.getName() + " (ID: " + student.getStudentId() + ")");
            }
            System.out.println();
        }
    }
}
