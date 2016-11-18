/**
 * Copyright 2016 VOPEN.XYZ.
 */
package xyz.vopen.passport.dao.jdbc;

import org.springframework.stereotype.Repository;
import xyz.vopen.passport.commons.jdbc.JdbcDaoSupport;
import xyz.vopen.passport.dao.PassportDAO;

/**
 * @author Elve.xu
 */
@Repository("passportDAO")
public class PassportDAOImpl extends JdbcDaoSupport implements PassportDAO {

    @Override
    public void something () {
        System.out.println("passport dao impl.");
        String sql = "select count(*) from table";
        int count = this.getJdbcTemplate().queryForObject(sql, Integer.class);
        ;
        System.out.println("Result :" + count);
    }
}
