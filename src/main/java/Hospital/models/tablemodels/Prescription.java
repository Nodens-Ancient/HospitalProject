package Hospital.models.tablemodels;

public class Prescription {
    private int id;
    private int idManipulation;
    private int idPersonalRef;
    private int idPersonalExec;
    private int idDiagnose;

    public int getIdDiagnose() {
        return idDiagnose;
    }

    public void setIdDiagnose(int idDiagnose) {
        this.idDiagnose = idDiagnose;
    }

    private int idResort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdManipulation() {
        return idManipulation;
    }

    public void setIdManipulation(int idManipulation) {
        this.idManipulation = idManipulation;
    }

    public int getIdPersonalRef() {
        return idPersonalRef;
    }

    public void setIdPersonalRef(int idPersonalRef) {
        this.idPersonalRef = idPersonalRef;
    }

    public int getIdPersonalExec() {
        return idPersonalExec;
    }

    public void setIdPersonalExec(int idPersonalExec) {
        this.idPersonalExec = idPersonalExec;
    }

    public int getIdResort() {
        return idResort;
    }

    public void setIdResort(int idresort) {
        this.idResort = idresort;
    }

    public Prescription(int id, int idManipulation, int idPersonalRef, int idDiagnose, int idPersonalExec, int idResort) {
        this.id = id;
        this.idManipulation = idManipulation;
        this.idPersonalRef = idPersonalRef;
        this.idPersonalExec = idPersonalExec;
        this.idDiagnose = idDiagnose;
        this.idResort = idResort;
    }

    public Prescription(){}

    @Override
    public String toString() {
        return "Prescription " +
                "   id : " + id +
                ",  idManipulation : " + idManipulation +
                ",  idPersonalRef : " + idPersonalRef +
                ",  idPersonalExec : "  + idPersonalExec +
                ",  idDiagnose : " + idDiagnose +
                ",  idResort : " + idResort;
    }
}
