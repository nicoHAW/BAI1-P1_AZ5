// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package testForHashMapBasedOnFixedSizedArray;


import java.util.Map;
import java.util.Scanner;

import dataForTests.personSingleName.Po;
import dataForTests.someObjekt.Io;
import hashMapBasedOnFixedSizedArray.HashMapBasedOnFixedSizedArray;


/**
 * TestFrame for HashMapBasedOnFixedSizedArray.
 * 
 * @author   Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *           P1@Hamburg-UAS.eu 
 * @version  2022/05/16 (#1)
 */
public class TestFrame11 {
    
    public static void main( final String... unused ) {
        final Map<Po,Io> mapUnderTest = new HashMapBasedOnFixedSizedArray<Po,Io>();
        
        mapUnderTest.put( new Po( "Uwe" ),  new Io( "1" ) );
        mapUnderTest.put( new Po( "Ute" ),  new Io( "2" ) );
        mapUnderTest.put( new Po( "Ede" ),  new Io( "3" ) );
        mapUnderTest.put( new Po( "Ina" ),  new Io( "4" ) );
        mapUnderTest.put( new Po( "Tim" ),  new Io( "5" ) );
        mapUnderTest.put( new Po( "Tom" ),  new Io( "6" ) );
        mapUnderTest.put( new Po( "Paul" ), new Io( "7" ) );
        mapUnderTest.put( new Po( "Jo" ),   new Io( "8" ) );
        mapUnderTest.put( new Po( "Yogi" ), new Io( "9" ) );
        printInternalStructure( mapUnderTest );
        System.out.printf( "\n\n\n" );
        
        
        
        // Dialog mit Anwender, welche Information gewuenscht ist
        //
        System.out.printf( "Fuer welche Person moechten Sie die zugehoerige Information erhalten?\n" );
        System.out.printf( "Geben Sie den Namen der jeweiligen Person ein : \n" );
        //
        // WorkAround fuer ein GUI bzw. eine Benutzerschnittstelle
        final Scanner scanner = new Scanner( System.in );
        final String wantedName = scanner.next();
        final Po wantedPerson = new Po( wantedName );
        final Io wantedInformation = mapUnderTest.get( wantedPerson );
        if( wantedInformation != null ){
            System.out.printf( "Die zugehoerige Information für \"%s\" lautet \"%s\"",  wantedPerson, wantedInformation );
        }else{
            System.out.printf( "Ich kann \"%s\" nicht in meinen Daten finden.",  wantedPerson );
        }//if 
        //
        // Scanner ist Resource, die zurueckgegeben werden muss
        scanner.close();
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
