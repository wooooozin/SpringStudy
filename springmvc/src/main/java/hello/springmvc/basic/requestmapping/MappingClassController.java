package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingClassController {

  @GetMapping("/mapping/users")
  public String user() {
    return "get Users";
  }

  @PostMapping("/mapping/users")
  public String addUser() {
    return "post user";
  }

  @GetMapping("/mapping/users/{userId}")
  public String findUser(
      @PathVariable("userId") String userId
  ) {
    return "find user" + userId;
  }

  @PatchMapping("/mapping/users/{userId}")
  public String updateUser(
      @PathVariable("userId") String userId
  ) {
    return "update user" + userId;
  }

  @DeleteMapping("/mapping/users/{userId}")
  public String deleteUser(
      @PathVariable("userId") String userId
  ) {
    return "delete user" + userId;
  }
}
