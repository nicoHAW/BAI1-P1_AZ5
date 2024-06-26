package tripleFinder;

import java.util.*;

import cards.Card.*;
import cards.*;

public class CardProcessor implements CardProcessor_I {
    // variables
    
    Map<Rank, List> cardMap = new HashMap<>();

    //----- CONSTRUCTOR -----
    public CardProcessor() {
    }

    //----- METHODS -----

    /**
     * CardProcessor takes Object of DataType Card and collects cards as long as there are three of the same Rank. 
     *@param 
     *@return
     *@exception
     */
    @Override
    public List<Card> process(Card card) {

        List<Card> cardList;

        //Tests
        assert card != null : "Bitte gültige Übergeben";

        // Get CardRank
        Rank cardRank = card.getRank();        

        /*
         * If cardMap doesn't has a Key with Current Rank create a new ArrayList and put
         * ArrayList with Key of current cardRank in HaspMap
         */

        if (!this.cardMap.containsKey(cardRank)) {
            cardList = new ArrayList<Card>();
            this.cardMap.put(cardRank, cardList);            
        } else {
            cardList = this.cardMap.get(cardRank);
        } //fi else

        cardList.add(card);

        if (cardList.size() == 3) {    
            return cardList;
        } return null;
    } // fi

    @Override
    public void reset() {
        this.cardMap.clear();   
    } //reset

    //----- Help Method -----


    //----- CONSTRUCTOR -----


}
