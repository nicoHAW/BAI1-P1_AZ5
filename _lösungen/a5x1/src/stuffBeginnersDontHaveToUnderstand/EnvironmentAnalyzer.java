// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
// "Home"-VCS: git@git.HAW-Hamburg.de:shf/Px/LabExercise/ZZZ_SupportStuff[.git]
package stuffBeginnersDontHaveToUnderstand;


import java.io.Serializable;
//import java.lang.module.ModuleDescriptor;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//deprecated: Warum tut sich JUnit immer so schwer auf einfache&zeitlose(!) Weise die Version zur Verfügung zu stellen?
//import org.junit.platform.runner.JUnitPlatform;


/**
 * Task: For information see ReadMe.txt resp. task
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          P1@Hamburg-UAS.eu
 * @version {@value #encodedVersion}
 */
public class EnvironmentAnalyzer implements Serializable {
    //
    //--VERSION:-------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                               #___~version~___YYYY_MM_DD__dd_
    final static private long encodedVersion = 2___00001_006___2023_03_13__01L;
    //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static private Version version = new Version( encodedVersion );
    static public String getDecodedVersion(){ return version.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung
    
    // serial version unique ID is based on given code version
    final static private long  serialVersionUID = version.getEncodedVersion();
    
    
    
    
    
    /**
     * Determine if assert is enabled for JVM.
     * 
     * @return <code>true</code> if assert is enabled,
     *         <code>false</code> otherwise.
     */
    public static boolean isAssertEnabled(){
        try {
            assert false : "ASSERT IS ENABLED";
            throw new RuntimeException( "ASSERT IS DISABLED" );
        }catch( final Throwable ex ){
            if( ex instanceof AssertionError ){
                return true;
            }else{
                return false;
            }//if
        }//try
    }//method()
    
    /**
     * Determine number of available cores
     * 
     * @return number of available cores
     */
    public static int getAvailableCores() {
        return Runtime.getRuntime().availableProcessors();
    }//method()
    
    /**
     * Determine Java version
     * 
     * @return java version
     */
    public static String getJavaVersion(){
        final String rawVersion = System.getProperty( "java.version" );
        if( rawVersion.startsWith("1.") ){
            //\=> java version: "1.0" - "1.4"
            return String.format( "%s (%s)",  rawVersion.substring( 2 ), rawVersion );
        }else{
            //\=> java version: "5.x" - "X.x"
            final int firstPositionOfDot = rawVersion.indexOf( "." );
            assert 0<firstPositionOfDot: "unexpected version format";
            final int mainJavaVersion = Integer.valueOf( rawVersion.substring( 0, firstPositionOfDot ));
            if( 9 > mainJavaVersion ){
                //\=> java version: "5.x" - "8.x"
                return rawVersion;
            }else{
                //\=> java version: "9.x" - "X.x"
                return Runtime.version().toString();                            // ".version()" since Java 9
            }//if
        }//if
    }//method()
    
    /**
     * Determine (JUnit-) Jupiter version
     * 
     * @return Jupiter version
     */
    /*
    public static String getJUnitJupiterVersion(){
        final String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        try{
            final Class<Test> testClass = org.junit.jupiter.api.Test.class;
            final Module module = testClass.getModule();
            if( null != module ){
                final ModuleDescriptor moduleDescriptor = module.getDescriptor();
                if( null != moduleDescriptor ){
                    final Optional<ModuleDescriptor.Version> optionalVersion = moduleDescriptor.version();
                    if( optionalVersion.isPresent() ){
                        return optionalVersion.get().toString();
                    }//if
                }//if
            }//if
            final Package pakage = testClass.getPackage();
            if( null != pakage ){
                final String version = pakage.getImplementationVersion();
                if( null != version ){
                    return version;
                }//if
            }//if
        }catch( final Exception ex ){
            final StringBuilder sb = new StringBuilder();
            sb.append( "\n\n" );
            sb.append( "UNEXPECTED probably JUnit5 related exception occurred in :  " );
            sb.append( methodName );
            sb.append( "\n" );
            sb.append( "message :  " );
            sb.append( ex.getMessage() );
            sb.append( "\n" );
            Herald.proclaimError( sb );
            ex.printStackTrace();
            Herald.proclaimError( "\nCall advisor.\n\n" );
        }//try
        return "??? <- could not be determined as result of an unexpected exception";
    }//method()
    //Note -> see https://stackoverflow.com/questions/59377304/accessing-junit-version-during-runtime
     * 
     */
    //
    /**
     * Determine (JUnit-) Platform version<br />
     * Attention: Access to JUnitPlatform is deprecated!
     * 
     * @return (JUnit-) Platform version
     */
    /*
    public static String getJUnitPlatformVersion(){
        final String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        try{
            final Class<JUnitPlatform> jUnitPlatformClass = org.junit.platform.runner.JUnitPlatform.class;  // deprecated: JUnit ist die Hölle - wie kommt man einfach&zeitlos an die Version?
            final Module module = jUnitPlatformClass.getModule();
            if( null != module ){
                final ModuleDescriptor moduleDescriptor = module.getDescriptor();
                if( null != moduleDescriptor ){
                    final Optional<ModuleDescriptor.Version> optionalVersion = moduleDescriptor.version();
                    if( optionalVersion.isPresent() ){
                        return optionalVersion.get().toString();
                    }//if
                }//if
            }//if
            final Package pakage = jUnitPlatformClass.getPackage();
            if( null != pakage ){
                final String version = pakage.getImplementationVersion();
                if( null != version ){
                    return version;
                }//if
            }//if
        }catch( final Exception ex ){
            final StringBuilder sb = new StringBuilder();
            sb.append( "\n\n" );
            sb.append( "UNEXPECTED probably JUnit5 related exception occurred in :  " );
            sb.append( methodName );
            sb.append( "\n" );
            sb.append( "message :  " );
            sb.append( ex.getMessage() );
            sb.append( "\n" );
            Herald.proclaimError( sb );
            ex.printStackTrace();
            Herald.proclaimError( "\nCall advisor.\n\n" );
        }//try
        return "??? <- could not be determined as result of an unexpected exception";
    }//method()
    //Note -> see https://stackoverflow.com/questions/59377304/accessing-junit-version-during-runtime
    */
    
}//class
