package aracyonetimsistem;

import java.io.IOException;

public class Bisiklet extends KaraTasit {

    private static int nesne_sayisi = 0;
    private String id_no;

    public Bisiklet() throws IOException {
        KaraTasit kara = new KaraTasit();
        id_no = idBul();
        kara.DosyaKaydet("Bisiklet_" + id_no);
    }

    public Bisiklet(String marka, int hiz, int yolcu_sayisi, int tekerlek, int fiyat, int uretim_yili, String renk) {
        setMarka(marka);
        setHiz(hiz);
        setYolcu(yolcu_sayisi);
        setRenk(renk);
        setUretim(uretim_yili);
        setFiyat(fiyat);
    }

    public String idBul() {
        nesne_sayisi++;
        id_no = nesne_sayisi + "";
        return id_no;
    }

    public void DosyaKaydet() throws IOException, IOException {

        DosyaKaydet(getMarka() + "");
        DosyaKaydet(getRenk() + "");
        DosyaKaydet(getHiz() + "");
        DosyaKaydet(getYolcu() + "");
        DosyaKaydet(getUretim() + "");
        DosyaKaydet(getFiyat() + "");
        DosyaKaydet(getTekerlek() + "");
        DosyaKaydet("\n");

    }
}
