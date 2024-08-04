// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package testForHashMapBasedOnFixedSizedArray;


import static dataForTests.cards.Card.Constant.*;

import java.util.Map;
import java.util.Scanner;

import dataForTests.cards.Hand;
import dataForTests.cards.Card.*;
import dataForTests.personSingleName.Po;
import hashMapBasedOnFixedSizedArray.HashMapBasedOnFixedSizedArray;


/**
 * TestFrame for HashMapBasedOnFixedSizedArray.
 * 
 * @author   Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *           P1@Hamburg-UAS.eu 
 * @version  2022/05/16 (#1)
 */
public class TestFrame12 {
    
    public static void main( final String... unused ) {
        final Map<Po,Hand> mapUnderTest = new HashMapBasedOnFixedSizedArray<Po,Hand>();
        
        mapUnderTest.put( new Po( "Uwe" ),  new Hand( CJ, S7, S3 ));
        mapUnderTest.put( new Po( "Zoe" ),  new Hand( H9, D5, S8 ));
        mapUnderTest.put( new Po( "Ede" ),  new Hand( H8, D9, C6 ));
        mapUnderTest.put( new Po( "Ina" ),  new Hand( C7, S6, DA ));
        mapUnderTest.put( new Po( "Tim" ),  new Hand( HA, D7, H2 ));
        mapUnderTest.put( new Po( "Tom" ),  new Hand( DK, D4, HQ ));
        mapUnderTest.put( new Po( "Ute" ),  new Hand( HT, DQ, C9 ));
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
        final Hand wantedHand = mapUnderTest.get( wantedPerson );
        if( wantedHand != null ){
            System.out.printf( "Spieler %s hat folgende Karten %s",  wantedPerson, wantedHand );
        }else{
            System.out.printf( "Ich kann Spieler %s nicht in meinen Daten finden.",  wantedPerson );
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
