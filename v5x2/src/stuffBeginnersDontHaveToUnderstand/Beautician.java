// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
// "Home"-VCS: git@git.HAW-Hamburg.de:shf/Px/LabExercise/ZZZ_SupportStuff[.git]
package stuffBeginnersDontHaveToUnderstand;


import java.io.Serializable;
import java.time.Clock;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


/**
 * Beautician - see ReadMe.txt resp. task
 *
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          P1@Hamburg-UAS.eu 
 * @version {@value #encodedVersion} 
 */
public class Beautician implements Serializable {
    //
    //--VERSION:-------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                               #___~version~___YYYY_MM_DD__dd_
    final static private long encodedVersion = 2___00001_003___2023_03_08__01L;
    //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static private Version version = new Version( encodedVersion );
    static public String getDecodedVersion(){ return version.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung
    
    // serial version unique ID is based on given code version
    private static final long serialVersionUID = version.getEncodedVersion();
    
    
    
    static public String nanoSecondBasedTimeToString( final long nanoSeconds ){
        if ( nanoSeconds >= 1_000_000_000_000_000_000L ){
            return String.format(
                "%d.%03d.%03d.%03d,%03d.%03d.%03d[s]",
                nanoSeconds  /  1_000_000_000_000_000_000L,
               (nanoSeconds  /      1_000_000_000_000_000L) % 1_000L,
               (nanoSeconds  /          1_000_000_000_000L) % 1_000L,
               (nanoSeconds  /              1_000_000_000L) % 1_000L,
               (nanoSeconds  /                  1_000_000L) % 1_000L,
               (nanoSeconds  /                      1_000L) % 1_000L,
                nanoSeconds  %                      1_000L
            );
        }else if ( nanoSeconds >= 1_000_000_000_000_000L ){
            return String.format(
                "%d.%03d.%03d,%03d.%03d.%03d[s]",
                nanoSeconds  /  1_000_000_000_000_000L,
               (nanoSeconds  /      1_000_000_000_000L) % 1_000L,
               (nanoSeconds  /          1_000_000_000L) % 1_000L,
               (nanoSeconds  /              1_000_000L) % 1_000L,
               (nanoSeconds  /                  1_000L) % 1_000L,
                nanoSeconds  %                  1_000L
            );
        }else if ( nanoSeconds >= 1_000_000_000_000L ){
            return String.format(
                "%d.%03d,%03d.%03d.%03d[s]",
                nanoSeconds  /  1_000_000_000_000L,
               (nanoSeconds  /      1_000_000_000L) % 1_000L,
               (nanoSeconds  /          1_000_000L) % 1_000L,
               (nanoSeconds  /              1_000L) % 1_000L,
                nanoSeconds  %              1_000L
            );
        }else if ( nanoSeconds >= 1_000_000_000L ){
            return String.format(
                "%d,%03d.%03d.%03d[s]",
                nanoSeconds  /  1_000_000_000L,
               (nanoSeconds  /      1_000_000L) % 1_000L,
               (nanoSeconds  /          1_000L) % 1_000L,
                nanoSeconds  %          1_000L
            );
        }else if ( nanoSeconds >= 1_000_000L ){
            return String.format(
                "%d,%03d.%03d[ms]",
                nanoSeconds  /  1_000_000L,
               (nanoSeconds  /      1_000L) % 1_000L,
                nanoSeconds  %      1_000L
            );
        }else if ( nanoSeconds >= 1_000L ){
            return String.format(
                "%d,%03d[us]",
                nanoSeconds  /  1_000L,
                nanoSeconds  %  1_000L
            );
        }else{
            return String.format(
                "%d[ns]",
                nanoSeconds
            );
        }//if
    }//method()
    
    
    static public String getPimpedTime(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone( ZoneId.of( "Europe/Berlin") ).format( Clock.systemUTC().instant() );
    }//method()
    
}//class
