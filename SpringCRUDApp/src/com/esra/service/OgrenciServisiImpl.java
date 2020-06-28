package com.esra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esra.dao.OgrenciDAO;
import com.esra.domain.Ogrenci;

@Service
public class OgrenciServisiImpl implements OgrenciServisi {

	@Autowired
	private OgrenciDAO ogrenciDAO;

	@Transactional
	@Override
	public List<Ogrenci> getOgrenciler() {

		return ogrenciDAO.getOgrenciler();
	}
	
	@Transactional
	@Override
	public void saveOgrenci(Ogrenci ogr) {
		ogrenciDAO.saveOgrenci(ogr);
		
	}
	
	@Transactional
	@Override
	public Ogrenci getOgrenci(int ogrId) {
		// TODO Auto-generated method stub
		return ogrenciDAO.getOgrenci(ogrId);
	}
	
	@Transactional
	@Override
	public void deleteOgrenci(int ogrId) {//Bu katmanýn görevi dao'ya aktarmak
		ogrenciDAO.deleteOgrenci(ogrId);
		
	}

}
