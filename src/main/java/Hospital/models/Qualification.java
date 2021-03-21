package Hospital.models;

public class Qualification {
    private int id;
    private String qualification;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Qualification(int id, String qualification) {
        this.id = id;
        this.qualification = qualification;
    }
    public Qualification(){}

    @Override
    public String toString() {
        return "Qualification :  " +
                "      id : " + id +
                ",      qualification : " + qualification;
    }
}
