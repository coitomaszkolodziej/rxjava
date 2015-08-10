package aaa;

import aaa.GetArtistsID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import pakiet.DBConnection;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class Java implements Interface
{
    public Java(){}
    
    
    public void groupArtistQuery()
    {
        try
        {
            Connection conn = DBConnection.getConnection();
            String q = new String("UPDATE artists SET (artist_name)=('ASD') WHERE artist_id BETWEEN 0 and 100" );
            
            PreparedStatement ps = conn.prepareStatement(q);
            ps.executeQuery();
            //System.out.println("Grupowanie udane.");
        }
        catch(SQLException e){}
        catch(ClassNotFoundException e){}
    }
    
    
    public LinkedList<GetArtistsID> getArtistsQuery()
    {  
        LinkedList<GetArtistsID> list = new LinkedList<GetArtistsID>();
        try
        {
        Connection conn = DBConnection.getConnection();
        
                String q = new String("SELECT artist_id FROM artists ");
                PreparedStatement ps = conn.prepareStatement(q);
                ResultSet rs = ps.executeQuery();
                
                while(rs.next())
                {
                    list.add(new GetArtistsID(rs.getInt(1)));
                }        
        }
        catch(SQLException e){}
        catch(ClassNotFoundException e){}
        return list;
    }
    
    
    public void insertArtistsQuery(int i)
    {
        int j=0;
        try
        {
         Connection conn = DBConnection.getConnection();
         String st = new String("SELECT * FROM artists");
                PreparedStatement ps1 = conn.prepareStatement(st);
                ResultSet rs = ps1.executeQuery();
                
         String namesPath=null,surnamesPath=null;
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         try
         {
            System.out.print("Podaj œcie¿ke do pliku z imionami.");
            namesPath=br.readLine();
            if(namesPath.length()==0)
            {
                namesPath="C:\\Users\\Praktyki\\Desktop\\InputData\\names.txt";
            }       
         }
         catch(IOException e){}
         
         try
         {
            System.out.print("Podaj œcie¿ke do pliku z nazwiskami.");
            surnamesPath=br.readLine();
            if(surnamesPath.length()==0)
            {
                surnamesPath="C:\\Users\\Praktyki\\Desktop\\InputData\\surnames.txt";
            }       
         }
         catch(IOException e){}

         while (rs.next())
         {
           j=j+1;  //zliczanie rekordow w tabeli
         }
         System.out.println("W tabeli artists by³o "+j+" rekordow. Dodano dodatkowe "+i+".");
         
         for(int k=(j+1);k<=(j+i);k++)
         {    
            String q = new String("INSERT INTO artists (artist_id, artist_name, artist_surname, artist_age)\n" +
                                   "VALUES (?,?,?,?)");
            
            Random rand = new Random();
            int wiek = rand.nextInt((80-20) + 1) + 20;
            
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setInt(1, k);
            
            
                    try
                    {  
                        BufferedReader reader = new BufferedReader(new FileReader(namesPath));
                        List<String> imiona = new ArrayList<String>();

                        String imie = reader.readLine();

                        while( imie != null ) 
                        {
                            imiona.add(imie);
                            imie = reader.readLine();
                        }
                        Random r = new Random();
                        String randomName = imiona.get(r.nextInt(imiona.size()));
                        ps.setString(2,randomName);
                    }
                    catch(FileNotFoundException e){}
                    catch(IOException e){}
            
                    
                    try
                    {  
                        BufferedReader reader = new BufferedReader(new FileReader(surnamesPath));
                        List<String> nazwiska = new ArrayList<String>();

                        String nazwisko = reader.readLine();

                        while( nazwisko!= null ) 
                        {
                            nazwiska.add(nazwisko);
                            nazwisko = reader.readLine();
                        }
                        Random r = new Random();
                        String randomSurname = nazwiska.get(r.nextInt(nazwiska.size()));
                        ps.setString(3,randomSurname);
                    }
                    catch(FileNotFoundException e){}
                    catch(IOException e){}
                    
            //ps.setString(2, "imie");
            //ps.setString(3, "nazwisko");
            ps.setInt(4, wiek);
            ps.execute();
            ps.close();
         }
         System.out.println("Dodawanie "+i+" rekordow do tabeli udane.\n W tabeli teraz jest "+(j+i)+" rekordow.");
         conn.close();
         ps1.close();
        }
        
        catch(SQLException e){}
        catch(ClassNotFoundException e){}
    }
    
    
    public void deleteArtistsQuery(int i,int k)
    {
        try
        {
        Connection conn = DBConnection.getConnection();
            for(int j=i;j<=(i+k);j++)
            {
                String q = new String("DELETE FROM artists\n" +
                                   "WHERE artist_id=?");
            
                PreparedStatement ps = conn.prepareStatement(q);
                ps.setInt(1, j);
           
                ps.execute();
                ps.close();
            }
            System.out.println("Usuwanie "+k+" rekordow z tabeli udane.");
            conn.close();
            }
        catch(SQLException e){}
        catch(ClassNotFoundException e){}
    }
    
    
    public void updateArtistQuery(int j)
    {
        int i=0,indeks,wiekRandom;
        String st = new String("SELECT * FROM artists");
        String q = new String("UPDATE artists SET (artist_name,artist_age)=(?,?) WHERE artist_id=?");
        
        String namesPath=null;
        String imie,randomName;
        
        BufferedReader br,reader;
        Random r,rand,rand1;

        List<String> imiona = new ArrayList<String>();
        
        PreparedStatement ps;
        
        try
        {
        Connection conn = DBConnection.getConnection();

            PreparedStatement ps1 = conn.prepareStatement(st);
            ResultSet rs = ps1.executeQuery();
            
            br = new BufferedReader(new InputStreamReader(System.in));
            
            while (rs.next())
            {
                i=i+1;  //zliczanie rekordow w tabeli
            }
            
            try
            {
               System.out.print("Podaj œcie¿ke do pliku z imionami.");
               namesPath=br.readLine();
               if(namesPath.length()==0)
               {
                   namesPath="C:\\Users\\Praktyki\\Desktop\\InputData\\names.txt";
               }       
            }
            catch(IOException e){}
            
            for(int k=0;k<j;k++)
            {
                rand = new Random();
                indeks = rand.nextInt((i-0) + 1) + 0;

                    ps = conn.prepareStatement(q);
                    
                            try
                            {  
                                reader = new BufferedReader(new FileReader(namesPath));
                               
                                imie = reader.readLine();

                                while( imie != null ) 
                                {
                                    imiona.add(imie);
                                    imie = reader.readLine();
                                }
                                r = new Random();
                                randomName = imiona.get(r.nextInt(imiona.size()));
                                ps.setString(1,randomName);
                            }
                            catch(FileNotFoundException e){}
                            catch(IOException e){}
                    
                    rand1 = new Random();
                    wiekRandom = rand1.nextInt((80-20) + 1) + 20; 
                    
                    ps.setInt(2,wiekRandom);
                    
                    ps.setInt(3, indeks);

                    ps.execute();
                    ps.close();
            }
            conn.close();
            }
        catch(SQLException e){}
        catch(ClassNotFoundException e){} 
    }
    
    
    public void deleteAllArtists()
    {
        int j=0;
        try
        {
        Connection conn = DBConnection.getConnection();
        String st = new String("SELECT * FROM artists");
                PreparedStatement ps1 = conn.prepareStatement(st);
                ResultSet rs = ps1.executeQuery();
                
         while (rs.next())
         {
           j=j+1;  //zliczanie rekordow w tabeli
         }
         
         String q = new String("DELETE FROM artists");
         PreparedStatement ps = conn.prepareStatement(q);
           
         ps.execute();
         ps.close();
         
         System.out.println("Usunieto wszystkie rekordy z tabeli.");
         conn.close();
        }
        catch(SQLException e){}
        catch(ClassNotFoundException e){}
    }
}
