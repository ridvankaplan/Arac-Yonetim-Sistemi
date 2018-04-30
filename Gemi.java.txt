package aracyonetimsistem;

import java.io.IOException;

public class Gemi extends DenizTasit {

    private static int nesne_sayisi = 0;
    private String id_no;

    public Gemi() throws IOException {
        DenizTasit deniz = new DenizTasit();
        id_no = idBul();
        deniz.DosyaKaydet("Gemi_" + id_no);

    }

    public Gemi(String marka, int hiz, int yolcu_sayisi, int fiyat, int uretim_yili, String renk) {
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
        System.out.println(id_no);
        return id_no;
    }

    public void DosyaKaydet() throws IOException, IOException {

        DosyaKaydet(getMarka() + "");
        DosyaKaydet(getRenk() + "");
        DosyaKaydet(getHiz() + "");
        DosyaKaydet(getYolcu() + "");
        DosyaKaydet(getUretim() + "");
        DosyaKaydet(getFiyat() + "");
        DosyaKaydet("\n");

    }

}
