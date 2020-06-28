package com.esra.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.esra.domain.Employees;

@Repository
public class KullaniciDAOImpl implements KullaniciDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean findUser(String username, String password) {
        Session session=sessionFactory.openSession();
        boolean userFound = false;
		String SQL_QUERY=" from Kullanici as k where k.username=?0 and k.password=?1";
		Query query=session.createQuery(SQL_QUERY);
		query.setParameter(0,username);
		query.setParameter(1, password);
		List list = query.list();
		if((list != null) && (list.size()>0)) {
			userFound=true;
		}
		session.close();
        return userFound;
	}


	
	/*@Override
	public List<Kullanici> getKullanicilar() {
		Session session = sessionFactory.getCurrentSession();
		Query<Kullanici> query = session.createQuery("from KULLANICI", Kullanici.class);
		List<Kullanici> resultList = query.getResultList();

		return resultList;
	}
	
    @Transactional
	@Override
	public String getKullanici(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		Kullanici kullanicii = (Kullanici) session.createQuery("FROM KULLANICI U WHERE U.username = :username").setParameter("username", username)
                .uniqueResult();

            if (kullanicii != null && kullanicii.getPassword().equals(password)) {
                return "secim";
            }
		return "redirect:/ogrenc/list";
	}*/

}
