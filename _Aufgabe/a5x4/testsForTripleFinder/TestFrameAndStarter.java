// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package testsForTripleFinder;


import cards.*;
import stuffBeginnersDontHaveToUnderstand.EnvironmentAnalyzer;
import stuffBeginnersDontHaveToUnderstand.GivenCodeVersion;
import stuffBeginnersDontHaveToUnderstand.Version;
//import tripleFinder.CardProcessor;
import tripleFinder.CardProcessor_I;


/**
 * Die Klasse {@link TestFrameAndStarter} testet die Lösung zu CardProcessor/TripleFinder - siehe Aufgabenstellung.
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          P1@Hamburg-UAS.eu 
 * @version {@value #encodedVersion} 
 */
 public class TestFrameAndStarter {
     //
     //--VERSION:-------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv
     //  ========                               #___~version~___YYYY_MM_DD__dd_
     final static private long encodedVersion = 2___00002_003___2023_05_19__01L;
     //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
     final static private Version version = new Version( encodedVersion );
     static public String getDecodedVersion(){ return version.getDecodedVersion(); }
     // Obiges (ab VERSION) dient nur der Versionierung
     
     
     
     
     
     /**
      * Die Methode {@link #main() testet die Lösung zur Aufgabe "TripleFinder" - siehe Aufgabenstellung.
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
        final boolean dbgOutputEnable = true;
        
        
        System.out.printf( "ACHTUNG!: Es folgen zufallsbasierte Tests.\n" );
        System.out.printf( "\n\n" );
        
        
        System.out.printf( "Test1: Ziehe solange Karten bis der 1.Drilling aufgetreten ist.\n" );
        System.out.printf( "======\n" );
        final CardProcessor_I cp = new CardProcessor();
        Deck deck = new Deck();
        Object result;
        do{
            final Card card = deck.deal();
            if( dbgOutputEnable )  System.out.printf( "%s",  card );
            result = cp.process( card );
        }while( null == result );
        if( dbgOutputEnable )  System.out.printf( "\n==>> " );
        System.out.printf( "%s\n", result );
        System.out.printf( "\n\n" );
        
        
        System.out.printf( "Test2:\n" );
        System.out.printf( "======\n" );
        cp.reset();
        System.out.printf( " -- \"reset()\" ---\n" );
        System.out.printf( "Ziehe solange Karten bis der 1.Drilling aufgetreten ist, aber NICHT mehr als 13 Karten.\n" );
        deck = new Deck();
        result = null;
        int stillToDo=13;
        while( null==result  &&  --stillToDo>=0 ){
            final Card card = deck.deal();
            if( dbgOutputEnable )  System.out.printf( "%s",  card );
            result = cp.process( card );
        }//while
        if( dbgOutputEnable )  System.out.printf( "\n==>> " );
        System.out.printf( "%s\n", result );
        System.out.printf( "\n\n" );
        
        
        System.out.printf( "Test3:\n" );
        System.out.printf( "======\n" );
        cp.reset();
        System.out.printf( " -- \"reset()\" ---\n" );
        System.out.printf( "Ziehe solange Karten bis der 1.Drilling aufgetreten ist.\n" );
        result = null;
        while( null==result ){
            final Card card = deck.deal();
            if( dbgOutputEnable )  System.out.printf( "%s",  card );
            result = cp.process( card );
        }//while
        if( dbgOutputEnable )  System.out.printf( "\n==>> " );
        System.out.printf( "%s\n", result );
        */
        //----------------------------------------------------------------------// "MARKIERUNG" ;-)
        // Ab hier dürfen Sie eigene Tests ergänzen
        
    }//method()
    
}//class
