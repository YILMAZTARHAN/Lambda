import java.util.*;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("mehmet",
                "emre","nilgun","yıldız","kader","emine","islam","islam","emre","wabuziddin","cincix","kokarec"));

        byHrfTekrarsizSira(list);
        System.out.println();
        System.out.println(" *** ");
        karakterSayisiTekrarsizTersSirali(list);
        System.out.println();
        System.out.println(" *** ");
        karakterSayisiSirali(list);
        System.out.println();
        System.out.println(" *** ");
        sonHrfTersSiraliEl(list);
        System.out.println();
        System.out.println(" *** ");
        ciftKareTekrarsizTersSira(list);
        System.out.println();
        System.out.println(" *** ");
        harfSayisi7Kontrol(list);
        System.out.println();
        System.out.println(" *** ");
        wBaslamaKontrol(list);
        System.out.println();
        System.out.println(" *** ");
        xBitmeKontrol(list);
        System.out.println();
        System.out.println(" *** ");
        karakterSayisiEnBuyukEl(list);
        System.out.println();
        System.out.println(" *** ");
        karakteriEnBuyukEl2(list);
        System.out.println();
        System.out.println(" *** ");
        ilkElemanHaricSonHarfSirali(list);



    }
  //List elemanlarını alfabetik büyük harf ve tekrarsız yazdırınız
    public static void byHrfTekrarsizSira(List<String> list){
        list.
                stream().//akisa girdi
                // map(t->t.toUpperCase()).//elelmanlar byk harf update edildi
                 map(String::toUpperCase).//elelmanlar byk harf update edildi
                sorted().//alfabetik sira
                distinct().//tekrarsiz  yapildi
                forEach(t->System.out.print(t + " "));//yazdirilidi
        //EMRE EMİNE KADER MEHMET NİLGUN YILDIZ İSLAM

    }
    //list elelmanlarinin character sayisini ters sirali olarak tekrarsiz yazdiriniz
    public static void karakterSayisiTekrarsizTersSirali (List<String> list){
        list.
                stream().
                map(t->t.length()).//String data character sayısına ubdate edildi
                sorted(Comparator.reverseOrder()).//ters sıra
                distinct().//tekrarsız
                forEach(Lambda01::printEl);//yazdırıldı

    }

   //List elemanlarını character sayısına göre küçükten büyüğe doğru yazdırınız

    public static void karakterSayisiSirali (List<String> list){
        list.
                stream().
                sorted(Comparator.comparing(t->t.length())).//eleman character sayısına göre özel sıralama yapıldı
                forEach(t->System.out.print(t + " "));

    }
   //List elemanlarını son harfine göre ters sıralı yazdırınız

    public static void sonHrfTersSiraliEl(List<String>list){
        list.
                stream().
                sorted(Comparator.comparing(t->t.toString()
                        .charAt(t.toString().length()-1)).// elemanın length()-1)-->son index'inin karakterini alır
                        reversed()).//// elemanın length()-1)-->son index'inin karakterini ters sıralar z->a
                forEach(t->System.out.print(t + " "));
    }
    //Cift sayili elemanlarin karelerini hesaplayan, tekrarsız  buyukten kucuge dogru yaziniz.

    public static void ciftKareTekrarsizTersSira(List<String>list){
        list.
                stream().
                map(t->t.length()*t.length()).//string elemanlar character sayısına çevrildi
                filter(Lambda01::ciftBul).//çift şartı çalıştı
                distinct().//tekrarsız
                sorted(Comparator.reverseOrder()).//ters sıra b->k
                forEach(Lambda01::printEl);//yazdırılış

    }
  // list elemanlarının karakter sayısını 7 ve 7 den az olma durumunu kontrol ediniz.
    public static void harfSayisi7Kontrol(List<String>list){
    /* boolean kontrol= list.
             stream().
             allMatch(t->t.length()<=7);
     if (kontrol){
         System.out.println("List elemanları 7 harfden büyük değil");

     }else{
         System.out.println("Agam List elemanları 7 harfdEN büyük");
     }*/
        System.out.println(list.stream().allMatch(t->t.length()<=7)?"List elemanları 7 harfden büyük değil":"Agam List elemanları 7 harfdEN büyük");
    }
//List elemanlarının"W"ile başlamasını kontrol ediniz

    public static void wBaslamaKontrol(List<String>list){
        System.out.println(list.
                stream().noneMatch(t->t.startsWith("w"))?"w ile başlayan isim kimse ayağa kalksın":"Agam w ile başlayan isim olurr");

    }
//List elemanlarının"x"ile biten en az bir elemanu kontrol ediniz

    public static void xBitmeKontrol(List<String>list){
        System.out.println(list.
                stream().anyMatch(t->t.startsWith("x"))?"x ile biten isim kimse ayağa kalksın":"Agam x ile biten isim olurr");
 //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
 //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
 //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    }

//Karakter sayısı en büyük elemanı yazdırınız
    public static void karakterSayisiEnBuyukEl(List<String>list){
        System.out.println(list.
                stream().sorted(Comparator.comparing(t -> t.toString().length()).//length karakter uzunluğuna göre siralı k->
                        reversed()).//ters sıralı b>k
                findFirst());//ilk elemanı aldı

    }
    public static void karakteriEnBuyukEl2(List<String> list) {
        Stream<String> sonIsim = list.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).//lenght karakter uzunluguna gore siraladi k->b
                        reversed()).//ters sirlad b->k
                //  findFirst());//ilk elelmani aldi
                        limit(1);//limit(a) akısdan cıkan elemanları a parametresine dore ilk a elamanı alır
        System.out.println(Arrays.toString(sonIsim.toArray()));
    }
     //List elemanlarını son harfine göre sıralayıp ilk eleman hariç kalan elemanları yazdırınız
    public static void ilkElemanHaricSonHarfSirali(List<String> list){
        list.stream().sorted(Comparator.comparing(t->t.toString().charAt(t.length()-1))).skip(1).forEach(t->System.out.print(t+" "));

    }


}



