package com.jundagui.support;

import com.jundagui.entity.State;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes({State.class})
public class StateHandler implements TypeHandler<State> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, State state, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, state.getCode());
    }

    @Override
    public State getResult(ResultSet resultSet, String s) throws SQLException {
        Integer code = resultSet.getInt(s);
        return State.getSexByCode(code);
    }

    @Override
    public State getResult(ResultSet resultSet, int i) throws SQLException {
        Integer code = resultSet.getInt(i);
        return State.getSexByCode(code);
    }

    @Override
    public State getResult(CallableStatement callableStatement, int i) throws SQLException {
        Integer code = callableStatement.getInt(i);
        return State.getSexByCode(code);
    }

}
