// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package testsForHashSetBasedOnFixedSizeArray;


import hashSetBasedOnFixedSizedArray.HashSetBasedOnFixedSizedArray;
import hashSetBasedOnFixedSizedArray.UtilizationData;
import java.util.HashSet;
import java.util.Set;
import stuffBeginnersDontHaveToUnderstand.Version;


/**
 * TestFrame for HashSetBasedOnFixedSizedArray.
 * This is NOT an educational TestFrame.
 * This TestFrame is for actual testing.
 * 
 * @author   Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *           Px@Hamburg-UAS.eu
 * @version  {@value #encodedVersion}
 */
public class TestFrameAndStarter99_forActualTesting {
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
        System.out.printf( "Internal Test - does Set fullfill requirements? :\n" );
        System.out.printf( "\n" );
        
        final int  amountOfRandomNumbers = 100; 
        
        final Set<String> sut = new HashSetBasedOnFixedSizedArray<String>();    // sut ::= Set Under Test
        final Set<String> hashSet = new HashSet<String>();
        
        System.out.printf( "Adding some random numbers\n" );
        for( int stillToDo=amountOfRandomNumbers; --stillToDo>=0; ){
            final Integer elem = (int)( 10_000*Math.random() );
            sut.add( elem.toString() );
            hashSet.add( elem.toString() );
        }//for
        
        System.out.printf( "Show what happened\n" );
        printInternalStructure( sut );
        System.out.printf( "%s\n",  getUtilization( sut ));
        System.out.printf( "\n\n\n" );
        //
        // Ausgabe, ob die Objekte hashSet und sut bezgl der vom Interface Set eingeforderten Eigenschaften gleich sind
        System.out.printf( "Check if implemented set und java.util.HashSet behave(d) the same way\n" );
        System.out.printf( "Have both sets same amount of elements?\n" );
        final int size1 = sut.size();
        final int size2 = hashSet.size();
        System.out.printf(
            "  %s   since :   %d =?= %d\n",
            ( size1 == size2 )  ?  "ok :-)"  :  ":-(",
            size1,
            size2
        );
        System.out.printf( "Are both sets equal to each other?\n" );
        final boolean equalCheck1 = sut.equals( hashSet );
        final boolean equalCheck2 = hashSet.equals( sut );
        System.out.printf(
            "  %s   since :   %s =?= %s =?= true\n",
            (( equalCheck1 == equalCheck2 ) && equalCheck1 )  ?  "ok :-)"  :  ":-(",
            equalCheck1,
            equalCheck2
        );
        System.out.printf( "Is same hashCode computed by both sets?\n" );
        final int hashCode1 = sut.hashCode();
        final int hashCode2 = hashSet.hashCode();
        System.out.printf(
            "  %s   since :   %d =?= %d\n",
            ( hashCode1 == hashCode2 )  ?  "ok :-)"  :  "bad :-(",
            hashCode1,
            hashCode2
        );

        System.out.printf( "###--- THE END ---###\n" );
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
