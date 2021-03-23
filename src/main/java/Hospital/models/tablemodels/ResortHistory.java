package Hospital.models.tablemodels;

public class ResortHistory {
    private int id;
    private int idPatient;
    private String dateResort;
    private String dateDischarge;

    public int getId() {
        return id;
    }

    public void setId(int idResort) {
        this.id = idResort;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
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

    public ResortHistory(int id, int idPatient, String dateResort, String dateDischarge) {
        this.id = id;
        this.idPatient = idPatient;
        this.dateResort = dateResort;
        this.dateDischarge = dateDischarge;
    }
    public ResortHistory(){}

    @Override
    public String toString() {
        return "ResortHistory:" +
                "   id : " + id +
                ",  idPatient : " + idPatient +
                ",  dateResort : " + dateResort +
                ",  dateDischarge : " + dateDischarge;
    }
}
