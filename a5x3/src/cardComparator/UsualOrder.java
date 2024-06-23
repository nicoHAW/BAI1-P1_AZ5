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

    enum SuitOrder {
        CLUB, SPADES, HEART, DIAMOND;
    }
    
    @Override
    public int compare(Card firstCard, Card secondCard) {

        // Compare Ranks in order: highest First.
        
        int rankResult = secondCard.getRank().value() - firstCard.getRank().value();
        int suitResult = secondCard.getSuit().ordinal() - firstCard.getSuit().ordinal();
        
        //int suitResult = SuitOrder(secondCard.getSuit()) - SuitOrder(secondCard.getSuit());

        
        //Compares Ranks 
        if (rankResult == 0) {
            return suitResult;
        } else return rankResult;
    }
}
