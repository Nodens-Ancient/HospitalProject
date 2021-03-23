package Hospital.dao;

import Hospital.models.tablemodels.Manipulation;
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

    public List<Manipulation> getAllTable(){
        return super.getAllTable(TABLE_NAME, Manipulation.class);
    }

    public Manipulation show(int id){
        return super.show(TABLE_NAME, id, Manipulation.class);
    }

    public void delete(int id) {
        super.delete(TABLE_NAME, id);
    }

    public void save(Manipulation manipulation) {
        super.jdbcTemplate.update("INSERT INTO "+ TABLE_NAME +" (manipulation)  VALUES( ?)",
                manipulation.getManipulation());
    }
}
