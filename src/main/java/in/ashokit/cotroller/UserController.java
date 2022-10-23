package in.ashokit.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.User;
import in.ashokit.service.UserService;
import in.ashokit.vo.ResponseTemplateVo;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/")
	public User saveUser(User user) {
		log.info("Inside saveUser method of UserController" );
		return userService.saveUser(user);
		
	}
	@GetMapping("/{id}")
	public ResponseTemplateVo getUserWithDepartment(@PathVariable("id")Long userId) {
		log.info("Inside getUserWithDepartment method of UserController" );
		return userService.getUserWithDepartment(userId);
		
	}

}
