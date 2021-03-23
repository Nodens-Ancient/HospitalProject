package Hospital.models.additionalmodels;

public class MedicalHistory {
    private String patientName;
    private String dateResort;
    private String dateDischarge;
    private String symptoms;
    private String diagnoseInitial;
    private String diagnoseCurrent;
    private String diagnoseFinal;
    private String manipulation;

    public MedicalHistory(){}

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDateResort() {
        return dateResort;
    }

    public void setDateResort(String dateResort) {
        this.dateResort = dateResort;
    }

    public String getDateDischarge() {
        return dateDischarge;
    }

    public void setDateDischarge(String dateDischarge) {
        this.dateDischarge = dateDischarge;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnoseInitial() {
        return diagnoseInitial;
    }

    public void setDiagnoseInitial(String diagnoseInitial) {
        this.diagnoseInitial = diagnoseInitial;
    }

    public String getDiagnoseCurrent() {
        return diagnoseCurrent;
    }

    public void setDiagnoseCurrent(String diagnoseCurrent) {
        this.diagnoseCurrent = diagnoseCurrent;
    }

    public String getDiagnoseFinal() {
        return diagnoseFinal;
    }

    public void setDiagnoseFinal(String diagnoseFinal) {
        this.diagnoseFinal = diagnoseFinal;
    }

    public String getManipulation() {
        return manipulation;
    }

    public void setManipulation(String manipulation) {
        this.manipulation = manipulation;
    }

    public MedicalHistory(String patientName, String dateResort, String dateDischarge, String symptoms, String diagnoseInitial, String diagnoseCurrent, String diagnoseFinal, String manipulation) {
        this.patientName = patientName;
        this.dateResort = dateResort;
        this.dateDischarge = dateDischarge;
        this.symptoms = symptoms;
        this.diagnoseInitial = diagnoseInitial;
        this.diagnoseCurrent = diagnoseCurrent;
        this.diagnoseFinal = diagnoseFinal;
        this.manipulation = manipulation;
    }

    @Override
    public String toString() {
        return "MedicalHistory{" +
                "patientName='" + patientName + '\'' +
                ", dateResort='" + dateResort + '\'' +
                ", dateDischarge='" + dateDischarge + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", diagnoseInitial='" + diagnoseInitial + '\'' +
                ", diagnoseCurrent='" + diagnoseCurrent + '\'' +
                ", diagnoseFinal='" + diagnoseFinal + '\'' +
                ", manipulation='" + manipulation + '\'' +
                '}';
    }
}
