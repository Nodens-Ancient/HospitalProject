package Hospital.models;

public class Patients {
    private int id;
    private String patientName;
    private String patientPhoneNumber;

    public Patients(){}

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

    public Patients(int id, String patientName, String patientPhoneNumber) {
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
