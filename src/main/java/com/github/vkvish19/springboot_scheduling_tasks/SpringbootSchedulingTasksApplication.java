package com.github.vkvish19.springboot_scheduling_tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootSchedulingTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSchedulingTasksApplication.class, args);
	}

}
