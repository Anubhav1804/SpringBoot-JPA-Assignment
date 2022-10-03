package com.spring.boot.jpa.temp.SpringBootJpaTemp.Repository;

import com.spring.boot.jpa.temp.SpringBootJpaTemp.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSpringDataRepository extends JpaRepository<Course, Integer> {
}
