/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.coi.queries.getArtists;

import java.sql.SQLException;
import pl.gov.coi.queries.Executable;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 *
 * @author Praktyki
 */
public class GetArtistsQueryRx implements Executable{
    final private GetArtistQuery getArtistQuery = new GetArtistQuery();
    public void execute() throws SQLException 
    {   
        for(int j=1;j<=100;j++)
            threads();
    }
    
    private void threads()
    {
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        {
        Observable myObservable = Observable.create
        (
            new Observable.OnSubscribe<GetArtistQuery>() 
            {
                public void call(Subscriber<? super GetArtistQuery> sub) 
                {             
                    System.out.println(Thread.currentThread().getName());
                    sub.onNext(getArtistQuery);
                    sub.onCompleted();
                }
            }       
        );
        
        Subscriber mySubscriber = new Subscriber<GetArtistQuery>() 
        {
            public void onNext(GetArtistQuery s) 
            { 
                try {        
                    s.execute();
                 } catch (SQLException ex) { System.out.println(ex); }
            }
            public void onCompleted() {            
            }
            public void onError(Throwable e) {System.out.println(e); } 
        };
      //myObservable.subscribe(mySubscriber);       
      try {
          myObservable.
                  subscribeOn(Schedulers.io()).
                    //observeOn(Schedulers.from(executorService)).
                    observeOn(Schedulers.trampoline()).
                        subscribe(mySubscriber);
            Thread.sleep(2);  
            //executorService.shutdown();
          } catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        }
      
    }  
}
