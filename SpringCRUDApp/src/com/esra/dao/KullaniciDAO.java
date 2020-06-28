package com.esra.dao;

import java.util.List;

import com.esra.domain.Employees;
import com.esra.domain.Kullanici;

public interface KullaniciDAO {

	boolean findUser(String username, String password);

	

}
