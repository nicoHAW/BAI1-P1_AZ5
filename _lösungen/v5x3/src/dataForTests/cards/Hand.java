// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package dataForTests.cards;


import java.util.Arrays;
import stuffBeginnersDontHaveToUnderstand.Version;


/**
 * Just a plain simple (Card-)Hand to support tests of Map
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          Px@Hamburg-UAS.eu
 * @version {@value #encodedVersion}
 */
public class Hand {
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
    
    
    
    
    
    final private Card[] handCards;
    
    
    
    /**
     * The constructor initializes the hand with given cards
     * 
     * @param cards  given cards for initialization
     */
    public Hand( final Card... cards ){
        assert isNullFree( cards ) : "Illegal Argument";
        this.handCards = cards;
    }//constructor()
    //
    // Die Hilfsmethode ist Zustanfsfrei. Sie greift NICHT auf den Objekt-Zustand zu => static
    static private boolean isNullFree( final Card... handCards ){
        if( null == handCards )  return false;
        for( final Card card : handCards ){
            if( null == card )  return false;
        }//for
        return true;
    }//method()
    
    
    
    
    @Override
    public boolean equals( final Object otherObject ){
        if( this == otherObject )  return true;
        if( null == otherObject )  return false;
        if( getClass() != otherObject.getClass() )  return false;
        
        final Hand otherHand = (Hand)( otherObject );
        if( ! Arrays.equals( handCards, otherHand.handCards ))  return false;
        return true;
    }//method()
    
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(handCards);
    }//method()
    
    @Override
    public String toString(){
        return String.format(
            "[<%s>: %s ]",
            Hand.class.getSimpleName(),
            Arrays.toString( handCards )
        );
    }//method()
    
}//class
