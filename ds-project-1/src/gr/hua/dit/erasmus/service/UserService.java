package gr.hua.dit.erasmus.service;

import java.util.List;

import gr.hua.dit.erasmus.entity.User;

public interface UserService {
	
	public List<User> getUsers();

	public void save(User user);
	
	public void saveRole(User user, String role);

	public User getUser(String username);
	
}
