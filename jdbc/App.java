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
          
          System.out.println("1: Insert");
          System.out.println("2: View");
          System.out.println("3: Update");
          System.out.println("4: Delete");
          System.out.println("9: Exit");
          int s = sc.nextInt();
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
                    String showDB= sc.next();
                    stmt = conn.createStatement();				   
                    String sqlShow = "SELECT * FROM "+showDB; //dove va il doppio apice ("") in SLQ va solo quello singolo('')
                    ResultSet rs = stmt.executeQuery(sqlShow);				// Esegue una insert
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
                    String sqlUpdate = "UPDATE alunno SET cognome = "+updatedCognome+", nome = "+updatedNome+", eta = "+updatedEta+" WHERE id in ("+updatedId+")"; //dove va il doppio apice ("") in SLQ va solo quello singolo('')
                    stmt.executeUpdate(sqlUpdate);				// Esegue una insert
                    break;

               case 4:
               //DROP
                    String dropTable= sc.next();
                    stmt = conn.createStatement();				   
                    String sqlDrop = "DROP TABLE "+dropTable; //dove va il doppio apice ("") in SLQ va solo quello singolo('')
                    stmt.executeUpdate(sqlDrop);			
                    break;

               case 9:
                    stmt.close();						  
                    conn.close();
                    break;
          }
          
       } 
       catch (Exception e) {
            e.printStackTrace();            					// Gestione errori 
       }

    }
}
