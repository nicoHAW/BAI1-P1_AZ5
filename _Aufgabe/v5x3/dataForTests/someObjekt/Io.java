// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package dataForTests.someObjekt;


import java.util.Objects;
import stuffBeginnersDontHaveToUnderstand.Version;


/**
 * Die Klasse ist hier nur Hilfsmittel um Lehrinhalte zu verdeutlichen.<br />
 * Die Klasse <b>{@link Io}</b> beschreibt ein <b>I</b>nformations-Object (mit equals() und hashCode() <b>O</b>verwritten).
 * Der Name ist klar SCHLECHT und derartige Namen sollten in realen Anwendungen unbedingt vermieden werden.
 * Hier wurde jedoch bewusst ein kurzer Klassen-Name gewählt, damit "die Ausgaben" übersichtlich sind.
 * <br />
 * Kurz: Diese Variante dient zum Experimentieren - experimentieren Sie 😉.
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          Px@Hamburg-UAS.eu
 * @version {@value #encodedVersion}
 */
public class Io {
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
    
    
    
    
    
    public String information;                                                  // public on purpose - für mögliche Experimente
    
    
    
    
    
    /**
     * Der Konstruktor initialisiert das Informations-Objekt mit der als aktuellen Parameter übergebenen Information
     *  
     * @param information  die Information bzw. Daten
     */
    public Io( final String information ){
        this.information = information;
    }//constructor()
    
    
    
    
    
    // Bemerkung:
    // Dieses equals() nutzt (bewusst(!) zur Abwechslung) mal "instanceof" für denTest,
    // ob die Typen der Objekte einen sinnvollen Vergleich ermöglichen.
    // Für Weiteres siehe Vorlesung.
    @Override
    public boolean equals( final Object otherObject ){
        if( this == otherObject )  return true;                                 // beide Objekte identisch?
        if( null == otherObject )  return false;                                // existiert other?
        if( ! ( otherObject instanceof Io ))  return false;                     // Andere Klasse als Vergleichbar akzeptabel?  Es gäbe Alternative: "if(getClass()!=otherObject.getClass())..."; Siehe Vorlesung
        final Io other = (Io)( otherObject );
        
        // Objekt-Referenz-Variaben-Werte vergleichen. Die jeweiligen Vergleiche werden an "Objects" delegiert.
        if( ! Objects.equals(  information, other.information ))  return false; // Objekt-Referenz-Variaben-Wert vergleichen
        
        return true;                                                            // KEINE "Erbmasse" muss verglichen werden => fertig
    }//method()
    //
    // Achtung! Es muss gelten,
    // dass zwei Objekte, die gemäß equals() als gleich gewertet werden
    // auch den gleichen hashCode() abliefern.
    @Override
    public int hashCode(){
        return information.hashCode();                                          // hashCode()-Brechnung wird an "Objects" delegiert.
        // Oder nur z.B.
        // return (null==information || 0==information.length()) ? 0 : information.charAt( 0 );
        // Experimentieren Sie 😉
    }//method()
    
    
    @Override
    public String toString(){
        return String.format(
            "[<%s>: %s ]",
            Io.class.getSimpleName(),
            information
        );
    }//method()
    
}//class
