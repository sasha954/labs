package ua.nure.lab1.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.nure.lab1.dao.VectorDao;
import ua.nure.lab1.domain.entity.Vector;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class VectorDaoImpl implements VectorDao {

    private static final String ID_FIELD = "id";
    private static final String ALTERNATIVE_FIELD = "alternative_id";
    private static final String MARK_FIELD = "mark_id";

    private static final String CREATE_NEW_VECTOR = "insert into vector (alternative_id, mark_id) values (?,?)";
    private static final String GET_ALL_VECTORS = "select * from vector";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Vector> getAllVectors() {
        return null;
    }

    @Override
    public Vector createVector(Vector vector) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        return jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(CREATE_NEW_VECTOR, new String[]{ID_FIELD});
            statement.setInt(1, vector.getAlternative().getId());
            statement.setInt(2, vector.getMark().);
        });
    }

    @Override
    public void deleteVector(int vectorId) {

    }

    @Override
    public Vector updateVector(Vector vector) {
        return null;
    }

    @Override
    public Vector getVectorById(int vectorId) {
        return null;
    }
}
