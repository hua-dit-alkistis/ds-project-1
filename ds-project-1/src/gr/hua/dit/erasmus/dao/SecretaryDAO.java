package gr.hua.dit.erasmus.dao;

import java.util.List;

import gr.hua.dit.erasmus.entity.Secretary;

public interface SecretaryDAO {

	public List<Secretary> getMembers();

	public void saveMember(Secretary member);
	
	public Secretary getMember(int id);

	public void deleteMember(int id);
}
