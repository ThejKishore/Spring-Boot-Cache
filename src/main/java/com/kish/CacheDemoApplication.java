package com.kish;

import com.kish.app.dao.PersonDao;
import com.kish.app.pojo.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class CacheDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(PersonDao personDao){
		return s->{
			personDao.save(constructPerson("Rakesh","Chandran","racky@gmail.com","Chennai,India"));
			personDao.save(constructPerson("Madhan","Babu","madhan@gmail.com","Chennai,India"));
			personDao.save(constructPerson("Vamsy","Raju","vamsyRaju@gmail.com","Austin,Texas,US"));

		};
	}


	private Person constructPerson(String fName,String lName,String mailId,String address){
		Person p =new Person();
		p.setAddress(address);
		p.setFirstName(fName);
		p.setMailId(mailId);
		p.setLastName(lName);
		return p;
	}
}
