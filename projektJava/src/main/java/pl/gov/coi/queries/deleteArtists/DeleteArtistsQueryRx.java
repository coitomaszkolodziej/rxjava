/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.coi.queries.deleteArtists;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import pl.gov.coi.queries.Executable;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 *
 * @author Praktyki
 */
public class DeleteArtistsQueryRx implements Executable{
    final private DeleteArtistQuery deleteArtistQuery = new DeleteArtistQuery();
    public void execute(){
    for(int j=1;j<=10;j++)
        threads(); 
    }  
    
    private void threads()
    {
        
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        {
        Observable myObservable = Observable.create
        (
            new Observable.OnSubscribe<DeleteArtistQuery>() 
            {
                public void call(Subscriber<? super DeleteArtistQuery> sub) 
                {             
                   // System.out.println(Thread.currentThread().getName());
                    sub.onNext(deleteArtistQuery);
                    sub.onCompleted();
                }
            }       
        );
        
        Subscriber mySubscriber = new Subscriber<DeleteArtistQuery>() 
        {
            public void onNext(DeleteArtistQuery s) 
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
            Thread.sleep(100);                 
          } catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        }
      executorService.shutdown();
      
    }
}
