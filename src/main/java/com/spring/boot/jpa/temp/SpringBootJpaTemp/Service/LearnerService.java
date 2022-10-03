package com.spring.boot.jpa.temp.SpringBootJpaTemp.Service;

import com.spring.boot.jpa.temp.SpringBootJpaTemp.Entity.Course;
import com.spring.boot.jpa.temp.SpringBootJpaTemp.Entity.Learner;
import com.spring.boot.jpa.temp.SpringBootJpaTemp.Repository.LearnerSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LearnerService {

    @Autowired
    LearnerSpringDataRepository repo;

    // Add Learner
    public Learner addLearner(Learner learner) {
        return repo.save(learner);
    }


    // Find Learner By Id.
    public Learner findLearnerById(int id) {
        Optional<Learner> tempLearner =  repo.findById(id);

        Learner l = null;
        if(tempLearner.isPresent())
            l = tempLearner.get();
        else{
            throw new RuntimeException("Learner with id " + id + " not found");
        }
        return l;
    }

    // get all learner
    public List<Learner> getAllLearner() {
        return repo.findAll();
    }

    // number of entity or rows in table
    public long getEntity() {
        return repo.count();
    }

    //delete entity by id
    public void deleteEntityById(int id) {
        //repo.deleteById(id);

        Optional<Learner> tempLearner = repo.findById(id);
        if(tempLearner.isEmpty())
            throw new RuntimeException("Learner with id " + id + " not found");

        repo.delete(tempLearner.get());
    }

    // 6.
    public boolean EntityExistById(int id) {
        return repo.existsById(id);
    }


    // 7.(Grabbing Course object into Learner)
    public Learner assignCourse(int learner_id, Course course){
        Learner learner = repo.findById(learner_id).get();

        learner.setCourse(course);

        return repo.save(learner);
    }

    @Transactional
    public List<Learner> findByEmailAddressAndLastname(String email, String lastname){
        return repo.findByEmailAddressAndLastname(email,lastname);
    }

    @Transactional
    public List<Learner> findDistinctLeanerByLastnameOrFirstname(String firstname, String lastname){
        return repo.findDistinctLeanerByLastnameOrFirstname(firstname,lastname);
    }

    @Transactional
    public List<Learner> findByLastnameIgnoreCase(String lastname){
        return repo.findByLastnameIgnoreCase(lastname);
    }

    @Transactional
    public List<Learner> findByLastnameOrderByFirstnameAsc(String lastname){
        return repo.findByLastnameOrderByFirstnameAsc(lastname);
    }
}
