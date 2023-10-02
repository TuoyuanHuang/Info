// scrive e legge un array di byte alla volta in modo sequenziale

import java.io.*;
import java.util.*;

public class Scrittura{

public static void main(String args[]) throws IOException{
  System.out.println("prova file sequenziali contenenti un record");

      RandomAccessFile f = new RandomAccessFile("..\\record.dat","rw");
     		//apre un file in lettura/scrittura
    
      String s1 = "12345";                  // stringhe lunghe tutte 5 caratteri 
      String s2 = "ABCDE";
      String s3 = "abcde";
      String s4 = "*---*"; 

      /*f.write(s1.getBytes() ); 	            // le stringhe sono scritte nel file
      f.write(s2.getBytes() );              // a partire dall'inizio file,	
      f.write(s3.getBytes() );              // per scrivere alla fine del file: seek( f.length() );*/

      

      byte [] b= new byte[5];
      f.seek(0);                            // si posiziona all'inizio file 
      System.out.println("\nCONTENUTO DEL FILE:" );
      int s = f.read(b);        // legge i dati in b e se s vale -1 è il fine file
      while (s>=0){				
	      String str= new String(b);
	      System.out.println("  dato: "+ str);
          s= f.read(b);
      } 
    

      f.seek(5);                     // si posiziona sul secondo record
      f.write(s4.getBytes() );      // sovrascrive il contenuto del secondo record
      
      f.seek(0);      
      System.out.println("\n\nFILE MODIFICATO:" );
      s = f.read(b);        // legge i dati in b e se s vale -1 è il fine file
      while (s>=0){				
	      String str= new String(b);
	      System.out.println(" dato: "+ str);
          s= f.read(b);
       }
       
       Scanner sc = new Scanner(System.in);
       int sw=sc.nextInt();
       
       switch(sw){
          case 1:
            User tempUser = new User(sc.next(), sc.next(), sc.next());
            f.write(tempUser.getNome().getBytes());
            f.write(tempUser.getCognome().getBytes());
            f.write(tempUser.getIndirizzo().getBytes());
            break;

          case 2:
            
       }
       f.close();

  }// main

}// class