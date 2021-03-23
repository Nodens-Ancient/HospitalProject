package Hospital.dao;

import Hospital.models.additionalmodels.MedicalHistory;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@Component
public class MedicalHistoryDAO extends HospitalDAO{
    private static final String QUERY = "select patients.id, patients.patientName, resorthistory.dateResort, " +
            "resorthistory.dateDischarge, diagnoses.symptoms, " +
            "diagnoses.diagnoseInitial, diagnoses.diagnoseCurrent, diagnoses.diagnoseFinal, manipulations.manipulation\n" +
            " from (patients inner join resorthistory on patients.id = resorthistory.idPatient)  \n" +
            " join diagnoses on resorthistory.id = diagnoses.idResort join prescriptions on diagnoses.id = prescriptions.idDiagnose\n" +
            " join manipulations on prescriptions.idManipulation = manipulations.id where patients.id = ?";

    protected MedicalHistoryDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<MedicalHistory> getMedicalHistory(int id){
        return super.jdbcTemplate.query(QUERY, new Object[]{id},new BeanPropertyRowMapper<>(MedicalHistory.class));
    }
}
