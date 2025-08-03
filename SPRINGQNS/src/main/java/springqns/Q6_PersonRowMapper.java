package springqns;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class Q6_PersonRowMapper implements RowMapper<Q6_Person> {
    @Override
    public Q6_Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q6_Person person = new Q6_Person();
        person.setId(rs.getInt("id"));
        person.setAge(rs.getInt("age"));
        person.setFirstName(rs.getString("first_name"));
        person.setLastName(rs.getString("last_name"));
        return person;
    }
}
