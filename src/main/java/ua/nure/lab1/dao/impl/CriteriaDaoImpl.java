package ua.nure.lab1.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.nure.lab1.dao.CriteriaDao;
import ua.nure.lab1.domain.entity.Criteria;
import ua.nure.lab1.domain.entity.OptimalityType;
import ua.nure.lab1.domain.entity.ScaleType;
import ua.nure.lab1.domain.entity.Type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class CriteriaDaoImpl implements CriteriaDao {

    private static final String ID_FIELD = "id";
    private static final String NAME_FIELD = "name";
    private static final String RANGE_FIELD = "range";
    private static final String WEIGHT_FIELD = "weight";
    private static final String TYPE_FIELD = "type";
    private static final String OPTIMALITY_TYPE_FIELD = "optim_type";
    private static final String UNITS_FIELD = "units";
    private static final String SCALE_TYPE_FIELD = "scales_type";

    private static final String CREATE_CRITERIA = "insert into criteria (name, `range`, weight, type, optim_type, " +
            "units, scales_type) values (?,?,?,?,?,?,?)";
    private static final String DELETE_CRITERIA = "delete from criteria where id=?";
    private static final String GET_ALL_CRITERIA = "select * from criteria";
    private static final String GET_CRITERIA_BY_ID = "select * from criteria where id=?";
    private static final String UPDATE_CRITERIEA = "update criteria set name=?, range=?, weight=?, type=?, optim_tipe=?," +
            "units=?, scales_type=? where id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Criteria createCriteria(Criteria criteria) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(CREATE_CRITERIA, new String[]{ID_FIELD});
            statement.setString(1, criteria.getName());
            statement.setInt(2, criteria.getRange());
            statement.setInt(3, criteria.getWeight());
            statement.setString(4, criteria.getType().toString());
            statement.setString(5, criteria.getOptimType().toString());
            statement.setString(6, criteria.getUnits());
            statement.setString(7, criteria.getScaleType().toString());
            return statement;
        }, keyHolder);

        int id = (int) Optional.ofNullable(keyHolder.getKeys().get(ID_FIELD)).orElse(0);
        criteria.setId(id);

        return criteria;
    }

    @Override
    public Criteria updateCriteria(Criteria criteria) {
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(UPDATE_CRITERIEA);
            statement.setString(1, criteria.getName());
            statement.setInt(2, criteria.getRange());
            statement.setInt(3, criteria.getWeight());
            statement.setString(4, criteria.getType().toString());
            statement.setString(5, criteria.getOptimType().toString());
            statement.setString(6, criteria.getUnits());
            statement.setString(7, criteria.getScaleType().toString());
            statement.setInt(8, criteria.getId());
            return statement;
        });

        return criteria;
    }

    @Override
    public void removeCriteria(int criteriaId) {
        jdbcTemplate.update(DELETE_CRITERIA, criteriaId);
    }

    @Override
    public List<Criteria> getAllCriteria() {
        return jdbcTemplate.query(GET_ALL_CRITERIA, (rs, rowNum) -> constructCriteria(rs));
    }

    private Criteria constructCriteria(ResultSet resultSet) throws SQLException {
        Criteria criteria = new Criteria();
        criteria.setId(resultSet.getInt(ID_FIELD));
        criteria.setName(resultSet.getString(NAME_FIELD)).setRange(resultSet.getInt(RANGE_FIELD))
                .setWeight(resultSet.getInt(WEIGHT_FIELD)).setType(Type.valueOf(resultSet.getString(TYPE_FIELD)))
                .setOptimType(OptimalityType.valueOf(resultSet.getString(OPTIMALITY_TYPE_FIELD)))
                .setUnits(resultSet.getString(UNITS_FIELD))
                .setScaleType(ScaleType.valueOf(resultSet.getString(SCALE_TYPE_FIELD)));
        return criteria;
    }

    @Override
    public Criteria getCriteriaById(int criteriaId) {
        return jdbcTemplate.query(GET_CRITERIA_BY_ID, this::extractData, criteriaId);
    }

    private Criteria extractData(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return constructCriteria(rs);
        }
        return null;
    }
}
