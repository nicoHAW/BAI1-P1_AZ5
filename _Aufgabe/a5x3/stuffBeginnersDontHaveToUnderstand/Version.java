// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
// "Home"-VCS: git@git.HAW-Hamburg.de:shf/Px/LabExercise/ZZZ_SupportStuff[.git]
package stuffBeginnersDontHaveToUnderstand;


import java.io.Serializable;


/**
 * The single purpose of the class {@link Version} is to hold the &quot;code version&quot;.<br />
 * <br />
 * <code>
 * Coding/format for (code) version<br />
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
 * @version {@value #encodedV2} 
 */
public class Version implements Serializable {
    //
    //--VERSION:--(of "Version-class" itself)--#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                               #___~version~___YYYY_MM_DD__dd_
    final static private long encodedV2 =      2___00002_009___2023_04_18__01L; // "V2" ::= V^2 = (class) Version Version  resp. Version of the class Version
    //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    //
    static {
        assert isCodingValid( encodedV2 ) : "setup error : faulty version number coded";  // we are all humans - check that "leading one" has NOT got lost
    }//static block resp. "static initializer" ~ "class-constructor()"
    //
    private static boolean isCodingValid( final long version ){
        final int leadingDigit = (int)( version / 1__000_000__000_000__000_000L );
        return 1<=leadingDigit && leadingDigit<=2;
    }//method(()
    //
    final static private Version version = new Version( encodedV2 );
    /**
     * The method {@link #getDecodedVersion()} delivers the code version as reground/readable String.
     * @return version as decoded/readable String.
     */
    static public String getDecodedV2(){ return version.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung.
    
    // serial version unique ID is based on given code version
    private static final long serialVersionUID = encodedV2;
    
    
    
    
    
    /**
     * The encoded (client) version for some "other" class
     */
    private final long encodedVersion;
    
    
    
    /**
     * The constructor checks given (client) version number if correctly coded and stores it
     * 
     * @param encodedVersion  the encoded (client) version number
     */
    public Version( final long encodedVersion ){
        if( ! isCodingValid( encodedVersion )){ throw new IllegalArgumentException( "Faulty coding of version"); }
        this.encodedVersion = encodedVersion;
    }//constructor()
    
    
    
    /**
     * The method {@link #getVersionNumber()} delivers the encoded (client) version number.
     * 
     * @return version
     */
    public long getEncodedVersion(){
        return encodedVersion;
    }//method()
    
    /**
     * The method {@link #getDecodedVersion()} delivers the given (client) code version as
     * reground/readable String.
     * 
     * @return version as decoded/readable String.
     */
    public String getDecodedVersion(){
        int mainVersion = 0;
        int subVersion = 0;
        int year = 0;
        int month = 0;
        int day = 0;
        int dailyVersion = 0;
        //
        long tmp = encodedVersion;
        final int leadingDigit = (int)( encodedVersion / 1__000_000__000_000__000_000L );
        switch( leadingDigit ){
            //  _1___mmmm_sss___YYYY_MM_DD__ddd
            case 1:
                dailyVersion = (int)( tmp %   1_000 );
                tmp /=   1_000;
                day =          (int)( tmp %     100 );
                tmp /=     100;
                month =        (int)( tmp %     100 );
                tmp /=     100;
                year =         (int)( tmp %  10_000 );
                tmp /=  10_000;
                subVersion =   (int)( tmp %   1_000 );
                tmp /=   1_000;
                mainVersion =  (int)( tmp %  10_000 );
                tmp /=  10_000;
                assert 1 == tmp : "Uuuupppss : internal error - there (should) have been checks before";
            break;
            //
            //  _2___mmmmm_sss___YYYY_MM_DD__dd
            case 2:
                dailyVersion = (int)( tmp %     100 );
                tmp /=     100;
                day =          (int)( tmp %     100 );
                tmp /=     100;
                month =        (int)( tmp %     100 );
                tmp /=     100;
                year =         (int)( tmp %  10_000 );
                tmp /=  10_000;
                subVersion =   (int)( tmp %   1_000 );
                tmp /=   1_000;
                mainVersion =  (int)( tmp % 100_000 );
                tmp /= 100_000;
                assert 2 == tmp : "Uuuupppss : internal error - there (should) have been checks before";
            break;
            //
            //  undefined
            default:
                assert false : "Uuuupppss : internal error - there (should) have been checks before";
        }//switch
        //
        final StringBuffer sb = new StringBuffer( "" );
        sb.append( Long.toString( mainVersion ));
        sb.append( "." );
        sb.append( String.format( "%03d", subVersion ));
        sb.append( "   ( " );
        sb.append( String.format( "%04d", year ));
        sb.append( "/" );
        sb.append( String.format( "%02d", month ));
        sb.append( "/" );
        sb.append( String.format( "%02d", day ));
        sb.append( " [#" );
        sb.append( String.format( "%d", dailyVersion ));
        sb.append( "] )" );
        return sb.toString();
    }//method()
    
}//class
