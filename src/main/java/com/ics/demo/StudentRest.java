package com.ics.demo;

import com.ics.demo.models.MockAppointments;
import com.ics.demo.models.MockLecturers;
import com.ics.demo.models.MockStudent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

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

        // find by student number - 8
        MockStudent mockStudent = studentFeignRestCLient.getStudentByStudentNUmber("94006");
        System.out.println("student is"+mockStudent);

        // get all lecturers
        List<MockLecturers> mockLecturers = studentFeignRestCLient.getAllLecturers();
        System.out.println("Lecturers " + mockLecturers);

        // create a new appointment
        MockAppointments appointments = studentFeignRestCLient.createAppointment(new MockAppointments(mockStudent.getid(),Integer.toUnsignedLong(1)));
        System.out.println("Appoint "+ appointments);

        // confirm appointment
        //appointments.setStudentId(brian.getid());
        MockAppointments confirm = studentFeignRestCLient.confirmAppointment(appointments.getId(),brian.getid());
        System.out.println("Confirmed"+confirm);
    }
}
