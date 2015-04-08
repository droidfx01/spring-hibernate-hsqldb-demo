package net.droidfx.springHibernateHsqldbDemo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import net.droidfx.springHibernateHsqldbDemo.config.AppContext;
import net.droidfx.springHibernateHsqldbDemo.entity.User;
import net.droidfx.springHibernateHsqldbDemo.repository.User.UserRepository;

@Component
public class Demo {
	
	
	static final Logger log = LoggerFactory.getLogger(Demo.class);

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				AppContext.class);
 
		UserRepository userRepo = ctx.getBean(UserRepository.class);
		
		List<User> users = userRepo.findAll();
		
		for (User user2 : users) {
			log.debug(user2.toString());
		}
	}

}
