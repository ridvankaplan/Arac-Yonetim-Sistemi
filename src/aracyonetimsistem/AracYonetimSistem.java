    package aracyonetimsistem;

    import java.io.IOException;

    public class AracYonetimSistem {

        public static void main(String[] args) throws IOException {
            Veri veri = new Veri();

            int islem, liste, arac;
            boolean kontrol = true, menu = true;
            while (kontrol) {//Surekli Dongu icinde
                islem = veri.ilkSecim();//Ilk Secimi Yaptiriyoruz
                menu = true;
                if (islem == 1 && menu == true) {
                    arac = veri.aracSecim();//Arac Sectiriyoruz             
                    if (arac == 6) {//Kullanici 6 Girerse Onceki Menuye Donuyor
                        menu = false;
                    } else if (arac == 7) {
                        kontrol = false;
                    } else if (arac != 7) {//7 ye basarsa cikis Yaptiriyoruz
                        veri.veriAl(arac);//Aracla ilgili bilgileri kullanicidan aliyoruz
                        veri.aracKaydet(arac);
                    }

                } else if (islem == 2 && menu == true) {
                    liste = veri.listele();//Veri Listelemek Icin Secim Yaptiriyoruz
                    veri.kayitListele(liste);//Girilen Secime Gore Verilerini Listeliyor
                    if (liste == 4) {
                        menu = false;
                    } else if (liste == 5) {
                        kontrol = false;
                    }

                } else if (islem == 3 && menu == true) {

                    veri.guncelSecim();//Guncelleme 
                } else {

                }
            }

        }

    }
