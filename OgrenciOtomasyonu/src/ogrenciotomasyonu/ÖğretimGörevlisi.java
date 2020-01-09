/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ogrenciotomasyonu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import static ogrenciotomasyonu.OgrenciOtomasyonu.hocaBul;
import static ogrenciotomasyonu.OgrenciOtomasyonu.dersBul;

/**
 *
 * @author sns
 */
public class ÖğretimGörevlisi extends Çalışan implements YetkiliÜye{
    ArrayList <Öğrenci> kendiÖğrencileri = new ArrayList<Öğrenci>();
    String verdiğiDersAdı;
    Ders verdiğiDers;

    public ÖğretimGörevlisi(String tc, String isim, String yaş, String maaş, String maaşGünü, String işTanımı, String şifre, String verdiğiDersAdı) {
        this.tc = tc;
        this.isim = isim;
        this.yaş = yaş;
        this.maaş = maaş;
        this.maaşGünü = maaşGünü;
        this.işTanımı = işTanımı;
        this.şifre = şifre;
        this.verdiğiDersAdı = verdiğiDersAdı;
        this.verdiğiDers = dersBul(verdiğiDersAdı);

    }
    
    public void notGir(Öğrenci ogr , Ders ders, int not){
        
    }
    
    public void devamsızlıkYaz(Öğrenci ogr, String yok){
        Scanner scan = new Scanner(System.in);
        try{
            File dos = new File("src\\ogrenciotomasyonu\\yoklama\\");
            if(!dos.exists())
                dos.createNewFile();
            File yenidos= new File(dos.getPath() + ogr.tc +".txt");
            if(!yenidos.exists())
                yenidos.createNewFile();
            FileWriter fstream = new FileWriter(yenidos);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(yok+"\n");
            out.close();
            }catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
    }
    
    public void harfNotuGir(int a, int b, int c,int d){
        try{
            FileWriter fstream = new FileWriter("src/ogrenciotomasyonu/harfNotlari/" + this.verdiğiDersAdı +".txt");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("AA: "+ a + " ");
            out.write("BB: "+ b + " ");
            out.write("CC: "+ c + " ");
            out.write("DD: "+ d + " ");
            out.close();
        }catch (Exception e){
          System.err.println("Error: " + e.getMessage());
        }
    }
    

    @Override
    public void dersProgGor(Ders dersListesi[]){
        for(int i = 0; i < dersListesi.length; i++){
            System.out.println(dersListesi[i].getDersAdi() + ": " + dersListesi[i].getDersGünü()+ " günleri; Saat: " + dersListesi[i].getDersSaati());
        }
    }

    @Override
    public void harfNotuBelirle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void yoklamaGörüntüle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notGor(Öğrenci ogr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return tc+" "+isim+" "+yaş+" "+maaş+" "+maaşGünü+" "+işTanımı;
    }

    
}
