package ua.nure.lab1.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;
import ua.nure.lab1.dao.AlternativeDao;
import ua.nure.lab1.domain.entity.Alternative;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class AlternativeDaoImpl implements AlternativeDao {

    private static final String ID_FIELD = "id";
    private static final String NAME_FIELD = "name";
    private static final String INSERT_ALTERNATIVE = "insert into alternative (name) values (?)";
    private static final String GET_ALL_ALTERNATIVES = "select * from alternative";
    private static final String GET_ALTERNATIVE_BY_ID = "select * from alternative where id=?";
    private static final String DELETE_ARTICLE = "delete from alternative where id=?";
    private static final String UDATE_ALTERNATIVE = "update alternative set name=? where id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Alternative createAlternative(Alternative alternative) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(INSERT_ALTERNATIVE, new String[]{ID_FIELD});
            statement.setString(1, alternative.getName());
            return statement;
        }, keyHolder);

        int id = (int) Optional.ofNullable(keyHolder.getKeys().get(ID_FIELD)).orElse(0);
        alternative.setId(id);
        return alternative;
    }

    @Override
    public Alternative updateAlternative(Alternative alternative) {
        jdbcTemplate.update(UDATE_ALTERNATIVE, alternative.getName(), alternative.getId());
        return alternative;
    }

    @Override
    public void removeAlternative(int alternativeId) {
        jdbcTemplate.update(DELETE_ARTICLE, alternativeId);
    }

    @Override
    public List<Alternative> getAllAlternatives() {
        return jdbcTemplate.query(GET_ALL_ALTERNATIVES, (rs, rowNum) -> constructAlternatives(rs));
    }

    private Alternative constructAlternatives(ResultSet resultSet) throws SQLException {
        Alternative alternative = new Alternative();
        alternative.setId(resultSet.getInt(ID_FIELD));
        alternative.setName(resultSet.getString(NAME_FIELD));
        return alternative;
    }

    @Override
    public Alternative getAlternativeById(int id) {
        return jdbcTemplate.query(GET_ALTERNATIVE_BY_ID, this::extractData, id);
    }

    private Alternative extractData(ResultSet rs) throws SQLException{
        if (rs.next()) {
            return constructAlternatives(rs);
        }
        return null;
    }
}
