package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.database.repositories.UserRepository;

/**
* @author vianney
*
*/
@RestController
@RequestMapping("/api/users")
public class UserRestController {
 public UserRestController(@Autowired UserRepository repository) {
   super();
 }
}
