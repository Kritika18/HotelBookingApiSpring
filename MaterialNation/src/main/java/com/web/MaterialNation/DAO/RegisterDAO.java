package com.web.MaterialNation.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.web.MaterialNation.DAOModel.RegisterUser;
import com.web.MaterialNation.DAOModel.User;




@Repository
public class RegisterDAO {
	private static Logger LOG = LoggerFactory.getLogger(RegisterDAO.class);

	
	private JdbcTemplate jdbc;

	@Autowired
	public RegisterDAO(DataSource dataSource) {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	
	public List<RegisterUser> isemail(String email) {
		String sql = "select * from users where email = '" + email + "'";
		LOG.debug("Fetching user's emaildetails");
		List<RegisterUser> results = jdbc.query(sql, new BeanPropertyRowMapper<>(RegisterUser.class));

       return results; // we are getting display in postman 
   }
	public List<RegisterUser> ismobile(String mobile) {
		String sql = "select * from users where mobile = '" + mobile + "'";
		LOG.debug("Fetching user's mobiledetails");
		List<RegisterUser> m =jdbc.query(sql, new BeanPropertyRowMapper<>(RegisterUser.class));
       return m; // we are getting display in postman 
   }
	

	
	public RegisterUser isemail2(String email) {
		String sql = "select * from users where email = '" + email + "'";
		 // list of how many users will be displayed in postman
		LOG.debug("Fetching user's emaildetails");
		RegisterUser getuser= jdbc.queryForObject(sql,new BeanPropertyRowMapper<>(RegisterUser.class) );
		return getuser ; // we are getting display in postman 
   }
	
	public void registeruser(RegisterUser u) {
		// TODO Auto-generated method stub
		String sql = "insert into users(id , firstname , lastname , email ,mobile,password) values(?,?,?,?,?,?)";
		LOG.debug("Updating user's Data");
		try {
			jdbc.update(sql , u.getId(), u.getFirstName() , u.getLastName(),u.getEmail(),u.getMobile(),u.getPassword() );
		}
		catch(Exception e) {
			
			System.out.println(e);
		
		
		}	
	}	

}
