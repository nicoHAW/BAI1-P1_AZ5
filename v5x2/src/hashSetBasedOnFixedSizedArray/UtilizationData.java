// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package hashSetBasedOnFixedSizedArray;


import stuffBeginnersDontHaveToUnderstand.Version;


// Seit Java14 gibt es "record"s, die sich hier anbieten würden.
// Wir kennen diese aber nicht und daher finden sie hier keinen Einsatz.
/**
 * Demo class containg utilization data.
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          Px@Hamburg-UAS.eu
 * @version {@value #encodedVersion}
 */
public class UtilizationData {
    //
    //--VERSION:-------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                               #___~version~___YYYY_MM_DD__dd_
    final static private long encodedVersion = 2___00002_001___2023_05_17__01L;
    //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static private Version version = new Version( encodedVersion );
    /**
     * The method {@link #getDecodedVersion()} delivers the code version as reground/readable String.
     * @return version as decoded/readable String.
     */
    static public String getDecodedVersion(){ return version.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung.
    
    
    
    
    
    final private int cardinality;
    final private double utilization;
    final private double variance;
    final private double standardDeviation1;                                    // Standardabweichung der Grundgesamtheit ("unkorrigierte" Standardabweichung)
    final private double standardDeviation2;                                    // Standardabweichung der Stichprobe        ("korrigierte" Standardabweichung)
    
    
    
    /**
     * Constructs a new record of utilization data
     *
     * @param cardinality               cardinality
     * @param utilization               utilization
     * @param variance                  variance
     * @param standardDeviation(1st)    standard deviation uncorrected  (Standardabweichung der Grundgesamtheit)
     * @param standardDeviation(2nd)    standard deviation corrected    (Standardabweichung der Stichprobe)
     */
    public UtilizationData(
        final int cardinality,
        final double utilization,
        final double variance,
        final double standardDeviation1,                                        // Standardabweichung der Grundgesamtheit ("unkorrigierte" Standardabweichung)
        final double standardDeviation2                                         // Standardabweichung der Stichprobe        ("korrigierte" Standardabweichung)
    ){
        this.cardinality = cardinality;
        this.utilization = utilization;
        this.variance = variance;
        this.standardDeviation1 = standardDeviation1;
        this.standardDeviation2 = standardDeviation2;
    }//constructor()
    
    
    
    @Override
    public String toString(){
        return String.format(
            "[cardinality=%d, utilization=%f, variance=%f, su=%f, sc=%f]",
            cardinality,
            utilization,
            variance,
            standardDeviation1,
            standardDeviation2
        );
    }//method()
    
}//class
