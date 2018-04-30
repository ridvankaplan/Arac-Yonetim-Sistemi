package aracyonetimsistem;

import java.io.IOException;

public interface Arac {

    public void setMarka(String marka);

    public String getMarka();

    public void setRenk(String renk);

    public String getRenk();

    public void setHiz(int hiz);

    public int getHiz();

    public void setYolcu(int yolcu_sayisi);

    public int getYolcu();

    public void setUretim(int uretim_yili);

    public int getUretim();

    public void setFiyat(double fiyat);

    public double getFiyat();
//Aracin Hizlanma,Yavaslama ve Durma Islemini Asagidaki Methodlarda Yapiyoruz

    public int Hizlan(int hiz_fark);

    public int Yavasla(int hiz_fark);

    public void Dur();

    public void DosyaKaydet(String kayit) throws IOException, IOException;

    public void Guncelle(String id, String eski, String yeni) throws IOException;

}
