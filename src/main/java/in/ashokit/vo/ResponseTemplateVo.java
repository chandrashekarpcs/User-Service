package in.ashokit.vo;

import org.springframework.beans.factory.annotation.Autowired;

import in.ashokit.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVo {
	
	private User user;
	private Department department;
	 

}
