package com.lovemesomecoding.es.user;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Users", description = "User Operations")
@Slf4j
@RequestMapping("/users")
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Get Users By First Name", description = "Get Users By First Name")
    @GetMapping("/firstname")
    public ResponseEntity<List<User>> getUsersByFirstName(@RequestParam String firstName) {
        log.info("getUsersByFirstName firstName={}", firstName);
        return new ResponseEntity<>(userService.getUsersByFirstName(firstName), OK);
    }

    @Operation(summary = "Get Users By Last Name", description = "Get Users By Last Name")
    @GetMapping("/lastName")
    public ResponseEntity<List<User>> getUsersByLastName(@RequestParam String lastName) {
        log.info("getUsersByLastName lastName={}", lastName);
        return new ResponseEntity<>(userService.getUsersByLastName(lastName), OK);
    }
}
