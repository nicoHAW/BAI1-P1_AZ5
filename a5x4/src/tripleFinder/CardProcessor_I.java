// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package tripleFinder;


import static cards.Card.*;
import static cards.Card.Constant.*;
//
import cards.*;
import cards.Card.*;
import stuffBeginnersDontHaveToUnderstand.Version;


/**
 * Das Interface {@link CardProcessor_I}<br />
 * o) beschreibt eine CardProcessor und <br />
 * o) definiert die Funktionalität möglicher Implementierungen und fordert die entsprechenden Methoden ein. <br />
 *
 * Die von Ihnen zu implementierende Klasse CardProcessor muss einen parameterlosen Konstruktor aufweisen.
 * Eine genaue Auflistung der Anforderungen an die zu implementierende Klasse findet sich auf dem Aufgabenzettel.
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          P1@Hamburg-UAS.eu 
 * @version {@value #encodedVersion} 
 */
public interface CardProcessor_I {
    //
    //--VERSION:-----------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                       #___~version~___YYYY_MM_DD__dd_
    final static long encodedVersion = 2___00002_001___2023_04_29__01L;
    //---------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static Version cardProcessorInterfaceVersion = new Version( encodedVersion );
    static String getDecodedVersion(){ return cardProcessorInterfaceVersion.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung
    
    
    
    
    
    /**
     * Diese Methode verarbeitet eine (Spiel-)Karte.
     * Die als Parameter übergebene(n) Karte(n) wird(werden) zunächst intern gespeichert.
     * Sobald ein Drilling (3 Karten vom gleichen Rang) vorliegt,
     * soll dieser Drilling (also die entsprechenden 3 Karten) als Rückgaberwert der Methode zurückgegeben werden.
     *
     * @param card bestimmt die (neue) Karte, die zu verarbeiten ist.
     * @return  der erste Drilling unmittebar nachdem er aufgetreten ist<br />
     *          und sonst null.
     */
    Object process( final Card card );
    
    
    /**
     * löscht alle (internen) gespeicherten Karten.
     */
    void reset();
    
}//interface
