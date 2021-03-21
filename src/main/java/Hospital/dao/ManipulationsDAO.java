package Hospital.dao;

import Hospital.models.AvailableManipulations;
import Hospital.models.Diagnoses;
import Hospital.models.Manipulations;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@Component
public class ManipulationsDAO extends HospitalDAO{

    private static final String TABLE_NAME = "manipulations";

    protected ManipulationsDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<Manipulations> index(){
        return super.index(TABLE_NAME, Manipulations.class);
    }

    public Manipulations show(int id){
        return super.show(TABLE_NAME, id, Manipulations.class);
    }

    public void delete(int id) {
        super.delete(TABLE_NAME, id);
    }

    public void save(Manipulations manipulations) {
        super.jdbcTemplate.update("INSERT INTO "+ TABLE_NAME +" (manipulation)  VALUES( ?)",
                manipulations.getManipulation());
    }
}
