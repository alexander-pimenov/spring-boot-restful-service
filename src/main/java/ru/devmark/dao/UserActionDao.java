package ru.devmark.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.devmark.model.ActionType;
import ru.devmark.model.UserAction;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public class UserActionDao {

    private static final String SQL_ADD_ACTION =
        "insert into user_action (action_date, user_id, action_type) values (:actionDate, :userId, :actionId)";

    private static final String SQL_GET_HISTORY =
        "select * from user_action where action_date >= :dateFrom and action_date < :dateTo" +
        " and user_id = :userId order by action_date desc";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private UserActionMapper userActionMapper;

    public void addAction(LocalDateTime actionDate, int userId, ActionType action) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("actionDate", Timestamp.valueOf(actionDate));
        params.addValue("userId", userId);
        params.addValue("actionId", action.getId());
        jdbcTemplate.update(SQL_ADD_ACTION, params);
    }

    public List<UserAction> getUserActionHistory(int userId, LocalDate dateFrom, LocalDate dateTo) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", userId);
        params.addValue("dateFrom", Timestamp.valueOf(dateFrom.atTime(LocalTime.MIN)));
        params.addValue("dateTo", Timestamp.valueOf(dateTo.atTime(LocalTime.MAX)));
        return jdbcTemplate.query(SQL_GET_HISTORY, params, userActionMapper);
    }
}
