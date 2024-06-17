// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package testsForCardComparator;


import static cards.Card.*;
import static cards.Card.Constant.*;
//
import cards.*;
import cards.Card.*;
import java.util.*;
//import cardComparator.UsualOrder;
import stuffBeginnersDontHaveToUnderstand.EnvironmentAnalyzer;
import stuffBeginnersDontHaveToUnderstand.GivenCodeVersion;
import stuffBeginnersDontHaveToUnderstand.Version;


/**
 * Die Klasse {@link TestFrameAndStarter} testet die Lösung zu "Sort with help of Comparator" - siehe Aufgabenstellung.
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          P1@Hamburg-UAS.eu 
 * @version {@value #encodedVersion} 
 */
public class TestFrameAndStarter {
    //
    //--VERSION:-------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                               #___~version~___YYYY_MM_DD__dd_
    final static private long encodedVersion = 2___00002_001___2023_04_29__01L;
    //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static private Version version = new Version( encodedVersion );
    static public String getDecodedVersion(){ return version.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung
    
    
    
    
    
    /**
     * Die Methode {@link #main() testet die Lösung zu "usual order".
     * Diese Methode darf bis zur "Markierung" NICHT geändert werden
     * außer, dass Sie "den Kommentar vor den letzten Statements" entfernen müssen.
     * Wohl aber dürfen Sie am Ende/nach der Markierung eigene Tests ergänzen.
     * 
     * @param unused wird nicht genutzt, aber "von Java eingefordert".
     */
    public static void main( final String... unused ){
        
        // print some information at start
        System.out.printf( "TestFrame information\n" );
        System.out.printf( "=====================\n" );
        System.out.printf( "\n" );
        //
        System.out.printf( "Release:\n" );
        System.out.printf( "    GivenCode version:      %s\n",  GivenCodeVersion.getDecodedVersion() );
        System.out.printf( "    Card version:           %s\n",  Card.getDecodedVersion() );
        System.out.printf( "    Deck version:           %s\n",  Deck.getDecodedVersion() );
        System.out.printf( "\n" );
        //
        System.out.printf( "Environment:\n" );
        System.out.printf( "    #Cores:                 %d\n",  EnvironmentAnalyzer.getAvailableCores() );
        System.out.printf( "    Java:                   %s\n",  EnvironmentAnalyzer.getJavaVersion() );
        System.out.printf( "    assert enabled?:        %s\n",  EnvironmentAnalyzer.isAssertEnabled() );
        System.out.printf( "    UTF-8 configured?:      %s      <- check output\n",  "[ÄËÏÖÜẞäëïöüß␣🙂😉🙁😟😓😎☠]" );
        System.out.printf( "\n\n\n\n" );
        //
        System.out.printf( "Start of actual demo\n" );
        System.out.printf( "vvvvvvvvvvvvvvvvvvvv\n" );
        System.out.printf( "\n\n" );
        //
        System.out.flush();
        
        
        
        
        
        // Anfang des eigentlichen Tests
        //==============================
        
        /*
        final Deck deck = new Deck();
        final int randomNumber = 1+ (int)( 52*Math.random() );
        final List<Card> list = new ArrayList<Card>();
        for( int stillToDO=randomNumber; --stillToDO>=0; ){
            list.add( deck.deal() );
        }//for
        
        final Comparator<Card> usualOrder = new UsualOrder();
        System.out.println( list );
        Collections.sort( list, usualOrder );
        System.out.println( list );
        */
        //----------------------------------------------------------------------// "MARKIERUNG" ;-)
        // Ab hier dürfen Sie eigene Tests ergänzen
        
    }//method()
    
}//class
