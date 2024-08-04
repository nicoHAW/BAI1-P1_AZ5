// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
//"Home"-VCS:  git@git.HAW-Hamburg.de:shf/Px/LabExercise/CXZ_CardsLeanVersion[.git]
package cards;


import stuffBeginnersDontHaveToUnderstand.Version;


/* ----------------------------------------------------------------------------
 * KNOWN PROBLEMS: 130114: JavaDoc has problem with inner classes : "bug_id=4464323" resp. "http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4464323"
 * 
 * NOTEs:          This class was decided to be implemented as class on purpose.
 *                 An enum is avoided since the "natural order" of an enum is explicitly NOT wanted.
 * 
 * OPEN POINTS:    Should all be removed in the final version, anyway they have been
 *                 marked with:__???__<YYMMDD>  (search/grep for__???__)
 *                 Currently there is only "bug_id=4464323" (see above)
 * -----------------------------------------------------------------------------
 * 
 * Bemerkung
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
 * 
 * 
 * Schließlich:
 * Diese Klasse ist für Poker (konkret Texas Hold’em) zugeschnitten!
 * Um es Anfängern leichter zu machen, sind viele Dinge in dieser Klasse zusammengefasst worden,
 * die in einem guten Software-Entwurf getrennt werden sollten.
 * Z.B.
 * o) Die Karte selbst ist eigentlich nur ein Träger des Aufdrucks.
 *    Kleine Kinder neigen dazu, wenn eine Karte fehlt und eine andere zu viel ist
 *    auf der "überflüssigen" Karte, die fehlende Karte aufzumahlen. D.h. die Karte
 *    als Träger nimmt über die Zeit verschiedene Werte/Aufdrucke an.
 * o) Es gibt unterschiedliche Spielkarten mit unterschiedlichen Namen und Aufdrucken.
 *    o) Z.B. Kreuz, Treff, Eichel, Bastos bezeichnen die gleiche (Karten-)"Farbe".
 *       Welcher Name sollverwendet werden?
 *    o) Auch können sich die Kartenstappel bzgl. der darin enthaltenen Werte unterscheiden.
 *       Gibt es Joker?
 *       Gibt es die Ränge 2-6 ? (In einigen Ländern ist sogar üblich, dass auch die Ränge 7,8  oder 9 fehlen)
 * o) Erst das konkrete (Karten-)Spiel - also Z.B. Poker, Skat, Doppelkopf, Mau-Mau, Canasta, Rommé, Bridge usw. - 
 *    legt den Wert einer Karte (bestehend aus Rang und Farbe) fest.
 * Die Berücksichtigung dieser Aspekte, würde zu mehreren Referenztypen führen und nicht nur einer Klasse. 
 * Obiges wird von diese Implementierung nicht unterstützt. Sie ist auf Poker zugeschnitten!
 */
/**
 * Die Klasse {@link Card} ist der Datentyp für eine Spiel<strong>karte</strong>.
 * Die Implementierung der (Spiel-)Karte ist auf den Anwendungszweck <strong>Poker</strong>
 * (konkret: <strong>Texas Hold’em</strong>) abgestimmt.<br />
 * <br />
 * Wichtige Attribute dieser Klasse sind:<br />
 * &bull;{@link #getRank()} liefert den Karten-Wert <em>(bzw. {@link Card.Rank})</em> der aktuellen Karte <em>(bzw. {@link Card})</em>.<br />
 * &bull;{@link #getSuit()} liefert die Farbe <em>(bzw. {@link Card.Suit})</em> der aktuellen Karte <em>(bzw. {@link Card})</em>.<br />
 * &bull;{@link #equals()} vergleicht 2 Karten <em>(bzw. {@link Card})</em> bezüglich Gleichheit im "üblichen Sinne".<br />
 * &bull;{@link #compareTo()} vergleicht 2 Karten <em>(bzw. {@link Card})</em> gemäß den Pokerregeln (bei der Endauswertung).
 *      Als Konsequenz der Poker-/Texas Hold’em-Regeln ist die durch <strong>compareTo</strong> gegebene "natürliche Ordnung" (<strong>natural ordering</strong>)
 *      <strong>nicht in Harmonie (<u>inconsistent</u>) mit equals</strong>.<br/>
 * &bull;&hellip;<br />
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
public class Card implements Comparable<Card> {
    //
    //--VERSION:-------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                               #___~version~___YYYY_MM_DD__dd_
    final static private long encodedVersion = 2___00001_004___2023_04_16__01L;
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
    // TYPEs--------------------------------------------------------------------
    
    /**
     * Der enum {@link #Suit} beschreibt die möglichen <strong>Farb</strong>werte einer Karte:
     * <table>
     *   <tr> <td valign="top">&bull;</td> <td><code>CLUB</code></td>    <td>&harr;</td> <td>&clubs; (bzw. <strong>Kreuz</strong> oder auch Eichel)<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>DIAMOND</code></td> <td>&harr;</td> <td><font color="red">&diams;</font> (bzw. <strong>Karo</strong> oder auch Schellen)<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>HEART</code></td>   <td>&harr;</td> <td><font color="red">&hearts;</font> (bzw. <strong>Herz</strong> oder auch Rot)<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>SPADES</code></td>  <td>&harr;</td> <td>&spades; (bzw. <strong>Pik</strong> oder auch Laub/Blatt/Schippen/Gras/Grün)<td> </tr>
     * </table>
     */
    public enum Suit {
        
        CLUB,     // Kreuz
        DIAMOND,  // Karo
        HEART,    // Herz
        SPADES;   // Pik
        
        
        @Override
        public String toString(){
            String resu;
            
            switch( this ){
                case CLUB    : resu = "C"; break;  // \u2663
                case DIAMOND : resu = "D"; break;  // \u2666
                case HEART   : resu = "H"; break;  // \u2665
                case SPADES  : resu = "S"; break;  // \u2660
                default      : resu = "?";
            }//switch
            
            return resu;
        }//method()
        
    }//enum
    
    
    
    /**
     * Der enum {@link #Rank} beschreibt die möglichen <strong>Ränge</strong> bzw. Kartenwerte einer Karte <em>(bzw. {@link Card})</em> :
     * <table>
     *   <tr> <td valign="top">&bull;</td> <td><code>TWO</code></td>   <td>&harr;</td> <td>&quot;2&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>THREE</code></td> <td>&harr;</td> <td>&quot;3&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>FOUR</code></td>  <td>&harr;</td> <td>&quot;4&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>FIVE</code></td>  <td>&harr;</td> <td>&quot;5&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>SIX</code></td>   <td>&harr;</td> <td>&quot;6&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>SEVEN</code></td> <td>&harr;</td> <td>&quot;7&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>EIGHT</code></td> <td>&harr;</td> <td>&quot;8&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>NINE</code></td>  <td>&harr;</td> <td>&quot;9&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>TEN</code></td>   <td>&harr;</td> <td>&quot;10&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>JACK</code></td>  <td>&harr;</td> <td>Bube (bzw. Unter)<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>QUEEN</code></td> <td>&harr;</td> <td>Dame (bzw. Ober)<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>KING</code></td>  <td>&harr;</td> <td>König<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>ACE</code></td>   <td>&harr;</td> <td>Ass (bzw. Daus)<td> </tr>
     * </table>
     */
    public enum Rank {
        
        TWO,    //  2
        THREE,  //  3
        FOUR,   //  4
        FIVE,   //  5
        SIX,    //  6
        SEVEN,  //  7
        EIGHT,  //  8
        NINE,   //  9
        TEN,    //  T bzw. 10
        JACK,   //  J bzw. Bube
        QUEEN,  //  Q bzw. Dame
        KING,   //  K bzw. König
        ACE;    //  A bzw. Ass
        
        
        /**
         * Die Methode {@link #value()} berechnet den (&quot;üblichen&quot;) numerischen Wert eines Karten-Ranges <em>(bzw. {@link #Rank})</em>.
         * Hierbei ist das Ass <em>(bzw. <code>ACE</code>)</em> die Karte <em>(bzw. {@link Card})</em> mit dem höchsten Wert.
         * Ein Ass weist also <u>immer</u> den Wert 14 auf.
         * (Achtung! Sonderfälle wie z.B. Ass als Wheel bei &quot;TEXAS HOLD&apos;EM&quot; werden von {@link #value()} nicht berücksichtigt.
         * 
         * @return numerischer Wert des Karten-Ranges <em>(bzw. {@link Rank})</em>.
         */
        public int value(){
           return ordinal() + 2;
        }//method()
        
        
        /**
         * Die Methode {@link #increment()} liefert den um eins erhöhten Karten-Rang <em>(bzw. {@link #Rank})</em>.
         * Falls die aktuelle Karte <em>(bzw. {@link Card})</em> ein Ass <em>(bzw. <code>ACE</code>)</em> ist,
         * dann wird (sofern enabled) eine Assertion-Exception ausgelöst,
         * andernfalls <code>ACE</code> zurückgeliefert.
         * 
         * @return  den um eins erhöhte Karten-Rang <em>(bzw. {@link #Rank})</em>.
         */
        public Rank increment(){
            if( equals( ACE )){
                assert false : "ERROR: Ace is already highest value and can NOT be incremented!";
                return ACE;
            }else{
                return Rank.values()[ ordinal() +1 ];
            }//if
        }//method()
        
        /**
         * Die Methode {@link #decrement()} liefert den um eins erniedrigten Karten-Rang <em>(bzw. {@link #Rank})</em>.
         * Falls die aktuelle Karte <em>(bzw. {@link Card})</em> eine 2 <em>(bzw. <code>TWO</code>)</em> ist,
         * dann wird (sofern enabled) eine Assertion-Exception ausgelöst,
         * andernfalls <code>TWO</code> zurückgeliefert.
         * 
         * @return  den um eins erniedrigte Karten-Rang <em>(bzw. {@link #Rank})</em>.
         */
        public Rank decrement(){
            if( equals( TWO )){
                assert false : "ERROR: Two is already lowest value and can NOT be decremented!";
                return TWO;
            }else{
                return Rank.values()[ ordinal() -1 ];
            }//if
        }//method()
        
        
        @Override
        public String toString(){
            String resu;
            
            switch( this ){
                case TEN   : resu = "T"; break;
                case JACK  : resu = "J"; break;
                case QUEEN : resu = "Q"; break;
                case KING  : resu = "K"; break;
                case ACE   : resu = "A"; break;
                default    : resu = "" + value();
            }//switch
            
            return resu;
        }//method()

    }//enum
    
    
    
    //
    //
    // CONSTANTs----------------------------------------------------------------
    
    
    public static class Constant {
        
        public static final Suit CLUB    = Suit.CLUB;
        public static final Suit DIAMOND = Suit.DIAMOND;
        public static final Suit HEART   = Suit.HEART;
        public static final Suit SPADES  = Suit.SPADES;
        
        public static final Rank TWO     = Rank.TWO;
        public static final Rank THREE   = Rank.THREE;
        public static final Rank FOUR    = Rank.FOUR;
        public static final Rank FIVE    = Rank.FIVE;
        public static final Rank SIX     = Rank.SIX;
        public static final Rank SEVEN   = Rank.SEVEN;
        public static final Rank EIGHT   = Rank.EIGHT;
        public static final Rank NINE    = Rank.NINE;
        public static final Rank TEN     = Rank.TEN;
        public static final Rank JACK    = Rank.JACK;
        public static final Rank QUEEN   = Rank.QUEEN;
        public static final Rank KING    = Rank.KING;
        public static final Rank ACE     = Rank.ACE;
        
        
        
        
        
        /**
         * Die Konstante {@link #C2} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>TWO</strong></code> bzw. &clubs;2.
         */
        public static final Card C2 = new Card ( CLUB, TWO );
        /**
         * Die Konstante {@link #C3} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>THREE</strong></code> bzw. &clubs;3.
         */
        public static final Card C3 = new Card ( CLUB, THREE );
        /**
         * Die Konstante {@link #C4} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>FOUR</strong></code> bzw. &clubs;4.
         */
        public static final Card C4 = new Card ( CLUB, FOUR );
        /**
         * Die Konstante {@link #C5} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>FIVE</strong></code> bzw. &clubs;5.
         */
        public static final Card C5 = new Card ( CLUB, FIVE );
        /**
         * Die Konstante {@link #C6} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>SIX</strong></code> bzw. &clubs;6.
         */
        public static final Card C6 = new Card ( CLUB, SIX );
        /**
         * Die Konstante {@link #C7} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>SEVEN</strong></code> bzw. &clubs;7.
         */
        public static final Card C7 = new Card ( CLUB, SEVEN );
        /**
         * Die Konstante {@link #C8} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>EIGHT</strong></code> bzw. &clubs;8.
         */
        public static final Card C8 = new Card ( CLUB, EIGHT );
        /**
         * Die Konstante {@link #C9} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>NINE</strong></code> bzw. &clubs;9.
         */
        public static final Card C9 = new Card ( CLUB, NINE );
        /**
         * Die Konstante {@link #CT} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>TEN</strong></code> bzw. &clubs;10.
         */
        public static final Card CT = new Card ( CLUB, TEN );
        /**
         * Die Konstante {@link #CJ} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>JACK</strong></code> bzw. &clubs;Bube.
         */
        public static final Card CJ = new Card ( CLUB, JACK );
        /**
         * Die Konstante {@link #CQ} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>QUEEN</strong></code> bzw. &clubs;Dame.
         */
        public static final Card CQ = new Card ( CLUB, QUEEN );
        /**
         * Die Konstante {@link #CK} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>KING</strong></code> bzw. &clubs;König.
         */
        public static final Card CK = new Card ( CLUB, KING );
        /**
         * Die Konstante {@link #CA} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>ACE</strong></code> bzw. &clubs;Ass.
         */
        public static final Card CA = new Card ( CLUB, ACE );
        
        
        /**
         * Die Konstante {@link #D2} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>TWO</strong></code> bzw. <font color="red">&diams;2</font>.
         */
        public static final Card D2 = new Card ( DIAMOND, TWO );
        /**
         * Die Konstante {@link #D3} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>THREE</strong></code> bzw. <font color="red">&diams;3</font>.
         */
        public static final Card D3 = new Card ( DIAMOND, THREE );
        /**
         * Die Konstante {@link #D4} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>FOUR</strong></code> bzw. <font color="red">&diams;4</font>.
         */
        public static final Card D4 = new Card ( DIAMOND, FOUR );
        /**
         * Die Konstante {@link #D5} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>FIVE</strong></code> bzw. <font color="red">&diams;5</font>.
         */
        public static final Card D5 = new Card ( DIAMOND, FIVE );
        /**
         * Die Konstante {@link #D6} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>SIX</strong></code> bzw. <font color="red">&diams;6</font>.
         */
        public static final Card D6 = new Card ( DIAMOND, SIX );
        /**
         * Die Konstante {@link #D7} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>SEVEN</strong></code> bzw. <font color="red">&diams;7</font>.
         */
        public static final Card D7 = new Card ( DIAMOND, SEVEN );
        /**
         * Die Konstante {@link #D8} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>EIGHT</strong></code> bzw. <font color="red">&diams;8</font>.
         */
        public static final Card D8 = new Card ( DIAMOND, EIGHT );
        /**
         * Die Konstante {@link #D9} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>NINE</strong></code> bzw. <font color="red">&diams;9</font>.
         */
        public static final Card D9 = new Card ( DIAMOND, NINE );
        /**
         * Die Konstante {@link #DT} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>TEN</strong></code> bzw. <font color="red">&diams;10</font>.
         */
        public static final Card DT = new Card ( DIAMOND, TEN );
        /**
         * Die Konstante {@link #DJ} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>JACK</strong></code> bzw. <font color="red">&diams;JACK</font>.
         */
        public static final Card DJ = new Card ( DIAMOND, JACK );
        /**
         * Die Konstante {@link #DQ} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>QUEEN</strong></code> bzw. <font color="red">&diams;QUEEN</font>.
         */
        public static final Card DQ = new Card ( DIAMOND, QUEEN );
        /**
         * Die Konstante {@link #DK} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>KING</strong></code> bzw. <font color="red">&diams;KING</font>.
         */
        public static final Card DK = new Card ( DIAMOND, KING );
        /**
         * Die Konstante {@link #DA} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>ACE</strong></code> bzw. <font color="red">&diams;ACE</font>.
         */
        public static final Card DA = new Card ( DIAMOND, ACE );
        
        
        /**
         * Die Konstante {@link #H2} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>TWO</strong></code> bzw. <font color="red">&hearts;2</font>.
         */
        public static final Card H2 = new Card ( HEART, TWO );
        /**
         * Die Konstante {@link #3} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>THREE</strong></code> bzw. <font color="red">&hearts;3</font>.
         */
        public static final Card H3 = new Card ( HEART, THREE );
        /**
         * Die Konstante {@link #H4} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>FOUR</strong></code> bzw. <font color="red">&hearts;4</font>.
         */
        public static final Card H4 = new Card ( HEART, FOUR );
        /**
         * Die Konstante {@link #H5} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>FIVE</strong></code> bzw. <font color="red">&hearts;5</font>.
         */
        public static final Card H5 = new Card ( HEART, FIVE );
        /**
         * Die Konstante {@link #H6} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>SIX</strong></code> bzw. <font color="red">&hearts;6</font>.
         */
        public static final Card H6 = new Card ( HEART, SIX );
        /**
         * Die Konstante {@link #H7} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>SEVEN</strong></code> bzw. <font color="red">&hearts;7</font>.
         */
        public static final Card H7 = new Card ( HEART, SEVEN );
        /**
         * Die Konstante {@link #H8} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>EIGHT</strong></code> bzw. <font color="red">&hearts;8</font>.
         */
        public static final Card H8 = new Card ( HEART, EIGHT );
        /**
         * Die Konstante {@link #H9} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>NINE</strong></code> bzw. <font color="red">&hearts;9</font>.
         */
        public static final Card H9 = new Card ( HEART, NINE );
        /**
         * Die Konstante {@link #HT} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>TEN</strong></code> bzw. <font color="red">&hearts;10</font>.
         */
        public static final Card HT = new Card ( HEART, TEN );
        /**
         * Die Konstante {@link #HJ} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>JACK</strong></code> bzw. <font color="red">&hearts;JACK</font>.
         */
        public static final Card HJ = new Card ( HEART, JACK );
        /**
         * Die Konstante {@link #HQ} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>QUEEN</strong></code> bzw. <font color="red">&hearts;QUEEN</font>.
         */
        public static final Card HQ = new Card ( HEART, QUEEN );
        /**
         * Die Konstante {@link #HK} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>KING</strong></code> bzw. <font color="red">&hearts;KING</font>.
         */
        public static final Card HK = new Card ( HEART, KING );
        /**
         * Die Konstante {@link #HA} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>ACE</strong></code> bzw. <font color="red">&hearts;ACE</font>.
         */
        public static final Card HA = new Card ( HEART, ACE );
        
        
        /**
         * Die Konstante {@link #S2} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>TWO</strong></code> bzw. &spades;2.
         */
        public static final Card S2 = new Card ( SPADES, TWO );
        /**
         * Die Konstante {@link #S3} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>THREE</strong></code> bzw. &spades;3.
         */
        public static final Card S3 = new Card ( SPADES, THREE );
        /**
         * Die Konstante {@link #S4} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>FOUR</strong></code> bzw. &spades;4.
         */
        public static final Card S4 = new Card ( SPADES, FOUR );
        /**
         * Die Konstante {@link #S5} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>FIVE</strong></code> bzw. &spades;5.
         */
        public static final Card S5 = new Card ( SPADES, FIVE );
        /**
         * Die Konstante {@link #S6} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>SIX</strong></code> bzw. &spades;6.
         */
        public static final Card S6 = new Card ( SPADES, SIX );
        /**
         * Die Konstante {@link #S7} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>SEVEN</strong></code> bzw. &spades;7.
         */
        public static final Card S7 = new Card ( SPADES, SEVEN );
        /**
         * Die Konstante {@link #S8} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>EIGHT</strong></code> bzw. &spades;8.
         */
        public static final Card S8 = new Card ( SPADES, EIGHT );
        /**
         * Die Konstante {@link #S9} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>NINE</strong></code> bzw. &spades;9.
         */
        public static final Card S9 = new Card ( SPADES, NINE );
        /**
         * Die Konstante {@link #ST} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>TEN</strong></code> bzw. &spades;10.
         */
        public static final Card ST = new Card ( SPADES, TEN );
        /**
         * Die Konstante {@link #SJ} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>JACK</strong></code> bzw. &spades;JACK.
         */
        public static final Card SJ = new Card ( SPADES, JACK );
        /**
         * Die Konstante {@link #SQ} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>QUEEN</strong></code> bzw. &spades;QUEEN.
         */
        public static final Card SQ = new Card ( SPADES, QUEEN );
        /**
         * Die Konstante {@link #SK} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>KING</strong></code> bzw. &spades;KING.
         */
        public static final Card SK = new Card ( SPADES, KING );
        /**
         * Die Konstante {@link #SA} steht für die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>ACE</strong></code> bzw. &spades;ACE.
         */
        public static final Card SA = new Card ( SPADES, ACE );
        
    }//class
    
    
    
    //
    //
    // ATTRIBUTE DATA-----------------------------------------------------------
    
    private final Suit suit;
    private final Rank rank;
    
    
    
    //
    //
    // CONSTRUCTORs-------------------------------------------------------------
    
    //__???__<130114> see "bug_id=4464323" resp. "http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4464323"
    /**
     * Der Konstruktor erzeugt eine Karte <em>(bzw. {@link Card})</em>.
     * Dieser Konstrukor ist nur für interne Zwecke und setzt interne Variablen.
     * Studenten dürfen diesen Konstruktor <strong><u>nicht</u></strong> zur Lösung der Poker-Aufgabe nutzen.
     * 
     * @param suit  bestimmt die Farbe <em>(bzw. {@link Card.Suit})</em> der zu erzeugenden Karte <em>(bzw. {@link Card})</em>.
     * @param rank  bestimmt den Karten-Wert <em>(bzw. {@link Card.Rank}</em> der zu erzeugenden Karte <em>(bzw. {@link Card})</em>.
     */
    Card( final Suit suit, final Rank rank ) {                                  // package scope on purpose - do NOT(!) change this
        this.suit = suit;
        this.rank = rank;
    }//constructor()
    
    
    
    //
    //
    // METHODs------------------------------------------------------------------
    
    /**
     * Die Methode {@link #printCardArray()} druckt alle Karten <em>(bzw. {@link Card})</em>
     * eines Arrays über Karten <em>(bzw. {@link Card})</em>.
     * Der Code basiert auf einer Idee/ersten Implementierung von:<br/>
     * Mark-Andr&eacute Kloesters; (p)2009.<br/>
     * Die "Operation"/Funktionalität ist immer wieder bei vielen Studenten sehr beliebt und
     * wurde daher zum festen Bestandteil der {@link Card}-Klasse.
     * 
     * @param   cards Das Array über Karten <em>(bzw. {@link Card})</em>, das ausgedruckt werden soll.
     */
    public static void printCardArray( final Card... cards ){
        
        for( int i=0;  i < cards.length;  i++ ){
            if( cards[i] != null ){
                System.out.printf( "%15s", " ________ " );
            }else{
                System.out.printf( "%15s", " ..NULL.. " );
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < cards.length;  i++ ){
            if( cards[i] != null ){
                switch( cards[i].getSuit() ){
                    case HEART   : System.out.printf( "%15s", String.format( "|%s _  _  |", cards[i].getRank())); break;
                    case DIAMOND : System.out.printf( "%15s", String.format( "|%s       |", cards[i].getRank())); break;
                    case CLUB    : System.out.printf( "%15s", String.format( "|%s  __   |", cards[i].getRank())); break;
                    case SPADES  : System.out.printf( "%15s", String.format( "|%s  __   |", cards[i].getRank())); break;
                }//switch
            }else{
                System.out.printf( "%15s", String.format( "00      00" ));
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < cards.length;  i++ ){
            if( cards[i] != null ){
                switch( cards[i].getSuit() ){
                    case HEART   : System.out.printf( "%15s", String.format( "| / \\/ \\ |" )); break;
                    case DIAMOND : System.out.printf( "%15s", String.format( "|   /\\   |"  )); break;
                    case CLUB    : System.out.printf( "%15s", String.format( "| _|  |_ |"   )); break;
                    case SPADES  : System.out.printf( "%15s", String.format( "|  /  \\  |"  )); break;
                }//switch
            }else{
                System.out.printf( "%15s", String.format( ". 00  00 ." ));
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < cards.length;  i++ ){
            if( cards[i] != null ){
                switch( cards[i].getSuit() ){
                case HEART   : System.out.printf( "%15s", String.format( "| \\    / |" )); break;
                case DIAMOND : System.out.printf( "%15s", String.format( "|  /  \\  |" )); break;
                case CLUB    : System.out.printf( "%15s", String.format( "||      ||"  )); break;
                case SPADES  : System.out.printf( "%15s", String.format( "| /    \\ |" )); break;
                }//switch
            }else{
                System.out.printf( "%15s", String.format( ".   00   ." ));
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < cards.length;  i++ ){
            if( cards[i] != null ){
                switch( cards[i].getSuit() ){
                case HEART   : System.out.printf( "%15s", String.format( "|  \\  /  |" )); break;
                case DIAMOND : System.out.printf( "%15s", String.format( "|  \\  /  |" )); break;
                case CLUB    : System.out.printf( "%15s", String.format( "||__  __||"  )); break;
                case SPADES  : System.out.printf( "%15s", String.format( "|/      \\|" )); break;
                }//switch
            }else{
                System.out.printf( "%15s", String.format( ". 00  00 ." ));
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < cards.length;  i++ ){
            if( cards[i] != null ){
                switch( cards[i].getSuit() ){
                    case HEART   : System.out.printf( "%15s", String.format( "|   \\/   |"  )); break;
                    case DIAMOND : System.out.printf( "%15s", String.format( "|   \\/   |"  )); break;
                    case CLUB    : System.out.printf( "%15s", String.format( "|  /__\\  |"  )); break;
                    case SPADES  : System.out.printf( "%15s", String.format( "|\\_/||\\_/|" )); break;
                }//switch
            }else{
                System.out.printf( "%15s", String.format( "00      00" ));
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < cards.length;  i++ ){
            if( cards[i] != null ){
                System.out.printf( "%15s", "|________|" );
            }else{
                System.out.printf( "%15s", String.format( "'''NULL'''" ));
            }//if
        }//for
        System.out.println();
        
    }//method()
    
    
    
    //__???__<130114> see "bug_id=4464323" resp. "http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4464323"
    /**
     * Die Methode {@link #getRank()} liefert den Karten-Wert <em>(bzw. {@link Card.Rank})</em> der aktuellen Karte <em>(bzw. {@link Card})</em>.
     * 
     * @return Rang der aktuellen Karte <em>(bzw. {@link Card})</em>.
     */
    public Rank getRank() {
        return rank;     
    }//method()
    
    
    //__???__<130114> see "bug_id=4464323" resp. "http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4464323"
    /**
     * Die Methode {@link #getSuit()} liefert die Farbe <em>(bzw. {@link Card.Suit})</em> der aktuellen Karte <em>(bzw. {@link Card})</em>.
     * 
     * @return Farbe der aktuellen Karte <em>(bzw. {@link Card})</em>.
     */
    public Suit getSuit() {
        return suit;
    }//method()
    
    
    
    /**
     * Note:<br/>
     * As result of the specific poker game rules  this class has a 
     * <strong>natural ordering</strong> that <strong>is <u>inconsistent</u> with equals</strong>.<br/>
     * In Poker the suit does NOT matter, when it is decided who has won.
     */
    @Override
    public int compareTo( final Card other ){
        return rank.compareTo( other.rank );
    }//method()
    
    @Override
    public boolean equals( final Object other ){
        return ( getClass()==other.getClass() )  ?  ( suit==((Card)other).getSuit()) && (rank==((Card)other).getRank())  :  false;    
    }//method()
    
    @Override
    public int hashCode() {
        final int prime = 31;
        return  ((rank==null) ? 0 : rank.hashCode())  +  prime*((suit==null) ? 0 : suit.hashCode());
    }//method()
    
    
    
    @Override
    public String toString(){
        return " [" + suit + rank + "] ";
    }//method()
    
}//class
