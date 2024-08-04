// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
/*
 * Demo-Implementierung um Hashing zu erklären.
 * ============================================
 * Ziel dieses Codes ist es, das Interface Set mit einer möglichst einfachen HashSet
 * zu implementieren und auf dieses Weise die Funktion einer HashSet zu verdeutlichen.
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
package hashSetBasedOnFixedSizedArray;

 
import java.util.*;
import stuffBeginnersDontHaveToUnderstand.Version;


/**
 * Demo class to explain hashing.
 * This implementation of interface Set is internally
 * using a hash table based on fixed sized array to keep the code as simple as possible.
 * null as (set-)element or parameter is NOT supported.
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          Px@Hamburg-UAS.eu
 * @version {@value #encodedVersion}
 */
public class HashSetBasedOnFixedSizedArray<T> implements Set<T> {
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
    
    
    
    
    
    // "16" damit Statistiken auf eine Bildschirmseite passen
    final static int defaultHashTableSize = 16;                                 // default size of hashTable
    
    // ARRAY(!) über Listen.
    // Das ARRAY ist die HashTable und die Listen sind die jeweiligen Kollisions-Listen für Elemente,
    // die sich den gleichen HashCode teilen.
    final private List<T>[] hashTable;
    
    
    
    
    
    /*
     * Im Zusammenhang mit der "Generic-Problematik",
     * also der Java internen Generic-Implementierungs-Entscheidung bei Einführung von Java5, das Java1.4 ablöste,
     * MUSS das Array über generische Listen mit: "... ( List<T>[] )( new List[ ... ] ) ..." erzeugt werden.
     * Leider führt dies zu einer "unchecked"-Warnung vom Compiler, die mit "@SuppressWarnings("unchecked")" unterdrückt wird.
     */
    /**
     * Hash Set internally using fixed size hash table (resp. array).
     * See https://docs.oracle.com/javase/8/docs/api/ -> Set
     * defining the behavior of this implementation.
     * 
     * @param fixedHashTableSize  the internal fixed size of the hash table
     */
    public HashSetBasedOnFixedSizedArray( final int fixedHashTableSize ){
        assert 0<fixedHashTableSize  :  "Illegal Argument :  Only positive hash table size (>0) supported";
        
        @SuppressWarnings("unchecked")
        final List<T>[] theHashTable = ( List<T>[] )( new List[ fixedHashTableSize ] );
        for( int hashTableIndex=fixedHashTableSize; --hashTableIndex>=0; ){
            theHashTable[hashTableIndex] = new ArrayList<T>();
        }//for
        hashTable = theHashTable;
    }//constructor()
    //
    /**
     * Hash Set internally using fixed size hash table (resp. array).
     * See https://docs.oracle.com/javase/8/docs/api/ -> Set
     * defining the behavior of this implementation.
     */
    public HashSetBasedOnFixedSizedArray(){
        this( defaultHashTableSize );                                           // use default hash table size
    }//constructor()
    
    
    
    
    
    /*
     * https://docs.oracle.com/javase/8/docs/api/ -> Set -> add requires
     * Adds the specified element to this set if it is not already present (optional operation).
     * More formally, adds the specified element e to this set
     * if the set contains no element e2 such that (e==null ? e2==null : e.equals(e2)).
     * If this set already contains the element, the call leaves the set unchanged and returns false.
     * In combination with the restriction on constructors, this ensures that sets never contain duplicate elements.
     * The stipulation above does not imply that sets must accept all elements;
     * sets may refuse to add any particular element, including null, and throw an exception,
     * as described in the specification for Collection.add.
     * Individual set implementations should clearly document any restrictions on the elements that they may contain.
     * 
     * Returns  true if this set did not already contain the specified element
     */
    /**
     * Adds element to set as defined by set-&collection-interface.
     * null is NOT accepted as element. The element must NOT be null.
     * 
     * @param  elem  the element to be added
     * @return  true if this set did not already contain the specified element
     */
    @Override
    public boolean add( final T elem ){
        assert null!=elem :  "\"NullPointerException\"/IllegalArgument :  null is NOT supported as argument";
        
        final int hashTableIndex = scaleHashCode( elem.hashCode() );
        final List<T> collisionList = hashTable[ hashTableIndex ];
        final boolean alreadyContained = collisionList.contains( elem );
        if( alreadyContained )   return false;  // see above - the interface requires:  If this set already contains the element, the call leaves the set unchanged and returns false. ...
        return collisionList.add( elem );
    }//method()
    
    /*
     * https://docs.oracle.com/javase/8/docs/api/ -> Set -> addAll requires:
     * Adds all of the elements in the specified collection to this set if they're not already present (optional operation).
     * If the specified collection is also a set, the addAll operation effectively modifies this set
     * so that its value is the union of the two sets.
     * The behavior of this operation is undefined if the specified collection is modified while the operation is in progress.
     */
    /**
     * Adds elements of another collection to set as defined by set-&collection-interface.
     * null is NOT accepted as collection resp. parameter. The collection must NOT be null.
     * 
     * @param  coll  the collection that contains the elements to be added
     * @return  true if this set did not already contain the specified element
     */
    @Override
    public boolean addAll( final Collection<? extends T> coll ){
        assert null!=coll :  "\"NullPointerException\"/IllegalArgument :  null is NOT supported as argument";
        
        boolean success = true;
        for( final T elem : coll ){
            success &= add( elem );                                             // add is expected to be always successful => hence, no "correcting" actions are implemented
        }//for
        return success;
    }//method()
    
    
    
    /*
     * https://docs.oracle.com/javase/8/docs/api/ -> Set -> clear requires:
     * Removes all of the elements from this set (optional operation). The set will be empty after this call returns.
     */
    @Override
    public void clear(){
        for( int hashTableIndex=hashTable.length; --hashTableIndex>=0; ){
            hashTable[hashTableIndex].clear();
        }//for
    }//method()
    
    
    
    /*
     * https://docs.oracle.com/javase/8/docs/api/ -> Set -> contains requires:
     * Returns:  true if this set contains the specified element. More formally, returns true if and only if this set contains an element e such that (o==null ? e==null : o.equals(e)).
     */
    /**
     * Checks if the set contains the wanted element as defined by set-&collection-interface.
     * null is NOT accepted as wanted element resp. parameter. The wanted element must NOT be null.
     * 
     * @param  wantedElem  the element that is wanted
     * @return  true if this set contains the specified element
     */
    @Override
    public boolean contains( final Object wantedElem ){
        assert null!=wantedElem :  "\"NullPointerException\"/IllegalArgument :  null is NOT supported as argument";
        
        for( final List<T> collisionList : hashTable ){
            if( collisionList.contains( wantedElem )){
                return true;
            }//if
        }//for
        return false;
    }//method()
    
    /*
     * https://docs.oracle.com/javase/8/docs/api/ -> Set -> containsAll requires:
     * Returns true if this collection contains all of the elements in the specified collection.
     * This implementation iterates over the specified collection,
     * checking each element returned by the iterator in turn to see if it's contained in this collection.
     * If all elements are so contained true is returned, otherwise false.
     */
    /**
     * Checks if the set contains all of the elements in the specified collection as defined by set-&collection-interface.
     * null is NOT accepted as collection resp. parameter. The collection must NOT be null.
     * 
     * @param  coll  the collection that contains the elements to be checked if the they are contained by set
     * @return  true if this set did not already contain the specified element
     */
    @Override
    public boolean containsAll( Collection<?> coll ){
        assert null!=coll :  "\"NullPointerException\"/IllegalArgument :  null is NOT supported as argument";
        
        for( final Object wantedElem : coll ){
            if( ! contains( wantedElem )){
                return false;
            }//if
        }//for
        return true;
    }//method()
    
    
    
    /*
     * https://docs.oracle.com/javase/8/docs/api/ -> Set -> equals requires:
     * Compares the specified object with this set for equality.
     * Returns true if the specified object is also a set,
     * the two sets have the same size,
     * and every member of the specified set is contained in this set (or equivalently,
     * every member of this set is contained in the specified set).
     * This definition ensures that the equals method works properly across different implementations of the set interface.
     * 
     * => ...instanceof Set... muss eingesetzt werden
     */
    @Override
    public boolean equals( final Object otherObject ){
        if( this == otherObject )  return true;
        if( null == otherObject )  return false;
        if( ! ( otherObject instanceof Set ))  return false;
        
        @SuppressWarnings("unchecked")
        final Set<Object> other = (Set<Object>)( otherObject );
        
        if( size() != other.size() )  return false;
        for( final T elem : this ){                                             // this zeigt auf das Objekt von dem jetzt "iterator()" aufgerufen wird
            if( ! other.contains( elem ) )  return false;                       // ..in der Konsequenz wird die HashSet Element für Element durchlaufen
        }//for
        return true;
    }//method()
     
    /*
     * https://docs.oracle.com/javase/8/docs/api/ -> Set -> hashCode requires:
     * Returns the hash code value for this set.
     * The hash code of a set is defined to be the sum of the hash codes of the elements in the set,
     * where the hash code of a null element is defined to be zero.
     * This ensures that s1.equals(s2) implies that s1.hashCode()==s2.hashCode() for any two sets s1 and s2,
     * as required by the general contract of Object.hashCode().
     */
    @Override
    public int hashCode(){
        int sum=0;
        for( final T elem : this ){                                             // this zeigt auf das Objekt von dem jetzt "iterator()" aufgerufen wird
            sum += (null==elem  ?  0  :  elem.hashCode() );                     // ..in der Konsequenz wird die HashSet Element für Element durchlaufen
        }//for
        return sum;
    }//method()
    
    
    
    /*
     * https://docs.oracle.com/javase/8/docs/api/ -> Set -> isEmpty requires:
     * Returns  true if this set contains no elements.
     */
    @Override
    public boolean isEmpty(){
        for( final List<T> collisionList : hashTable ){
            if( ! collisionList.isEmpty() ){
                return false;
            }//if
        }//for
        return true;
    }//method()
    
    
    
    /*
     * https://docs.oracle.com/javase/8/docs/api/ -> Set -> remove requires:
     * Removes the specified element from this set if it is present (optional operation).
     * More formally, removes an element e such that (o==null ? e==null : o.equals(e)), if this set contains such an element.
     * Returns true if this set contained the element (or equivalently, if this set changed as a result of the call).
     * (This set will not contain the element once the call returns.)
     *
     * Returns  true if this set changed as a result of the call
     */
    /**
     * Removes the specified element from this set as defined by set-&collection-interface.
     * null is NOT accepted as element resp. parameter. The element must NOT be null.
     * 
     * @param  elem  the element to be removed from this set
     * @return  true if this set changed as a result of the call
     */
    @Override
    public boolean remove( final Object elem ){
        assert null!=elem :  "\"NullPointerException\"/IllegalArgument :  null is NOT supported as argument";
        
        final int hashTableIndex = scaleHashCode( elem.hashCode() );
        final List<T> collisionList = hashTable[ hashTableIndex ];
        return collisionList.remove( elem );
    }//method()
    
    /*
     * https://docs.oracle.com/javase/8/docs/api/ -> Set -> removeAll requires:
     * Removes from this set all of its elements that are contained in the specified collection (optional operation).
     * If the specified collection is also a set, this operation effectively modifies this set
     * so that its value is the asymmetric set difference of the two sets.
     *
     * Returns  true if this set changed as a result of the call
     */
    /**
     * Removes all elements contained in specified collection as defined by set-&collection-interface.
     * null is NOT accepted as wanted element resp. parameter. The wanted element must NOT be null.
     * 
     * @param  coll  the collection containing elements to be removed from this set
     * @return  true if this set changed as a result of the call
     */
    @Override
    public boolean removeAll( Collection<?> coll ){
        assert null!=coll :  "\"NullPointerException\"/IllegalArgument :  null is NOT supported as argument";
        
        boolean success = false;
        for( final Object elem : coll ){
            if( remove( elem )){
                success = true;
            }//if
        }//for
        return success;
    }//method()
    
    
    
    /*
     * https://docs.oracle.com/javase/8/docs/api/ -> Set -> retainAll requires:
     * Retains only the elements in this set that are contained in the specified collection (optional operation).
     * In other words, removes from this set all of its elements that are not contained in the specified collection.
     * If the specified collection is also a set, this operation effectively modifies this set
     * so that its value is the intersection of the two sets.
     *
     * Returns  true if this set changed as a result of the call
     */
    /**
     * Retains only the elements in this set that are contained in the specified collection as defined by set-&collection-interface.
     * null is NOT accepted as collection resp. parameter. The collection must NOT be null.
     * 
     * @param  coll  the collection containing elements to be retained in this set
     * @return  true if this set changed as a result of the call
     */
    @Override
    public boolean retainAll( final Collection<?> coll ){
        assert null!=coll :  "\"NullPointerException\"/IllegalArgument :  null is NOT supported as argument";
        
        boolean resu = false;
        final Iterator<T> iter = iterator();
        while( iter.hasNext() ){
            if( ! coll.contains( iter.next() ) ){
                iter.remove();
                resu = true;
            }//if
        }//while
        return resu;
    }//method()
    
    
    
    /*
     * https://docs.oracle.com/javase/8/docs/api/ -> Set -> size requires:
     * Returns  the number of elements in this set (its cardinality).
     * If this set contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     */
    @Override
    public int size(){
        long sum = 0;
        for( final List<T> collisionList : hashTable ){
            sum += collisionList.size();
        }//for
        return (sum<=Integer.MAX_VALUE)  ?  (int)( sum )  :  Integer.MAX_VALUE; // see above - the interface requires:  If this set contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
    }//method()
    
    
    
    
    
    // Bis "hierhin" wurden die Methoden vom Interface Set eingefordert.
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    //##########################################################################
    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    // Die folgenden Methoden sollen das grundsätzliche Verständnis des Hashings
    // bzw. der Funktionsweise einer HashSet unterstützen.
    
    
    
    /*
     * Die folgende Methode legt den internen Aufbau der Klasse offen
     * und unterläuft damit die Idee der Datenkapselung ;-)
     * Sinn dieser Klasse ist ja "Dinge" zu erklären (und damit aus didaktischen Gründen offen zu legen).
     */
    public void printInternalStructure(){
        System.out.printf( "vvvvv\n" );                                         // mark beginning
        for( int hashTableIndex=0; hashTableIndex<hashTable.length; hashTableIndex++ ){
            System.out.printf( "%02d-> [",  hashTableIndex );
            final List<T> collisionList = hashTable[hashTableIndex];
            final int lastPosition = collisionList.size() -1;
            if( 0 <= lastPosition ){
                for( int listIndex=0; listIndex<lastPosition; listIndex++ ){
                    System.out.printf( "%s, ",  collisionList.get( listIndex ));
                }//for
                System.out.printf( "%s",  collisionList.get( lastPosition ));
            }//if
            System.out.printf( "]\n" );
        }//for
        System.out.printf( "^^^^^\n" );                                         // mark end
    }//method()
    
    
    
    /*
     * Alle Berechnungen werden auf eine "einfache Art" durchgeführt um max. Verständlichkeit zu erreichen.
     * Eine Minimierung möglicher Rundungsfehler findet NICHT statt.
     */
    /**
     * this method delivers internal utilization statistics coded inside an UtilizationData object
     *
     * @return  utilization statistics
     */
    public UtilizationData getUtilization(){
        final int size = size();    // it is NOT expected that there are more than Integer.MAX_VALUE elements ;-)
        final double utilization = 1.0*size/hashTable.length;
        double sumOfSquareDiffs = 0.0;
        for( final List<T> list : hashTable ){
            final double diff = list.size() - utilization;
            sumOfSquareDiffs += ( diff*diff );
        }//for
        final double variance = sumOfSquareDiffs / hashTable.length;                                            // unkorrigierte Stichprobenvarianz -> https://de.wikipedia.org/wiki/Stichprobenvarianz
        final double standardDeviation1 = (0>=size)  ?  Double.NaN  :  Math.sqrt( sumOfSquareDiffs / size );    // Standardabweichung der Grundgesamtheit ("unkorrigierte" Standardabweichung)
        final double standardDeviation2 = (0>=size)  ?  Double.NaN  :  Math.sqrt( sumOfSquareDiffs /(size-1));  // Standardabweichung der Stichprobe
        final UtilizationData utilizationData = new UtilizationData(
            size,                       // size
            utilization,                // utilization
            variance,                   // variance
            standardDeviation1,         // standard deviation ("uncorrected")
            standardDeviation2          // standard deviation ("corrected")
        );
        return utilizationData;
    }//method()
    
    
    
    /*
     * Scale hashCode into required range
     */
    private int scaleHashCode( final int hashCode ){
        final int hashTableIndex = hashCode % hashTable.length;
        return  (hashTableIndex<0)  ?  -hashTableIndex  :  hashTableIndex;
    }//method()
    
    
    
    
    
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    // Ende der Methoden, die das "Hashing-Verständnis" unterstützen sollen.
    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    //##########################################################################
    //##########################################################################
    //###
    //###
    //###
    //##########################################################################
    //##########################################################################
    // Die folgenden Methoden werden wieder vom Interface Set (das sich von Collection ableitet) eingefordert.
    //
    // P1:
    // Unser Wissen reicht noch nicht aus  um das Folgende zu verstehen.
    // Im Folgenden wird auf Inhalte des 2.Semesters (P2) zurückgegriffen.
    // Ohne Vorwissen können Sie das Folgende gegenwärtig NICHT verstehen.
    //
    // AD:
    // Die (Kern-)Programmierausbildug ist abgeschlossen! AD setzt P1&P2 voraus.
    // Auch der folgende Code muss verstanden werden (können).
    
    
    
    /* Die Folgende Methode "iterator()" wird letztlich vom Iterable-Interface eingefordert.
     * Das Interface Set leitet sich von Collection ab und Collection wiederum von Iterable.
     * Die Unterstützung von Iterable ist wichtig, damit u.a. der "foreach-Loop" eingesetzt
     * werden kann.
     *
     * https://docs.oracle.com/javase/8/docs/api/ -> Set -> iterator
     * Returns  an iterator over the elements in this set. The elements are returned in no particular order
     * (unless this set is an instance of some class that provides a guarantee).
     */
    @Override
    public Iterator<T> iterator(){
        // Der Iterator wird als Objekt einer "anonymen Klasse" erzeugt.
        // "Anonyme Klassen" sind Spezialfälle von "inneren Klassen".
        // "Innere Klassen" sind Thema des 2.Semester bzw. von P2.
        // Der Vorteil besteht darin, dass so der Zugriff auf mit private geschützte Dinge möglich ist.
        // Alle Interna der Klasse HashSetBasedOnFixedSizedArray sind weiterhin sauber gekapselt.
        return new Iterator<T>(){
            private int hashTableIndex = 0;
            private int collisionListIndex = 0;
            private int lastElemHashTableIndex = -1;
            private int lastElemCollisionListIndex = -1;
            
            
            
            @Override
            public boolean hasNext(){
                while( hashTableIndex < hashTable.length ){
                    if( collisionListIndex < hashTable[hashTableIndex].size() ){
                        return true;
                    }//if
                    collisionListIndex = 0;
                    hashTableIndex++;
                }//while
                return (( hashTableIndex < hashTable.length )  &&  ( collisionListIndex < hashTable[hashTableIndex].size() ));
            }//method()
            //
            @Override
            public T next(){
                while( hashTableIndex < hashTable.length ){
                    if( collisionListIndex < hashTable[hashTableIndex].size() ){
                        lastElemHashTableIndex = hashTableIndex;
                        lastElemCollisionListIndex = collisionListIndex;
                        return hashTable[hashTableIndex].get( collisionListIndex++ );
                    }//if
                    collisionListIndex = 0;
                    hashTableIndex++;
                }//while
                throw new NoSuchElementException();
            }//method()
            //
            @Override
            public void remove(){
                if( -1==lastElemHashTableIndex ){
                    throw new IllegalStateException();
                }//if
                hashTable[lastElemHashTableIndex].remove( lastElemCollisionListIndex );
                lastElemHashTableIndex = -1;
            }//method()
        };
    }//method()
    
    
    
    /*
     * https://docs.oracle.com/javase/8/docs/api/ -> Set -> toArray
     * Returns an array containing all of the elements in this set.
     * If this set makes any guarantees as to what order its elements are returned by its iterator,
     * this method must return the elements in the same order.
     * The returned array will be "safe" in that no references to it are maintained by this set.
     * (In other words, this method must allocate a new array even if this set is backed by an array).
     * The caller is thus free to modify the returned array.
     * This method acts as bridge between array-based and collection-based APIs.
     */
    @Override
    public Object[] toArray(){
        return toArray( new Object[0] );
    }//method()
    
    /*
     * toArray benutzt einen lokalen Generic E, der nur für die Methode gilt.
     * Es geht leider nicht anders und wird ohnehin so vom Interface eingefordert.
     * Die Hashtabelle läuft jedoch über einen Generic T. D.h. die Einträge in der Hashtabelle müssen auf den Typ E geCASTet (=gezwungen) werden.
     * Im Zusammenhang mit der "Generic-Problematik" - der Java internen Generic-Implementierungs-Entscheidung bei Einführung von Java5, das Java1.4 ablöste,
     * führt dies leider zu einer "unchecked"-Warnung vom Compiler, die mit "@SuppressWarnings("unchecked")" unterdrückt wird.
     * Der Klient unterliegt später der Pflicht beim Aufruf von toArray ein geeignetes Array als Parameter zu übergeben.
     *
     * https://docs.oracle.com/javase/8/docs/api/ -> Set -> toArray
     * Returns an array containing all of the elements in this set; the runtime type of the returned array is that of the specified array.
     * If the set fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the specified array and the size of this set.
     * If this set fits in the specified array with room to spare (i.e., the array has more elements than this set),
     * the element in the array immediately following the end of the set is set to null.
     * (This is useful in determining the length of this set only if the caller knows that this set does not contain any null elements.)
     * If this set makes any guarantees as to what order its elements are returned by its iterator,
     * this method must return the elements in the same order.
     * Like the toArray() method, this method acts as bridge between array-based and collection-based APIs.
     * Further, this method allows precise control over the runtime type of the output array,
     * and may, under certain circumstances, be used to save allocation costs.
     *
     * Suppose x is a set known to contain only strings.
     * The following code can be used to dump the set into a newly allocated array of String:
     * String[] y = x.toArray(new String[0]);
     *
     * Note that toArray(new Object[0]) is identical in function to toArray().
     */
    @Override
    public <E> E[] toArray( E[] array ){
        // determine required size
        final int numberOfElements = size();    // it is NOT expected that there are more than Integer.MAX_VALUE elements ;-)
        
        // prepare/generate targetArray
        final boolean newArrayRequired = ( array.length < numberOfElements );
        final E[] targetArray =  newArrayRequired  ?  Arrays.copyOf( array, numberOfElements )  :  array;
        
        // fill targetArray with data
        int index=0;
        for( final T elem_T : this ){                                           // this zeigt auf das Objekt von dem jetzt "iterator()" aufgerufen wird
            @SuppressWarnings("unchecked")                                      // ..in der Konsequenz wird die HashSet Element für Element durchlaufen
            final E elem_E = (E)( elem_T );
            targetArray[index] = elem_E;
            index++;
        }//for
        assert ( index == numberOfElements ) : String.format( "internal coding error : %d != %d",  index, numberOfElements );
        //
        // set empty entries null  (if incoming array is used, there might be empty entries at the end)
        for( int stillToDoIndex=targetArray.length; --stillToDoIndex>=numberOfElements; ){
            targetArray[stillToDoIndex] = null;
        }//for
        
        return targetArray;
    }//method()
    
}//class
