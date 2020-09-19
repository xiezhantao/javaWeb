package com.atguigu.dao.impl;

import com.atguigu.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author xzt
 * @create 2020-07-18 14:08
 */
public class BaseDao {

//    private QueryRunner queryRunner = new QueryRunner();
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     *
     * @param sql
     * @param args
     * @return 返回-1表示修改失败，其他表示影响的行数
     */
    public int update(String sql,Object... args){
       return jdbcTemplate.update(sql,args);
    }

    /**
     * 返回一个查询结果
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args){
        T object = null;
        try {
            object = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(type), args);
        } catch (DataAccessException e) {
        }
        return object;
    }

    /**
     * 返回多个查询结果
     * @param type
     * @param sql
     * @param args
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args){
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(type),args);
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args){
        Object object = jdbcTemplate.queryForObject(sql, Object.class, args);
        return object;
    }

}
