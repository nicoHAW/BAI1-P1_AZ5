// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
// "Home"-VCS:  git@git.HAW-Hamburg.de:shf/Px/LabExercise/ZZZ_SupportStuff[.git]
package stuffBeginnersDontHaveToUnderstand;


import java.io.Serializable;


/**
 * The single purpose of this class is to hold the &quot;project version&quot;.
 * Since the code/project is an exercise, it's named {@link GivenCodeVersion}.
 * It's not expected or wanted that there are different release branches.
 * There has to be only one single release branch (for the "given code")!!!
 * Hence, there is a single/central project version
 * that is stored in this class.<br />
 * <br />
 * <code>
 * Coding/format of (Given) Code Version<br />
 * &nbsp;&nbsp;c: coding format<br />
 * &nbsp;&nbsp;m: main version<br />
 * &nbsp;&nbsp;s: sub version<br />
 * &nbsp;&nbsp;Y: year<br />
 * &nbsp;&nbsp;M: month<br />
 * &nbsp;&nbsp;D: day<br />
 * &nbsp;&nbsp;d: version of day<br />
 * <br />
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; c___mmmm_sss___YYYY_MM_DD__ddd<br />
 * &nbsp;&nbsp;e.g.&nbsp;&nbsp;                     1___0001_014___2021_11_20__001<br />
 * <br />
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; c___mmmmm_sss___YYYY_MM_DD__dd<br />
 * &nbsp;&nbsp;e.g.&nbsp;&nbsp;                     2___00001_014___2021_11_20__01
 * <code />
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          Px@Hamburg-UAS.eu 
 * @version {@value #encodedOwnClassVersion} 
 */
public class GivenCodeVersion implements Serializable {
    //
    //--VERSION:----------------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv------//#####################################
    //  ========                                        #___~version~___YYYY_MM_DD__dd_     //### HERE:
    final static private long encodedGivenCodeVersion = 2___00002_004___2023_05_19__01L;    //### <<<=== !!! GIVEN CODE VERSION !!!
    //------------------------=======================---#---^^^^^-^^^---^^^^-^^-^^--^^      //#####################################
    //#############################################################################################################################
    final static private long encodedOwnClassVersion  = 2___00002_009___2023_03_08__02L;    // encoded version of class itself
    final static private Version givenCodeVersion = new Version( encodedGivenCodeVersion );
    final static private Version ownClassVersion  = new Version( encodedOwnClassVersion );
    // Obiges (ab VERSION) dient nur der Versionierung.
    
    // serial version unique ID is based on given code version
    private static final long serialVersionUID = givenCodeVersion.getEncodedVersion();
    
    
    
    
    
    /**
     * The method {@link #getEncodedVersion()} delivers the given code / project version.
     * 
     * @return version
     */
    static public long getEncodedVersion(){
        return givenCodeVersion.getEncodedVersion();
    }//method()
    
    /**
     * The method {@link #getDecodedVersion()} delivers the given code / project version as reground/readable String.
     * 
     * @return version as decoded/readable String.
     */
    static public String getDecodedVersion(){
        return givenCodeVersion.getDecodedVersion();
    }//method()
    
    
    /**
     * The method {@link #getEncodedVersionOfClassItself()} delivers the (given code) class version itself.
     * 
     * @return version
     */
    static public long getEncodedVersionOfClassItself(){
        return ownClassVersion.getEncodedVersion();
    }//method()
    
    /**
     * The method {@link #getDecodedVersionOfClassItself()} delivers the (given code) class version itself as reground/readable String.
     * 
     * @return version as decoded/readable String.
     */
    static public String getDecodedVersionOfClassItself(){
        return ownClassVersion.getDecodedVersion();
    }//method()
    
}//class
