package gr.hua.dit.erasmus.dao;

import java.util.List;

import gr.hua.dit.erasmus.entity.User;

public interface UserDAO {
	
	public List<User> getUsers();

	public void save(User user);
	
	public void saveRole(User user, String role);

	public User getUser(String username);
}
