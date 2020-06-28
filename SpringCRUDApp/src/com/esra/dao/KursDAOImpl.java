package com.esra.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.esra.domain.Department;
import com.esra.domain.Kurs;
import com.esra.domain.Ogrenci;
import com.esra.domain.Ogretmen;

@Repository
public class KursDAOImpl implements KursDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Kurs> getKurslar() {
		Session session = sessionFactory.getCurrentSession();

		Query<Kurs> query = session.createQuery("from Kurs", Kurs.class);
		List<Kurs> resultList = query.getResultList();

		return resultList;
	}

	@Override
	public void saveKurs(Kurs kurs) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(kurs);
	}

	@Override
	public Kurs getKurs(int krsId) {
		Session session = sessionFactory.getCurrentSession();

		Kurs krs = session.get(Kurs.class, krsId);

		return krs;
	}

	@Override
	public void deleteKurs(int krsId) {
		Session session = sessionFactory.getCurrentSession();
		Kurs krs = session.get(Kurs.class, krsId);

		session.delete(krs);

	}

	@Override
	public List<Ogretmen> getOgretmenList() {
		Session session = sessionFactory.getCurrentSession();
		Query<Ogretmen> query = session.createQuery("from Ogretmen", Ogretmen.class);
		List<Ogretmen> resultList = query.getResultList();

		return resultList;
	}
}
