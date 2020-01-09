package ogrenciotomasyonu;



public class Ders {
    String kredi, dersKodu;
    String dersAdi, dersSınıfı, dersSaati, dersGünü;
    ÖğretimGörevlisi dersHocası;
    String yarıyıl;
    int not;
    String harfPuanı;
    int aNotu,bNotu,cNotu,fNotu;
    
    public int getNot() {
        return not;
    }
    
    Ders(String dersKodu, String dersAdi, String dersSınıfı, String dersSaati, String dersGünü, ÖğretimGörevlisi dersHocası, String yarıyıl){
        this.dersAdi = dersAdi;
        this.dersGünü = dersGünü;
        this.dersHocası = dersHocası;
        this.dersKodu = dersKodu;
        this.dersSaati = dersSaati;
        this.dersSınıfı = dersSınıfı;
        this.yarıyıl = yarıyıl;
        
    }
    
    public ÖğretimGörevlisi getDersHocası() {
        return dersHocası;
    }
    
    public String getDersAdi() {
        return dersAdi;
    }

    public String getDersSaati() {
        return dersSaati;
    }

    public String getDersGünü() {
        return dersGünü;
    }

    public String getKredi() {
        return kredi;
    }

    
    @Override
    public String toString(){
        return dersKodu +" "+ dersAdi+" "+dersSınıfı+" "+dersSaati+" "+" " +dersGünü +" "+ dersHocası + " " + yarıyıl;
    }

    public void setNot(int not) {
        this.not = not;
    }
    
    
    

    
}
