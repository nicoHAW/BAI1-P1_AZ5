// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package testsForHashSetBasedOnFixedSizeArray;


import hashSetBasedOnFixedSizedArray.HashSetBasedOnFixedSizedArray;
import hashSetBasedOnFixedSizedArray.UtilizationData;
import java.util.Set;

import dataForTests.Po;
import stuffBeginnersDontHaveToUnderstand.Version;


/**
 * TestFrame for HashSetBasedOnFixedSizedArray using Po.
 * 
 * @author   Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *           Px@Hamburg-UAS.eu
 * @version  {@value #encodedVersion}
 */
public class TestFrameAndStarter12_usingPo {
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
        final Set<Po> setUnderTest = new HashSetBasedOnFixedSizedArray<Po>();
        
        System.out.printf( "Adding some persons\n" );
        setUnderTest.add( new Po( "Simpson", "Homer J." ));
        setUnderTest.add( new Po( "Simpson", "Marge" ));
        setUnderTest.add( new Po( "Simpson", "Bart" ));
        setUnderTest.add( new Po( "Simpson", "Lisa" ));
        setUnderTest.add( new Po( "Simpson", "Maggie" ));
        setUnderTest.add( new Po( "Underdunk Terwilliger Phd.", "Robert Jr." ));         // #1
        setUnderTest.add( new Po( "Szyslak", "Morris" ));         
        setUnderTest.add( new Po( "Lumpkin", "Lurleen" ));
        setUnderTest.add( new Po( "Underdunk Terwilliger Phd.", "Robert Jr." ));         // #2
        setUnderTest.add( new Po( "van Houten", "Milhouse" ));
        setUnderTest.add( new Po( "Muntz", "Nelson" ));
        setUnderTest.add( new Po( "MacMoran", "Willie" ));
        setUnderTest.add( new Po( "Mann", "Otto" ));
        setUnderTest.add( new Po( "Krustofski", "Herschel Shmoikel Pinkus Yerucham" ));
        setUnderTest.add( new Po( "Underdunk Terwilliger Phd.", "Robert Jr." ));         // #3
        setUnderTest.add( new Po( "Flanders", "Ned" ));
        setUnderTest.add( new Po( "Flanders", "Maude" ));
        setUnderTest.add( new Po( "Flanders", "Rod" ));
        setUnderTest.add( new Po( "Flanders", "Todd" ));
        setUnderTest.add( new Po( "Burns", "Charles Montgomery" ));         
        setUnderTest.add( new Po( "Smithers", "Waylon" ));
        setUnderTest.add( new Po( "Underdunk Terwilliger Phd.", "Robert Jr." ));         // #4
        setUnderTest.add( new Po( "Dr. Abernathy MD JD", "Eleanor" ));
        
        System.out.printf( "Show what happened\n" );
        printInternalStructure( setUnderTest );
        System.out.printf( "%s\n",  getUtilization( setUnderTest ));
        System.out.printf( "\n\n\n" );
        
        
        
        final Po maude = new Po( "Flanders", "Maude" );
        System.out.printf( "(Trying) to delete some person -> \"%s\"\n",  maude );
        if( setUnderTest.remove( maude )){
            System.out.printf( "Removement is reported as successful\n" );
        }else{
            System.out.printf( "Removement is reported as unsuccessful\n" );
        }//if
        System.out.printf( "Show set again\n" );
        printInternalStructure( setUnderTest );
        System.out.printf( "%s\n",  getUtilization( setUnderTest ));
        System.out.printf( "\n\n\n" );
        
        
        
        final Po bart = new Po( "Simpson", "Bart" );
        System.out.printf( "Checking \"%s\"\n",  bart );
        if( setUnderTest.contains( bart )){
            System.out.printf( "\"%s\" is reported to be contained in set\n",  bart );
        }else{
            System.out.printf( "\"%s\" is reported to be NOT contained in set\n",  bart );
        }//if
        System.out.printf( "Show set again\n" );
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
