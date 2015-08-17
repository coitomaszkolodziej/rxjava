package pl.gov.coi.queries;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import rx.*;
import rx.Scheduler;
import rx.schedulers.Schedulers;



/**
 * @author Tomasz Ko³odziej
 */
public class InsertArtistsQueryRx implements Executable {
    Scheduler scheduler=Schedulers.io();
    public void execute() throws SQLException 
    {
        /*
        Powinno robic dokladnie to samo co InsertArtistsQuery ale w roznych watkach (rxJava)
         */
        Observable myObservable = Observable.create
        (
            new Observable.OnSubscribe<String>() 
            {
                public void call(Subscriber<? super String> sub) 
                {
                                   
                    sub.onNext("1");
                    sub.onCompleted();
                }
            }       
        );
        
        Subscriber mySubscriber = new Subscriber<String>() 
        {
            public void onNext(String s) 
            { 
                System.out.println(s);
            }
            public void onCompleted() {
                try {
                    new InsertArtistQuery().execute();
                    System.out.println("2");
                } catch (SQLException ex) { System.out.println(ex); }
            }
            public void onError(Throwable e) {System.out.println(e); } 
        };
      //myObservable.subscribe(mySubscriber);
      myObservable.subscribeOn(Schedulers.io()).subscribe(mySubscriber);      
    }
}
