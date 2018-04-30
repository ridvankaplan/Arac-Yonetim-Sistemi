package aracyonetimsistem;

import java.io.IOException;

public interface HavaTasit extends Arac {

    @Override
    public void setMarka(String marka);

    @Override
    public String getMarka();

    @Override
    public void setRenk(String renk);

    @Override
    public String getRenk();

    @Override
    public void setHiz(int hiz);

    @Override
    public int getHiz();

    @Override
    public void setYolcu(int yolcu_sayisi);

    @Override
    public int getYolcu();

    @Override
    public void setUretim(int uretim_yili);

    @Override
    public int getUretim();

    @Override
    public void setFiyat(double fiyat);

    @Override
    public double getFiyat();
//Aracin Hizlanma,Yavaslama ve Durma Islemini Asagidaki Methodlarda Yapiyoruz

    @Override
    public int Hizlan(int hiz_fark);

    @Override
    public int Yavasla(int hiz_fark);

    @Override
    public void Dur();

    @Override
    public void DosyaKaydet(String kayit) throws IOException, IOException;

    @Override
    public void Guncelle(String id, String eski, String yeni) throws IOException;

    public boolean inis();
}
