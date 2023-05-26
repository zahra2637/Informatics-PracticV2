package com.informatics.practice.app.view;
import com.informatics.practice.app.entity.Person;
import com.informatics.practice.app.repository.PersonDto;
import com.informatics.practice.app.service.PersonSearchResult;
import com.informatics.practice.app.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController()
@RequestMapping(value="api", produces = APPLICATION_JSON_VALUE)
public class Controller  {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
    PersonService service;
@Autowired
    public Controller(PersonService service) {
        this.service = service;
    }

    @GetMapping(value = "list", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity userDetails(@RequestBody @Validated PersonDto person) {

//        int userDetails = (int) repository.count();
        return new ResponseEntity<String>("hello", HttpStatus.OK);
    }
    @PostMapping(value = "create", consumes = APPLICATION_JSON_VALUE)
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public Person create(@RequestBody @Validated Person person){
        return service.createOrUpdate(person);
    }

    @DeleteMapping(value = "delete", consumes = APPLICATION_JSON_VALUE)
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public Person delete(@RequestParam(name = "personId") Long id){
        return service.delete(id);
    }
    @GetMapping(value = "get", consumes = APPLICATION_JSON_VALUE)
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public PersonSearchResult findAll(){
        List<Person> objects =
                StreamSupport.stream(service.getAll().spliterator(), false)
                        .collect(Collectors.toList());
        return new PersonSearchResult(objects, 0, objects.size());
    }

}
