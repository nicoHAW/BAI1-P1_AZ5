// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
/*
 * Demo-Implementierung um HashMap zu erklären.
 * ============================================
 * Ziel dieses Codes ist es, das Interface Map mit einer möglichst einfachen HashMap
 * zu implementieren und auf dieses Weise die Funktion einer HashMap zu verdeutlichen.
 * Die Priorität liegt auf der Veständlichkeit. "Vieles" ginge effizienter&performanter;
 * insbesondere ein Array fester Größe macht eigentlich keinen Sinn.
 * Aber wären diese Aspekte berücksichtigt wurden, wäre der Code komplizierter.
 * 
 * Inzwischen ist die Implemetierung "alt".
 * Sie wurde ("damals") für Java8 entwickelt.
 * Ist aber zum Zeitpunkt der "Online-Stellung" immer noch gültig
 * bzw. "gerade" auf Gültigkeit geprüft wurden.
 * 
 * Wie immer gilt: ;-)
 *
 * Deutsch :    Erklärender Kommentar für Programmieranfänger
 *              Dieser Kommentar würde im "Normalfall" nicht da stehen
 *
 * Englisch :   Kommentar der auch im "Normalfall" da stehen würde
 */
package hashMapBasedOnFixedSizedArray;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import stuffBeginnersDontHaveToUnderstand.Version;


/**
 * Demo class {@link Card HashMapBasedOnFixedSizedArray} is an educational implementation
 * of and to explain Map.
 * This implementation of interface Map is internally using a based on fixed sized array
 * to keep the code as simple as possible.
 * For the same reason null is NOT supported,
 *   o) neither as parameter itself,
 *   o) nor as any kind of key,
 *   o) nor as any kind of value
 * 
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          Px@Hamburg-UAS.eu
 * @version {@value #encodedVersion}
 */
public class HashMapBasedOnFixedSizedArray<K,V> implements Map<K,V> {
    //
    //--VERSION:-------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                               #___~version~___YYYY_MM_DD__dd_
    final static private long encodedVersion = 2___00002_002___2023_05_19__01L;
    //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static private Version version = new Version( encodedVersion );
    /**
     * The method {@link #getDecodedVersion()} delivers the code version as reground/readable String.
     * @return version as decoded/readable String.
     */
    static public String getDecodedVersion(){ return version.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung.
    
    
    
    
    
    final static int defaultHashTableSize = 8;                                  // default size of hashTable
    
    final private List<Map.Entry<K,V>>[] hashTable;
    
    
    
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html requires:
     * All general-purpose map implementation classes should provide two "standard" constructors:
     * 1.) a void (no arguments) constructor which creates an empty map, and
     * 2.) a constructor with a single argument of type Map
     */
    public HashMapBasedOnFixedSizedArray( final int fixedHashTableSize ){
        assert 0<fixedHashTableSize  :  "Illegal Argument :  Only positive hash table size (>0) supported";
        
        @SuppressWarnings("unchecked")
        final List<Map.Entry<K,V>>[] theHashTable = ( List<Map.Entry<K,V>>[] )( new List[ fixedHashTableSize ] );
        for( int hashTableIndex=fixedHashTableSize; --hashTableIndex>=0; ){
            theHashTable[hashTableIndex] = new ArrayList<Map.Entry<K,V>>();
        }//for
        hashTable = theHashTable;
    }//constructor()
    //
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html requires:
     * a void (no arguments) constructor which creates an empty map
     */
    public HashMapBasedOnFixedSizedArray(){
        this( defaultHashTableSize );                                           // use default hash table size
    }//constructor()
    //
    //
    public HashMapBasedOnFixedSizedArray(
        final Map< ? extends K,  ? extends V >  mapToBeIntegrated,
        final int  fixedHashTableSize
    ){
        this( fixedHashTableSize );
        iPutAll( mapToBeIntegrated );
    }//constructor()
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html requires:
     * a constructor with a single argument of type Map, which creates a new map with the same key-value mappings as its argument.
     * In effect, the latter constructor allows the user to copy any map, producing an equivalent map of the desired class.
     */
    public HashMapBasedOnFixedSizedArray( final Map<? extends K,  ? extends V> mapToBeIntegrated ){
        this( mapToBeIntegrated, defaultHashTableSize );                        // use default hash table size
    }//constructor()
    
    
    
    
    
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html -> size() requires:
     * Returns the number of key-value mappings in this map.
     * If the map contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     */
    @Override
    public int size(){
        long sum = 0;
        for( final List<Map.Entry<K,V>> collisionList : hashTable ){
            sum += collisionList.size();
        }//for
        return (sum<=Integer.MAX_VALUE)  ?  (int)( sum )  :  Integer.MAX_VALUE; // see above - the interface requires:  If this set contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
    }//method()
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html -> isEmpty() requires:
     * Returns true if this map contains no key-value mappings.
     */
    @Override
    public boolean isEmpty(){
        for( final List<Map.Entry<K,V>> collisionList : hashTable ){
            if( ! collisionList.isEmpty() ){
                return false;
            }//if
        }//for
        return true;
    }//method()
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html -> containsKey() requires:
     * Returns true if this map contains a mapping for the specified key.
     * More formally, returns true if and only if this map contains a mapping for a key k such that Objects.equals(key, k).
     * (There can be at most one such mapping.)
     */
    @Override
    public boolean containsKey( final Object key ){
        assert null!=key :  "\"NullPointerException\"/IllegalArgument :  null is NOT supported as argument";
        
        final int hashTableIndex = scaleHashCode( key.hashCode() );
        final List<Entry<K,V>> collisionList = hashTable[ hashTableIndex ];
        for( final Entry<K,V> entry : collisionList ){
            if( key.equals( entry.getKey() )){
                return true;
            }//if
        }//for
        return false;
    }//method()
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html -> containsValue() requires:
     * Returns true if this map maps one or more keys to the specified value.
     * More formally, returns true if and only if this map contains at least one mapping to a value v such that Objects.equals(value, v).
     * This operation will probably require time linear in the map size for most implementations of the Map interface.
     */
    @Override
    public boolean containsValue( final Object value ){
        for( final List<Map.Entry<K,V>> collisionList : hashTable ){
            for( final Entry<K,V> entry : collisionList ){
                if( value.equals( entry.getValue() )){
                    return true;
                }//if
            }//for
        }//for
        return false;
    }//method()
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html -> get() requires:
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     * More formally, if this map contains a mapping from a key k to a value v such that Objects.equals(key, k),
     * then this method returns v; otherwise it returns null. (There can be at most one such mapping.)
     * 
     * If this map permits null values, then a return value of null does not necessarily indicate that the map contains no mapping for the key;
     * it's also possible that the map explicitly maps the key to null.
     * The containsKey operation may be used to distinguish these two cases.
     */
    @Override
    public V get( final Object key ){
        assert null!=key :  "\"NullPointerException\"/IllegalArgument :  null is NOT supported as argument for key";
        
        final int hashTableIndex = scaleHashCode( key.hashCode() );
        final List<Entry<K,V>> collisionList = hashTable[ hashTableIndex ];
        for( final Entry<K,V> entry : collisionList ){
            if( key.equals( entry.getKey() )){
                final V wantedValue = entry.getValue();
                return wantedValue;
            }//if
        }//for
        //\=> key is NOT in map
        return null;                                                            // NO value for search key available
    }//method()
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html -> put() requires:
     * Associates the specified value with the specified key in this map (optional operation).
     * If the map previously contained a mapping for the key, the old value is replaced by the specified value.
     * (A map m is said to contain a mapping for a key k if and only if m.containsKey(k) would return true.)
     */
    @Override
    public V put( final K key,  final V value ){
        assert null!=key :    "\"NullPointerException\"/IllegalArgument :  null is NOT supported as argument for key";
        assert null!=value :  "\"NullPointerException\"/IllegalArgument :  null is NOT supported as argument for value";
        
        final int hashTableIndex = scaleHashCode( key.hashCode() );
        final List<Entry<K,V>> collisionList = hashTable[ hashTableIndex ];
        for( final Entry<K,V> entry : collisionList ){
            if( key.equals( entry.getKey() )){
                final V oldValue = entry.getValue();
                entry.setValue( value );
                return oldValue;                                                // return old value that was overwritten
            }//if
        }//for
        //\=> key is NOT in map, yet
        // insert new map entry (key-value pair).
        final Entry<K,V> newEntry = new MapEntry<K,V>( key, value );
        collisionList.add( newEntry );
        return null;                                                            // NO old value to return
    }//method()
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html -> putAll() requires:
     * Copies all of the mappings from the specified map to this map (optional operation). 
     * The effect of this call is equivalent to that of calling put(k, v) on this map once for each mapping from key k to value v in the specified map.
     * The behavior of this operation is undefined if the specified map is modified while the operation is in progress.
     */
    @Override
    public void putAll( final Map<? extends K,  ? extends V> mapToBeIntegrated ){
        iPutAll( mapToBeIntegrated );
    }//method()
    //
    // internal putAll that is private(!) and can be used by the constructor also
    private void iPutAll( final Map<? extends K,  ? extends V> mapToBeIntegrated ){
        /*
         * 1.st verson - more "simple"
        for( final K key : mapToBeIntegrated.keySet() ){
            assert null!=key : "\"NullPointerException\"/IllegalArgument :  null is NOT supported as any kind of key - even if contained inside another map";
            final V value = mapToBeIntegrated.get( key );
            assert null!=value :  "\"NullPointerException\"/IllegalArgument :  null is NOT supported as any kind of value - even if contained inside another map";
            put( key, value );
        }//for
        */
        // 2nd version - more "efficient"
        for( final Entry<? extends K, ? extends V> entry : mapToBeIntegrated.entrySet() ){
            assert null!=entry : "\"NullPointerException\"/IllegalArgument :  null is NOT supported as any kind of entry - even if contained inside another map";
            final K key = entry.getKey();
            assert null!=key : "\"NullPointerException\"/IllegalArgument :  null is NOT supported as any kind of key - even if contained inside another map";
            final V value = entry.getValue();
            assert null!=value :  "\"NullPointerException\"/IllegalArgument :  null is NOT supported as any kind of value - even if contained inside another map";
            put( key, value );
        }//for
    }//method()
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html -> remove() requires:
     * Removes the mapping for a key from this map if it is present (optional operation).
     * More formally, if this map contains a mapping from key k to value v such that Objects.equals(key, k), that mapping is removed.
     * (The map can contain at most one such mapping.)
     * Returns the value to which this map previously associated the key, or null if the map contained no mapping for the key.
     * If this map permits null values, then a return value of null does not necessarily indicate that the map contained no mapping for the key;
     * it's also possible that the map explicitly mapped the key to null.
     * The map will not contain a mapping for the specified key once the call returns.
     * */
    @Override
    public V remove( final Object key ){
        final int hashTableIndex = scaleHashCode( key.hashCode() );
        final List<Entry<K,V>> collisionList = hashTable[ hashTableIndex ];
        final Iterator<Entry<K,V>> entryIterator = collisionList.iterator();
        while( entryIterator.hasNext() ){
            final Entry<K,V> entry = entryIterator.next();
            if( key.equals( entry.getKey() )){
                final V oldValue = entry.getValue();
                entryIterator.remove();
                return oldValue;
            }//if
        }//for
        //\=> key was NOT in map
        return null;
    }//method()
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html -> clear() requires:
     * Removes all of the mappings from this map (optional operation). The map will be empty after this call returns.
     */
    @Override
    public void clear(){
        for( int hashTableIndex=hashTable.length; --hashTableIndex>=0; ){
            hashTable[hashTableIndex].clear();
        }//for
    }//method()
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html -> keySet() requires:
     * Returns a Set view of the keys contained in this map.
     * The set is backed by the map, so changes to the map are reflected in the set, and vice-versa.
     * If the map is modified while an iteration over the set is in progress
     * (except through the iterator's own remove operation), the results of the iteration are undefined.
     * The set supports element removal, which removes the corresponding mapping from the map,
     * via the Iterator.remove, Set.remove, removeAll, retainAll, and clear operations.
     * It does not support the add or addAll operations.
     */
    @Override
    public Set<K> keySet(){
        final Set<K> resultKeySet = new HashSet<K>();
        for( int hashTableIndex=hashTable.length; --hashTableIndex>=0; ){
            final List<Entry<K,V>> collisionList = hashTable[ hashTableIndex ];
            for( final Entry<K,V> entry : collisionList ){
                resultKeySet.add( entry.getKey() );
            }//for
        }//for
        return resultKeySet;
    }//method()
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html -> values() requires:
     * Returns a Collection view of the values contained in this map.
     * The collection is backed by the map, so changes to the map are reflected in the collection, and vice-versa.
     * If the map is modified while an iteration over the collection is in progress
     * (except through the iterator's own remove operation), the results of the iteration are undefined.
     * The collection supports element removal, which removes the corresponding mapping from the map,
     * via the Iterator.remove, Collection.remove, removeAll, retainAll and clear operations.
     * It does not support the add or addAll operations.
     */
    @Override
    public Collection<V> values(){
        final Set<V> resultValueSet = new HashSet<V>();
        for( final List<Map.Entry<K,V>> collisionList : hashTable ){
            for( final Entry<K,V> entry : collisionList ){
                final V currentValue = entry.getValue();
                resultValueSet.add(  currentValue );
            }//for
        }//for
        return resultValueSet;
    }//method()
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html -> entrySet() requires:
     * Returns a Set view of the mappings contained in this map.
     * The set is backed by the map, so changes to the map are reflected in the set, and vice-versa.
     * If the map is modified while an iteration over the set is in progress
     * (except through the iterator's own remove operation, or through the setValue operation on a map entry returned by the iterator)
     * the results of the iteration are undefined.
     * The set supports element removal, which removes the corresponding mapping from the map,
     * via the Iterator.remove, Set.remove, removeAll, retainAll and clear operations.
     * It does not support the add or addAll operations.
     */
    @Override
    public Set<Entry<K, V>> entrySet(){
        final Set<Entry<K, V>> resultSet = new HashSet<Entry<K, V>>();
        for( int hashTableIndex=hashTable.length; --hashTableIndex>=0; ){
            final List<Entry<K,V>> collisionList = hashTable[ hashTableIndex ];
            for( final Entry<K,V> entry : collisionList ){
                resultSet.add( entry );
            }//for
        }//for
        return resultSet;
    }//method()
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html -> equals() requires:
     * Compares the specified object with this map for equality.
     * Returns true if the given object is also a map and the two maps represent the same mappings.
     * More formally, two maps m1 and m2 represent the same mappings if m1.entrySet().equals(m2.entrySet()).
     * This ensures that the equals method works properly across different implementations of the Map interface.
     */
    @Override
    public boolean equals( final Object otherObject ){
        if( this == otherObject )  return true;
        if( null == otherObject )  return false;
        if( ! ( otherObject instanceof Map ))  return false;
        
        @SuppressWarnings("unchecked")
        final Map<Object,Object> otherMap = (Map<Object,Object>)( otherObject );
        return entrySet().equals( otherMap.entrySet() );
    }//method()
    
    /*
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Map.html -> hashCode() requires:
     * Returns the hash code value for this map.
     * The hash code of a map is defined to be the sum of the hash codes of each entry in the map's entrySet() view.
     * This ensures that m1.equals(m2) implies that m1.hashCode()==m2.hashCode() for any two maps m1 and m2,
     * as required by the general contract of Object.hashCode().
     */
    @Override
    public int hashCode(){
        final int prime = 31;
        int theHashCode = 0;
        for( int hashTableIndex=hashTable.length; --hashTableIndex>=0; ){
            final List<Entry<K,V>> collisionList = hashTable[ hashTableIndex ];
            for( final Entry<K,V> entry : collisionList ){
                theHashCode = prime*theHashCode ^ entry.hashCode();
            }//for
        }//for
        return theHashCode;
    }//method()
    
    
    
    //##########################################################################
    
    
    
    /*
     * Die folgende Methode legt den internen Aufbau der Klasse offen
     * und unterlaeuft damit die Idee der Datenkapselung ;-)
     * Sinn dieser Klasse ist ja "Dinge" zu erklaeren (und offen zu legen).
     */
    public void printInternalStructure(){
        System.out.printf( "vvvvv\n" );                                         // mark beginning
        for( int hashTableIndex=0; hashTableIndex<hashTable.length; hashTableIndex++ ){
            System.out.printf( "[%03d]:\n",  hashTableIndex );                  // hash table index
            final List<Map.Entry<K,V>> collisionList = hashTable[hashTableIndex];
            final int lastPosition = collisionList.size() -1;
            for( int listIndex=0; listIndex<=lastPosition; listIndex++ ){
                System.out.printf( "  |\n" );                               // separator between elements of collision list
                final Entry<K,V> entry = collisionList.get( listIndex );
                final K key = entry.getKey();
                final V value = entry.getValue();
                System.out.printf( " (+)----->[ %s ]----->>> %s\n",  key, value );
            }//for
            if( hashTableIndex<hashTable.length-1 )  System.out.printf( "\n" );
        }//for
        System.out.printf( "^^^^^\n" );                                         // mark end
    }//method()
    
    
    
    /*
     * Scale hashCode into required range
     */
    private int scaleHashCode( final int hashCode ){
        final int hashTableIndex = hashCode % hashTable.length;
        return  (hashTableIndex<0)  ?  -hashTableIndex  :  hashTableIndex;
    }//method()
    
}//class
