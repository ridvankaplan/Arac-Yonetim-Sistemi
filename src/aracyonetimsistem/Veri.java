package aracyonetimsistem;

import java.io.IOException;
import java.util.Scanner;

public class Veri {

    public static String marka, yakit_turu, renk;
    public static int hiz, yolcu_sayisi, tekerlek_sayisi, fiyat, uretim_yili;

    public void veriAl(int arac) throws IOException {
        Scanner input = new Scanner(System.in);
        int secim, fark;
        System.out.println("Aracinizin Markasini Giriniz : ");
        Veri.marka = input.nextLine();
        System.out.println("Aracinizin Yakit Turunu Giriniz : ");
        Veri.yakit_turu = input.nextLine();
        System.out.println("Aracinizin Hizini Giriniz : ");
        Veri.hiz = input.nextInt();
        System.out.println("Aracinizin Yolcu Sayisini Giriniz : ");
        Veri.yolcu_sayisi = input.nextInt();
        if (arac == 1 || arac == 2) {
            System.out.println("Aracinizin Tekerlek Sayisini Giriniz : ");
            Veri.tekerlek_sayisi = input.nextInt();
        }
        System.out.println("Aracinizin Fiyatini Giriniz : ");
        Veri.fiyat = input.nextInt();
        System.out.println("Aracinizin Rengini Giriniz : ");
        Veri.renk = input.next();
        System.out.println("Aracinizin Uretim Yilini Giriniz : ");
        Veri.uretim_yili = input.nextInt();
        System.out.println("Aracinizin Hizini Arttirmak Icin 1 Azaltmak Icin -1 Degisiklik Yapmamak Icin 0'a Basiniz ");
        secim = input.nextInt();

        if (secim == 1) {
            System.out.println("Aracin Hizini Ne Kadar Arttirmak Istiyorsunuz ");
            fark = input.nextInt();
            if (arac == 1 || arac == 2) {
                KaraTasit kara = new KaraTasit();
                hiz = kara.Hizlan(hiz + fark);
            } else if (arac == 3) {
                DenizTasit deniz = new DenizTasit();
                hiz = deniz.Hizlan(hiz + fark);
            } else if (arac == 4) {
                Ucak ucak = new Ucak(marka, hiz, yolcu_sayisi, fiyat, uretim_yili, renk);
                hiz = ucak.Hizlan(hiz + fark);
            } else if (arac == 5) {
                UcanGemi ucan = new UcanGemi(marka, hiz, yolcu_sayisi, fiyat, uretim_yili, renk);
                hiz = ucan.Hizlan(hiz + fark);
            }
        } else if (secim == -1) {
            System.out.println("Aracin Hizini Ne Kadar Azaltmak Istiyorsunuz ");
            fark = input.nextInt();
            if (arac == 1 || arac == 2) {
                KaraTasit kara = new KaraTasit();
                hiz = kara.Yavasla(hiz - fark);
            } else if (arac == 3) {
                DenizTasit deniz = new DenizTasit();
                hiz = deniz.Yavasla(hiz - fark);
            } else if (arac == 4) {
                HavaTasit ucak = new Ucak(marka, hiz, yolcu_sayisi, fiyat, uretim_yili, renk);
                hiz = ucak.Yavasla(hiz - fark);
            } else if (arac == 5) {
                HavaTasit ucan = new UcanGemi(marka, hiz, yolcu_sayisi, fiyat, uretim_yili, renk);
                hiz = ucan.Yavasla(hiz - fark);
            }
        } else if (secim == 0) {
            System.out.println("Degisiklik Yapilmadi!!!");
        }
        System.out.println("Araci Durdurmak Icin 0 Devam Etmek Icin 1 Giriniz ");
        secim = input.nextInt();
        if (secim == 0) {
            if (arac == 1 || arac == 2) {
                KaraTasit kara = new KaraTasit();
                kara.Dur();
            } else if (arac == 3) {
                DenizTasit deniz = new DenizTasit();
                deniz.Dur();
            } else if (arac == 4) {
                Ucak ucak = new Ucak(marka, hiz, yolcu_sayisi, fiyat, uretim_yili, renk);
                ucak.Dur();
            } else if (arac == 5) {
                UcanGemi ucan = new UcanGemi(marka, hiz, yolcu_sayisi, fiyat, uretim_yili, renk);
                ucan.Dur();
            }
        }
    }

    public int ilkSecim() {
        Scanner input = new Scanner(System.in);
        int islem;
        System.out.println("Yapmak İstediğiniz İşlemi Seçiniz");//Islem secim kismi
        System.out.println("1.Veri Girişinde Bulun");
        System.out.println("2.Veri Listele");
        System.out.println("3.Veri Güncelle");
        islem = input.nextInt();
        return islem;
    }

    public int aracSecim() {
        Scanner input = new Scanner(System.in);
        int arac;
        System.out.println("Veri Girişinde Bulunacağınız Aracı Seçiniz");//Arac secim kismi
        System.out.println("1.Otomobil");
        System.out.println("2.Bisiklet");
        System.out.println("3.Gemi");
        System.out.println("4.Uçak");
        System.out.println("5.Uçan Gemi");
        System.out.println("Bir Önceki Menüye Geri Dön");
        System.out.println("Çıkış");
        arac = input.nextInt();
        return arac;
    }

    public int listele() {
        Scanner input = new Scanner(System.in);
        int liste;
        System.out.println("Listelemek İstediğiniz Veri Tipini Seçiniz");//Tasit tipini secim kismi
        System.out.println("1.Kara Taşıtları");
        System.out.println("2.Deniz Taşıtları");
        System.out.println("3.Hava Taşıtları");
        System.out.println("Bir Önceki Menüye Geri Dön");
        System.out.println("Çıkış");
        liste = input.nextInt();
        return liste;
    }

    public void aracKaydet(int arac) throws IOException {
        switch (arac) {
            case 1:
                Otomobil oto1 = new Otomobil();
                Otomobil oto2 = new Otomobil(Veri.marka, Veri.hiz, Veri.yolcu_sayisi, Veri.tekerlek_sayisi, Veri.fiyat, Veri.uretim_yili, Veri.renk, Veri.yakit_turu);
                oto2.DosyaKaydet();
                break;
            case 2:
                Bisiklet b1 = new Bisiklet();
                Bisiklet b2 = new Bisiklet(Veri.marka, Veri.hiz, Veri.yolcu_sayisi, Veri.tekerlek_sayisi, Veri.fiyat, Veri.uretim_yili, Veri.renk);
                b2.DosyaKaydet();
                break;
            case 3:
                Gemi g1 = new Gemi();
                Gemi g2 = new Gemi(Veri.marka, Veri.hiz, Veri.yolcu_sayisi, Veri.fiyat, Veri.uretim_yili, Veri.renk);
                g2.DosyaKaydet();
                break;
            case 4:
                Ucak u1 = new Ucak();
                Ucak u2 = new Ucak(Veri.marka, Veri.hiz, Veri.yolcu_sayisi, Veri.fiyat, Veri.uretim_yili, Veri.renk);
                u2.DosyaKaydet();
                break;
            case 5:
                UcanGemi ug1 = new UcanGemi();
                UcanGemi ug2 = new UcanGemi(Veri.marka, Veri.hiz, Veri.yolcu_sayisi, Veri.fiyat, Veri.uretim_yili, Veri.renk);
                ug2.DosyaKaydet();
                break;
            default:
                break;
        }
    }

    public void kayitListele(int liste) throws IOException {
        switch (liste) {
            case 1:
                KaraTasit kara = new KaraTasit();
                kara.Oku();
                break;
            case 2:
                DenizTasit deniz = new DenizTasit();
                deniz.Oku();
                break;
            case 3:
                Ucak hava = new Ucak(null, 0, 0, 0, 0, null);
                UcanGemi hava1 = new UcanGemi(null, 0, 0, 0, 0, null);
                hava.Oku();
                hava1.Oku();
                break;
            default:
                break;
        }
    }

    public void guncelSecim() throws IOException {
        String id, eski, yeni;
        Scanner input = new Scanner(System.in);
        System.out.println("Güncellemek İstediğiniz Aracın Id'sini Giriniz");//Guncelleme kismi
        id = input.next();
        System.out.println("Güncellemek İstediğiniz Yerin Eski Degerini Giriniz");
        eski = input.next();
        System.out.println("Güncellemek İstediğiniz Yerin Yeni Degerini Giriniz");
        yeni = input.next();
        if (id.charAt(0) == 'O' || id.charAt(0) == 'B') {
            KaraTasit kara = new KaraTasit();
            kara.Guncelle(id, eski, yeni);
        } else if (id.charAt(0) == 'G') {
            DenizTasit deniz = new DenizTasit();
            deniz.Guncelle(id, eski, yeni);

        } else if (id.charAt(0) == 'U' && id.charAt(3) == 'k') {
            Ucak ucak = new Ucak(Veri.marka, Veri.hiz, Veri.yolcu_sayisi, Veri.fiyat, Veri.uretim_yili, Veri.renk);
            ucak.Guncelle(id, eski, yeni);
        } else if (id.charAt(0) == 'U' && id.charAt(3) == 'n') {
            UcanGemi ug = new UcanGemi(Veri.marka, Veri.hiz, Veri.yolcu_sayisi, Veri.fiyat, Veri.uretim_yili, Veri.renk);
            ug.Guncelle(id, eski, yeni);

        }
        System.out.println(eski + " Degeri " + yeni + " Degeri Olarak Guncellendi");
    }
}
