package pl.gov.coi.queries;


import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rx.*;
import rx.schedulers.Schedulers;



/**
 * @author Tomasz Ko³odziej
 */
public class InsertArtistsQueryRx implements Executable { 
    final private InsertArtistQuery insertArtistQuery = new InsertArtistQuery();
    public void execute() throws SQLException 
    {   
        /*
        Powinno robic dokladnie to samo co InsertArtistsQuery ale w roznych watkach (rxJava)
         */
        for(int j=1;j<=100;j++)
            threads();
    }
    
    private void threads()
    {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        {
        Observable myObservable = Observable.create
        (
            new Observable.OnSubscribe<InsertArtistQuery>() 
            {
                public void call(Subscriber<? super InsertArtistQuery> sub) 
                {             
                    System.out.println(Thread.currentThread().getName());
                    sub.onNext(insertArtistQuery);
                    sub.onCompleted();
                }
            }       
        );
        
        Subscriber mySubscriber = new Subscriber<InsertArtistQuery>() 
        {
            public void onNext(InsertArtistQuery s) 
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
                    observeOn(Schedulers.from(executorService)).
                    //observeOn(Schedulers.io()).
                        subscribe(mySubscriber);
            Thread.sleep(2);                 
          } catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        }
      executorService.shutdown();
    }  
}
