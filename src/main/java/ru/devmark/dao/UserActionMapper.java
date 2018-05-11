package ru.devmark.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.devmark.model.ActionType;
import ru.devmark.model.UserAction;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserActionMapper implements RowMapper<UserAction> {

    @Override
    public UserAction mapRow(ResultSet rs, int i) throws SQLException {
        UserAction action = new UserAction();
        action.setUserId(rs.getInt("user_id"));
        action.setAction(ActionType.getById(rs.getInt("action_type")));
        action.setActionDate(rs.getTimestamp("action_date").toLocalDateTime());
        return action;
    }
}
