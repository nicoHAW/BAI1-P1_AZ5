package cardComparator;


import static cards.Card.*;
import static cards.Card.Constant.*;
import cards.*;
import cards.Card.*;

import java.util.Collections;

/**
 * Comparator for Cards defining "usual order"
 * 
 * @author   Nico Pätzel 
 * @version  Version 0.1 [22.06.2024]
 */
// Klasse "UsualOrder"
//
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
// Fügen Sie hier Ihren Code ein
// bzw. ersetzen Sie diesen Kommentar durch Ihren Code.
// ...

//
import java.util.Comparator;

public class UsualOrder implements Comparator<Card> {

    @Override
    public int compare(Card firstCard, Card secondCard) {
        int rankResult;
        int suitResult;



        /*
        // firstCard 
        Rank firstCardRank = firstCard.getRank();
        int firstCardRankValue = firstCardRank.value();
        Suit firstCardSuit = firstCard.getSuit();
        int firstCardOrdinal = firstCardSuit.ordinal();

        // secondCard 
        Rank secondCardRank = secondCard.getRank();
        int secondCardRankValue = secondCardRank.value();
        Suit secondCardSuit = secondCard.getSuit();
        int secondCardOrdinal = secondCardSuit.ordinal();

         */
        // Compare Ranks in order: highest First.
       // return rankResult = secondCard.getRank().value() - firstCard.getRank().value();

        // Compare Suites in order:

        int firstCardSuit = SuitOrder(firstCard.getSuit());
        int secondCardSuit = SuitOrder(secondCard.getSuit());

        return suitResult = firstCardSuit - secondCardSuit;

    }






    //---------- HELP METHODS ----------

    private int ihelperOrder(Card givenCard) {

        // firstCard Data
        Rank cardRank = givenCard.getRank();
        int cardRankValue = cardRank.value();
        Suit cardSuit = givenCard.getSuit();

        // Get factors for Ordinal
        int cardSuiteFaktor = SuitOrder(cardSuit);

        // Create a comparable number: Value of card + Factor for Suit

        int cardValue = cardSuiteFaktor + cardRankValue;

        return (cardValue);

    }


    private int SuitOrder(Suit givenCard) {

        switch (givenCard) {

            case CLUB:     // Kreuz
                return 40;
            case SPADES:   // Pik
                return 30;
            case HEART:    // Herz
                return 20;
            case DIAMOND:  // Karo
                return 10;
            default:
                return 0;
        }
    }
}
