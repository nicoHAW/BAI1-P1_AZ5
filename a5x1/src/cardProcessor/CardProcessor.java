// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package cardProcessor;


import static cards.Card.*;
import static cards.Card.Constant.*;
//
import cards.*;
import cards.Card.*;
import java.util.*;
import java.util.jar.Attributes.Name;



/**
 * CardProcessor printing cards in reverse order - see task
 * 
 * @author   Nico Pätzel
 * @version  Version 1 [18.06.2024]
 */
public class CardProcessor {

    /**
     * Draws a new Card from a given deck until drawn card is equal to the wished card. 
     * Puts cards on a stack and returns stack in reversed order.
     * 
     * @param deck : Transmit a Datatype Deck - Deck can't be null. 
     * @param wishedCard : Transmit a Datatype Card - LastCard can't be null.
     * @param dbgOutputEnable : Transmit a boolean true or false to activate or deactivate if drawn card will be given out - default: true 
     */
    public void reversedOrder(Deck deck, Card wishedCard, boolean dbgOutputEnable) {      

        // ----- ASSERTS ----- 
        //Testing for nulls
        assert deck != null : "There is no deck - please transmit a deck";
        assert wishedCard != null : "There is no Card - please transmit a Card";

        //----- VARIABLES -----
        Card drawnCard;
        Stack<Card> cardStack = new Stack<Card>();

        if (dbgOutputEnable)  System.out.printf("##### Karten Gezogen #####\n");


        //----- STATEMENTS -----

        // draw cards and push to Stack (as long as drawn card is not equal to lastCard) 
        do {
            drawnCard = deck.deal();
            //opens print method if true
            if (dbgOutputEnable) {
                System.out.printf("%s", drawnCard);
                //iPrintCards(drawnCard, wishedCard);
            }
            cardStack.push(drawnCard);
        } while (!drawnCard.equals(wishedCard));
        if (dbgOutputEnable) {
            System.out.printf("\n\n");
        }
        
        System.out.printf("##### Karten Reversed #####\n");
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

        //----- STATEMENT -----
        reversedOrder(deck, lastCard, true); // activates reversedOrder with default boolean
    } // method

    
    
    //----- HELP METHODS -----

    //Method - to print given Cards
    private void iPrintCards(Card printDrawnCard, Card printLastCard) {

        System.out.printf("%s", printDrawnCard);
        //System.out.printf("Gewünschte Karte %s\n", printLastCard);

    } //method
    
    //-----  -----
    
 // ----- STANDARD METHODS ----- 
    @Override
    public String toString() {
        return String.format( "[< %s >: ]", CardProcessor.class.getSimpleName());
    }
    

}//class
