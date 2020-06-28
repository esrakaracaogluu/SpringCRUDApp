package com.esra.dao;

import java.util.List;
import com.esra.domain.Kurs;
import com.esra.domain.Ogretmen;

public interface KursDAO {
	public List<Kurs> getKurslar();

	public void saveKurs(Kurs kurs);

	public Kurs getKurs(int krsId);

	public void deleteKurs(int krsId);

	public List<Ogretmen> getOgretmenList();

}
