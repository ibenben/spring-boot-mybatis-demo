package xyz.ibenben.zhongdian.system.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.ibenben.zhongdian.system.service.UserService;

@Controller
@RequestMapping("/system/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/regiester")
	public String regiester(Map<String, Object> model){
		userService.saveUser(null);
		model.put("msg", "张三丰");		
		return "regiester";
	}
}
