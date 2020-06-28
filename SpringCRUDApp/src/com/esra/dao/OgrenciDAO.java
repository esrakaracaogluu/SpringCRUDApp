package com.esra.dao;

import java.util.List;
import com.esra.domain.Ogrenci;

public interface OgrenciDAO {
	//��rencileri bize getirecek,ad�n� koydu�umuz,hangi metodlar�n olacag�n� belirledi�imiz katman
	public List<Ogrenci> getOgrenciler();// Ogrenci DAO'su uygulaman�n veritaban�na giden taraf�n� bu katmana yapt�r�caz

	public void saveOgrenci(Ogrenci ogr);

	public Ogrenci getOgrenci(int ogrId);

	public void deleteOgrenci(int ogrId);
    
}
