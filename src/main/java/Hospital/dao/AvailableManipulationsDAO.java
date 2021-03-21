package Hospital.dao;

import Hospital.models.AvailableManipulations;
import Hospital.models.Diagnoses;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@Component
public class AvailableManipulationsDAO extends HospitalDAO{
    private static final String TABLE_NAME = "availablemanipulations";
    protected AvailableManipulationsDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<AvailableManipulations> index(){
        return super.index(TABLE_NAME, AvailableManipulations.class);
    }

    public AvailableManipulations show(int id){
        return super.show(TABLE_NAME, id, AvailableManipulations.class);
    }

    public void delete(int id) {
        super.delete(TABLE_NAME, id);
    }

    public void save(AvailableManipulations availableManipulations) {
        super.jdbcTemplate.update("INSERT INTO "+ TABLE_NAME +" (idQualifications)  VALUES( ?)",
                availableManipulations.getIdQualification());
    }
}
