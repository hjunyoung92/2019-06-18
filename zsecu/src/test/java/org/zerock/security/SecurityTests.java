package org.zerock.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
						"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class SecurityTests {
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void testInsertAuth() {
		String sql = "insert into tbl_member_auth (userid, auth) values(?,?)";
		for (int i = 80; i < 100; i++) {
			try (Connection con = ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
			){
				if(i<80) {
					pst.setString(1,"user "+i);
					pst.setString(2,"ROLE_USER");
				}
				else if (i<90){
					pst.setString(1,"user "+i);
					pst.setString(2,"ROLE_MEMBER");
				}
				else {
					pst.setString(1,"user "+i);
				pst.setString(2,"ROLE_ADMIN");}
				
				int count = pst.executeUpdate();
				log.info(count);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} //for end
		
	}
	
	@Test
	public void testInsertMember() {
		String sql = "insert into tbl_member (userid, userpw, username) values(?,?,?)";
		for (int i = 0; i < 100; i++) {
			try (Connection con = ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
			){
				if(i<80) {
					pst.setString(1, "user"+1);
					pst.setString(2, bcrypt.encode("user"+1));
					pst.setString(3,"일반유저 "+1);
				}
				else if (i<90){
					pst.setString(1, "user"+1);
					pst.setString(2, bcrypt.encode("manager"+1));
					pst.setString(3,"매니저 "+1);
					
				}
				else {
					pst.setString(1, "user"+1);
					pst.setString(2, bcrypt.encode("admin"+1));
					pst.setString(3,"어드민 "+1);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} //for end
	}
	
	@Test
	public void test1() {
		log.info(bcrypt);
		
		String encoded = bcrypt.encode("1234");//char sequence는 문자열이랑 유사
		//$2a$10$MbQvUypc4BnAIaQgAHHdC.3ggAAs8s0n.h8MkzWmTdtZP/trMvSEK
		//$2a$10$B4DD9ubchxPJlIbNlUF4WOFNABXRmS8/5H2QVi2V95k9WrTELyLvC
		//$2a$10$vBuBiU2FeGrbMImdJn9MYe3ph5GSBJ.eEud0/Vi.U4eX/TM.3ZlTi
		
		log.info(encoded);
		log.info("--------------");
		
		boolean result = bcrypt.matches("1234", encoded);
		
		log.info(result);
	
		
		
	}
	
}
