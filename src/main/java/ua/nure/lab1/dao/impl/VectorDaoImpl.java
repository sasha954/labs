package ua.nure.lab1.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.nure.lab1.dao.VectorDao;
import ua.nure.lab1.domain.dto.VectorDto;
import ua.nure.lab1.domain.entity.*;
import ua.nure.lab1.service.AlternativeService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VectorDaoImpl implements VectorDao {

    private static final String ID_FIELD = "id";
    private static final String ALTERNATIVE_FIELD = "alternative_id";
    private static final String MARK_FIELD = "mark_id";

    private static final String CREATE_NEW_VECTOR = "insert into vector (alternative_id, mark_id) values (?,?)";
    private static final String GET_ALL_VECTORS = "SELECT v.*, mark_crit.id as c_id, mark_crit.name as c_name, mark_crit.range as c_range, mark_crit.weight as c_weight, \n" +
            "mark_crit.type as c_type, mark_crit.optim_type as c_optim_type, mark_crit.units as c_unit, mark_crit.scales_type as c_scale_type,\n" +
            "mark_crit.m_name as mark_name, mark_crit.m_range as mark_range, mark_crit.m_num as mark_num, mark_crit.m_norm as mark_norm, \n" +
            "a.name as alternative_name FROM games.vector as v join alternative as a on a.id = v.alternative_id\n" +
            "join (select m.id as m_id, m.`name` as m_name, m.range as m_range, m.numMark as m_num, m.normMark as m_norm, \n" +
            "c.* from mark as m join criteria as c on m.criteria_id = c.id) as mark_crit on mark_crit.m_id = v.mark_id where v.alternative_id = ?";
    private static final String GET_ALL_ALTERNATIVE_ID = "select alternative_id from vector group by alternative_id";

}
