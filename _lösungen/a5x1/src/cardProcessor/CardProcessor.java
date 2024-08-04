// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package cardProcessor;


import static cards.Card.*;
import static cards.Card.Constant.*;
import cards.*;
import cards.Card.*;
import java.util.*;


/**
 * CardProcessor printing cards in reverse order
 * 
 * @author   (Raffael Apitz, Laurin Kamischke) 
 * @version  (240617#1)
 */
public class CardProcessor {

    /**
     * Die Methode reverseOrder() zieht solange Karten von einem Kartenstapel
     * bis eine gewuenschte Karte gezogen wird
     * und gibt danach alle gezogenen Karten in umgekehrter Reihenfolge wieder aus.
     *
     * @param deck              der Kartenstapel von dem die Karten gezogen werden. Darf nicht null sein, da es sonst keine Karten zum Ziehen gibt.
     * @param lastCard          die gewuenschte Karte, die die Ziehung beendet. Darf nicht null sein, da wir sonst nicht wissen wann wir aufhören sollen zu ziehen.
     * @param dbgOutputEnable   true schaltet Kontrollausgabe an und false aus.
     */
    public void reverseOrder(final Deck deck, final Card lastCard, final boolean dbgOutputEnable){
        assert deck != null : "The deck can't be null, we need cards to continue";
        assert lastCard != null : "The lastCard can't be null, we need to know when to stop";

        //the stack of dealt cards - every new card gets put on top, at the end we print all cards in LIFO-order
        final Stack<Card> dealtCards = new Stack<Card>();
        Card currentCard;

        if (dbgOutputEnable) {
            System.out.printf("Card to search: %s\n \n", lastCard);
            System.out.printf("Dealing Cards...\n");
        }

        //draw cards from the deck until the newest card equals the target-/last-card
        do {
            currentCard = deck.deal();
            if (dbgOutputEnable) {
                System.out.printf("newest card: %s \n", currentCard);
            }
            //add every drawn card to the stack
            dealtCards.push(currentCard);
        } while (!currentCard.equals(lastCard));

        if (dbgOutputEnable) {
            System.out.printf("\n Dealt Cards: \n");
            //removing all cards from the stack and printing them, until there are no more left
            while (!dealtCards.empty()) {
                System.out.printf("%s \n", dealtCards.pop());
            }   
        }
    }

}
