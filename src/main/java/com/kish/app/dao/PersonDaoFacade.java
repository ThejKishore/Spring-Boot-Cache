package com.kish.app.dao;

import com.kish.app.pojo.Person;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ThejKishore on 4/30/2017.
 */
@Component
@Slf4j
public class PersonDaoFacade {

    @Autowired
    private PersonDao personDao;

    @Cacheable(value = "person")
    public List<Person> getAllPersonRecords(){
        log.info("inside the getAllPersonRecords in PersonDaoFacade");
        return personDao.findAll();
    }


    @Cacheable(value = "person" , key ="#personId")
    public Person getPersonById(Long personId){
        log.info("inside the getPersonById  in PersonDaoFacade");
        return personDao.findOne(personId);
    }

    @Caching ( evict = {
            @CacheEvict(value = "person",key="#person.personId"),
            @CacheEvict(value = "person",key="#person.mailId")

    }, put= {
            @CachePut(value = "person",key="#person.personId"),
            @CachePut(value = "person",key="#person.mailId"),
    }
    )
    public void savePerson(Person person){
        log.info("inside the savePerson in PersonDaoFacade");
        personDao.saveAndFlush(person);
        log.info("successfully saved the person");
    }


    @Cacheable(value = "person" , key = "#mailId")
    public Person getPersonByMailId(String mailId){
        log.info("inside the getPersonByMailId in PersonDaoFacade");
        return personDao.findByMailId(mailId);
    }
}
