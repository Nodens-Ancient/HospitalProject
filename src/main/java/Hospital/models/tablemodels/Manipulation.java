package Hospital.models.tablemodels;

public class Manipulation {

    private int id;
    private String manipulation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManipulation() {
        return manipulation;
    }

    public void setManipulation(String manipulation) {
        this.manipulation = manipulation;
    }

    public Manipulation(int id, String manipulation) {
        this.id = id;
        this.manipulation = manipulation;
    }
    public Manipulation(){}

    @Override
    public String toString() {
        return "Manipulation : " +
                "   id = : " + id +
                ",  manipulation = " + manipulation;
    }
}
