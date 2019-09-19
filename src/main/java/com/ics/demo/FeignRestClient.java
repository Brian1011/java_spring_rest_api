package com.ics.demo;

import com.ics.demo.models.University;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//url is this is the base url
@FeignClient(name="client", url="http://10.51.10.111:9090/")
public interface FeignRestClient {
    // all universities
    @RequestMapping(method = RequestMethod.GET, value = "universities")
    List<University> getAllUniverisities();

    // single university
    @RequestMapping(method = RequestMethod.GET, value = "universities/{id}")
    University findById(@PathVariable(name = "id") long id);

    // post 1 uni
    @RequestMapping(method = RequestMethod.POST, value = "universities")
    University createUniversity(@RequestBody University university);

    // patch
    @RequestMapping(method = RequestMethod.PATCH, value = "universities/{id}")
    University update(@PathVariable(name = "id") long id, @RequestBody University university);

    // search by university name
    @RequestMapping(method = RequestMethod.GET, value = "universities/search")
    List<University> searchByName(@RequestParam String name);
}
