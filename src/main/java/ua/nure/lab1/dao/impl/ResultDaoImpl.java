package ua.nure.lab1.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.nure.lab1.dao.ResultDao;
import ua.nure.lab1.domain.entity.Alternative;
import ua.nure.lab1.domain.entity.Result;
import ua.nure.lab1.domain.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ResultDaoImpl implements ResultDao {
    private static final String INSERT_RESULT = "insert into result values (default,?,?,?,?)";
    private static final String UPDATE_RANGE = "update result set `range`=? where id=?";
    private static final String GET_ALL_RESULTS = "select * from result";
    public static final String ID = "id";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Result createResult(Result result) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(INSERT_RESULT, new String[]{ID});
            statement.setInt(1, result.getRange());
            statement.setDouble(2, result.getWeight());
            statement.setInt(3, result.getAlternative().getId());
            statement.setInt(4, 1);
            return statement;
        }, keyHolder);

        int resultId = Optional.of(keyHolder.getKey().intValue()).orElse(0);
        result.setId(resultId);
        return result;
    }

    @Override
    public List<Result> getAllResults() {
        return jdbcTemplate.query(GET_ALL_RESULTS, (rs, rowNum) -> constructResult(rs));
    }

    private Result constructResult(ResultSet rs) throws SQLException {
        Alternative alternative = new Alternative();
        alternative.setId(rs.getInt("alternative_id"));
        User user = new User();
        user.setId(rs.getInt("user_id"));
        Result result = new Result();
        result.setId(rs.getInt("id"));
        result.setWeight(rs.getDouble("weight"));
        result.setRange(rs.getInt("range"));
        result.setAlternative(alternative);
        result.setUser(user);
        return result;
    }

    @Override
    public void updateResultsRange(List<Result> results) {
        jdbcTemplate.batchUpdate(UPDATE_RANGE, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, results.get(i).getRange());
                ps.setInt(2, results.get(i).getId());
            }

            @Override
            public int getBatchSize() {
                return results.size();
            }
        });
    }
}
