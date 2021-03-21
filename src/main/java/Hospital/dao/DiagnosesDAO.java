package Hospital.dao;

import Hospital.models.Diagnoses;
import Hospital.models.Personal;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@Component
public class DiagnosesDAO extends HospitalDAO{
    private static final String TABLE_NAME = "diagnoses";

    private JdbcTemplate jdbcTemplate;
    protected DiagnosesDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<Diagnoses> index(){
        return super.index(TABLE_NAME, Diagnoses.class);
    }

    public Diagnoses show(int id){
        return super.show(TABLE_NAME, id, Diagnoses.class);
    }

    public void delete(int id) {
        super.delete(TABLE_NAME, id);
    }

    public void save(Diagnoses diagnoses) {
        super.jdbcTemplate.update("INSERT INTO "+ TABLE_NAME +" (idResot, symptoms, diagnoseInitial, diagnoseFinal, diagnoseCurrent)  VALUES( ?, ?, ?,?,?)",
                diagnoses.getIdResort(), diagnoses.getSymptoms(), diagnoses.getDiagnoseInitial(), diagnoses.getDiagnoseFinal(), diagnoses.getDiagnoseCurrent());
    }

}
