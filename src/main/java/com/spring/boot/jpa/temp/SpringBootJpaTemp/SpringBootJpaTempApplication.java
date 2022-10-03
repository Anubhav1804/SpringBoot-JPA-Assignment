package com.spring.boot.jpa.temp.SpringBootJpaTemp;

import com.spring.boot.jpa.temp.SpringBootJpaTemp.Entity.Course;
import com.spring.boot.jpa.temp.SpringBootJpaTemp.Entity.Learner;
import com.spring.boot.jpa.temp.SpringBootJpaTemp.Repository.CourseSpringDataRepository;
import com.spring.boot.jpa.temp.SpringBootJpaTemp.Repository.LearnerSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaTempApplication implements CommandLineRunner {

	@Autowired
	LearnerSpringDataRepository repo;

	@Autowired
	CourseSpringDataRepository c_repo;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void run(String... args) throws Exception {
		logger.info("Inserting Learner \n", repo.save(new Learner("Anubhav","Srivastava","anubhav@gmail.com","password1")));
		//System.out.println(repo.save(new Learner("Anubhav","Srivastava","anubhav@gmail.com","password1",4455)));
		logger.info("Inserting Learner \n", repo.save(new Learner("Gourav","Kumar","gourav@gmail.com","password4")));
		logger.info("Inserting Learner \n", repo.save(new Learner("Aditya","Choudhary","aditya@gmail.com","password3")));
		logger.info("Inserting Learner \n", repo.save(new Learner("Harsh","Pareek","harsh@gmail.com","password5")));
		logger.info("Inserting Learner \n", repo.save(new Learner("Adesh","Srivastava","adesh@gmail.com","password2")));

		//logger.info("Finding Learner by Id \n", repo.findById(2));    // logger will not show output in console.
		System.out.println("Finding Learner by Id \n" +  repo.findById(2));

		//logger.info("Find All Learner ", repo.findAll());   // logger will not show output in console.
		System.out.println("Find All Learner " + repo.findAll());


		logger.info("Inserting Course \n", c_repo.save(new Course(6600,"ME", "Mechanical Engineering")));
		logger.info("Inserting Course \n", c_repo.save(new Course(4455,"CSE","Computer Science Engineering")));
		logger.info("Inserting Course \n", c_repo.save(new Course(1835, "ECE","Electronic & Communication Engineering")));
		logger.info("Inserting Course \n", c_repo.save(new Course(2172, "EEE","Electronic & Electrical Engineering")));
	}

	public static void main(String[] args) {

		SpringApplication.run(SpringBootJpaTempApplication.class, args);
	}
}
