package com.esra.dao;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.esra.domain.Ogrenci;

@Repository
public class OgrenciDAOImpl implements OgrenciDAO {// ogrencidaoýmpl sýnýfý ogrencidao'yu implemente edecek
    
	
	@Autowired //Sessionfactory cinsinden bir bean varsa(adý her neyse) bunu bana buraya injecte et(ver)
	SessionFactory sessionFactory;
		
	//@Transactional
	@Override
	public List<Ogrenci> getOgrenciler() {
		Session session=sessionFactory.getCurrentSession();
		
		//session.beginTransaction();
		Query<Ogrenci> query=session.createQuery("from Ogrenci",Ogrenci.class);//Okumayý yaptý,sorguyu attý
		List<Ogrenci> resultList=query.getResultList();//Gelen sonucu resultListe alýyorum
		//session.getTransaction().commit();
		return resultList;//Listi döndürdü
	}

	@Override
	public void saveOgrenci(Ogrenci ogr) {
		Session session=sessionFactory.getCurrentSession();
      
		//session.save(ogr);
		
		session.saveOrUpdate(ogr);
		

	}

	@Override
	public Ogrenci getOgrenci(int ogrId) {
		
		Session session=sessionFactory.getCurrentSession();
		
		Ogrenci ogr=session.get(Ogrenci.class, ogrId);
		
		return ogr;
	}

	@Override
	public void deleteOgrenci(int ogrId) {
		
		Session session=sessionFactory.getCurrentSession();
		
		Ogrenci ogr=session.get(Ogrenci.class, ogrId);

		session.delete(ogr);
		
	}
	
}
