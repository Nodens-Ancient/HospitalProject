package Hospital.models.tablemodels;

public class Personal {
    private int id;
    private String personalName;
    private String personalPhoneNumber;
    private int idQualification;

    public Personal(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public String getPersonalPhoneNumber() {
        return personalPhoneNumber;
    }

    public void setPersonalPhoneNumber(String personalPhoneNumber) {
        this.personalPhoneNumber = personalPhoneNumber;
    }

    public int getIdQualification() {
        return idQualification;
    }

    public void setIdQualification(int idQualification) {
        this.idQualification = idQualification;
    }

    public Personal(int id, String personalName, String personalPhoneNumber, int idQualification) {
        this.id = id;
        this.personalName = personalName;
        this.personalPhoneNumber = personalPhoneNumber;
        this.idQualification = idQualification;
    }

    @Override
    public String toString() {
        return "Personal : " +
                "       id : " + id +
                ",      name : " + personalName +
                ",      phone number : " + personalPhoneNumber +
                ",      qualification id : " + idQualification;
    }
}
