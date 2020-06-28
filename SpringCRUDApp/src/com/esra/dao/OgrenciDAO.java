package com.esra.dao;

import java.util.List;
import com.esra.domain.Ogrenci;

public interface OgrenciDAO {
	//Öðrencileri bize getirecek,adýný koyduðumuz,hangi metodlarýn olacagýný belirlediðimiz katman
	public List<Ogrenci> getOgrenciler();// Ogrenci DAO'su uygulamanýn veritabanýna giden tarafýný bu katmana yaptýrýcaz

	public void saveOgrenci(Ogrenci ogr);

	public Ogrenci getOgrenci(int ogrId);

	public void deleteOgrenci(int ogrId);
    
}
