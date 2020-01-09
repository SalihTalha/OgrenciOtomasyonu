/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ogrenciotomasyonu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import static ogrenciotomasyonu.OgrenciOtomasyonu.Dersler;
import static ogrenciotomasyonu.OgrenciOtomasyonu.Öğrenciler;

public class idariMemur extends Çalışan implements YetkiliÜye{
    
    public void devamsızlıkYaz(Öğrenci ogr, String yok){
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
    
    public void harfNotuGir(int a, int b, int c,int d, String dersAdı){
        try{
            File dos = new File("src\\ogrenciotomasyonu\\harfNotlari\\");
            if(!dos.exists())
                dos.createNewFile();
            File yenidos= new File(dos.getPath() + dersAdı +".txt");
            if(!yenidos.exists())
                yenidos.createNewFile();
            FileWriter fstream = new FileWriter(yenidos);
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
    
    public idariMemur(String tc, String ad, String maaş, String maaşGünü, String işTanımı, String şifre){
        this.tc = tc;
        this.isim = ad;
        this.maaş = maaş;
        this.maaşGünü = maaşGünü;
        this.işTanımı = işTanımı;
        this.şifre = şifre;
    }

    public idariMemur() {
    }
    public void dersProgramıDeğiştir(String yeni , String eski) { // NOT OVERRIDE 
        ArrayList<String>lines = new ArrayList<>();

        try {
            File f1 = new File("src/ogrenciotomasyonu/dersler.txt");
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            String line;
            boolean find = false;
            while ((line = br.readLine()) != null) {
                if (line.contains(eski) && !find){
                    find = true;
                    line = line.replace(eski, yeni);
                }
                lines.add(line);
            }
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(f1);
            BufferedWriter out = new BufferedWriter(fw);
            for(String s : lines)
                 out.write(s);
            out.flush();
            out.close();
        }catch (Exception ex) {
                ex.printStackTrace();
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
    public void dersProgGor(Ders[] dersler) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
