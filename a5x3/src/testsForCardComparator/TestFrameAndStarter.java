// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package testsForCardComparator;


import static cards.Card.*;
import static cards.Card.Constant.*;
//
import cards.*;
import cards.Card.*;
import java.util.*;


import cardComparator.UsualOrder;
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
        
        //----------------------------------------------------------------------// "MARKIERUNG" ;-)
        // Ab hier dürfen Sie eigene Tests ergänzen
        
        boolean nicosTest = false;
        
        if (nicosTest) {
            
        System.out.println("----- TESTS NICO -----");
       // final Deck deck = new Deck();
        
        Card cardOne = deck.deal();
        Card cardTwo = deck.deal();
        Card cardThree = deck.deal();
        Card cardFour = deck.deal();
        Card cardFive = deck.deal();
        Card cardSix = deck.deal();
        
        
        System.out.println("----- KARTE 1 -----");
        System.out.println("Karte = " + cardOne);
        System.out.println("Rank = " + cardOne.getRank());
        System.out.println("Suit = " + cardOne.getSuit());
        
        System.out.println("----- KARTE 2 -----");
        System.out.println("Karte = " + cardTwo);
        System.out.println("Rank = " + cardTwo.getRank());
        System.out.println("Suit = " + cardTwo.getSuit());
        
        System.out.println("----- KARTE 3 -----");
        System.out.println("Karte = " + cardThree);
        System.out.println("Rank = " + cardThree.getRank());
        System.out.println("Suit = " + cardThree.getSuit());
        
        System.out.println("----- KARTE 4 -----");
        System.out.println("Karte = " + cardFour);
        System.out.println("Rank = " + cardFour.getRank());
        System.out.println("Suit = " + cardFour.getSuit());
        
        System.out.println("----- KARTE 5 -----");
        System.out.println("Karte = " + cardFive);
        System.out.println("Rank = " + cardFive.getRank());
        System.out.println("Suit = " + cardFive.getSuit());
        
        System.out.println("----- KARTE 6 -----");
        System.out.println("Karte = " + cardSix);
        System.out.println("Rank = " + cardSix.getRank());
        System.out.println("Suit = " + cardSix.getSuit());
        
        
        System.out.println("----- Liste -----");

        List<Card> cardList = new ArrayList<>();
        cardList.add(cardOne);
        cardList.add(cardTwo);
        cardList.add(cardThree);
        cardList.add(cardFour);
        cardList.add(cardFive);
        cardList.add(cardSix);
        
        System.out.println(cardList.toString());
        
        
        Rank cardOneRank = cardOne.getRank();
        int cardOneRankVal = cardOneRank.value();
        int cardOneRankOrdi = cardOneRank.ordinal();
                
        Suit cardOneSuit = cardOne.getSuit();
        int cardOneSuiOrdi = cardOneSuit.ordinal();
        
        System.out.printf(""
                + "Karte ist: %s\n"
                + "Rank ist: %s \n"
                + "Value von Rank ist: %d \n"
                + "Ordinal von Rank ist: %d \n"
                + "Suit ist: %s \n"
                + "Ordinal von Suite ist: %s \n", 
                cardOne, cardOneRank, cardOneRankVal, cardOneRankOrdi, cardOneSuit, cardOneSuiOrdi );

        
        System.out.println("----- Sortieren -----");
        
//       final Comparator<Card> usualOrder = new cardComparator.UsualOrder();
       Collections.sort( cardList, usualOrder );

       System.out.println(cardList.toString());

        }
        
    }//method()
    
}//class
