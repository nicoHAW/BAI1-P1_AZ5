package cardComparator;


import static cards.Card.*;
import static cards.Card.Constant.*;
import java.util.Comparator;
import cards.*;
import cards.Card.*;


/**
 * Comparator for Cards defining "usual order"
 * 
 * @author   (Raffael Apitz, Laurin Kamischke) 
 * @version  (240617#1)
 */
public class UsualOrder implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        assert card1 != null : "The first card we are trying to compare is null, both cards need to be valid to continue.";
        assert card2 != null : "The second card we are trying to compare is null, both cards need to be valid to continue.";

        //Compare Ranks high to low
        final Rank card1Rank = card1.getRank();
        final Rank card2Rank = card2.getRank();
        final int rankCompare = card2Rank.compareTo(card1Rank);
        
        //Adapted order of Suits
        final Suit[] suitOrder = new Suit[] {CLUB, SPADES, HEART, DIAMOND};
        //Compare Suits using our adapted suit-order and the enum-ordinals of the Suit-Enum
        final Suit card1Suit = card1.getSuit();
        final Suit card2Suit = card2.getSuit();
        final int card1SuitOrdinal = card1Suit.ordinal();
        final int card2SuitOrdinal = card2Suit.ordinal();
        final int card1NewSuitOrdinal = suitOrder[card1SuitOrdinal].ordinal();
        final int card2NewSuitOrdinal = suitOrder[card2SuitOrdinal].ordinal();
        final int suitCompare = card1NewSuitOrdinal - card2NewSuitOrdinal;

        //either the cards have a different rank (primary), or a different suit (secondary)
        //if the rank is the same, rankCompare would be 0, in that case we use suitCompare to determine the order, otherwise we use rankCompare 
        return (rankCompare == 0) ? suitCompare : rankCompare;
    }
    
}