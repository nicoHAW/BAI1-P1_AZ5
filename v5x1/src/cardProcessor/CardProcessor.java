// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package cardProcessor;


import static cards.Card.*;
//
import cards.*;
import java.util.*;
import stuffBeginnersDontHaveToUnderstand.Version;



/**
 * Example/Demo :  Draw N cards of same colour - see task
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          Px@Hamburg-UAS.eu
 * @version {@value #encodedVersion}
 */
public class CardProcessor {
    //
    //--VERSION:-------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                               #___~version~___YYYY_MM_DD__dd_
    final static private long encodedVersion = 2___00002_001___2023_05_18__01L;
    //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static private Version version = new Version( encodedVersion );
    /**
     * The method {@link #getDecodedVersion()} delivers the code version as reground/readable String.
     * @return version as decoded/readable String.
     */
    static public String getDecodedVersion(){ return version.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung.
    
    
    
    
    
    /**
     * Ziehe solange Karten vom gegebenen Kartenstapel, bis Du "requestedNumber" Karten gleicher Farbe hast
     * und gib diese danach(!) aus.
     * Es wird vorausgesetzt, dass "genügend" viele Karten im Kartenstapel sind.
     * Optional gib (zur Kontrolle) jede Karte, die Du gerade gezogen hast, sofort(!) aus.
     * Auch wenn die Kontrollausgabe aktiviert ist, sollen die "requestedNumber" Karten gleicher Farbe
     * nachdem(!) sie gezogen wurden, ausgegeben werden.
     * 
     * @param deck             der Kartenstapel dem die Karten zu entnehmen sind
     * @param requestedNumber  gewünschte Anzahl Karten gleicher Farbe
     * @param dbgOutputEnable  true schaltet Kontrolausgabe an und false aus.
     */
    public void drawSameColour( final Deck deck, final int requestedNumber, final boolean dbgOutputEnable ){
        
        final int maxNumberOfCardsOfSameSuit = 13;
        assert 0<=requestedNumber && requestedNumber <= maxNumberOfCardsOfSameSuit : "parameter NOT supported, since unreasonable";
        
        
        // prepare data structure
        //
        final Map<Suit,List<Card>> lastCardsMap = new HashMap<Suit,List<Card>>();
        // Obige Zeile folgt konsequent der Idee "Gegen ein Interface zu implementieren"
        // indem auch auf der RECHTEN Seite der Zuweisung das GENERIC "List<...>" auftaucht.
        // Es besteht KEIN Grund schon jetzt einen konkreten Typ für "List<...>"
        // (auf der rechten Seite) anzugeben, da noch KEIN "konkretes Objekt" erzeugt wird.
        
        
        // start actual action
        // draw cards until having got requested number of cards of same suit
        List<Card> suitList;
        do{
            final Card card = deck.deal();
            if( dbgOutputEnable )  System.out.printf( "%s", card );             // print each card if requested
            
            final Suit suit = card.getSuit();
            suitList = lastCardsMap.get( suit );
            if( null==suitList ){
                suitList = new ArrayList<Card>();
                lastCardsMap.put( suit, suitList );
            }//if
            suitList.add( card );
        }while( suitList.size() < requestedNumber );
        if( dbgOutputEnable)  System.out.printf( "\n" );                        // newline, if printing of each card was requested
        
        // print all cards
        for( final Card card : suitList ){
            System.out.printf( "%s", card );
        }//for
        System.out.printf( "\n" );
        
    }//method()
    
}//class
