package gr.hua.dit.erasmus.service;

import java.util.List;

import gr.hua.dit.erasmus.entity.Secretary;

public interface SecretaryService {
	
	public List<Secretary> getMembers();

	public void saveMember(Secretary member);
	
	public Secretary getMember(int id);

	public void deleteMember(int id);
}


