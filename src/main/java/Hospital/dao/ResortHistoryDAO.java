package Hospital.dao;

import Hospital.models.tablemodels.ResortHistory;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@Component
public class ResortHistoryDAO extends HospitalDAO{

    private static final String TABLE_NAME = "resorthistory";
    protected ResortHistoryDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<ResortHistory> getAllTable(){
        return super.getAllTable(TABLE_NAME, ResortHistory.class);
    }

    public ResortHistory show(int id){
        return super.show(TABLE_NAME, id, ResortHistory.class);
    }

    public void delete(int id) {
        super.delete(TABLE_NAME, id);
    }

    public void save(ResortHistory resortHistory) {
        super.jdbcTemplate.update("INSERT INTO "+ TABLE_NAME +" (idPatient, dateResort, dateDischarge)  VALUES( ?,?,?)",
                resortHistory.getIdPatient(), resortHistory.getDateResort(), resortHistory.getDateDischarge());
    }

}
