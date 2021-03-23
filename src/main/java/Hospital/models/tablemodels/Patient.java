package Hospital.models.tablemodels;

public class Patient {
    private int id;
    private String patientName;
    private String patientPhoneNumber;

    public Patient(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public Patient(int id, String patientName, String patientPhoneNumber) {
        this.id = id;
        this.patientName = patientName;
        this.patientPhoneNumber = patientPhoneNumber;
    }

    @Override
    public String toString() {
        return "Patient " +
                "id = " + id +
                " " + patientName +
                " " + patientPhoneNumber;
    }
}
