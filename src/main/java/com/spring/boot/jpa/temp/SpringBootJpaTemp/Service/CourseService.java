package com.spring.boot.jpa.temp.SpringBootJpaTemp.Service;

import com.spring.boot.jpa.temp.SpringBootJpaTemp.Entity.Course;
import com.spring.boot.jpa.temp.SpringBootJpaTemp.Entity.Learner;
import com.spring.boot.jpa.temp.SpringBootJpaTemp.Repository.CourseSpringDataRepository;
import com.spring.boot.jpa.temp.SpringBootJpaTemp.Repository.LearnerSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseSpringDataRepository repo;

    // Add Learner
    public Course addCourse(Course course) {
        return repo.save(course);
    }


    // Find Learner By Id.
    public Course findCourseById(int id) {
        Optional<Course> tempCourse =  repo.findById(id);

        Course c = null;
        if(tempCourse.isPresent())
            c = tempCourse.get();
        else{
            throw new RuntimeException("Learner with id " + id + " not found");
        }
        return c;
    }

    // get all learner
    public List<Course> getAllCourse() {
        return repo.findAll();
    }

    // number of entity or rows in table
    public long getEntity() {
        return repo.count();
    }

    //delete entity by id
    public void deleteEntityById(int id) {
        //repo.deleteById(id);

        Optional<Course> tempCourse = repo.findById(id);
        if(tempCourse.isEmpty())
            throw new RuntimeException("Learner with id " + id + " not found");

        repo.delete(tempCourse.get());
    }

    public boolean EntityExistById(int id) {
        return repo.existsById(id);
    }
}
