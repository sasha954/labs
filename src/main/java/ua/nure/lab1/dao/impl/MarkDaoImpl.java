package ua.nure.lab1.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.nure.lab1.dao.CriteriaDao;
import ua.nure.lab1.dao.MarkDao;
import ua.nure.lab1.domain.entity.Criteria;
import ua.nure.lab1.domain.entity.Mark;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class MarkDaoImpl implements MarkDao {

    private static final String ID_FIELD = "id";
    private static final String NAME_FIELD = "name";
    private static final String RANGE_FIELD = "range";
    private static final String NUM_FIELD = "numMark";
    private static final String NORM_FIELD = "normMark";
    private static final String CRITERIA_ID_FIELD = "criteria_id";

    private static final String CREATE_MARK = "insert into mark (name, `range`, numMark, normMark, criteria_id) " +
            "values (?,?,?,?,?)";
    private static final String DELETE_MARK = "delete from mark where id=?";
    private static final String GET_ALL_MARKS = "select * from mark";
    private static final String GET_MARK_BY_ID = "select * from mark where id=?";
    private static final String UPDATE_MARK = "update mark set name=?, `range`=?, numMark=?, normMark=?, criteria_id=? " +
            "where id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CriteriaDao criteriaDao;

    @Override
    public List<Mark> getAllMarks() {
        return jdbcTemplate.query(GET_ALL_MARKS, (rs, rowNum) -> constructMark(rs));
    }

    private Mark constructMark(ResultSet rs) throws SQLException {
        Mark mark = new Mark();
        mark.setId(rs.getInt(ID_FIELD));
        mark.setName(rs.getString(NAME_FIELD));
        mark.setRange(rs.getInt(RANGE_FIELD));
        mark.setNumMark(rs.getInt(NUM_FIELD));
        mark.setNormMark(rs.getInt(NORM_FIELD));
        mark.setCriterion(criteriaDao.getCriteriaById(rs.getInt(CRITERIA_ID_FIELD)));
        return mark;
    }

    @Override
    public Mark createMark(Mark mark) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(CREATE_MARK, new String[] {ID_FIELD});
            statement.setString(1, mark.getName());
            statement.setInt(2, mark.getRange());
            statement.setInt(3, mark.getNumMark());
            statement.setInt(4, mark.getNormMark());
            statement.setInt(5, mark.getCriterion().getId());
            return statement;
        }, keyHolder);

        int markId = (int) Optional.ofNullable(keyHolder.getKeys().get(ID_FIELD)).orElse(0);
        mark.setId(markId);

        return mark;
    }

    @Override
    public void deleteMark(int markId) {
        jdbcTemplate.update(DELETE_MARK, markId);
    }

    @Override
    public Mark updateMark(Mark mark) {
        jdbcTemplate.update(UPDATE_MARK, mark.getName(), mark.getRange(), mark.getNumMark(), mark.getNormMark(),
                mark.getCriterion().getId(), mark.getId());
        return mark;
    }

    @Override
    public Mark getMarkById(int markId) {
        return jdbcTemplate.query(GET_MARK_BY_ID, this::extractData, markId);
    }

    private Mark extractData(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return constructMark(rs);
        }
        return null;
    }
}
