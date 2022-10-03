package com.spring.boot.jpa.temp.SpringBootJpaTemp.Repository;

import com.spring.boot.jpa.temp.SpringBootJpaTemp.Entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LearnerSpringDataRepository extends JpaRepository<Learner, Integer> {
    @Modifying
    @Query("SELECT l FROM Learner l Where l.Email = :Email AND l.LastName = :LastName" )
    List<Learner> findByEmailAddressAndLastname(@Param("Email") String Email, @Param("LastName") String LastName );

    @Modifying
    @Query("SELECT DISTINCT l FROM Learner l Where l.FirstName = :FirstName OR l.LastName = :LastName")
    List<Learner> findDistinctLeanerByLastnameOrFirstname(@Param("FirstName") String FirstName, @Param("LastName") String learner_last_name );

    @Modifying
    @Query("SELECT l FROM Learner l Where UPPER(l.LastName) = UPPER(:LastName)")
    List<Learner> findByLastnameIgnoreCase( @Param("LastName") String LastName );

    @Modifying
    @Query("SELECT l FROM Learner l Where l.LastName = :LastName ORDER BY l.FirstName ASC")
    List<Learner> findByLastnameOrderByFirstnameAsc(@Param("LastName") String LastName );

}
