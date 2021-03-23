package Hospital.dao;

import Hospital.models.tablemodels.Personal;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@Component
public class PersonalDAO extends HospitalDAO {

    private static final String TABLE_NAME = "personal";

    protected PersonalDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<Personal> getAllTable(){
        return super.getAllTable(TABLE_NAME, Personal.class);
    }

    public Personal show(int id){
        return super.show(TABLE_NAME, id, Personal.class);
    }

    public void delete(int id) {
        super.delete(TABLE_NAME, id);
    }

    public void save(Personal personal) {
        super.jdbcTemplate.update("INSERT INTO "+ TABLE_NAME +" (personalName, personalPhoneNumber, idQualification)  VALUES( ?, ?, ?)", personal.getPersonalName(), personal.getPersonalPhoneNumber(),
                personal.getIdQualification());
    }

//    public void update(int id, Personal updatedPersonal) {
//        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?", updatedPerson.getName(),
//                updatedPerson.getAge(), updatedPerson.getEmail(), id);
//
//    }



}
