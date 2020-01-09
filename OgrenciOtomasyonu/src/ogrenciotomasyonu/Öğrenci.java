/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ogrenciotomasyonu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ogrenciotomasyonu.OgrenciOtomasyonu.Dersler;
import static ogrenciotomasyonu.OgrenciOtomasyonu.dersBul;

public class Öğrenci extends Insan implements okulÜyesi{
    ArrayList <Ders> öğrenciDersleri = new ArrayList <>();
    String okulNo;
    boolean dersSeçti = false;

    public void dersProgGor(){ // öğrenciDersleri inputu alacak
        for(int i = 0; i < 4; i++){
            System.out.println(öğrenciDersleri.get(i).dersAdi + ": " + öğrenciDersleri.get(i).dersGünü+ " günleri. \nSaat: " + öğrenciDersleri.get(i).dersSaati );
        }
    }
    
    public void dersSecimiYap()throws IOException{
        Scanner scan = new Scanner(System.in);
        try{
            FileWriter fstream = new FileWriter("src\\ogrenciotomasyonu\\dersSecimleri\\" + this.tc +".txt");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(this.tc + ": ");
            int i = 0;
            System.out.println("Dikkat: Bir öğrenci bir dönemde en fazla 4 ders alabilir! Ona göre seçim yapınız.");
            while( i != Dersler.size()){
                System.out.println(i + ". " + Dersler.get(i).getDersAdi() + ": " + Dersler.get(i).getDersGünü() + "günü ; Saat: " + Dersler.get(i).getDersSaati());
                i++;
            }
            System.out.println("Almak istediğiniz derslerin numarasınız veririniz.\n");
            for(i = 0; i < 4; i++){
                int secim = scan.nextInt();
                öğrenciDersleri.add(i, Dersler.get(secim));
                System.out.println(Dersler.get(secim).dersAdi + "seçildi.");
                out.write(öğrenciDersleri.get(i).dersAdi + " "); //öğrencinin aldığı derslerin ders kodları tutulacak
            }
        
            out.close();
        }catch (Exception e){
          System.err.println("Error: " + e.getMessage());
        }
        
    }
    
    @Override
    public void notGor(Öğrenci ogr){
        File file = new File("src/ogrenciotomasyonu/ogrenciNotları" + ogr.tc +".txt");
        if(!file.exists())
            try {
                file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Öğrenci.class.getName()).log(Level.SEVERE, null, ex);
        }
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Öğrenci.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = new BufferedReader(fr);
        for(int i = 0; i < 4; i++){
            try {
                System.out.println(br.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Öğrenci.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void dersProgGor(Ders[] dersler) {
        for(int i = 0; i < 4; i++)
            System.out.println(i + ". " + öğrenciDersleri.get(i).getDersAdi() + ": " + öğrenciDersleri.get(i).getDersGünü() + "günü ; Saat: " + öğrenciDersleri.get(i).getDersSaati());
    }
    
    Öğrenci(String tc, String isim, String yaş, String şifre){
        this.tc = tc;
        this.isim = isim;
        this.yaş = yaş;
        this.şifre = şifre;
    }
    
    public String toString(){
        return isim + " " + tc;
    }
    
}
