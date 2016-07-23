package xyz.ibenben.zhongdian.system.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.ibenben.zhongdian.system.dao.TaskDao;
import xyz.ibenben.zhongdian.system.dao.UserDao;
import xyz.ibenben.zhongdian.system.entity.Task;
import xyz.ibenben.zhongdian.system.entity.User;
import xyz.ibenben.zhongdian.system.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private TaskDao taskDao;
	
	@Transactional
	public void saveUser(User user){
		user = userDao.selectByPrimaryKey(1);
		user.setUsername("5566");
		userDao.updateByPrimaryKey(user);
//		int i = 10/0;
		Task task = new Task();
		task.setName("task 100");
		task.setDescript("task100 descriot");
		task.setState(1);
		taskDao.insert(task);
		
		Task temp = new Task();
		task.setState(1);
		List<Task> list = taskDao.selectByRowBounds(temp, new RowBounds(2, 12));
		System.out.println(list.size());
		for(Task t : list){
			System.out.println(t.getName());
		}
		
		List<User> users = userDao.selectByState(1);
		for(User u : users){
			System.out.println(u.getUsername());
		}
	}
}
