package lambda;

import java.util.ArrayList;
import java.util.List;

public class Q07 {
    //String isimlerden olusan bir list olusturnuz
    //List'deki isimlerden "a" ve "n" icerenlerin harf sayilarinin toplamini ekrana yazdiriniz
    //List'deki isimlerden ilk harfi son harfinden alfabetik olarak onde olan isimleri ekrana yazdirin

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Ali");
        list.add("Mark");
        list.add("Jackson");
        list.add("Amanda");
        list.add("Mariano");
        list.add("Alberto");
        list.add("Tucker");
        list.add("Christ");

        System.out.println(list.stream()
                .filter(t -> t.contains("a") && t.contains("n"))
                .mapToInt(t -> t.length())
                .sum());

        list.stream()
                .filter(t->t.toLowerCase()
                        .charAt(0)<t.charAt(t.length()-1))
                .map(t->t)
                .forEach(System.out::println);

    }
}
