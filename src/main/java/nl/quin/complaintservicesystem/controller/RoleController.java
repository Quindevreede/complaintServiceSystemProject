package nl.quin.complaintservicesystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping(value = "/roles")
    public class RoleController {

        @GetMapping(value = "")
        public ResponseEntity<Object> getMessage() {
            return new ResponseEntity<>("SECURED REST endpoint: /roles", HttpStatus.OK);
        }

}