// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package cardProcessor;


import static cards.Card.*;
import static cards.Card.Constant.*;
//
import cards.*;
import cards.Card.*;
import java.util.*;



/**
 * CardProcessor printing cards in reverse order - see task
 * 
 * @author   Nico Pätzel
 * @version  Version 1 [18.06.2024]
 */
public class CardProcessor {

    /**
     * Die Methode reverseOrder() zieht solange Karten von einem Kartenstapel
     * bis eine gewünschte Karte gezogen wird
     * und gibt danach alle gezogenen Karten in umgekehrter Reihenfolge wieder aus.
     *
     * @param deck              der Kartenstapel von dem die Karten gezogen werden.
     * @param lastCard          die gewünschte Karte, die die Ziehung beendet.
     * @param dbgOutputEnable   true schaltet Kontrollausgabe an und false aus.
     */
    // HHH      HHH   III   EEEEEEEEEEEE   RRRRRRRRRRR          <<<                                  !!!
    // HHH      HHH   III   EEEEEEEEEEEE   RRRRRRRRRRRR        <<<                                   !!!
    // HHH      HHH   III   EEE            RRR      RRR       <<<                                    !!!
    // HHH      HHH   III   EEE            RRR      RRR      <<<                                     !!!
    // HHHHHHHHHHHH   III   EEEEEEEEEEEE   RRRRRRRRRRR      <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<     !!!
    // HHHHHHHHHHHH   III   EEEEEEEEEEEE   RRRRRRRRRR       <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<     !!!
    // HHH      HHH   III   EEE            RRR   RRR         <<<                                     !!!
    // HHH      HHH   III   EEE            RRR    RRR         <<<
    // HHH      HHH   III   EEEEEEEEEEEE   RRR     RRR         <<<                                   !!!
    // HHH      HHH   III   EEEEEEEEEEEE   RRR      RRR         <<<                                  !!!
    //

    /**
     * Draws a new Card from a given deck until drawn card is equal to the wished card. 
     * Puts cards on a stack and returns stack in reversed order.
     * 
     * @param deck : Transmit a Datatype Deck - Deck can't be null. 
     * @param lastCard : Transmit a Datatype Card - LastCard can't be null.
     * @param dbgOutputEnable : Transmit a boolean true or false to activate or deactivate if drawn card will be given out - default: true 
     */

    public void reversedOrder(Deck deck, Card lastCard, boolean dbgOutputEnable) {      

        // ----- ASSERTS ----- 
        //Testing for nulls
        assert deck != null : "There is no deck - please transmit a deck";
        assert lastCard != null : "There is no Card - please transmit a Card";

        //----- VARIABLES -----
        Card drawnCard;
        Stack<Card> cardStack = new Stack<>();

        System.out.printf("##### Karten Gezogen #####\n");


        //----- STATEMENTS -----

        // draw cards and push to Stack (as long as drawn card is not equal to lastCard) 
        do {
            drawnCard = deck.deal();
            cardStack.push(drawnCard);

            //opens print method if true
            if (dbgOutputEnable) {
                iPrintCards(drawnCard, lastCard);
            } 
        } while (!drawnCard.equals(lastCard));


        System.out.printf("\n\n##### Karten Reversed #####\n");
        // After drawn lastCard pull from Stack
        while (!cardStack.isEmpty()) {
            System.out.printf("%s", cardStack.pop());
        }

    } //method


    // METHOD: overloads reversedOrder in case no boolean is given.
    public void reversedOrder(Deck deck, Card lastCard) {

        // ----- ASSERTS ----- 
        assert deck != null : "Error: There is no deck - please transmit a deck" ;
        assert lastCard != null : "There is no Card - please transmit a Card" ;

        //----- VARIABLES -----
        boolean dbgOutputEnable = true; 

        //----- STATEMENT -----
        reversedOrder(deck, lastCard, dbgOutputEnable); // activates reversedOrder with default boolean
    } // method

    
    
    //----- HELP METHODS -----

    //Method - to print given Cards
    private void iPrintCards(Card printDrawnCard, Card printLastCard) {

        System.out.printf("%s", printDrawnCard);
        //System.out.printf("Gewünschte Karte %s\n", printLastCard);

    } //method

}//class
