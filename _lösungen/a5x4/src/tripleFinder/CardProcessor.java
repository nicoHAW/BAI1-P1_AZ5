package tripleFinder;


import cards.Card;
import cards.Card.Rank;
import java.util.*;


/**
 * CardProcessor for processing cards
 * 
 * @author   (Raffael Apitz, Laurin Kamischke) 
 * @version  (240618#1)
 */
public class CardProcessor implements CardProcessor_I {
    
    //the map that contains our processed cards - we use the card rank as key and a list of cards as a value
    Map<Rank,List<Card>> processedCards = new HashMap<Rank,List<Card>>();
    final boolean debugEnabled = false;
    
    public CardProcessor() {
        processedCards = new HashMap<Rank,List<Card>>();
    }
    
    @Override
    public Object process(Card card) {
        assert card != null : "The card to process can't be null";
        
        final Rank cardRank = card.getRank();        
        //using the rank of the card we are trying to process - check if there are cards with the same rank (cardsWithSameRank is null if there are none)
        List<Card> cardsWithSameRank = processedCards.get(cardRank);
        
        //check if there are already other cards with the same rank
        if (cardsWithSameRank != null) {
            //add the newest card to our list of cards with the same rank
            cardsWithSameRank.add(card);
            
            if (cardsWithSameRank.size() >= 3) {
                //if we now have atleast 3 cards with the same rank - remove those from our map, we dont have to check if the key is valid, because we did that above (by getting the values for this key)
                processedCards.remove(cardRank);
            } else {
                //otherwise add the list of cards to our map
                processedCards.put(cardRank, cardsWithSameRank);
                cardsWithSameRank = null; //we set our ArrayList null because we only want to return a valid List at the end if there is a trio
            }
        } else {
            //if this is the first card with that rank - add it to the map
            final List<Card> singleCardArray = new ArrayList<Card>();
            singleCardArray.add(card);
            processedCards.put(cardRank, singleCardArray);
        }        

        //return cardsWithSameRank - its either null (no trio) or an arrayList with atleast 3 same cards
        return cardsWithSameRank;
    }

    @Override
    public void reset() {
        //clear our map
        processedCards.clear();
    }

}