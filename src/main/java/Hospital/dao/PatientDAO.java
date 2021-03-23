package Hospital.dao;

import Hospital.models.tablemodels.Patient;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@Component
public class PatientDAO extends HospitalDAO {

    private JdbcTemplate jdbcTemplate;
    private static final String TABLE_NAME = "patients";

    protected PatientDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<Patient> getAllTable(){
        return super.getAllTable(TABLE_NAME, Patient.class);
    }

    public Patient show(int id){
        return super.show(TABLE_NAME, id, Patient.class);
    }

    public void delete(int id) {
        super.delete(TABLE_NAME, id);
    }

    public void save(Patient patient) {
        super.jdbcTemplate.update("INSERT INTO patients (patientName, patientPhoneNumber)  VALUES( ?, ?)",
                patient.getPatientName(), patient.getPatientPhoneNumber());
    }


}
