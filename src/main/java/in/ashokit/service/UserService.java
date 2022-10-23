package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ashokit.entity.User;
import in.ashokit.repository.UserRepository;
import in.ashokit.vo.Department;
import in.ashokit.vo.ResponseTemplateVo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
    
	@Autowired
	private RestTemplate restTemplate;
	
	public User saveUser(User user) {
       log.info( "Inside saveUser method of UserService");
       return userRepository.save(user);
	}

	public ResponseTemplateVo getUserWithDepartment(Long userId) {
	       log.info( "Inside getUserWithDepartment method of UserService");
		ResponseTemplateVo vo=new ResponseTemplateVo();
    User user = userRepository.findByUserId(userId);

	Department department=
	     restTemplate.getForObject(  "http://DEPARTMENT/departments/" + user.getDepartmentId() 
			,Department.class  );
  vo.setUser(user);
  vo.setDepartment(department);
	return vo;
	}

}
