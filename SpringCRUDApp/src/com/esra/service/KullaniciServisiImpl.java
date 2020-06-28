package com.esra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.esra.dao.KullaniciDAO;

@Service
public class KullaniciServisiImpl implements KullaniciServisi{
	

    @Autowired
	private KullaniciDAO kullaniciDAO;
	
    @Transactional
	@Override
	public boolean findUser(String username,String password){
		
		return kullaniciDAO.findUser(username,password);
	}
}
