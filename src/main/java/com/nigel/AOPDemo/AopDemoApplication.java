package com.nigel.AOPDemo;

import com.nigel.AOPDemo.dao.AccountDAO;
import com.nigel.AOPDemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return runner -> {
			// demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			demoTheAfterReturningAdvice(theAccountDAO);
		};
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nMain program: demoTheAfterReturningAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(
			AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business methods
		Account myAccount = new Account();
		myAccount.setName("George");
		myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountdao getter/setter methods
		theAccountDAO.setName("Test");
		theAccountDAO.setServiceCode("Blue");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business methods
		theMembershipDAO.addMember();
		theMembershipDAO.sleep();
	}
}
