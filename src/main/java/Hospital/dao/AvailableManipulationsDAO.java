package Hospital.dao;

import Hospital.models.tablemodels.AvailableManipulation;
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

    public List<AvailableManipulation> getAllTable(){
        return super.getAllTable(TABLE_NAME, AvailableManipulation.class);
    }

    public AvailableManipulation show(int id){
        return super.show(TABLE_NAME, id, AvailableManipulation.class);
    }

    public void delete(int id) {
        super.delete(TABLE_NAME, id);
    }

    public void save(AvailableManipulation availableManipulation) {
        super.jdbcTemplate.update("INSERT INTO "+ TABLE_NAME +" (idQualifications)  VALUES( ?)",
                availableManipulation.getIdQualification());
    }
}
