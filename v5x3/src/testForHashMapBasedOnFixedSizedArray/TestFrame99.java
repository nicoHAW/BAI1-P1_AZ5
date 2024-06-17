// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package testForHashMapBasedOnFixedSizedArray;


import java.util.*;

import dataForTests.person.Person;
import dataForTests.someObjekt.Io;
import hashMapBasedOnFixedSizedArray.HashMapBasedOnFixedSizedArray;


/**
 * TestFrame for HashMapBasedOnFixedSizedArray.
 * This is NOT an educational TestFrame.
 * This TestFrame is for actual testing.
 * 
 * @author   Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *           P1@Hamburg-UAS.eu 
 * @version  2022/05/16 (#1)
 */
public class TestFrame99 {
    
    public static void main( final String... unused ){
        
        // testing with identical objects
        /*scope*/{
            final Map<Person,Io> myTable = new HashMapBasedOnFixedSizedArray<Person,Io>();
            final Map<Person,Io> javaMap = new HashMap<Person,Io>();
            for( int i=1; i<10; i++ ){
                final String surname = "s" + String.format( "%02d", i );
                final String firstname = "f" + String.format( "%02d", i );
                final String information = "i" + String.format( "%02d", i );
                final Person key = new Person( surname, firstname );
                final Io value = new Io( information );
                myTable.put( key, value );
                javaMap.put( key, value );
            }//for
            printInternalStructure( myTable );
            System.out.printf( "\n" );
            //
            assert areMapsVeryEqual( myTable, javaMap, true ) : "Maps are NOT very equal";
        }//scope
        
        
        
        // testing with equal objects
        /*scope*/{
            final Map<Person,Io> myTable = new HashMapBasedOnFixedSizedArray<Person,Io>();
            final Map<Person,Io> javaMap = new HashMap<Person,Io>();
            for( int i=1; i<10; i++ ){
                final String surname = "s" + String.format( "%02d", i );
                final String firstname = "f" + String.format( "%02d", i );
                final String information = "i" + String.format( "%02d", i );
                myTable.put( new Person( surname, firstname ),  new Io( information ) );
                javaMap.put( new Person( surname, firstname ),  new Io( information ) );
            }//for
            //
            assert areMapsVeryEqual( myTable, javaMap, true ) : "Maps are NOT very equal";
        }//scope
        
        
        
        // testing with equal objects
        /*scope*/{
            final Map<Person,Io> myTable = new HashMapBasedOnFixedSizedArray<Person,Io>();
            final Map<Person,Io> javaMap = new HashMap<Person,Io>();
            final int maxValue = 16;
            final int runNo = 500;
            for( int stillToDo=runNo; --stillToDo>=0; ){
                final Random rand = new Random();
                final int n1 = rand.nextInt( maxValue );
                final int n2 = rand.nextInt( maxValue );
                final int n3 = rand.nextInt( maxValue );
                final String surname = "s" + String.format( "%02d", n1 );
                final String firstname = "f" + String.format( "%02d", n2 );
                final String information = "i" + String.format( "%02d", n3 );
                myTable.put( new Person( surname, firstname ),  new Io( information ) );
                javaMap.put( new Person( surname, firstname ),  new Io( information ) );
            }//for
            assert areMapsVeryEqual( myTable, javaMap, true ) : "Maps are NOT very equal";
            //
            final Map<Person,Io> map2 = new HashMap<Person,Io>();
            final int maxValue2 = 10;
            final int runNo2 = 100;
            for( int stillToDo=runNo2; --stillToDo>=0; ){
                final Random rand = new Random();
                final int n1 = rand.nextInt( maxValue2 );
                final int n2 = rand.nextInt( maxValue2 );
                final int n3 = rand.nextInt( maxValue2 );
                final String surname = "s" + String.format( "%02d", n1 );
                final String firstname = "f" + String.format( "%02d", n2 );
                final String information = "i" + String.format( "%02d", n3 );
                map2.put( new Person( surname, firstname ),  new Io( information ) );
            }//for
            myTable.putAll( map2 );
            javaMap.putAll( map2 );
            assert areMapsVeryEqual( myTable, javaMap, true ) : "Maps are NOT very equal";
            //
            final Map<Person,Io> map3 = new HashMap<Person,Io>();
            final int maxValue3 = 10;
            final int runNo3 = 100;
            for( int stillToDo=runNo3; --stillToDo>=0; ){
                final Random rand = new Random();
                final int n1 = rand.nextInt( maxValue3 );
                final int n2 = rand.nextInt( maxValue3 );
                final int n3 = rand.nextInt( maxValue3 );
                final String surname = "s" + String.format( "%02d", n1 );
                final String firstname = "f" + String.format( "%02d", n2 );
                final String information = "i" + String.format( "%02d", n3 );
                map3.put( new Person( surname, firstname ),  new Io( information ) );
            }//for
            myTable.clear();
            javaMap.clear();
            myTable.putAll( map3 );
            javaMap.putAll( map3 );
            assert areMapsVeryEqual( myTable, javaMap, true ) : "Maps are NOT very equal";
            for( final Person key : map3.keySet()){
                final Io expectedValue = map3.get( key );
                assert expectedValue.equals( javaMap.get(key)) : "Uuuupppss";
                assert expectedValue.equals( myTable.get(key)) : "Uuuupppss";
                assert expectedValue.equals( javaMap.remove(key)) : "Uuuupppss";
                assert expectedValue.equals( myTable.remove(key)) : "Uuuupppss";
                assert areMapsVeryEqual( myTable, javaMap, true ) : "Maps are NOT very equal";
            }//for
            assert javaMap.isEmpty() : "Uuuupppss";
            assert myTable.isEmpty() : "Uuuupppss";
            assert areMapsVeryEqual( myTable, javaMap, true ) : "Maps are NOT very equal";
            //
            final Map<Person,Io> myTable2 = new HashMapBasedOnFixedSizedArray<Person,Io>( map3 );
            final Map<Person,Io> javaMap2 = new HashMap<Person,Io>( map3 );
            assert areMapsVeryEqual( myTable2, javaMap2, true ) : "Maps are NOT very equal";
        }//scope
        
        System.out.printf( "###--- THE END ---###\n" );
    }//method()
    
    
    
    
    
    /*
     * Are maps equal and do they behave the same way?
     */
    private static boolean areMapsVeryEqual( final Map<?,?> m1,  final Map<?,?> m2,  final boolean dbgEnable ){
        //
        final int size1 = m1.size();
        final int size2 = m2.size();
        if( size1 != size2 ){
            if( dbgEnable )  System.out.printf( "sizes differ: %d!=%d\n",  size1, size2 );
            return false;
        }//if
        //
        final int hashCode1 = m1.hashCode();
        final int hashCode2 = m2.hashCode();
        if( hashCode1 != hashCode2 ){
            if( dbgEnable )  System.out.printf( "hashcodes differ: %d!=%d\n",  hashCode1, hashCode2 );
            return false;
        }//if
        //
        //
        if( ! m1.equals( m2 )){
            if( dbgEnable )  System.out.printf( "! m1.equals( m2 )\n" );
            return false;
        }//if
        if( ! m2.equals( m1 )){
            if( dbgEnable )  System.out.printf( "! m2.equals( m1 )\n" );
            return false;
        }//if
        //
        //
        final Set<?> eSet1 = m1.entrySet();
        final Set<?> eSet2 = m2.entrySet();
        if( ! eSet1.equals( eSet2 )){
            if( dbgEnable )  System.out.printf( "! eSet1.equals( eSet2 )\n" );
            return false;
        }//if
        if( ! eSet2.equals( eSet1 )){
            if( dbgEnable )  System.out.printf( "! eSet2.equals( eSet1 )\n" );
            return false;
        }//if
        //
        //
        final Set<?> kSet1 = m1.keySet();
        final Set<?> kSet2 = m2.keySet();
        if( ! kSet1.equals( kSet2 )){
            if( dbgEnable )  System.out.printf( "! kSet1.equals( kSet2 )\n" );
            return false;
        }//if
        if( ! kSet2.equals( kSet1 )){
            if( dbgEnable )  System.out.printf( "! kSet2.equals( kSet1 )\n" );
            return false;
        }//if
        //2nd check with containsKey
        for( final Object elem : kSet1 ){
            if( ! m2.containsKey( elem )) {
                if( dbgEnable )  System.out.printf( "key %s is NOT in m2\n",  elem );
                return false;
            }//if
        }//for
        for( final Object elem : kSet2 ){
            if( ! m1.containsKey( elem )) {
                if( dbgEnable )  System.out.printf( "key %s is NOT in m1\n",  elem );
                return false;
            }//if
        }//for
        //
        //
        // ATTENTION! : The implementations of the collections may differ (e.g. set vs. list)
        final Collection<?> coll1 = m1.values();
        final Collection<?> coll2 = m2.values();
        for( final Object elem : coll1 ){
            if( ! coll2.contains( elem )) {
                if( dbgEnable )  System.out.printf( "value %s is NOT in m2\n",  elem );
                return false;
            }//if
        }//for
        for( final Object elem : coll2 ){
            if( ! coll1.contains( elem )) {
                if( dbgEnable )  System.out.printf( "value %s is NOT in m1\n",  elem );
                return false;
            }//if
        }//for
        //2nd check with containsValue
        for( final Object elem : coll1 ){
            if( ! m2.containsValue( elem )) {
                if( dbgEnable )  System.out.printf( "value %s is NOT in m2\n",  elem );
                return false;
            }//if
        }//for
        for( final Object elem : coll2 ){
            if( ! m1.containsValue( elem )) {
                if( dbgEnable )  System.out.printf( "value %s is NOT in m1\n",  elem );
                return false;
            }//if
        }//for
        
        if( dbgEnable )  System.out.flush();
        return true;
    }//method()
    
    
    
    
    
    // Sorry, hier schlagen die Generics zu.
    // So etwas wie "<?,?>" verstehen wir (vermutlich) noch nicht.
    // Dadurch wird die Typsicherheit "so gut es geht" sichergestellt.
    // Für das Verständnis des Algorithmus ist dies nicht wichtig.
    
    private static void printInternalStructure( final Map<?,?> map ){
        assert map instanceof HashMapBasedOnFixedSizedArray :  String.format( "Unsupported operation for %s",  map.getClass().getSimpleName() );
        //
        // DownCast ist nötig für Zugriff auf printInternalStructure().
        // Durch instanceof zuvor ist der DownCast sicher.
        ((HashMapBasedOnFixedSizedArray<?,?>)map).printInternalStructure();
    }//method()
    
}//class
