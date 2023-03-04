import java.io.*;
import java.util.HashMap;

public class Main {
    static HashMap map = new HashMap();
    public static void main(String[] args) {
        String csv = "Dati.csv";
        String split = ";";
        String s = "";
        try {
            BufferedReader br = new BufferedReader( new FileReader(csv));
            while((s = br.readLine())!=null){
                String [] dati = s.split(split);
                map.put(dati[0],dati[1]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        searchDataAndSave("M0001");
    }
    public static void searchDataAndSave(String key){
        if(map.containsKey(key)){
            System.out.println(map.get(key));
        }else {
            System.out.println("non trovato");
        }

    }

    public static void serialize(){
        try {
            FileOutputStream fs = new FileOutputStream("SerializedData.txt");
            ObjectOutputStream os = new ObjectOutputStream(fs);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}