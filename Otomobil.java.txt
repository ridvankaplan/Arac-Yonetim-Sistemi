package aracyonetimsistem;

import java.io.IOException;

public class Otomobil extends KaraTasit {

    private String yakit_turu;
    private static int nesne_sayisi = 0;
    public String id_no;

    public Otomobil() throws IOException {
        KaraTasit kara = new KaraTasit();
        id_no = idBul();
        kara.DosyaKaydet("Otomobil_" + id_no);
    }

    public Otomobil(String marka, int hiz, int yolcu_sayisi, int tekerlek, int fiyat, int uretim_yili, String renk, String yakit) {
        setMarka(marka);
        setHiz(hiz);
        setYolcu(yolcu_sayisi);
        setRenk(renk);
        setUretim(uretim_yili);
        setFiyat(fiyat);
        setTekerlek(tekerlek);
        this.yakit_turu = yakit;

    }

    public String idBul() {
        nesne_sayisi++;
        id_no = nesne_sayisi + "";
        return id_no;
    }

    public void setYakit(String yakit_turu) {
        this.yakit_turu = yakit_turu;
    }

    public String getYakit() {
        return yakit_turu;
    }

    public void DosyaKaydet() throws IOException, IOException {

        DosyaKaydet(getMarka());
        DosyaKaydet(getRenk());
        DosyaKaydet(getHiz() + "");
        DosyaKaydet(getYolcu() + "");
        DosyaKaydet(getUretim() + "");
        DosyaKaydet(getFiyat() + "");
        DosyaKaydet(getYakit());
        DosyaKaydet(getTekerlek() + "");
        DosyaKaydet("\n");
    }

}
