package gr.hua.dit.erasmus.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import gr.hua.dit.erasmus.dao.UserDAO;
import gr.hua.dit.erasmus.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void save(User user) {
		// enable by default the user
		user.setEnabled((short) 1);
		
		// hash the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDAO.save(user);
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public User getUser(String username) {
		return userDAO.getUser(username);
	}

	@Override
	@Transactional
	public void saveRole(User user, String role) {
		userDAO.saveRole(user, role);
		
	}
}

