package com.ics.demo;

import com.ics.demo.models.Course;
import com.ics.demo.models.Room;
import com.ics.demo.models.Student;
import com.ics.demo.models.University;
import com.ics.demo.repositories.CourseRepository;
import com.ics.demo.repositories.RoomRepository;
import com.ics.demo.repositories.StudentRepository;
import com.ics.demo.repositories.UniversityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

@Component
@EnableFeignClients
public class DummyData implements CommandLineRunner
{
    private final UniversityRepository universityRepository;
    private final StudentRepository studentRepository;
    private final RoomRepository roomRepository;
    private final CourseRepository courseRepository;

    public DummyData(UniversityRepository universityRepository, StudentRepository studentRepository, RoomRepository roomRepository, CourseRepository courseRepository) {
        this.universityRepository = universityRepository;
        this.studentRepository = studentRepository;
        this.roomRepository = roomRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //university
        University strath = new University("Strathmore", "OLe Sangale");
        universityRepository.save(strath);

        University jkuat = new University("JKUAT", "Juja");
        universityRepository.save(jkuat);

        //students
        Student student1 = new Student("John","Doe","Martin","2000",jkuat);
        studentRepository.save(student1);

        Student student2 = new Student("Jane","Doe","Rose","1999", strath);
        studentRepository.save(student2);

        //Rooms
        Room room26 = new Room("Room 26","Phase1");
        roomRepository.save(room26);

        Room room10 = new Room("Room 10","Phase1");
        roomRepository.save(room10);

        //saved course
        //returned the saved course
        Course course = courseRepository.save(new Course("Distributed Objects"));
        course.addStudent(student1);
        courseRepository.save(course);

        Course course1 = new Course("Web Security");
        Course savedCourse1 = courseRepository.save(course1);
        savedCourse1.addStudent(student2);
        courseRepository.save(savedCourse1);


    }

}
