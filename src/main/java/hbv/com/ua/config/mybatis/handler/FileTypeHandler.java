package hbv.com.ua.config.mybatis.handler;

import hbv.com.ua.domain.FileType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileTypeHandler extends BaseTypeHandler<FileType> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, FileType fileType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, fileType.name());
    }

    @Override
    public FileType getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return FileType.valueOf(s);
    }

    @Override
    public FileType getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return FileType.valueOf(resultSet.getString(i));
    }

    @Override
    public FileType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return FileType.valueOf(callableStatement.getString(i));
    }
}
