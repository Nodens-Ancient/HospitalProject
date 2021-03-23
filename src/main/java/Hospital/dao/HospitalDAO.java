package Hospital.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public abstract class HospitalDAO {
    protected final JdbcTemplate jdbcTemplate;

    protected HospitalDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public <T> List<T> getAllTable(String tableName, Class<T> tClass){
        return  jdbcTemplate.query("SELECT * FROM " + tableName, new BeanPropertyRowMapper<>(tClass));
    }

    public void delete(String tableName, int id){
        jdbcTemplate.update("DELETE FROM " + tableName + " WHERE id=?", id);
    }

    public <T> T show(String tableName, int id, Class<T> tClass){
        return  jdbcTemplate.query("SELECT * FROM " + tableName + " WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(tClass))
                .stream().findAny().orElse(null);
    }
}
