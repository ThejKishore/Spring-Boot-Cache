package com.kish.app.dao;

import com.kish.app.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ThejKishore on 4/30/2017.
 */
@Repository

public interface PersonDao extends JpaRepository<Person,Long> {
     Person findByMailId(String mailId);
}
