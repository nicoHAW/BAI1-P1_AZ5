// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package testForHashMapBasedOnFixedSizedArray;


import java.util.Map;

import hashMapBasedOnFixedSizedArray.HashMapBasedOnFixedSizedArray;
import stuffBeginnersDontHaveToUnderstand.Version;


/**
 * TestFrame for HashMapBasedOnFixedSizedArray.
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          Px@Hamburg-UAS.eu
 * @version {@value #encodedVersion}
 */
public class TestFrame01 {
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
     * Diese Methode {@link #main()} startet Experimente bzgl. HashMapBasedOnFixedSizedArray.
     * 
     * @param unused wird nicht genutzt, aber "von Java eingefordert".
     */
    public static void main( final String... unused ) {
        final Map<String,String> mapUnderTest = new HashMapBasedOnFixedSizedArray<String,String>();
        
        mapUnderTest.put( "a", "1" );
        mapUnderTest.put( "b", "2" );
        mapUnderTest.put( "c", "3" );
        mapUnderTest.put( "i", "4" );
        mapUnderTest.put( "j", "5" );
        mapUnderTest.put( "o", "6" );
        mapUnderTest.put( "x", "7" );
        mapUnderTest.put( "y", "8" );
        mapUnderTest.put( "z", "9" );
        printInternalStructure( mapUnderTest );
        System.out.printf( "\n\n\n" );
        
        System.out.printf( "%s",  mapUnderTest.get( "x" ));
        
    }//method()
    
    
    
    
    
    // Sorry, hier schlagen die Generics zu.
    // So etwas wie "<?,?>" verstehen wir (vermutlich) noch nicht.
    // Dadurch wird die Typsicherheit "so gut es geht" sichergestellt.
    // Für das Verständnis des Algorithmus ist dies nicht wichtig.
    
    private static void printInternalStructure( final Map<?,?> map ){
        assert map instanceof HashMapBasedOnFixedSizedArray :  String.format( "Unsupported operation for %s",  map.getClass().getSimpleName() );
        //
        // DownCast ist nötig für Zugriff auf printInternalStructure().
        // Durch instanceof zuvor ist der DownCast sicher.
        ((HashMapBasedOnFixedSizedArray<?,?>)map).printInternalStructure();
    }//method()
    
}//class
