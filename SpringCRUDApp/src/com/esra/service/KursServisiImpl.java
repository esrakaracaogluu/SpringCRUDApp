package com.esra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esra.dao.KursDAO;
import com.esra.domain.Kurs;
import com.esra.domain.Ogretmen;

@Service
public class KursServisiImpl implements KursServisi {

		@Autowired
		private KursDAO kursDAO;

		@Transactional
		@Override
		public List<Kurs> getKurslar() {

			return kursDAO.getKurslar();
		
	}
       
		@Transactional
		@Override
		public void saveKurs(Kurs kurs) {
             kursDAO.saveKurs(kurs);			
		}
		
		@Transactional
		@Override
		public Kurs getKurs(int krsId) {
			return kursDAO.getKurs(krsId);
		}
		
		@Transactional
		@Override
		public void deleteKurs(int krsId) {
           kursDAO.deleteKurs(krsId);			
		}

		@Transactional
		@Override
		public List<Ogretmen> getOgretmenList() {
			return kursDAO.getOgretmenList();
		}
		
       
}
