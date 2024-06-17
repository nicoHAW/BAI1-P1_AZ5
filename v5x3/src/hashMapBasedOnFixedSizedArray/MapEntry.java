// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package hashMapBasedOnFixedSizedArray;


import java.util.Map.Entry;
import java.util.Objects;

import stuffBeginnersDontHaveToUnderstand.Version;


/**
 * Demo class implementing interface Map.Entry.
 * For further Details see (e.g.):
 * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.Entry.html
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          Px@Hamburg-UAS.eu
 * @version {@value #encodedVersion}
 */
public class MapEntry<K,V> implements Entry<K,V> {
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
    
    
    
    
    
    private K key;
    private V value;
    
    
    
    MapEntry( final K key,  final V value ){
        this.key = key;
        this.value = value;
    }//constructor()
    
    
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.Entry.html -> getKey() requires:
     * Returns the key corresponding to this entry.
     */
    @Override
    public K getKey(){
        return key;
    }//method()

    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.Entry.html -> getValue() requires:
     * Returns the value corresponding to this entry.
     * If the mapping has been removed from the backing map (by the iterator's remove operation),
     * the results of this call are undefined.
     * 
     * implementations may, but are not required to, throw IllegalStateException if the entry has been removed from the backing map.
     */
    @Override
    public V getValue(){
        return value;
    }//method()

    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.Entry.html -> getValue() requires:
     * Replaces the value corresponding to this entry with the specified value (optional operation). (Writes through to the map.)
     * The behavior of this call is undefined if the mapping has already been removed from the map (by the iterator's remove operation).
     * 
     * implementations may, but are not required to, throw exceptions...
     */
    @Override
    public V setValue(V value){
        final V oldValue = this.value;
        this.value = value;
        return oldValue;
    }//method()
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.Entry.html -> equals() requires:
     * Compares the specified object with this entry for equality.
     * Returns true if the given object is also a map entry and the two entries represent the same mapping.
     * More formally, two entries e1 and e2 represent the same mapping if
     *     (e1.getKey()==null   ? e2.getKey()==null   : e1.getKey().equals(e2.getKey()))  &&
     *     (e1.getValue()==null ? e2.getValue()==null : e1.getValue().equals(e2.getValue()))
     * This ensures that the equals method works properly across different implementations of the Map.Entry interface.
     * 
     * The implementation below is in harmony with that
     */
    @Override
    public boolean equals( final Object otherObject ){
        if ( this == otherObject ) return true;
        if ( null == otherObject ) return false;
        if ( ! ( otherObject instanceof Entry<?,?> )) return false;
        
        final Entry<?,?> otherEntry = (Entry<?,?>)( otherObject );
        if( ! Objects.equals( key, otherEntry.getKey() )) return false;
        if( ! Objects.equals( value, otherEntry.getValue() )) return false;
        return true;
    }//method()
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.Entry.html -> hashCode() requires:
     * Returns the hash code value for this map entry. The hash code of a map entry e is defined to be:
     *     (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
     *     (e.getValue()==null ? 0 : e.getValue().hashCode())
     * This ensures that e1.equals(e2) implies that e1.hashCode()==e2.hashCode() for any two Entries e1 and e2,
     * as required by the general contract of Object.hashCode.
     */
    @Override
    public int hashCode(){
        return Objects.hash( key, value );
    }//method()
    
    @Override
    public String toString(){
        return String.format(
            "[%s->%s]",
            key,
            value
        );
    }//method()
    
}//class
