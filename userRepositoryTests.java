package com.example.mysql.demo1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class userRepositoryTests
{
@Autowired
private userRepository repo;
@Autowired
private TestEntityManager entitymanager;
@Test
public void testcreateuser()
{
	user u=new user();
	u.setEmail("diptipatil3jan@gmail.com");
	u.setPassword("diptid");
	u.setFirstname("Dipt");
	u.setLastname("deshpande");
	user saveduser=repo.save(u);
	user existUser=entitymanager.find(user.class, saveduser.getId());
	
	assertThat(existUser.getEmail()).isEqualTo(u.getEmail());
}

}
