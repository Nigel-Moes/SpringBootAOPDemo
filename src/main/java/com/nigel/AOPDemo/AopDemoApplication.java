package com.nigel.AOPDemo;

import com.nigel.AOPDemo.dao.AccountDAO;
import com.nigel.AOPDemo.dao.MembershipDAO;
import com.nigel.AOPDemo.service.TrafficFortuneService;
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
			AccountDAO theAccountDAO,
			MembershipDAO theMembershipDAO,
			TrafficFortuneService theTrafficFortuneService) {
		return runner -> {
			// demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			// demoTheAfterReturningAdvice(theAccountDAO);
			// demoTheAfterThrowingAdvice(theAccountDAO);
			// demoTheAfterAdvice(theAccountDAO);
			// demoTheAroundAdvice(theTrafficFortuneService);
			// demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceRethrowException(theTrafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain program: demoTheAroundAdviceRethrowException");
		System.out.println("Calling getFortune()");
		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);
		System.out.println("My fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune()");
		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);
		System.out.println("My fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		String data = theTrafficFortuneService.getFortune();
		System.out.println("My fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exception
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception exc) {
			System.out.println("\n\nMain program: caught exception: " + exc);
		}
		// display the accounts
		System.out.println("\n\nMain program: demoTheAfterThrowingAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exception
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception exc) {
			System.out.println("\n\nMain program: caught exception: " + exc);
		}
		// display the accounts
		System.out.println("\n\nMain program: demoTheAfterThrowingAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
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
