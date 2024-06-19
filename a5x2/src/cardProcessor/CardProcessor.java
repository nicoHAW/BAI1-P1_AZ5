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

public Card [] removeDuplicates(Card... cards) {
    //Card[] cleared = new Card[cards.length];
    
    HashSet<Card> cardSet = new HashSet<>();
    
    for (int i = 0; i<cards.length; i++) {
        cardSet.add(cards[i]);
    }
    
    cardSet.toArray(cards);
    
    return cards;
}
    
    
}//class
