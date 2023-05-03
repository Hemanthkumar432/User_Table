package Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.User;
import Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController
{
  private final UserRepository userRepository;
  @Autowired
  public UserController(UserRepository userRepository)
  {
    this.userRepository = userRepository;
  }

  @GetMapping("/users")
  public List<User> getAllUsers() {

    System.out.println("request came for getting all user data");

    List<User> users = new ArrayList<User>();

    users = userRepository.findAll();

    System.out.println("response sent!!!");

    return users;
  }
}
