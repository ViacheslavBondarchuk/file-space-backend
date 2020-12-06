package hbv.com.ua.config.mybatis.handler;

import hbv.com.ua.domain.Authority;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class AuthorityArrayTypeHandler extends BaseTypeHandler<Collection<Authority>> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Collection<Authority> authorities, JdbcType jdbcType) throws SQLException {
        preparedStatement.setArray(i, (Array) authorities);
    }

    @Override
    public Collection<Authority> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return this.createAuthorities(resultSet.getArray(s).getArray());
    }

    @Override
    public Collection<Authority> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return this.createAuthorities(resultSet.getArray(i).getArray());
    }

    @Override
    public Collection<Authority> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return this.createAuthorities(callableStatement.getArray(i).getArray());
    }

    protected Collection<Authority> createAuthorities(Object o) {
        final String[] authoritiesString = (String[]) o;
        if (authoritiesString.length > 0) {
            Collection<Authority> authorityCollection = new ArrayList<>();
            for (String s : authoritiesString) {
                authorityCollection.add(Enum.valueOf(Authority.class, s));
            }
            return Collections
                    .unmodifiableCollection(authorityCollection);
        }
        return null;
    }
}
