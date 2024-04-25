package com.nigel.AOPDemo;

import com.nigel.AOPDemo.dao.AccountDAO;
import com.nigel.AOPDemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return runner -> {
			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(
			AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business methods
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the membership business methods
		theMembershipDAO.addMember();
		theMembershipDAO.sleep();

	}

}
