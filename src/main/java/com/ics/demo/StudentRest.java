package com.ics.demo;

import com.ics.demo.models.MockStudent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentRest implements CommandLineRunner {
    private final StudentFeignRestCLient studentFeignRestCLient;

    public StudentRest(StudentFeignRestCLient studentFeignRestCLient) {
        this.studentFeignRestCLient = studentFeignRestCLient;
    }

    @Override
    public void run(String... args) throws Exception {
        // post 1 student
        MockStudent brian = studentFeignRestCLient.createStudent(new MockStudent("94006", "Brian"));
        System.out.println("New student is: "+brian);

    }
}
