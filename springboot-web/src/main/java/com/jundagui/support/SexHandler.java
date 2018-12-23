package com.jundagui.support;

import com.jundagui.entity.Sex;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes({Sex.class})
public class SexHandler implements TypeHandler<Sex> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Sex sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, sexEnum.getCode());
    }

    @Override
    public Sex getResult(ResultSet resultSet, String s) throws SQLException {
        Integer code = resultSet.getInt(s);
        return Sex.getSexByCode(code);
    }

    @Override
    public Sex getResult(ResultSet resultSet, int i) throws SQLException {
        Integer code = resultSet.getInt(i);
        return Sex.getSexByCode(code);
    }

    @Override
    public Sex getResult(CallableStatement callableStatement, int i) throws SQLException {
        Integer code = callableStatement.getInt(i);
        return Sex.getSexByCode(code);
    }

}
