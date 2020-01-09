
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
/*
    Kodla ilgili öğrencinin notu:
        Kodu yazmaya başladığımda bitmesinden ümitli değildim. Kodla ilgili çok fazla çıkmaza girdim. 
    Derste görmediğimiz, java'nın hazır kütüphanelerinde bulunan şeyleri denedim ve hatalar aldım. 
    İlk başta kendimi tekrar etmeden bu sistemi oluşturmak için kafamı çok yordum ve bu beni projeden soğuttu.
    Sonra java yazarken kodu mümkün olduğunca tekrarlayıp nesne yönelimli çalışma mantığını neden uygulamam gerektiğini anladım.
    İşin sonunda kodu bitirmek için farklı yöntemleri aynı kodda kullanıp çalışan birşey çıkarmak uğruna yazdım.
    Biteceğini düşünmüyordum ama sonunda bitti. Umarım beğenirsiniz.

*/


public class OgrenciOtomasyonu {
    static ArrayList< Ders > Dersler = new ArrayList<>();
    static ArrayList<Öğrenci> Öğrenciler = new ArrayList<>() ;
    static ArrayList <ÖğretimGörevlisi> Hocalar= new ArrayList<>();
    static ArrayList <idariMemur> memurlar = new ArrayList<>();
    
    static void hocaOku(){
        FileReader file=null;
        try{
            file = new FileReader("src/ogrenciotomasyonu/hocalar.txt");
        }catch(FileNotFoundException e){System.out.println("Can't read file! Path must be src/ogrenciotomasyonu/hocalar.txt");}
        Scanner input = new Scanner(file);

        while(input.hasNext()) {
            String temp = input.nextLine();
            String words[] = temp.split(" ");
            Hocalar.add(new ÖğretimGörevlisi(words[0],words[1],words[2],words[3],words[4],words[5],words[6], words[7]));
        }
    }
    
    /*static void hocanınDersleriniAta(){
        for(int i = 0; i < Hocalar.size(); i++){
            for(int j = 0; j < Dersler.size(); j++){
                if(Dersler.get(j).dersHocası.equals(Hocalar.get(i))){
                    Hocalar.get(i).verdiğiDers = Dersler.get(j);
                }
            }
        }
    
    }*/
    
    static void notGir(ÖğretimGörevlisi hoca, Öğrenci ogr, int not){
        boolean flag = false;
        int sonuc = 0;
        for(int i = 0; i < 4; i++){
            if(ogr.öğrenciDersleri.get(i).dersHocası.equals(hoca.isim)){
                sonuc = i;
                flag = true;
            }
            if(flag == true){
                ogr.öğrenciDersleri.get(sonuc).not = not;
            }
            else{
                System.out.println("Hata! Öğrenci dersinizi almıyor");
            }
        }
    }
    
    static ÖğretimGörevlisi hocaBul(String tc){
        for(int i= 0; i < Hocalar.size(); i++){
            if(tc.equals(Hocalar.get(i).tc)){
                return Hocalar.get(i);
            }
        }
        return null;
    }
    
    static idariMemur memurBul(String tc){
        for(int i = 0; i < memurlar.size(); i++){
            if(tc.equals(memurlar.get(i).tc)){
                return memurlar.get(i);
            }
        }
        return null;
    }
    
    static void memurOku(){
        FileReader file=null;
        try{
         file = new FileReader("src/ogrenciotomasyonu/memurlar.txt");
        }catch(FileNotFoundException e){System.out.println("File not found! Path must be 'src/ogrenciotomasyonu/memurlar.txt'");}
        Scanner input = new Scanner(file);
        while(input.hasNext()) {
            String temp = input.nextLine();
            String words[] = temp.split(" ");
            memurlar.add(new idariMemur(words[0],words[1],words[2],words[3],words[4], words[5]));
        }
    }
    
    /*static void öğrencilerimiBul(ÖğretimGörevlisi hoca){
        for (Öğrenci Öğrenciler1 : Öğrenciler) {
            for (int j = 0; j < 4; j++) {
                if (Öğrenciler1.öğrenciDersleri.get(j).dersAdi.equals(hoca.verdiğiDersAdı)) {
                    hoca.kendiÖğrencileri.add(Öğrenciler1);
                }
            }
        }
    }*/
    
    /*static Ders hocasındanBul(ÖğretimGörevlisi hoca){ //Hoca verip verdiği dersi almaya gerek kalmadı
        for(int i = 0; i < Dersler.size(); i++){
            if(Dersler.get(i).dersHocası.tc.equals(hoca.tc)){
                return Dersler.get(i);
            }
        }
        return null;
    }*/
    
    static Öğrenci öğrenciBul(String tc){ //TC verip öğrenci döndür
        for(int i= 0; i < Öğrenciler.size(); i++){
            if(tc.equals(Öğrenciler.get(i).tc)){
                return Öğrenciler.get(i);
            }
        }
        return null;
    }
    
    static Ders dersBul(String dersAdi){ // Ders adı verip dersi döndür
        for(int i= 0; i < Dersler.size(); i++){
            if(dersAdi.equals(Dersler.get(i).dersAdi)){
                return Dersler.get(i);
            }
        }
        return null;
    }
    
    
    static void öğrenciOku(){
        FileReader file=null;
        try{
         file = new FileReader("src/ogrenciotomasyonu/öğrenciler.txt");
        }catch(FileNotFoundException e){System.out.println("File not found! Path must be 'src/ogrenciotomasyonu/dersler.txt'");}
        Scanner input = new Scanner(file);
        while(input.hasNext()) {
            String temp = input.nextLine();
            String words[] = temp.split(" ");
            Öğrenciler.add(new Öğrenci(words[0],words[1],words[2],words[3]));
        }
    }
    
    static void dersOku(){
        FileReader file=null;
        try{
         file = new FileReader("src/ogrenciotomasyonu/dersler.txt");
        }catch(FileNotFoundException e){System.out.println("File not found! Path must be 'src/ogrenciotomasyonu/dersler.txt'");}
        Scanner input = new Scanner(file);
        while(input.hasNext()) {
            String temp = input.nextLine();
            String words[] = temp.split(" ");
            Dersler.add(new Ders(words[0],words[1],words[2],words[3],words[4],hocaBul(words[5]),words[6]));
        }
    }
        
    
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int giriş;
        hocaOku();
        dersOku();
        öğrenciOku();
        memurOku();
        /*for(int q = 0; q < Hocalar.size(); q++){
            öğrencilerimiBul(Hocalar.get(q));
        }*/
        //hocanınDersleriniAta(); gerek kalmadı, artık ders adını dosyadan alıp derslerle karşılaştırıyorum.

        do{
            System.out.println("İstanbul Üniversitesi - Cerrahpaşa\nÖğrenci Otomasyonu\nYapmak İstediğiniz İşlemi Seçiniz:");
            System.out.println("1-Öğrenci Girişi\n2-Öğretim Üyesi Girişi\n3-İdari Personel Girişi\n4-Üye Ol\n5-Çıkış Yap");
            giriş = scan.nextInt();
            switch(giriş){
                case 1:
                    int i =0;
                    System.out.println("TC:");
                    String ögrTC = scan.next();
                    System.out.println("Şifre:");
                    String ögrS = scan.next();
                    Öğrenci girişli = öğrenciBul(ögrTC);
                    if(girişli != null){
                        int ögrSecim;
                        do{
                            System.out.println("Hoşgeldiniz " + girişli.isim + " Yapmak istediğiniz işlemi seçiniz:");
                            System.out.println("1-Sınav Sonuçlarını Gör\n2-Ders Programını Gör\n3-Ders Seçimi Yap\n4-Geri Dön");
                            ögrSecim = scan.nextInt();
                            switch(ögrSecim){
                                case 1:
                                    girişli.notGor(girişli);
                                    break;
                                case 2:
                                    if(girişli.dersSeçti)
                                        girişli.dersProgGor();
                                    else
                                        System.out.println("Ders seçimi yapınız.");
                                    break;
                                case 3:
                                    girişli.dersSecimiYap();
                                    girişli.dersSeçti = true;
                                    break;
                            }
                        }while(ögrSecim != 4);
                    }
                    else{
                        System.out.println("Öğrenci BULUNAMADI!");
                    }
                    
                    break;
                case 2:
                    System.out.println("TC:");
                    String ögKA = scan.next();
                    System.out.println("Şifre:");
                    String ögS = scan.next();
                    ÖğretimGörevlisi gHoca = hocaBul(ögKA);
                    if(gHoca != null){
                        if(gHoca.şifre.equals(ögS)){
                            int ögSecim = 0;
                            while(ögSecim != 5){
                                System.out.println("Hoşgeldiniz " + gHoca.isim + " Yapmak istediğiniz işlemi seçiniz:");
                                System.out.println("1-Sınav Sonuçlarını Gir\n2-Harf Notu Belirle\n3-Ders Programını Gör\n4-Yoklamayı Gir\n5-Geri Dön");
                                ögSecim = scan.nextInt();
                                switch(ögSecim){
                                    case 1:
                                        int choice, k;
                                        System.out.println("Not gireceğiniz öğrenciyi seçin: ");
                                        for(int t = 0; t < Öğrenciler.size(); t++){
                                            System.out.println(t + ". " + Öğrenciler.get(t).isim);
                                        }
                                        choice = scan.nextInt(); 
                                        System.out.println("Seçilen öğrenci: " + Öğrenciler.get(choice) + "\nNot Girin: ");
                                        int puan = scan.nextInt();
                                        Öğrenci geçiciÖgr = Öğrenciler.get(choice);
                                        try{
                                            File dos = new File("src\\ogrenciotomasyonu\\ogrenciNotları\\");
                                            if(!dos.exists())
                                                dos.createNewFile();
                                            File yenidos= new File(dos.getPath() + geçiciÖgr.tc +".txt");
                                            if(!yenidos.exists())
                                                yenidos.createNewFile();
                                            FileWriter fstream = new FileWriter(yenidos);
                                            BufferedWriter out = new BufferedWriter(fstream);
                                            out.write(gHoca.verdiğiDersAdı + ":" + puan +"\n");
                                            out.close();
                                            }catch (Exception e){
                                                System.err.println("Error: " + e.getMessage());
                                            }
                                        break;
                                    case 2:
                                        int a,b,c,d;
                                        System.out.println("Sırasıyla AA BB CC ve DD notlarını giriniz: ");
                                        a = scan.nextInt();
                                        b = scan.nextInt();
                                        c = scan.nextInt();
                                        d = scan.nextInt();
                                        gHoca.harfNotuGir(a,b,c,d);
                                        
                                        /*gHoca.verdiğiDers.harfNotları.put("AA", a);
                                        gHoca.verdiğiDers.harfNotları.put("BB", b);
                                        gHoca.verdiğiDers.harfNotları.put("CC", c);
                                        gHoca.verdiğiDers.harfNotları.put("DD", d);
                                        System.out.println("Harf notları: ");
                                        System.out.println("AA: "+gHoca.verdiğiDers.harfNotları.get("AA"));
                                        System.out.println("BB: "+gHoca.verdiğiDers.harfNotları.get("BB"));
                                        System.out.println("CC: "+gHoca.verdiğiDers.harfNotları.get("CC"));
                                        System.out.println("DD: "+gHoca.verdiğiDers.harfNotları.get("DD"));*/
                                        break;
                                    case 3:
                                        File file = new File("src/ogrenciotomasyonu/dersler.txt");
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
                                        String thisLine = " ";
                                        while(thisLine != null){
                                            thisLine = br.readLine();
                                            if(thisLine.contains(gHoca.isim)){
                                                String[] ders = thisLine.split(" ");
                                                System.out.println(ders[1] + " dersi " + ders[2] + " sınıfında " + ders[3] + " saatinde " + ders[4] + " günleri sizin tarafınızdan verilecektir." );
                                                thisLine = null;
                                            }
                                        }
                                        
                                        
                                        break;
                                    case 4:
                                        System.out.println("Öğrencinizi seçiniz: ");
                                        for( i = 0; i < Öğrenciler.size(); i++){
                                            System.out.println(i + ". " + Öğrenciler.get(i).isim);
                                        }
                                        System.out.println((i) + ". Çık");
                                        choice = scan.nextInt();
                                        if(choice!=i){
                                            System.out.println("Tarih giriniz (gg.aa.yy): ");
                                            String yok = scan.next();
                                            gHoca.devamsızlıkYaz(Öğrenciler.get(choice), yok);
                                        }                                        
                                        break;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("TC:");
                    String ipKA = scan.next();
                    System.out.println("Şifre:");
                    String ipS = scan.next();
                    idariMemur gmemur = memurBul(ipKA);
                    if(gmemur!= null){
                        System.out.println("Hoşgeldiniz " + gmemur.isim + " Yapmak istediğiniz işlemi seçiniz:");
                        System.out.println("1-Harf Notu Belirle\n2-Ders Programını Değiştir\n3-Yoklamayı Gir\n4-Geri Dön");
                        int ipSecim = scan.nextInt();
                        while(ipSecim!= 4){
                        switch(ipSecim){
                            case 1:
                                System.out.println("Harf notunu belirlemek istediğiniz dersi giriniz: ");
                                for( i = 0; i < Dersler.size(); i++){
                                    System.out.println(i + ". " + Dersler.get(i).dersAdi);
                                }
                                int secim = scan.nextInt();
                                System.out.println("Sırasıyla AA BB CC DD için girilecek notları verin: ");
                                int a = scan.nextInt();
                                int b = scan.nextInt();
                                int c = scan.nextInt();
                                int d = scan.nextInt();
                                gmemur.harfNotuGir(a, b, c, d, Dersler.get(secim).getDersAdi());
                                break;
                            
                            case 2:
                                File file = new File("src/ogrenciotomasyonu/dersler.txt");
                                if(!file.exists())
                                    file.createNewFile();
                                FileReader fr = new FileReader(file);
                                BufferedReader br = new BufferedReader(fr);
                                i = 0;
                                ArrayList <String> idariDersler = new ArrayList<>();
                                while (br.readLine() != null)
                                { //TODO
                                    idariDersler.add(br.readLine());
                                    System.out.println(i + ". " + idariDersler.get(i));
                                    i++;
                                }
                                System.out.println("Değişiklik yapmak istediğiniz dersi seçiniz: ");
                                int hngders = scan.nextInt();
                                System.out.println("Değiştirmek istediğiniz içeriği seçiniz:\n0-Ders Kodu\n1-Ders Adı\n2-Ders Sınıfı\n3-Ders Saati\n4-Ders Günü");
                                int icr = scan.nextInt();
                                String eski = idariDersler.get(icr);
                                System.out.println(eski);
                                String words[] = eski.split(" ");
                                System.out.println("Yeni içeriği giriniz: ");
                                String yeni = scan.nextLine();
                                gmemur.dersProgramıDeğiştir(words[icr], yeni);
                                break;
                                
                        }
                        }
                    }else{
                        System.out.println("İdari Memur Bulunamadı!");
                    }
                    break;
                case 4:
                    System.out.println("Hoşgeldiniz\n1-Öğrenci Üyeliği\n2-Öğretim Üyesi Üyeliği\n3-İdari Personel Üyeliği\n4-Geri");
                    int yeniÜye = scan.nextInt();
                    switch(yeniÜye){
                        case 1:
                            Scanner tara = new Scanner(System.in);
                            System.out.println("Sırasıyla istenilen bilgileri giriniz.\nTc: ");
                            String tc = tara.nextLine();
                            System.out.println("İsim(Boşluk Bırakmayınız!): ");
                            String isim = tara.nextLine();
                            System.out.println("Yaş: ");
                            String yaş = tara.nextLine();
                            System.out.println("Şifre: ");
                            String şifre = tara.nextLine();
                            try{
                                File f1 = new File("src/ogrenciotomasyonu/öğrenciler.txt");
                                FileReader fr = new FileReader(f1);
                                BufferedReader br = new BufferedReader(fr);
                                String line;
                                ArrayList<String>lines = new ArrayList<>();
                                while ((line = br.readLine()) != null) {
                                    lines.add(line + "\n");
                                }
                                fr.close();
                                br.close();
                                FileWriter fw = new FileWriter(f1);
                                BufferedWriter out = new BufferedWriter(fw);
                                for(String s : lines)
                                     out.write(s);
                                out.write(tc + " " + isim + " " + yaş + " " + şifre + "\n");
                                out.flush();
                                out.close();
                                öğrenciOku();
                            }catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        case 2:
                            Scanner ara = new Scanner(System.in);
                            System.out.println("Sırasıyla istenilen bilgileri giriniz.\nTc: ");
                            String tcög = ara.nextLine();
                            System.out.println("İsim(Boşluk Bırakmayınız!): ");
                            String isimög = ara.nextLine();
                            System.out.println("Yaş: ");
                            String yaşög = ara.nextLine();
                            System.out.println("Şifre: ");
                            String şifreög = ara.nextLine();
                            try{
                                File f1 = new File("src/ogrenciotomasyonu/hocalar.txt");
                                FileReader fr = new FileReader(f1);
                                BufferedReader br = new BufferedReader(fr);
                                String line;
                                ArrayList<String>lines = new ArrayList<>();
                                while ((line = br.readLine()) != null) {
                                    lines.add(line + "\n");
                                }
                                fr.close();
                                br.close();
                                FileWriter fw = new FileWriter(f1);
                                BufferedWriter out = new BufferedWriter(fw);
                                for(String s : lines)
                                     out.write(s);
                                out.write(tcög + " " + isimög + " " + yaşög + " 1500 15 yeniKayıtlıHoca " + şifreög + " belirsiz" + "\n");
                                out.flush();
                                out.close();
                                hocaOku();
                            }catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        case 3:
                            Scanner araa = new Scanner(System.in);
                            System.out.println("Sırasıyla istenilen bilgileri giriniz.\nTc: ");
                            String tcc = araa.nextLine();
                            System.out.println("İsim(Boşluk Bırakmayınız!): ");
                            String ismm = araa.nextLine();
                            System.out.println("Yaş: ");
                            String yaşş = araa.nextLine();
                            System.out.println("Şifre: ");
                            String şiffre = araa.nextLine();
                            try{ 
                                File f1 = new File("src/ogrenciotomasyonu/memurlar.txt");
                                FileReader fr = new FileReader(f1);
                                BufferedReader br = new BufferedReader(fr);
                                String line;
                                ArrayList<String>lines = new ArrayList<>();
                                while ((line = br.readLine()) != null) {
                                    lines.add(line + "\n");
                                }
                                fr.close();
                                br.close();
                                FileWriter fw = new FileWriter(f1);
                                BufferedWriter out = new BufferedWriter(fw);
                                for(String s : lines)
                                     out.write(s);
                                out.write(tcc + " " + ismm + " " + yaşş + " 1500 15 yeniKayıtlıMemur " + şiffre + "\n");
                                out.flush();
                                out.close();
                                memurOku();
                            }catch (Exception ex) {
                                ex.printStackTrace();
                            }
                    }
                    break;
                case 5:
                    System.out.println("İyi Günler Dileriz");
                    break;
                default:
                    System.out.println("Lütfen tekrar seçim yapınız. Çıkmak için 5'e basabilirsiniz");
                    break;
            }
        }while(giriş!=5);
        
    }
    
}
