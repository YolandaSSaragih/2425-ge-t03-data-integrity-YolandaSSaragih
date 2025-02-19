package academic.model;

public class Course {
    private final String code; // Course code should not change
    private String name;        // Course name
    private final int credits;  // Number of credits should not change
    private String semester;     // Semester in which the course is offered

    public Course(String code, String name, int credits, String semester) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.semester = semester;
    }

    public String getCode() {
        return code; // Only getter, no setter
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits; // Only getter, no setter
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + semester;
    }
}