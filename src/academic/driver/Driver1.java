package academic.driver;
/**
 * @author 12S23017_Andrey Jonathan
 * @author 12S23050_Yolanda Saragih
 */

import academic.model.Enrollment; 
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Enrollment[] enrollments = new Enrollment[100]; 
        int enrollmentCount = 0;

        while (true) {
            String input = scanner.nextLine(); 
            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");

            if (parts.length == 5) {
                String code = parts[1];
                String id = parts[2];
                String angkatan = parts[3];
                String semester = parts[4];

                Enrollment enrollment = new Enrollment(code, id, angkatan, semester);
                enrollments[enrollmentCount] = enrollment;
                enrollmentCount++;

            } else {
                
            }
        }

        scanner.close();
    }
}
 