package com.liyc.springboot.dao;

import com.liyc.springboot.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Types;

/**
 * @Author lyc
 * @Date 2020-9-17 17:26
 * @ClassName JdbcTemplateDao
 * @Description TODO
 */
@Repository
public class JdbcTemplateDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int saveUser(User user){
        String sql = "insert into user (create_time,email,nick_name,pass_word,user_name) " +
                " values(?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, System.currentTimeMillis(), user.getEmail(),
                user.getNickName(), user.getPassWord(), user.getUserName());
        return update;
    }

    /**
     * namedParameterJdbcTemplate 使用map入参很容易实现动态sql
     * 此方法也可以使用带in语句的参数注入
     *
     * 解决了使用：1、相对array参数，解决了参数in复杂、变量重用的问题。
     * 注意：
     *  1、如果是in貌似是不可以用数组的，用list可以。
     *  2、比较麻烦的是NamedParameterJdbcTemplate和JdbcTemplate没继承/接口关系。并且Named依赖Jdbc，所以在写公共dao的时候要注意。
     * @param user
     * @return
     */
    public List<User> queryByMap(User user){
        Map<String,Object> params = new HashMap<String,Object>();
        StringBuffer sb = new StringBuffer("select * from user where 1=1 ");
        if(StringUtils.isNotBlank(user.getUserName())){
            sb.append(" and user_name=:user_name");
            params.put("user_name", user.getUserName());
        }
        if(StringUtils.isNotBlank(user.getNickName())){
            sb.append(" and nick_name=:nick_name");
            params.put("nick_name", user.getNickName());
        }
        List<User> list = namedParameterJdbcTemplate.query(sb.toString(), params, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    /**
     * jdbcTemplate动态sql 常规?占位参数,请映射到对象上
     *  此方法使用in语句比较麻烦 需要手动拼接sql参数
     * 注意使用BeanPropertyRowMapper将查询结果映射到对象需要遵循命名规则:驼峰->下划线
     * @param user
     * @return
     */
    public List<User> queryByarry(User user) {
        List<Object> params = new ArrayList<Object>();
        StringBuffer sb = new StringBuffer("select * from user where 1=1 ");

        if (user != null) {
            if(StringUtils.isNotBlank(user.getUserName())){
                sb.append(" and user_name=?");
                params.add(user.getUserName());
            }
            if(StringUtils.isNotBlank(user.getNickName())){
                sb.append(" and nick_name=?");
                params.add(user.getNickName());
            }
        }
        // 如果存在in语句则需要手动拼接
        /*for (Iterator<String> iterator = names.iterator(); iterator.hasNext(); ) {
            iterator.next();
            sql += "?";
            if(iterator.hasNext()) sql += ",";
        }
        sql += ")";
        params.add(names);*/
        List<User> list = jdbcTemplate.query(sb.toString(), params.toArray(), new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    /**
     * 将查询结果转为javaBean对象
     * @param id
     * @return
     */
    public User queryForObject(Long id) {
        String sql = " select * from user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserName(rs.getString("user_name"));
                user.setNickName(rs.getString("nick_name"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        });
        return user;
    }

    /**
     * 批处理并使用匿名内部类传参数
     * @param users
     * @return
     */
    public int[] batchUpdate(List<User> users) {
        String sql = "update user set user_name=?,nick_name=?,email=?,pass_word=? where id=? ";
        int[] updateCounts = jdbcTemplate.batchUpdate(sql,
                new BatchPreparedStatementSetter() {//使用匿名内部类设置批量操作的参数
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        // 注意此处设置参数是从1开始
                        ps.setString(1, users.get(i).getUserName());
                        ps.setString(2, users.get(i).getNickName());
                        ps.setString(3,users.get(i).getEmail());
                        ps.setString(4,users.get(i).getPassWord());
                        ps.setLong(5, users.get(i).getId());
                    }

                    public int getBatchSize() {
                        return users.size();
                    }
                });
        return updateCounts;
    }

    /**
     * 使用List<Object[]>传参
     * @param users
     * @return
     */
    public int[] batchinsert(List<User> users){
        List<Object[]> batch = new ArrayList<Object[]>();
        long time = System.currentTimeMillis();
        for (User user : users) {
            Object[] values = new Object[]{
                    time,
                    user.getEmail(),
                    user.getNickName(),
                    user.getPassWord(),
                    user.getUserName()
            };

            batch.add(values);
        }
        String sql = "insert into user (create_time,email,nick_name,pass_word,user_name) " +
                " values(?,?,?,?,?)";
        int[] updateCounts = jdbcTemplate.batchUpdate(sql,batch);
        return updateCounts;
    }

    public List<Map<String, Object>> queryList() {
        String sql = "select * from heros ";
        return jdbcTemplate.queryForList(sql);
    }
}
