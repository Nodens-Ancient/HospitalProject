package Hospital.dao;

import Hospital.models.AvailableManipulations;
import Hospital.models.Prescription;
import Hospital.models.ResortHistory;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@Component
public class PrescriptionsDAO extends HospitalDAO{
    private static final String TABLE_NAME = "prescriptions";
    protected PrescriptionsDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<Prescription> index(){
        return super.index(TABLE_NAME, Prescription.class);
    }

    public Prescription show(int id){
        return super.show(TABLE_NAME, id, Prescription.class);
    }

    public void delete(int id) {
        super.delete(TABLE_NAME, id);
    }

    public void save(Prescription prescription) {
        super.jdbcTemplate.update("INSERT INTO "+ TABLE_NAME +" (idQualifications)  VALUES( ?,?,?,?,?)",
                prescription.getIdManipulation(), prescription.getIdPersonalRef(),
                prescription.getIdDiagnose(), prescription.getIdPersonalExec(), prescription.getIdResort());
    }
}
