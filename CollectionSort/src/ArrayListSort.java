import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ArrayListSort {
    static HashMap map = new HashMap();

    public static void main(String[] args) {
        System.out.println("Sort ArrayList");
        sort();
        System.out.println("Sort Lista");
        sortLista();

    }

    public static <T extends Comparable<? super T>> void sort() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Volkswagen");
        list.add("Toyota");
        list.add("Aston Martin");
        list.add("Ferrari");
        list.add("Mercedes-Benz");
        list.add("Audi");
        list.add("Fiat");
        list.add("BMW");
        list.add("Lamborghini");
        System.out.println("Prima di sort: " + list);
        Collections.sort(list);
        System.out.println("Dopo sort: " + list);
    }

    public static <T extends Comparable<? super T>> void sortLista() {
        List<String> list = new ArrayList<String>();
        list.add("Volkswagen");
        list.add("Toyota");
        list.add("Aston Martin");
        list.add("Ferrari");
        list.add("Mercedes-Benz");
        list.add("Audi");
        list.add("Fiat");
        list.add("BMW");
        list.add("Lamborghini");
        System.out.println("Prima di sort: " + list);
        Collections.sort(list);
        System.out.println("Dopo sort: " + list);
    }
}