package academic.driver;

/**
 * @author 12S23017_Andrey Jonathan
 * @author 12S23050_Yolanda Saragih
 */

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        ArrayList<String> invalidMessages = new ArrayList<>();

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
                        String code = parts[1];
                        String id = parts[2];
                        String angkatan = parts[3];
                        String semester = parts[4];

                        Course course = findCourse(courses, code);
                        if (course == null) {
                            invalidMessages.add("invalid course|" + code);
                            break;
                        }
                        Student student = findStudent(students, id);
                        if (student == null) {
                            invalidMessages.add("invalid student|" + id);
                            break;
                        }

                        Enrollment enrollment = new Enrollment(code, id, angkatan, semester);
                        enrollments.add(enrollment);
                    }
                    break;
            }
        }
Collections.sort(courses, new Comparator<Course>() {
            @Override
            public int compare(Course c1, Course c2) {
                return c1.getCode().compareTo(c2.getCode());
            }
        });

        for (String message : invalidMessages) {
            System.out.println(message);
        }

        for (Course course : courses) {
            System.out.println(course.toString());
        }

        for (Student student : students) {
            System.out.println(student.toString());
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString() + "|None");
        }

        scanner.close();
    }

    private static Course findCourse(ArrayList<Course> courses, String code) {
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    private static Student findStudent(ArrayList<Student> students, String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
}