package springqns;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class Q6_PersonDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q6_Person> getAllPersons() {
        String sql = "SELECT * FROM person";
        return jdbcTemplate.query(sql, new Q6_PersonRowMapper());
    }
}
