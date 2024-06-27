// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package cardProcessor;


import static cards.Card.*;
import static cards.Card.Constant.*;
import cards.*;
import cards.Card.*;
import java.util.*;


/**
 * CardProcessor removing duplicates - see task
 * 
 * @author   Nico Pätzel 
 * @version  Version 0.1 [18.06.2024]
 */
public class CardProcessor {

    /**
     * Die Methode removeDuplicates() entfernt Doppelte aus den übergebenen Karten.
     * Welche Karte (von den mehrfach vorhandenen Karten) übrig bleibt ist egal.
     * Wichtig ist, dass es bei den als Ergebnis abgelieferten Katen keine Doppelten gibt,
     * aber sonst jede Karten erhalten bleibt. 
     *
     * @param cards     die übergebenen Karten aus denen die Doppelten entfernt werden.
     * 
     * @return          die Karten befreit von Doppelten.
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

    public Card[] removeDuplicates(Card... cards) {
        // ----- ASSERTS ----- 
        assert cards != null : "Error: There is no card - please transmit cards or a array o cards";
        for (int i = 0; i<cards.length-1; i++) {
            assert cards[i] != null : "Error: There is no card at position "+i+1+" - please transmit cards or a array o cards";
        } //for


        // ----- SORT IN SET ----- 
        Set<Card> cardSet = new HashSet<>();

        for (Card tempCards : cards) {
            cardSet.add(tempCards);
        }

        //Old for loop replaced by iterator
        /*        for (int i = 0; i<cards.length; i++) {
         *           cardSet.add(cards[i]);
         *        } // for
         */


        // ----- SORT IN ARRAY ----- 
        //Create Array cleanedCards and use toArray and create a new Array of Cards with size of CardSet.
        Card[] cleanedCards = cardSet.toArray(new Card[0]);


        // ----- RETURN ----- 
        return cleanedCards;
    }


}//class
