// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package cardProcessor;


import static cards.Card.*;
import static cards.Card.Constant.*;
import cards.*;
import cards.Card.*;
import java.util.*;


/**
 * CardProcessor removing duplicates
 * 
 * @author   (Raffael Apitz, Laurin Kamischke) 
 * @version  (240617#1)
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
    public Card[] removeDuplicates(final Card... givenCards) {
        assert givenCards != null : "The givenCards can't be null, we need cards to continue";
        
        //we save our cards in a HashSet, because it is faster than a treeSet and it automatically removes duplicates when added
        final Set<Card> noDuplicateCards = new HashSet<Card>();
        
        //we add every given card to the HashSet
        for (int i = 0; i < givenCards.length; i++) {
            noDuplicateCards.add(givenCards[i]);
        }
         
        //we create a new array with the length of our HashSet and return it
        Card[] noDuplicatesArray = noDuplicateCards.toArray(new Card[noDuplicateCards.size()]);

        return noDuplicatesArray;
    }
    
}