package ksp.vilius.Visma.task.controller;

import ksp.vilius.Visma.task.model.User;
import ksp.vilius.Visma.task.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;


    @PostMapping("/signup")
    private void CreateUser(@RequestBody User user) {

        userService.signUp(user);
        log.info("new user has been created");
    }
}
