package Hospital.dao;

import Hospital.models.tablemodels.Diagnose;
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

    public List<Diagnose> getAllTable(){
        return super.getAllTable(TABLE_NAME, Diagnose.class);
    }

    public Diagnose show(int id){
        return super.show(TABLE_NAME, id, Diagnose.class);
    }

    public void delete(int id) {
        super.delete(TABLE_NAME, id);
    }

    public void save(Diagnose diagnose) {
        super.jdbcTemplate.update("INSERT INTO "+ TABLE_NAME +" (idResot, symptoms, diagnoseInitial, diagnoseFinal, diagnoseCurrent)  VALUES( ?, ?, ?,?,?)",
                diagnose.getIdResort(), diagnose.getSymptoms(), diagnose.getDiagnoseInitial(), diagnose.getDiagnoseFinal(), diagnose.getDiagnoseCurrent());
    }

}
