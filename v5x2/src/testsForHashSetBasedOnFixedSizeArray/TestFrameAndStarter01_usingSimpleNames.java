// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package testsForHashSetBasedOnFixedSizeArray;


import hashSetBasedOnFixedSizedArray.HashSetBasedOnFixedSizedArray;
import hashSetBasedOnFixedSizedArray.UtilizationData;
import java.util.Set;
import stuffBeginnersDontHaveToUnderstand.Version;


/**
 * TestFrame for HashSetBasedOnFixedSizedArray.
 * 
 * @author   Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *           Px@Hamburg-UAS.eu
 * @version  {@value #encodedVersion}
 */
public class TestFrameAndStarter01_usingSimpleNames {
    //
    //--VERSION:-------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                               #___~version~___YYYY_MM_DD__dd_
    final static private long encodedVersion = 2___00002_002___2023_05_17__02L;
    //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static private Version version = new Version( encodedVersion );
    /**
     * The method {@link #getDecodedVersion()} delivers the code version as reground/readable String.
     * @return version as decoded/readable String.
     */
    static public String getDecodedVersion(){ return version.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung.
    
    
    
    
    
    /**
     * Diese Methode {@link #main()} startet Experimente bzgl. HashSetBasedOnFixedSizedArray.
     * 
     * @param unused wird nicht genutzt, aber "von Java eingefordert".
     */
    public static void main( final String... unused ){
        final Set<String> setUnderTest = new HashSetBasedOnFixedSizedArray<String>();
        
        System.out.printf( "Adding some persons\n" );
        setUnderTest.add( "Andrea" );
        setUnderTest.add( "Andreas" );
        setUnderTest.add( "Yvonne" );
        setUnderTest.add( "Ute" );
        setUnderTest.add( "Peter" );
        setUnderTest.add( "Anke" );
        setUnderTest.add( "Elke" );
        setUnderTest.add( "Otto" );
        setUnderTest.add( "Paul" );
        setUnderTest.add( "Hinz" );
        setUnderTest.add( "Kunz" );
        setUnderTest.add( "Karl" );
        setUnderTest.add( "Mary" );
        
        System.out.printf( "Show what happened\n" );
        printInternalStructure( setUnderTest );
        System.out.printf( "%s\n",  getUtilization( setUnderTest ));
        System.out.printf( "\n\n\n" );
        
        System.out.printf( "Clearing set\n" );
        setUnderTest.clear();
        System.out.printf( "Show what happened\n" );
        printInternalStructure( setUnderTest );
        System.out.printf( "%s\n",  getUtilization( setUnderTest ));
    }//method()
    
    
    
    
    
    // Sorry, hier schlagen die Generics zu.
    // So etwas wie "<?>" verstehen wir (vermutlich) noch nicht.
    // Dadurch wird die Typsicherheit "so gut es geht" sichergestellt.
    // Für das Verständnis des Algorithmus ist dies nicht wichtig.
    
    private static void printInternalStructure( final Set<?> set ){
        assert set instanceof HashSetBasedOnFixedSizedArray :  String.format( "Unsupported operation for %s",  set.getClass().getSimpleName() );
        //
        ((HashSetBasedOnFixedSizedArray<?>)set).printInternalStructure();
    }//method()
    
    private static UtilizationData getUtilization( final Set<?> set ){
        assert set instanceof HashSetBasedOnFixedSizedArray :  String.format( "Unsupported operation for %s",  set.getClass().getSimpleName() );
        //
        return ((HashSetBasedOnFixedSizedArray<?>)set).getUtilization();
    }//method()
    
}//class
