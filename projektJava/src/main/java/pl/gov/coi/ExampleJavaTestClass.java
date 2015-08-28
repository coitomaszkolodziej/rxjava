/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.coi;

import static com.google.common.base.Preconditions.checkArgument;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import pl.gov.coi.queries.insertArtists.InsertArtistsQuery;
 
public class ExampleJavaTestClass extends AbstractJavaSamplerClient implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //set up default arguments for the JMeter GUI
    @Override
        public void setupTest(JavaSamplerContext context){
        // TODO Auto-generated method stub

        super.setupTest(context);
        }
    
    @Override
    public Arguments getDefaultParameters() {
        Arguments defaultParameters = new Arguments();
        //defaultParameters.addArgument("QUERY", Query.INSERT_ARTIST.getSql());
        return defaultParameters;
    }
 
    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        // pull parameters
        SampleResult result = new SampleResult();
        result.sampleStart(); 
        try {
            new InsertArtistsQuery().execute();
            
            //Thread.sleep(100);
            result.setSuccessful(true);
        } catch (SQLException e) {   
            //} catch (FileNotFoundException ex) {
            result.setResponseMessage( "Exception: " + e );}
        //} catch (InterruptedException e) {
       //     result.setResponseMessage( "Exception: " + e );
        result.sampleEnd();
        return result;
    }
    
    /*@Override
        public void teardownTest(JavaSamplerContext context){
            // TODO Auto-generated method stub
            
        super.teardownTest(context);
        }*/
}
