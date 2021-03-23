package Hospital.models.tablemodels;

public class AvailableManipulation {
    private int id;
    private int idQualification;

    public AvailableManipulation(int id, int idQualification) {
        this.id = id;
        this.idQualification = idQualification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdQualification() {
        return idQualification;
    }

    public void setIdQualification(int idQualification) {
        this.idQualification = idQualification;
    }

    public AvailableManipulation(){}

    @Override
    public String toString() {
        return "AvailableManipulations : " +
                "  id : " + id +
                ",  qualification id : " + idQualification;
    }
}
