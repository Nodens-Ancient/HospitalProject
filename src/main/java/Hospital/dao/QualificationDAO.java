package Hospital.dao;

import Hospital.models.tablemodels.Qualification;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@Component
public class QualificationDAO extends HospitalDAO{
    private static final String TABLE_NAME = "qualification";
    protected QualificationDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }


    public List<Qualification> getAllTable(){
        return super.getAllTable(TABLE_NAME, Qualification.class);
    }

    public Qualification show(int id){
        return super.show(TABLE_NAME, id, Qualification.class);
    }

    public void delete(int id) {
        super.delete(TABLE_NAME, id);
    }

    public void save(Qualification qualification) {
        super.jdbcTemplate.update("INSERT INTO "+ TABLE_NAME +" (idQualifications)  VALUES( ?)",
                qualification.getQualification());
    }
}
