package aracyonetimsistem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ucak implements HavaTasit {

    private static int nesne_sayisi = 0;
    private String id_no;

    public Ucak() throws IOException {
        id_no = idBul();
        DosyaKaydet("Ucak_" + id_no);

    }

    public Ucak(String marka, int hiz, int yolcu_sayisi, int fiyat, int uretim_yili, String renk) {
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
        DosyaKaydet("\n");
    }

    @Override
    public boolean inis() {
        return getHiz() == 0; //Hiz 0 ise true dondurur ve Ucak inmis olur
    }

    @Override
    public void Dur() {
        if (inis() == true) {
            setHiz(0);
            System.out.println("Ucak İndi ve Durdu");
        } else {
            System.out.println("İnemediginiz icin durdurulamadi.");
        }
    }

    public void Oku() throws IOException {
        File file = new File("AracKayit.txt");
        FileReader fileReader = new FileReader(file);
        String line;

        BufferedReader br = new BufferedReader(fileReader);

        while ((line = br.readLine()) != null) {
            if (line.charAt(0) == 'U' && line.charAt(4) != 'G') {
                System.out.println(line);
            }
        }
        br.close();
    }
    private String marka, renk;
    private int hiz, yolcu_sayisi, uretim_yili;
    private double fiyat;
    List<String> lines = new ArrayList<String>();
    List<String> newlines = new ArrayList<String>();
    String line = null;
    String newline = null;

    @Override
    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Override
    public String getMarka() {
        return marka;
    }

    @Override
    public void setRenk(String renk) {
        this.renk = renk;
    }

    @Override
    public String getRenk() {
        return renk;
    }

    @Override
    public void setHiz(int hiz) {
        this.hiz = hiz;
    }

    @Override
    public int getHiz() {
        return hiz;
    }

    @Override
    public void setYolcu(int yolcu_sayisi) {
        this.yolcu_sayisi = yolcu_sayisi;
    }

    @Override
    public int getYolcu() {
        return yolcu_sayisi;
    }

    @Override
    public void setUretim(int uretim_yili) {
        this.uretim_yili = uretim_yili;
    }

    @Override
    public int getUretim() {
        return uretim_yili;
    }

    @Override
    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public double getFiyat() {
        return fiyat;
    }

//Aracin Hizlanma,Yavaslama ve Durma Islemini Asagidaki Methodlarda Yapiyoruz
    @Override
    public int Hizlan(int hiz_fark) {
        hiz = hiz + hiz_fark;
        return hiz;
    }

    @Override
    public int Yavasla(int hiz_fark) {
        return hiz_fark;
    }

    @Override
    public void DosyaKaydet(String kayit) throws IOException, IOException {

        File file = new File("AracKayit.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        if ("\n".equals(kayit)) {//Gelen deger \n ise alt satira geciyor
            bWriter.newLine();
        } else {
            bWriter.write(kayit + "    ");
        }

        bWriter.close();
    }

    @Override
    public void Guncelle(String id, String eski, String yeni) throws IOException {

        File f1 = new File("C:\\Users\\Rıdvan\\Desktop\\Java Çalışma\\AracYonetimSistem\\AracKayit.txt");
        FileReader fr = new FileReader(f1);
        BufferedReader br = new BufferedReader(fr);
        FileReader newfr = new FileReader(f1);
        BufferedReader newbr = new BufferedReader(newfr);
        int sayac = 0, newsayac = 0;
        while ((line = br.readLine()) != null) {//Girilen id ye kadar arrayliste dosyadaki bilgileri atıyor ve kacinci satirda kaldigini tutuyor

            if (line.contains(id)) {
                break;
            }
            sayac++;
            newlines.add(line);
        }
        while ((newline = newbr.readLine()) != null) {//Hafiza da tutulan satir degerine gore o satira kadar iniyor

            newsayac++;
            if (newsayac == sayac) {
                break;
            }

        }
        while ((newline = newbr.readLine()) != null) {//Degistirilecek degeri buluyoruz ve degistiriyoruz

            if (newline.contains(eski)) {
                newline = newline.replace(eski, yeni);
                newlines.add(newline);
                break;
            } else {
                newlines.add(newline);
            }

        }
        while ((newline = newbr.readLine()) != null) {//Degistirilen yerden sonraki satirlar arrayliste ekleniyor
            newlines.add(newline);

        }
        fr.close();
        br.close();

        FileWriter fw = new FileWriter(f1);
        BufferedWriter out = new BufferedWriter(fw);
        for (String s : newlines) {//Arraylistteki bilgiler dosyaya yazdiriyoruz
            out.write(s);
            out.newLine();
        }
        out.flush();
        out.close();
    }
}
