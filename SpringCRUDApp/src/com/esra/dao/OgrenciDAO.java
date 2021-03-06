package com.esra.dao;

import java.util.List;
import com.esra.domain.Ogrenci;

public interface OgrenciDAO {
	//Öğrencileri bize getirecek,adını koyduğumuz,hangi metodların olacagını belirlediğimiz katman
	public List<Ogrenci> getOgrenciler();// Ogrenci DAO'su uygulamanın veritabanına giden tarafını bu katmana yaptırıcaz

	public void saveOgrenci(Ogrenci ogr);

	public Ogrenci getOgrenci(int ogrId);

	public void deleteOgrenci(int ogrId);
    
}
