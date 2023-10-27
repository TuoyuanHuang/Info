import java.sql.*;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class App {
    static final String DB_URL = "jdbc:mysql://localhost/alunni";
    static final String USER = "root";				 	//  Database credentials
    static final String PASS = "";				
    
    public static void main(String[] args) {
        System.out.println("INIZIO PROGRAMMA");
        Scanner sc = new Scanner(System.in);

       Connection conn = null;
       Statement stmt = null;
       try {
          Class.forName("com.mysql.jdbc.Driver");			// Carica in memoria il driver JDBC 		
          conn = DriverManager.getConnection(DB_URL, USER, PASS);	// Apre una connessione
          
          
          int s = 0;
          while(s!=99){
               System.out.println("1: Insert");
               System.out.println("2: View");
               System.out.println("3: Update");
               System.out.println("4: Delete");
               System.out.println("5: Contare il numero di alunni con età maggiore di un certo valore( letto da tastiera)");
               System.out.println("6: visualizzare l'età media");
               System.out.println("7: Visualizzare gli alunni più vecchi");
               System.out.println("8: Visualizzare gli alunni che hanno nel nome una sequenza data ");
               System.out.println("9: Aumentare l'età di tutti gli alunni di un anno");
               System.out.println("10: Copiare nella tabella AlunniBack tutti i dati della tabella Alunni");
               System.out.println("11: Spostare nella tabella AlunniOld tutti gli alunni di una certa età");
               System.out.println("99: Exit");
               s = sc.nextInt();
               switch(s){
                    case 1:
                    //INSERT
                         int id = sc.nextInt();
                         String cognome = sc.next();
                         String nome = sc.next();
                         int eta = sc.nextInt();
                         stmt = conn.createStatement();				   
                         String sql = "INSERT INTO alunno (id, cognome, nome, eta)  VALUES ('"+id+"','"+ cognome +"','"+nome+"','"+eta+"')"; //dove va il doppio apice ("") in SLQ va solo quello singolo('')
                         int result = stmt.executeUpdate(sql);				// Esegue una insert
                         if (result > 0) System.out.println("inserito con successo"); 
                         else            System.out.println("Non inserito "); 
                         break;
                    
                    case 2:
                    //SHOW
                         System.out.println("inserisci la tavola che vuoi visualizzare");
                         String showDB= sc.next();
                         stmt = conn.createStatement();				   
                         String sqlShow = "SELECT * FROM "+showDB; //dove va il doppio apice ("") in SLQ va solo quello singolo('')
                         ResultSet rs = stmt.executeQuery(sqlShow);				
                         while(rs.next()){
                              System.out.print("ID: " + rs.getInt("id"));
                              System.out.print(", cognome: " + rs.getString("cognome"));
                              System.out.print(", nome: " + rs.getString("nome"));
                              System.out.println(", eta: " + rs.getString("eta"));
                         }
                         break;
                    
                    case 3:
                    //UPDATE SINGOLO
                         System.out.println("ID di chi aggiornare");
                         int updatedId= sc.nextInt();
                         System.out.println("cognome");
                         String updatedCognome = sc.next();
                         System.out.println("nome");
                         String updatedNome = sc.next();
                         System.out.println("eta");
                         int updatedEta = sc.nextInt();
                         stmt = conn.createStatement();				   
                         String sqlUpdate = "UPDATE alunno SET cognome = '"+updatedCognome+"', nome = '"+updatedNome+"', eta = '"+updatedEta+"' WHERE id in ('"+updatedId+"')"; //dove va il doppio apice ("") in SLQ va solo quello singolo('')
                         stmt.executeUpdate(sqlUpdate);				// Esegue una insert
                         break;

                    case 4:
                    //DROP
                         System.out.println("inserisci l'id dell'alunno da eliminare");
                         String dropTable= sc.next();
                         stmt = conn.createStatement();				   
                         String sqlDrop = "DELETE FROM alunno WHERE id = '"+dropTable+"'"; //dove va il doppio apice ("") in SLQ va solo quello singolo('')
                         stmt.executeUpdate(sqlDrop);			
                         break;

                    case 5:
                         //count alumni 
                         System.out.println("visualizza alunni con eta' maggiore a: ");
                         int etaM = sc.nextInt();
                         stmt = conn.createStatement();
                         String sqlViewMoreThan = ("SELECT * FROM alunno WHERE eta = '"+etaM+"'");	
                         ResultSet older = stmt.executeQuery(sqlViewMoreThan);				// Esegue una insert
                         while(older.next()){
                              System.out.print("ID: " + older.getInt("id"));
                              System.out.print(", cognome: " + older.getString("cognome"));
                              System.out.print(", nome: " + older.getString("nome"));
                              System.out.println(", eta: " + older.getString("eta"));
                         }	
                         break;
                         
                    case 6:
                         //avrg age
                         stmt = conn.createStatement();
                         System.out.print("l'eta' media e' di: ");
                         String sqlAverage = ("SELECT AVG(eta) FROM alunno");
                         ResultSet average = stmt.executeQuery(sqlAverage);
                         while(average.next()){
                              System.out.println("eta: " + average.getFloat(1)); //invoke il primo valore del result set
                         }
                         
                    case 7:
                         //older than
                         System.out.println("visualizzare gli alunni piu' vecchi: ");
                         stmt = conn.createStatement();
                         int old = sc.nextInt();
                         String olderThan = ("SELECT * FROM alunno WHERE eta > '"+old+"'");
                         ResultSet rsOld = stmt.executeQuery(olderThan);
                         while(rsOld.next()) {
                              System.out.print("ID: " + rsOld.getInt("id"));
                              System.out.print(", cognome: " + rsOld.getString("cognome"));
                              System.out.print(", nome: " + rsOld.getString("nome"));
                              System.out.println(", eta: " + rsOld.getString("eta"));
                         }
                    
                    case 8:
                         //name like
                         System.out.println("visualizzare gli alunni piu' vecchi: ");
                         stmt = conn.createStatement();
                         String name = sc.next();
                         String nameLike = ("SELECT * FROM alunno WHERE (lower(nome) LIKE '%"+name+"%')");
                         ResultSet rsNameLike = stmt.executeQuery(nameLike);
                         while(rsNameLike.next()) {
                              System.out.print("ID: " + rsNameLike.getInt("id"));
                              System.out.print(", cognome: " + rsNameLike.getString("cognome"));
                              System.out.print(", nome: " + rsNameLike.getString("nome"));
                              System.out.println(", eta: " + rsNameLike.getString("eta"));
                         }

                    case 9:
                         //age grow
                         stmt = conn.createStatement();
                         String grow1 = ("UPDATE alunno SET eta = eta+1 ");
                         int growResult = stmt.executeUpdate(grow1);
                         if(growResult>0){System.out.println("grow con sucesso");}

                    case 10:
                         //backup
                         stmt = conn.createStatement();
                         String backup = ("INSERT INTO alunniBackup SELECT * FROM alunno");
                         stmt.executeUpdate(backup);

                    case 11:
                         //moveOlder
                         stmt = conn.createStatement();
                         String moveOlder = ("INSERT INTO alunniBackup SELECT * FROM alunno WHERE eta > 30");
                         stmt.executeUpdate(moveOlder);
                         String deleteOlder = ("DELETE FROM alunno WHERE eta > 30");
                         stmt.executeUpdate(deleteOlder);
               }
          }
          } 
          catch (Exception e) {
               e.printStackTrace();            					// Gestione errori 
          }

     }

}
