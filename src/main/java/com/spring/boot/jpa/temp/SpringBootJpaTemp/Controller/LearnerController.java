package com.spring.boot.jpa.temp.SpringBootJpaTemp.Controller;

import com.spring.boot.jpa.temp.SpringBootJpaTemp.Entity.Course;
import com.spring.boot.jpa.temp.SpringBootJpaTemp.Entity.Learner;
import com.spring.boot.jpa.temp.SpringBootJpaTemp.Repository.LearnerSpringDataRepository;
import com.spring.boot.jpa.temp.SpringBootJpaTemp.Service.CourseService;
import com.spring.boot.jpa.temp.SpringBootJpaTemp.Service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class LearnerController {

    @Autowired
    LearnerService service;

    @Autowired
    CourseService c_service;

    @PostMapping("/learner")
    public Learner addLearner(@RequestBody Learner learner) {
        return service.addLearner(learner);
    }

    @GetMapping("/learner/{id}")
    public Learner getLearner(@PathVariable int id) {
        return service.findLearnerById(id);
    }

    @GetMapping("/learner")
    public List<Learner> getLearnerData() {
        return service.getAllLearner();
    }

    @GetMapping("/learnerentity")
    public long numberOfRows() {
        return service.getEntity();
    }

    @DeleteMapping("/deletelearner/{id}")
    public void deleteLearner(@PathVariable int id) {
        service.deleteEntityById(id);
    }

    @GetMapping("/learner/exist/{id}")
    public boolean CheckEntity(@PathVariable int id) {
        return service.EntityExistById(id);
    }

    // 7.Put Mapping for grabbing course object into Learner
    @PutMapping("/{learner_id}/course/{course_id}")
    public Learner assignDetails(@PathVariable int learner_id, @PathVariable int course_id){

        Course course = c_service.findCourseById(course_id);

        //System.out.println(course);
        return service.assignCourse(learner_id,course);
    }

    //================  @Query  =================================================

    @PostMapping(value = "/findByEmailAndLastName")
    public List<Learner> findByEmailAndLastName(@RequestBody Map<String,String> response){
        //response.get("email").toString(),response.get("last_name").toString()
        return service.findByEmailAddressAndLastname(response.get("Email").toString(),response.get("LastName").toString());
    }

    @PostMapping(value = "/findDistinctLeanerByLastnameOrFirstname")
    public List<Learner> findDistinctLeanerByLastnameOrFirstname(@RequestBody Map<String,String> response){
        //response.get("email").toString(),response.get("last_name").toString()
        return service.findDistinctLeanerByLastnameOrFirstname(response.get("FirstName").toString(),response.get("LastName").toString());
    }

    @PostMapping(value = "/findByLastnameIgnoreCase")
    public List<Learner> findByLastnameIgnoreCase(@RequestBody Map<String,String> response){
        //response.get("email").toString(),response.get("last_name").toString()
        return service.findByLastnameIgnoreCase(response.get("LastName").toString());
    }
    @PostMapping(value = "/findByLastnameOrderByFirstnameAsc")
    public List<Learner> findByLastnameOrderByFirstnameAsc(@RequestBody Map<String,String> response){
        //response.get("email").toString(),response.get("last_name").toString()
        return service.findByLastnameOrderByFirstnameAsc(response.get("LastName").toString());
    }



}
