// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
//"Home"-VCS:  git@git.HAW-Hamburg.de:shf/Px/LabExercise/CXZ_CardsLeanVersion[.git]
package cards;


import static cards.Card.*;                             // only for JavaDoc ;-)
//
import java.lang.reflect.Constructor;
import java.util.*;
import stuffBeginnersDontHaveToUnderstand.Herald;
import stuffBeginnersDontHaveToUnderstand.Version;


/* Bemerkung
 * zu unterschiedlichen Sprachen in einer Datei/Klasse und eigentlich sogar in
 * einem Projekt!
 * Es gilt später im Berufsleben (und eigentlich schon vorher/"jetzt"):
 *    Es dürfen niemals unterschiedliche Sprachen gemixt werden!!!
 * 
 * Eigentlich ist Englisch "Die Sprache".
 * 
 * Jedoch diese Klasse taucht früh auf und viele Anfänger schätzen es, die für Sie
 * wichtigen Dinge in deutsch zu lesen. Alles was für Anfänger als Anwender/Klient
 * dieser Klasse wichtig ist, ist in deutsch. Wichtige Kommentare (, die für Anfänger
 * nicht interessant sind, ) sind in englisch.
 * Die Klasse mit dem zugehörigen JavaDoc (und den daraus resultierenden Tooltipps
 * (z.B. unter Eclipse) ist dafür ausgelegt, das Anwender die Klasse nutzen können,
 * ohne in den Source-Code hineinschauen zu müssen.
 */
/**
 * Die Klasse {@link Deck} ist der Datentyp eines 52 Blatt Poker-Karten-<strong>Deck</strong>s.
 * Das 52 Blatt Poker-Karten-Deck besteht aus Spielkarten <em>(bzw. {@link Card})</em>, die<br />
 * die Ränge <em>(bzw. {@link Rank})</em>:<br />
 * &nbsp; &nbsp;<code>2</code>,&nbsp;<code>3</code>,&nbsp; <code>4</code>,&nbsp;&hellip;,&nbsp;<code>ACE</code><br />
 * in den Farben <em>(bzw. {@link Suit})</em>:<br />
 * &nbsp; &nbsp;<code>CLUB</code> (&clubs;), <code>DIAMOND</code> (<font color="red">&diams;</font>), <code>HEART</code> (<font color="red">&hearts;</font>) und <code>SPADES</code> (&spades;)<br />
 * aufweisen.<br />
 * <br />
 * Wichtige Attribute dieser Klasse sind:<br />
 * &bull;{@link #deal()} gibt die &quot;oberste&quot; Karte <em>(bzw. {@link Card})</em> des {@link Deck}s.<br />
 * &bull;{@link #removeTopCard()} zum Entfernen der &quot;obersten&quot; Karte <em>(bzw. {@link Card})</em> des {@link Deck}s.<br />
 * &bull;{@link #shuffleDeck()}} zum Mischen des {@link Deck}s.<br />
 * <br /><br />
 * 
 * First appearance of cards package respectively "Cards - Lean Version" respectively "(Poker) Cards" in WS2007/2008 TI1 P1::=PR1&PT/PTP.<br />
 * (c)&(p) 2007-2031<br />
 * Idea & Implementation : Michael Sch&auml;fers.<br />
 * Except Card::printCardArray : Idea & 1st Implementation : Mark-Andr&eacute Kloesters; (p)2009.<br />
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          P1@Hamburg-UAS.eu 
 * @version {@value #encodedVersion} 
 */
public class Deck {
    //
    //--VERSION:-------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                               #___~version~___YYYY_MM_DD__dd_
    final static private long encodedVersion = 2___00001_002___2023_03_28__01L;
    //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static private Version version = new Version( encodedVersion );
    /**
     * The method {@link #getDecodedVersion()} delivers the code version as reground/readable String.
     * @return version as decoded/readable String.
     */
    static public String getDecodedVersion(){ return version.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung
    
    
    
    
    
    //
    //
    // CONSTANTs----------------------------------------------------------------
    
    private final int expectedDeckSize = 52;
    
    
    
    //
    //
    // VARIABLEs----------------------------------------------------------------
    
    private List<Card> pack1st;
    private List<Card> pack2nd;
    
    
    
    //
    //
    // CONSTRUCTORs-------------------------------------------------------------
    
    /**
     * Der Konstruktor erzeugt ein {@link Deck}.
     * Es werden dabei interne Variablen gesetzt.
     */
    public Deck(){
        // "assert" that the world is as expected - SORRY, this mysterious comment is on purpose
        for (Constructor<?> constructor : Card.class.getDeclaredConstructors()){
            if (0!=constructor.getModifiers()){
                throw new IllegalStateException( String.format( "You have have done strange disturbing things - please call Michael Schaefers" ) );
            }//if
        }//for
        
        pack1st = new LinkedList<Card>();  // cards in game/pack
        pack2nd = new LinkedList<Card>();  // cards out of game/pack
        
        for(Card.Suit suit : Card.Suit.values()){
            for(Card.Rank rank : Card.Rank.values()){
               pack1st.add( new Card( suit, rank ) );
            }//for
        }//for
        assert expectedDeckSize == pack1st.size() : String.format( "INTERNAL PROGRAMMING ERROR : Disturbing deck size -> %d",  pack1st.size());
        
        Collections.shuffle( pack1st );
    }//constructor()
    
    
    
    //
    //
    // METHODs------------------------------------------------------------------
    
    /**
     * Die Methode {@link #shuffleDeck()} mischt die noch verfügbaren Karten <em>(bzw. {@link Card})</em> im {@link Deck}.
     */
    public void shuffleDeck(){
        Collections.shuffle( pack1st );
    }//method()
    
    /**
     * Die Methode {@link #deal()} liefert die &quot;oberste&quot; Karte <em>(bzw. {@link Card})</em> des {@link Deck}s.
     * Sollte keine Karte <em>(bzw. {@link Card})</em> im {@link Deck} vorhanden sein, so wird
     * die Meldung:<br />
     * &nbsp; &nbsp;<code>>>>> ERROR !!! : no more cards in deck - opening new pack</code><br />
     * auf dem Bildschirm ausgegeben
     * und eine neues {@link Deck} &quot;aufgemacht&quot; und diesem die oberste Karte <em>(bzw. {@link Card})</em> entnommen.
     * @return &quot;oberste&quot; Karte <em>(bzw. {@link Card})</em> des {@link Deck}s.
     */
    public Card deal(){
        if (pack1st.isEmpty()){
            StringBuilder sb = new StringBuilder( "\n" );
            sb.append( "#################\n" );
            sb.append( "# >>> ERROR !!! : NO MORE cards in deck !\n" );
            sb.append( "# ATTENTION !!! : As workaround a \"new\" pack containing the OLD cards is opened. There are only 52 cards available.\n" );
            sb.append( "# Hence, the SAME(!) cards are dealt again! But most probably in different order.\n" );
            sb.append( "# Most probably you should avoid this situation!\n" );
            sb.append( "#################\n" );
            sb.append( "\n\n" );
            Herald.proclaimError( sb );
            while(!pack2nd.isEmpty()){
                 pack1st.add( pack2nd.remove(0) );
            }//for
            shuffleDeck();
        }//if
        Card card = pack1st.remove( 0 );
        pack2nd.add( card );
        return card;
    }//method()
    
    /**
     * Die Methode {@link #removeTopCard()} entfernt die &quot;oberste&quot; Karte <em>(bzw. {@link Card})</em> des {@link Deck}s.
     * Sollte keine Karte <em>(bzw. {@link Card})</em> im {@link Deck} vorhanden sein, so wird
     * die Meldung:<br />
     * &nbsp; &nbsp;<code>>>>> ERROR !!! : no more cards in deck</code><br />
     * auf dem Bildschirm ausgegeben.
     */
    public void removeTopCard(){
       if (pack1st.isEmpty()){
           Herald.proclaimError( "\n>>>> ERROR !!! : no more cards in deck\n" );
       }else{
           pack2nd.add( pack1st.remove( 0 ) );
       }//if
    }//method()
    
    @Override
    public String toString(){
        StringBuffer resu = new StringBuffer();        
        for( Card c : pack1st )  resu.append( c );
        return resu.toString();
    }//method()
    
    
    @Override
    public boolean equals( final Object other ) {
        return getClass() == other.getClass()
            && pack1st!=null && ((Deck)other).pack1st!=null && pack1st.equals( ((Deck)other).pack1st )
            && pack2nd!=null && ((Deck)other).pack2nd!=null && pack2nd.equals( ((Deck)other).pack2nd );
    }//method()
    
    @Override
    public int hashCode() {
        final int prime = 31;
        return ((pack1st==null) ? 0 : pack1st.hashCode())  +  prime*((pack2nd==null) ? 0 : pack2nd.hashCode());
    }//method()
    
}//class
