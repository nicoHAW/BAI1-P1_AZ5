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

/** 
 * UsualOrder Comparator ONLY compares objects of the Data Type Card.
 * Objects wil be compared and Ordered by Rank (descending) and by Suit
 * Suit order: CLUB, SPADES, HEART, DIAMOND
 */

public class UsualOrder implements Comparator<Card> {


    @Override
    public int compare(Card firstCard, Card secondCard) {
        // ----- ASSERT ----- 
        // checks if Cards are not null. 
        assert firstCard != null: "please submit valid Card";
        assert secondCard != null: "please submit valid Card";

        //  ----- COMPARE ----- 
        // Compare RanksHighest First.
        int rankResult = secondCard.getRank().value() - firstCard.getRank().value();

        //Compares Suites - uses a help method to change the given enum order. 
        int suitResult = iHelperAdaptSuitOrder(secondCard.getSuit()) - iHelperAdaptSuitOrder(firstCard.getSuit()); 

        //Compares Ranks 
        if (rankResult == 0) {
            return suitResult;
        } else return rankResult;
    } // compare


    //----- HELP METHOD -----
    
     // Changes the given enum order 
    private int iHelperAdaptSuitOrder (Suit card) {
        switch (card) {
            case CLUB:
                return 4;
            case SPADES:
                return 3;
            case HEART:
                return 2;
            case DIAMOND:
                return 1;
            default:
                return 0;
        } //method adaptSuitOrder
    } // method
} // class
