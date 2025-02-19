package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");
            String command = parts[0];

            switch (command) {
                case "course-add":
                    if (parts.length == 5) {
                        String code = parts[1];
                        String name = parts[2];
                        int credits = Integer.parseInt(parts[3]);
                        String semester = parts[4];

                        Course course = new Course(code, name, credits, semester);
                        courses.add(course);
                    }
                    break;

                case "student-add":
                    if (parts.length == 5) {
                        String id = parts[1];
                        String name = parts[2];
                        String angkatan = parts[3];
                        String prodi = parts[4];

                        Student student = new Student(id, name, angkatan, prodi);
                        students.add(student);
                    }
                    break;

                case "enrollment-add":
                    if (parts.length == 5) {
                        String courseCode = parts[1];
                        String studentId = parts[2];
                        String angkatan = parts[3];
                        String semester = parts[4];

                        // Create the enrollment
                        Enrollment enrollment = new Enrollment(courseCode, studentId, angkatan, semester);
                        enrollments.add(enrollment);
                    }
                    break;
            }
        }

        for (int i = courses.size() - 1; i >= 0; i--) {
            System.out.println(courses.get(i).toString());
        }
        

        // Print all students in the order they were added
        for (Student student : students) {
            System.out.println(student.toString());
        }

        // Print all enrollments in the order they were added
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString() + "|None");
        }

        scanner.close();
    }
}