// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package dataForTests;

import java.util.Objects;

/**
 * Die Klasse Px beschreibt eine <b>P</b>erson (zum e<b>X</b>perimentieren).
 * Der Name ist klar SCHLECHT und derartige Namen sollten in realen Anwendungen unbedingt vermieden werden.
 * Die Klasse ist hier nur Hilfsmittel um Lehrinhalte zu verdeutlichen.
 * Hier wurde ein kurzer Klassen-Name gewaehlt, damit "die Ausgaben" uebersichtlich sind.
 * <br />
 * In dieser Version(svorlage) werden equals() und hashCode() ueberschrieben.
 * 
 * @author   Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *           P1@Hamburg-UAS.eu 
 * @version  2022/05/16 (#1)
 */
public class Px {
    
    final private String surname;
    final private String forename;
    
    
    
    
    
    public Px( final String surname,  final String forename ){
        this.surname = surname;
        this.forename = forename;
    }//constructor()
    
    
    
    
    
    @Override
    public boolean equals( final Object otherObject ){
        if( this == otherObject )  return true;                                 // beide Objekte identisch?
        if( null == otherObject )  return false;                                // existiert other?
        if( ! ( otherObject instanceof Px ))  return false;                     // Andere Klasse als Vergleichbar akzeptabel?
        final Px other = (Px)( otherObject );
        
        // Objekt-Referenz-Variaben-Werte vergleichen                           // Vergleich der Attribute
        if( ! Objects.equals( surname,  other.surname ))  return false;
        if( ! Objects.equals( forename, other.forename )) return false;
        
        return true;                                                            // KEINE "Erbmasse" muss verglichen werden => fertig
     }//method()
    
    // Ein einfacher experimenteller HashCode
    // Achtung! Es muss gelten,
    // dass zwei Objekte, die gemäß equals() als gleich gewertet werden
    // auch den gleichen hashCode() abliefern
    @Override
    public int hashCode(){
        final int prime = 31;
        int theHashCode = (null==surname || 0==surname.length()) ? 0 : surname.charAt( 0 );
        theHashCode = prime*theHashCode + ((null==forename || 0==forename.length()) ? 0 : forename.charAt( 0 ));
        return theHashCode;
    }//method()
    
    @Override
    public String toString(){
        return String.format(
            "[<%s>: sn=%s, fn=%s ]",
            Px.class.getSimpleName(),
            surname,
            forename
        );
    }//method()
    
}//class
