// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package dataForTests.personSingleName;


import java.util.Objects;
import stuffBeginnersDontHaveToUnderstand.Version;


/**
 * Die Klasse ist hier nur Hilfsmittel um Lehrinhalte zu verdeutlichen.<br />
 * Die Klasse <b>{@link Po}</b> beschreibt eine <b>P</b>erson (mit equals() und hashCode() <b>O</b>verwritten).
 * Der Name ist klar SCHLECHT und derartige Namen sollten in realen Anwendungen unbedingt vermieden werden.
 * Hier wurde jedoch bewusst ein kurzer Klassen-Name gewählt, damit "die Ausgaben" übersichtlich sind.
 * <br />
 * Diese Klasse könnte deutlich kompakter als "record" implementiert werden,
 * aber "record" war (vermutlich) noch nicht Vorlesungsthema.
 * <br />
 * Kurz: In dieser Variante werden equals() und hashCode() überschrieben.
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          Px@Hamburg-UAS.eu
 * @version {@value #encodedVersion}
 */
public class Po {
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
    
    
    
    
    
    final private String name;
    
    
    
    
    
    /**
     * Eine Person hat einen Namen.  Entsprechend wird eine Person vom Konstruktor
     * - gemäß der als aktuelle Parameter übergebenen Werte - initialisiert.
     * 
     * @param name  Name der Person
     */
    public Po( final String name ){
        this.name = name;
    }//constructor()
    
    
    
    
    
    @Override
    public boolean equals( final Object otherObject ){
        if( this == otherObject )  return true;                                 // beide Objekte identisch?
        if( null == otherObject )  return false;                                // existiert other?
        if( getClass() != otherObject.getClass() )  return false;               // Andere Klasse als Vergleichbar akzeptabel?  Es gäbe Alternative: "if(!( otherObject instanceof Po ))..."; Siehe Vorlesung
        final Po other = (Po)( otherObject );                                   // für den (nachfolgenden) einfachen Zugriff
        
        // Objekt-Referenz-Variaben-Werte vergleichen. Die jeweiligen Vergleiche werden an "Objects" delegiert.
        if( ! Objects.equals( name,  other.name ))  return false;
        
        return true;                                                            // KEINE "Erbmasse" muss verglichen werden => fertig
    }//method()
    //
    // Achtung! Es muss gelten,
    // dass zwei Objekte, die gemäß equals() als gleich gewertet werden
    // auch den gleichen hashCode() abliefern.
    // Diese "Aufgabe" wird an "Objects" delegiert.
    @Override
    public int hashCode(){
        return Objects.hashCode( name );
    }//method()
    
    
    @Override
    public String toString(){
        return String.format(
            "[<%s>: %s ]",
            Po.class.getSimpleName(),
            name
        );
    }//method()
    
}//class
