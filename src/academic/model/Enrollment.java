package academic.model;

public class Enrollment {
    private String courseCode;
    private String studentId;
    private String angkatan;
    private String semester;

    public Enrollment(String courseCode, String studentId, String angkatan, String semester) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.angkatan = angkatan;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return courseCode + "|" + studentId + "|" + angkatan + "|" + semester;
    }
}