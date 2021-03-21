package Hospital.models;

public class Diagnoses {

    private int id;

    private int idResort;
    private String symptoms;
    private String diagnoseCurrent;
    private String diagnoseFinal;
    private String diagnoseInitial;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdResort() {
        return idResort;
    }

    public void setIdResort(int idResort) {
        this.idResort = idResort;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
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

    public String getDiagnoseInitial() {
        return diagnoseInitial;
    }

    public void setDiagnoseInitial(String diagnoseInitial) {
        this.diagnoseInitial = diagnoseInitial;
    }

    public Diagnoses(int id, int idResort, String symptoms, String diagnoseCurrent, String diagnoseFinal, String diagnoseInitial) {
        this.id = id;
        this.idResort = idResort;
        this.symptoms = symptoms;
        this.diagnoseCurrent = diagnoseCurrent;
        this.diagnoseFinal = diagnoseFinal;
        this.diagnoseInitial = diagnoseInitial;
    }

    public Diagnoses(){}

    @Override
    public String toString() {
        return "Diagnose:" +
                "   id : " + id +
                ",  idResort : " + idResort +
                ",  symptoms : " + symptoms +
                ",  current diagnose : " + diagnoseCurrent +
                ",  final diagnose : " + diagnoseFinal +
                ",  initial diagnose : " + diagnoseInitial;
    }
}
