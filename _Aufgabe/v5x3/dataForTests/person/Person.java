// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package dataForTests.person;


import java.util.Objects;
import stuffBeginnersDontHaveToUnderstand.Version;


/**
 * Die Klasse ist hier nur Hilfsmittel um Lehrinhalte zu verdeutlichen.<br />
 * Die Klasse {@link Person} beschreibt eine Person und unterscheidet sich von Pi, Po und Px
 * dadurch, dass sie Vor- und Nach-Namen unterstützt.
 * Diese Klasse könnte deutlich kompakter als "record" implementiert werden,
 * aber "record" war (vermutlich) noch nicht Vorlesungsthema.
 * <br />
 * Diese Variante dient zum Experimentieren - experimentieren Sie 😉.
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          Px@Hamburg-UAS.eu
 * @version {@value #encodedVersion}
 */
public class Person {
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
    
    
    
    
    
    final private String surname;
    final private String forename;
    
    
    
    
    
    /**
     * Eine Person hat einen Nachnamen und einen Vornamen.
     * Entsprechend wird eine Person vom Konstruktor - gemäß der als aktuelle Parameter übergebenen Werte - initialisiert.
     * 
     * @param surname  Nachname der Person
     * @param forename  Vorname der Person
     */
    public Person( final String surname,  final String forename ){
        this.surname = surname;
        this.forename = forename;
    }//constructor()
    
    
    
    
    
    @Override
    public boolean equals( final Object otherObject ){
        if( this == otherObject )  return true;                                 // beide Objekte identisch?
        if( null == otherObject )  return false;                                // existiert other?
        if( getClass() != otherObject.getClass() )  return false;               // Andere Klasse als Vergleichbar akzeptabel?  Es gäbe Alternative: "if(!( otherObject instanceof Person ))..."; Siehe Vorlesung
        final Person other = (Person)( otherObject );
        
        // Objekt-Referenz-Variaben-Werte vergleichen                           // Vergleich der Attribute
        if( ! Objects.equals( surname,  other.surname ))  return false;
        if( ! Objects.equals( forename, other.forename )) return false;
        
        return true;                                                            // KEINE "Erbmasse" muss verglichen werden => fertig
    }//method()
    //
    // Achtung! Es muss gelten,
    // dass zwei Objekte, die gemäß equals() als gleich gewertet werden
    // auch den gleichen hashCode() abliefern.
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
            Person.class.getSimpleName(),
            surname,
            forename
        );
    }//method()
    
}//class
