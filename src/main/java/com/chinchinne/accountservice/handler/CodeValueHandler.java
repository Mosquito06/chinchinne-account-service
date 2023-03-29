package com.chinchinne.accountservice.handler;

import com.chinchinne.accountservice.domain.model.CodeValue;
import com.chinchinne.accountservice.domain.model.Status;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.hibernate.usertype.UserType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EnumSet;
import java.util.NoSuchElementException;

public class CodeValueHandler<E extends Enum<E> & CodeValue> implements TypeHandler<CodeValue>
{
    private Class<E> clz;

    public CodeValueHandler(Class<E> clz)
    {
        this.clz = clz;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, CodeValue codeValue, JdbcType jdbcType) throws SQLException
    {
        ps.setString(i, codeValue.getCode());
    }

    @Override
    public CodeValue getResult(ResultSet rs, String s) throws SQLException
    {
        return getCodeEnum(rs.getString(s));
    }

    @Override
    public CodeValue getResult(ResultSet rs, int i) throws SQLException
    {
        return getCodeEnum(rs.getString(i));
    }

    @Override
    public CodeValue getResult(CallableStatement cs, int i) throws SQLException
    {
        return getCodeEnum(cs.getString(i));
    }

    private CodeValue getCodeEnum(String code)
    {
        return EnumSet.allOf(clz).stream()
                .filter(e->e.getCode().equals(code))
                .findAny()
                .orElseThrow(()-> new NoSuchElementException());
    }
}
