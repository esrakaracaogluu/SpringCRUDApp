package com.esra.dao;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.esra.domain.Ogrenci;

@Repository
public class OgrenciDAOImpl implements OgrenciDAO {// ogrencidao�mpl s�n�f� ogrencidao'yu implemente edecek
    
	
	@Autowired //Sessionfactory cinsinden bir bean varsa(ad� her neyse) bunu bana buraya injecte et(ver)
	SessionFactory sessionFactory;
		
	//@Transactional
	@Override
	public List<Ogrenci> getOgrenciler() {
		Session session=sessionFactory.getCurrentSession();
		
		//session.beginTransaction();
		Query<Ogrenci> query=session.createQuery("from Ogrenci",Ogrenci.class);//Okumay� yapt�,sorguyu att�
		List<Ogrenci> resultList=query.getResultList();//Gelen sonucu resultListe al�yorum
		//session.getTransaction().commit();
		return resultList;//Listi d�nd�rd�
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
