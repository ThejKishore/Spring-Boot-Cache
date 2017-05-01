package com.kish.app.dao;

import com.kish.app.pojo.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by ThejKishore on 4/30/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PersonDaoFacadeTest {

    @Autowired
    PersonDaoFacade personDaoFacade;

    @Test
    public void testBasicCache(){
      log.info("inside basic Test Cache");
        List<Person> persons = personDaoFacade.getAllPersonRecords();

        persons.stream().forEach(e -> log.info(e.getPersonId()+""));

        List<Person> persons2 = personDaoFacade.getAllPersonRecords();
        persons2.stream().forEach(e -> log.info(e.getFirstName()));
    }


    @Test
    public void testRetirevePersonByIdCaching(){
        Person p1 = personDaoFacade.getPersonById(1l);
        log.info(p1.getFirstName());
        Person p2 = personDaoFacade.getPersonById(1l);
        log.info(p2.getFirstName());

        p1.setFirstName("Racky");
        personDaoFacade.savePerson(p1);


        Person p3 = personDaoFacade.getPersonById(1l);
        log.info(p3.getFirstName());
        Person p4 = personDaoFacade.getPersonById(1l);
        log.info(p4.getFirstName());


    }

    @Test
    public void testRetirevePersonByMailCaching(){
        Person p1 = personDaoFacade.getPersonByMailId("racky@gmail.com");
        log.info(p1.getFirstName());
        Person p2 = personDaoFacade.getPersonByMailId("racky@gmail.com");
        log.info(p2.getFirstName());

        p1.setFirstName("Racky");
        personDaoFacade.savePerson(p1);

        Person p3 = personDaoFacade.getPersonByMailId("racky@gmail.com");
        log.info(p3.getFirstName());
        Person p4 = personDaoFacade.getPersonByMailId("racky@gmail.com");
        log.info(p4.getFirstName());
    }

}
