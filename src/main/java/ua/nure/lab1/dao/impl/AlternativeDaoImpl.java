package ua.nure.lab1.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.nure.lab1.dao.AlternativeDao;
import ua.nure.lab1.domain.dto.AlternativeDto;
import ua.nure.lab1.domain.entity.Alternative;
import ua.nure.lab1.domain.entity.Mark;

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
    private static final String UPDATE_ALTERNATIVE = "update alternative set name=? where id=?";
    private static final String ADD_MARS_TO_ALTERNATIVE = "insert into vector (alternative_id, mark_id) values(?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Alternative createAlternative(AlternativeDto alternativeDto) {
        Alternative alternative = new Alternative();
        alternative.setName(alternativeDto.getName());
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
        jdbcTemplate.update(UPDATE_ALTERNATIVE, alternative.getName(), alternative.getId());
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


    @Override
    public Alternative addMarksToAlternative(Alternative alternative) {
        jdbcTemplate.batchUpdate(ADD_MARS_TO_ALTERNATIVE, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, alternative.getId());
                ps.setInt(2, alternative.getMark().get(i).getId());
            }

            @Override
            public int getBatchSize() {
                return alternative.getMark().size();
            }
        });
        return alternative;
    }
}
