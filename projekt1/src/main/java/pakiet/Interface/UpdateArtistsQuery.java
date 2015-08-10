/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakiet.Interface;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import pakiet.DBConnection;

/**
 *
 * @author Praktyki
 */
public class UpdateArtistsQuery implements Executable{
    
    public void execute(Query query, List<Object> parameters) {
        
        //To change body of generated methods, choose Tools | Templates.
       
        
        try
        {
            
            PreparedStatement q;
            q = QueryHelper.getPreparedStatement(query, parameters);
            
            
                        int i=0,indeks,wiekRandom;
                        String st = new String("SELECT * FROM artists");

                        String namesPath="C:\\Users\\Praktyki\\Desktop\\InputData\\names.txt";
                        String imie,randomName;

                        BufferedReader br,reader;
                        Random r,rand,rand1;

                        List<String> imiona = new ArrayList<String>();

                        //PreparedStatement ps;

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

                            for(int k=1;k<500;k++)
                            {
                                rand = new Random();
                                indeks = rand.nextInt((i-0) + 1) + 0;

                                    //ps = conn.prepareStatement(q);

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
                                                q.setString(1,randomName);
                                            }
                                            catch(FileNotFoundException e){}
                                            catch(IOException e){}

                                    rand1 = new Random();
                                    wiekRandom = rand1.nextInt((80-20) + 1) + 20; 

                                    q.setInt(2,wiekRandom);

                                    q.setInt(3, indeks);
                                    q.executeUpdate();       
                                    q.close();
                            }
                        }
                        catch(SQLException e){}                  
        }    
        catch(ClassNotFoundException e){} 
    }
}
