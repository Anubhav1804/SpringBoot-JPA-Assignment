package com.spring.boot.jpa.temp.SpringBootJpaTemp.Controller;
import com.spring.boot.jpa.temp.SpringBootJpaTemp.Entity.Course;
import com.spring.boot.jpa.temp.SpringBootJpaTemp.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService service;

    @PostMapping("/course")
    public Course addCourse(@RequestBody Course course) {
        return service.addCourse(course);
    }

    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable int id) {
        return service.findCourseById(id);
    }

    @GetMapping("/course")
    public List<Course> getCourseData() {
        return service.getAllCourse();
    }

    @GetMapping("/courseentity")
    public long numberOfRows() {
        return service.getEntity();
    }

    @DeleteMapping("/deletecourse/{id}")
    public void deleteCourse(@PathVariable int id) {
        service.deleteEntityById(id);
    }

    @GetMapping("/course/exist/{id}")
    public boolean CheckEntity(@PathVariable int id) {
        return service.EntityExistById(id);
    }
}
