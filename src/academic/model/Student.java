package academic.model;

public class Student {
    private final String id; // ID should not change
    private String name;
    private String angkatan;
    private String prodi;

    public Student(String id, String name, String angkatan, String prodi) {
        this.id = id;
        this.name = name;
        this.angkatan = angkatan;
        this.prodi = prodi;
    }

    public String getId() {
        return id; // Only getter, no setter
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + angkatan + "|" + prodi;
    }
}
