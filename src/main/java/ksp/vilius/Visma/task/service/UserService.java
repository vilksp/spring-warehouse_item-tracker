package ksp.vilius.Visma.task.service;

import ksp.vilius.Visma.task.model.User;
import ksp.vilius.Visma.task.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private void SignUp(User user) {

        userRepository.save(user);

    }
}
