package com.ics.demo;

import com.ics.demo.models.MockLecturers;
import com.ics.demo.models.MockStudent;
import com.ics.demo.models.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "mockClient", url = "http://10.51.11.230:1000/")
public interface StudentFeignRestCLient {
    // post
    @RequestMapping(method = RequestMethod.POST, value = "students")
    MockStudent createStudent(@RequestBody MockStudent mockStudent);

    // get student
    @RequestMapping(method = RequestMethod.GET, value = "students")
    MockStudent getStudentByStudentNUmber(@RequestParam String studentNumber);

    // get lecturers
    @RequestMapping(method = RequestMethod.GET, value = "lecturers")
    List<MockLecturers> getAllLecturers();
}
