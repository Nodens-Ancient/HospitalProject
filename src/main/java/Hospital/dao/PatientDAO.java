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

//    public void save(Patients patients) {
//        jdbcTemplate.update("INSERT INTO Person VALUES(1, ?, ?, ?)", person.getName(), person.getAge(),
//                person.getEmail());
//    }
//    public void update(int id, Patients updatedPatient) {
//        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?", updatedPerson.getName(),
//                updatedPerson.getAge(), updatedPerson.getEmail(), id);
//    }

//    public void delete(int id) {
//        jdbcTemplate.update("DELETE FROM patients WHERE id=?", id);
//    }

}
