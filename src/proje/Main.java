package proje;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

   public static List<Ogrenci>ogListesi=new ArrayList<>();
    public static void main(String[] args) {
        ogrenciListesi();
        notagoreSirala(30,90);
     System.out.println("**********************");
        yasaGoreSirala();
     System.out.println("**********************");
        yasaVeCinsiyetGre();

    }

 private static void yasaVeCinsiyetGre() {
 }

 private static void yasaGoreSirala() {
 ogListesi.stream().sorted(Comparator.comparing(Ogrenci::getYas).reversed()).forEach(System.out::println);

    }

 private static void notagoreSirala(double a,double b) {
     ogListesi.stream().filter(t->t.getDiplomaNotu()>a &&t.getDiplomaNotu()<b).forEach(t-> System.out.println(t.toString()));
    }








    private static void ogrenciListesi() {
    ogListesi.add(new Ogrenci("Ahmet","Can",30,95.50,"Erkek"));
    ogListesi.add(new Ogrenci("Ahmet","Yarba",25,90.50,"Erkek"));
    ogListesi.add(new Ogrenci("Ayşe","Can",21,82.50,"kadın"));
    ogListesi.add(new Ogrenci("Merve","Aslan",30,98.80,"Kadın"));
    ogListesi.add(new Ogrenci("Veli","Han",80,35.50,"Erkek"));
    ogListesi.add(new Ogrenci("Funda","Funda",24,99.20,"Kadın"));

    }


}
