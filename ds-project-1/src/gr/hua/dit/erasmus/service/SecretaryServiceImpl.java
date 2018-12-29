package gr.hua.dit.erasmus.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.erasmus.dao.SecretaryDAO;
import gr.hua.dit.erasmus.entity.Secretary;

@Service
public class SecretaryServiceImpl implements SecretaryService {
	
	@Autowired
	private SecretaryDAO secretaryDAO;

	@Override
	@Transactional
	public List<Secretary> getMembers() {
		return secretaryDAO.getMembers();
	}

	@Override
	@Transactional
	public void saveMember(Secretary member) {
		secretaryDAO.saveMember(member);
	}

	@Override
	@Transactional
	public Secretary getMember(int id) {
		return secretaryDAO.getMember(id);
	}

	@Override
	@Transactional
	public void deleteMember(int id) {
		secretaryDAO.deleteMember(id);
	}

}
